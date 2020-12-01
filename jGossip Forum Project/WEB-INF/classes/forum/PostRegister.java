package forum;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import forum.bean.*;
import java.sql.*;

public class PostRegister extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {

        	User user = new User();
        	user = (User)request.getAttribute("userreg");

        	if ((user.getUsername().equals(""))||(user.getEmail().equals(""))||(user.getPassword1().equals(""))||(user.getPassword2().equals(""))){
        		response.sendRedirect("/"); //error required not filled
        	}

        	if (user.getPassword1().equals(user.getPassword2())){
                        user.setPassword(user.getPassword1());
        	}
        	else {
        		response.sendRedirect("/"); // error msg password not equals
        	}

        	if (user.getSite().equals("")) user.setSite("none");
        	if (user.getYahooid().equals("")) user.setYahooid("none");
        	if (user.getLocation().equals("")) user.setLocation("none");
        	if (user.getBio().equals("")) user.setBio("none");

        	Connection con = null;

        	try {
                        Class.forName(DBConnection.getDBDriver());
			con = DriverManager.getConnection(DBConnection.getDBName(),DBConnection.getDBUsername(),DBConnection.getDBPasswd());

                        Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users where username='"+user.getUsername()+"'");

			if (rs.next()){
				response.sendRedirect("/"); //error cause username is exist
			}

                        if (!user.getBirthday().equals("")){

                        	PreparedStatement pstmt = con.prepareStatement("insert into users (username,password,email,site,yahooid,location,birthday,bio,state) values(?,?,?,?,?,?,?,?,?)");
                        	pstmt.clearParameters();
                        	pstmt.setString(1,user.getUsername());
                        	pstmt.setString(2,user.getPassword());
                        	pstmt.setString(3,user.getEmail());
                        	pstmt.setString(4,user.getSite());
                        	pstmt.setString(5,user.getYahooid());
                        	pstmt.setString(6,user.getLocation());
                        	pstmt.setString(7,user.getBirthday());
                        	pstmt.setString(8,user.getBio());
                        	pstmt.setString(9,"Junior Juice");
                        	pstmt.executeUpdate();
                        }
                        else {
                        	PreparedStatement pstmt = con.prepareStatement("insert into users (username,password,email,site,yahooid,location,bio,state) values(?,?,?,?,?,?,?,?)");
                        	pstmt.clearParameters();
                        	pstmt.setString(1,user.getUsername());
                        	pstmt.setString(2,user.getPassword());
                        	pstmt.setString(3,user.getEmail());
                        	pstmt.setString(4,user.getSite());
                        	pstmt.setString(5,user.getYahooid());
                        	pstmt.setString(6,user.getLocation());
                        	pstmt.setString(7,user.getBio());
                        	pstmt.setString(8,"Junior Juice");
                        	pstmt.executeUpdate();
                        }

                        con.close();

                        response.sendRedirect("/forum");
        	}
        	catch(Exception e){ }
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		doPost(request,response);
	}

	public String getServletInfo(){
		return "a servlet for storing registrstion information to database";
	}
}
