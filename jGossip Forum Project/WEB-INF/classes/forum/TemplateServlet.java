package forum;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class TemplateServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {

	//	response.setContentType("text/plain");
	//	PrintWriter out = response.getWriter();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		doPost(request,response);
	}

	public String getServletInfo(){
		return "A guideline servlet for programmers";
	}
}
