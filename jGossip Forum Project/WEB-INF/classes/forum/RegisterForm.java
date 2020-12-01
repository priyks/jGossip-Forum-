package forum;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RegisterForm extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {

		HttpSession session = request.getSession(true);
		session.putValue("register","register");

		response.sendRedirect("/forum/register.jsp");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		doPost(request,response);
	}

	public String getServletInfo(){
		return "forwarding servlet to registration form";
	}
}
