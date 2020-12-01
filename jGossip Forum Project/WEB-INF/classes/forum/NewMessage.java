package forum;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class NewMessage extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {

		HttpSession session = request.getSession(true);
		session.putValue("newmessage", "newmessage");
		response.sendRedirect("/forum/newmessage.jsp");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		doPost(request,response);
	}

	public String getServletInfo(){
		return "a servlet to view the new message's form";
	}
}
