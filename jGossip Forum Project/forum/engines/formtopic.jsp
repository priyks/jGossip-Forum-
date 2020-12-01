<jsp:useBean id="user" class="forum.bean.User"/>
<%
	if (session.getValue("user")!=null){
		user = (forum.bean.User)session.getValue("user");
	}
%>
<form action="jsps/posttopic.jsp" method="post">
<table border="1" cellpadding="0" cellspacing="0" width="100%" class="tablestyle" bordercolor="#999999">
<tr>
	<td colspan="2" class="title"><div class="divstyle">
	Post new topic
	</div>
	</td>
</tr>
<tr>
	<td class="blockcolor"><div class="divstyle"><span class="text">Username :</span></div>
	</td>
	<td>
	<%
		if (user.getUsername().equals("")){
	%>
	<div class="divstyle">
		<input type="text" name="username" size="20" maxlength="20"> register?
		</div>
	<%
		} else {
	%>
	<div class="divstyle">
		<span class="text"><%=user.getUsername()%></span>
		</div>
	<%
		}
	%>
	</td>
</tr>
<tr>
	<td class="blockcolor"><div class="divstyle"><span class="text">Password :</span></div>
	</td>
	<td>
	<%
		if (user.getUsername().equals("")){
	%>
	<div class="divstyle">
		<input type="password" name="password" size="20" maxlength="20"> Forgot your password?
	</div>
	<%
		} else {
	%>
	<div class="divstyle">
	<span class="text">****</span>
	</div>
	<%
		}
	%>
	</td>
</tr>
<tr>
	<td class="blockcolor"><div class="divstyle"><span class="text">Subject :</span></div>
	</td>
	<td><div class="divstyle">
		<input type="text" name="topic" size="50"></div>
	</td>
</tr>
<tr>
	<td class="blockcolor" valign="top"><div class="divstyle"><span class="text">Message :</span></div>
	</td>
	<td><div class="divstyle">
		<textarea name="message" cols="40" rows="10"></textarea></div>
	</td>
</tr>
</table>
<center>
<input type="submit" name="submit" value="Post New Topic">
<input type="reset" name="reset" value="Clear All">
</center><p>&nbsp;</p>
