package forum;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import forum.bean.*;
import java.sql.*;

public class PostLogin extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {

		HttpSession session = request.getSession(true);

		User user = new User();
		user = (User)request.getAttribute("userlog");

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

				session.putValue("user", user);
				session.removeValue("login");
				response.sendRedirect("/forum");
			}
			else {
				session.putValue("errorlog","errorlog");
				response.sendRedirect("/forum/login.jsp");
			}
		}
		catch (Exception e){ }
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		doPost(request,response);
	}

	public String getServletInfo(){
		return "A guideline servlet for programmers";
	}
}
