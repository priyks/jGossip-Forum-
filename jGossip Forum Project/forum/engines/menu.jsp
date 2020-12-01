<jsp:useBean id="user" class="forum.bean.User"/>
<%
	if (session.getValue("user")!=null){
		user = (forum.bean.User)session.getValue("user");
	}
%>
<table border="1" bordercolor="#999999" cellpadding="0" cellspacing="0" width="100%" class="menutable">
<tr>
<td>
<table border="0" width="100%" class="menutable">
<tr>
        <td>
        <a href="./jsps/register.jsp" class="menustyle">register</a>
        <%
        	if (user.getUsername().equals("")){
        %>
        | <a href="./jsps/login.jsp" class="menustyle">login</a>
        <%
        	} else {
        %>
        | <a href="jsps/logout.jsp" class="menustyle">logout</a>
        <%
        	}
        %>
        | <a href="#" class="menustyle">member list</a>
        </td>
        <td align="right">
        Login as:
        <%
        	if (user.getUsername().equals("")){
        %>
        anonymous
        <%
        	} else {
        		out.print(user.getUsername());
        	}
        %>
        </td>
</tr>
</table>
</td>
</tr>
</table>
