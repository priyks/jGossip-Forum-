<jsp:useBean id="user" class="forum.bean.User"/>
<jsp:setProperty name="user" property="*"/>
<%
	request.setAttribute("userlog",user);
%>
<jsp:forward page="/servlet/forum.PostLogin"/>
