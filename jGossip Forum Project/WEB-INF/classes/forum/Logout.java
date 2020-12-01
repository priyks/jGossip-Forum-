package forum;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Logout extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {

		HttpSession session = request.getSession(true);
		session.invalidate();

		response.sendRedirect("/forum");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		doPost(request,response);
	}

	public String getServletInfo(){
		return "A logout Servlet";
	}
}
