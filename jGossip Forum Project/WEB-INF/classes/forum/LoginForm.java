package forum;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginForm extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {

		HttpSession session = request.getSession(true);
		session.putValue("login","login");
		response.sendRedirect("/forum/login.jsp");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		doPost(request,response);
	}

	public String getServletInfo(){
		return "A login servlet form";
	}
}
