package forum;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import forum.bean.*;

public class ForumtoTopic extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {

		boolean none = true;
		Forum frm = new Forum();

		HttpSession session = request.getSession(true);

		Connection con = null;
		try {
			Class.forName(DBConnection.getDBDriver());
			con = DriverManager.getConnection(DBConnection.getDBName(),DBConnection.getDBUsername(),DBConnection.getDBPasswd());

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from forums where id="+request.getParameter("idforum"));

			if (rs.next()){
				frm.setName(rs.getString("name"));
				frm.setId(rs.getInt("id"));
				frm.setCategory(rs.getString("category"));
				frm.setDetails(rs.getString("details"));
				frm.setModerator(rs.getInt("moderator"));
				none = false;
				session.putValue("forum", frm);
			}

			con.close();
		}
		catch (Exception e){ }

		if (none){
			response.sendRedirect("/forum");
		}
		else response.sendRedirect("/forum/topics.jsp");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		doPost(request,response);
	}

	public String getServletInfo(){
		return "A servlet for authenticate a request for viewing Topic list";
	}
}
