package forum;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;
import java.sql.*;
import forum.bean.*;

public class PostTopic extends HttpServlet implements SingleThreadModel{

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(true);

		User user = new User();
		Forum forum = new Forum();
		Topic topic = new Topic();
		Message message = new Message();

		if (session.getValue("user")!=null){
			user = (User)session.getValue("user");

			storeMessage(user,forum,topic,message,request,response,session);
		}
		else if (request.getAttribute("user")!=null){
			user = (User)request.getAttribute("user");

			Connection con = null;
			try {
				Class.forName(DBConnection.getDBDriver());
				con = DriverManager.getConnection(DBConnection.getDBName(),DBConnection.getDBUsername(),DBConnection.getDBPasswd());

				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from users where username='"+user.getUsername()+"' and password='"+user.getPassword()+"'");

				if (rs.next()){
					user.setId(rs.getInt("id"));
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					user.setEmail(rs.getString("email"));
					user.setSite(rs.getString("site"));
					user.setYahooid(rs.getString("yahooid"));
					user.setLocation(rs.getString("location"));
					user.setBirthday(rs.getString("birthday"));
					user.setBio(rs.getString("bio"));
					user.setState(rs.getString("state"));

					storeMessage(user,forum,topic,message,request,response,session);
					session.putValue("user", user);
				}
				else response.sendRedirect("/");  // error page not login

				con.close();
			}
			catch (Exception e){ out.println(e); }
		}
		else {
			response.sendRedirect("/forum"); // not using the right way
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		doPost(request,response);
	}

	public void storeMessage(User user, Forum forum, Topic topic, Message message, HttpServletRequest request, HttpServletResponse response, HttpSession session)
	throws IOException, ServletException{

		if ((request.getAttribute("topic")!=null)&&(request.getAttribute("message")!=null)&&(session.getValue("forum")!=null)){
			topic = (Topic)request.getAttribute("topic");
			message = (Message)request.getAttribute("message");
			forum = (Forum)session.getValue("forum");

			String ipaddress = request.getRemoteAddr();
			//java.util.Date date = new java.util.Date();
			//String datetime = Integer.toString(date.getMonth()+1)+"/"+Integer.toString(date.getDate())+"/"+Integer.toString(date.getYear()+1900);

			Connection con = null;
			try {
                                Class.forName(DBConnection.getDBDriver());
				con = DriverManager.getConnection(DBConnection.getDBName(),DBConnection.getDBUsername(),DBConnection.getDBPasswd());

				PreparedStatement pstmt1 = con.prepareStatement("insert into topics (name, author, idforum) values (?,?,?)");
				pstmt1.clearParameters();
				pstmt1.setString(1,topic.getName());
				pstmt1.setInt(2,user.getId());
				pstmt1.setInt(3,forum.getId());
				pstmt1.executeUpdate();

				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from topics order by id desc");

				if (rs.next()){
					topic.setId(rs.getInt("id"));
				}

				PreparedStatement pstmt2 = con.prepareStatement("insert into messages (author, notes, ipaddress, idtopic, datetimes) values (?,?,?,?,now())");
				pstmt2.clearParameters();
				pstmt2.setInt(1,user.getId());
				pstmt2.setString(2,message.getNotes());
				pstmt2.setString(3,ipaddress);
				pstmt2.setInt(4,topic.getId());
				pstmt2.executeUpdate();

				con.close();
			}
			catch (Exception e){ }

			response.sendRedirect("/forum/jsps/messages.jsp?idtopic="+topic.getId());
		}
		else response.sendRedirect("/forum"); // error not using the right way
	}

	public String getServletInfo(){
		return "A guideline servlet for programmers";
	}
}
