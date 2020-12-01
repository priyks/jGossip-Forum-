<jsp:useBean id="user" class="forum.bean.User"/>
<jsp:setProperty name="user" property="*"/>
<%
	String day = new String();
	String month = new String();
	String year = new String();

	session.removeValue("register");

	if (request.getParameter("day")!=null) day = request.getParameter("day");
	if (request.getParameter("month")!=null) month = request.getParameter("month");
	if (request.getParameter("year")!=null) year = request.getParameter("year");

	if ((!day.equals(""))&&(!month.equals(""))&&(!year.equals(""))){
                user.setBirthday(month+"/"+day+"/"+year);
	} else response.sendRedirect("/forum");

	request.setAttribute("userreg",user);
%>
<jsp:forward page="/servlet/forum.PostRegister"/>
