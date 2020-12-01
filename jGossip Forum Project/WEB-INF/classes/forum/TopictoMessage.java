package forum;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import forum.bean.*;

public class TopictoMessage extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {

		Topic topic = new Topic();
		boolean none = true;

		HttpSession session = request.getSession(true);

		Connection con = null;
		try {
			Class.forName(DBConnection.getDBDriver());
			con = DriverManager.getConnection(DBConnection.getDBName(),DBConnection.getDBUsername(),DBConnection.getDBPasswd());

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from topics where id="+request.getParameter("idtopic"));

			if (rs.next()){
				topic.setName(rs.getString("name"));
				topic.setId(rs.getInt("id"));
				topic.setAuthor(rs.getInt("author"));
				topic.setViews(rs.getInt("views"));
				topic.setIdforum(rs.getInt("idforum"));
				none = false;
				session.putValue("topic", topic);

				PreparedStatement pstmt = con.prepareStatement("update topics set views=?+1 where id=?");
				pstmt.clearParameters();
				pstmt.setInt(1,topic.getViews());
				pstmt.setInt(2,topic.getId());
				pstmt.executeUpdate();
			}
			con.close();
		}
		catch (Exception e){ }

		if (none){
			response.sendRedirect("/forum");
		}
		else {
			response.sendRedirect("/forum/messages.jsp");
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		doPost(request,response);
	}

	public String getServletInfo(){
		return "A servlet for authenticate a request for viewing Messages list";
	}
}
