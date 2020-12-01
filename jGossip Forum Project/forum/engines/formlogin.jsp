<%
	String error = new String();
	if (session.getValue("errorlog")!=null){
		error = "<center>Wrong username or password. <br>Please try again.</center>";
		session.removeValue("errorlog");
	}
%>
<form action="jsps/postlogin.jsp" method="post">
<table border="1" cellpadding="0" cellspacing="0" width="100%" class="tablestyle" bordercolor="#999999">
<tr>
	<td colspan="2">
		<div class="divstyle">
		<span class="title">
		Login
		</span>
		</div>
	</td>
</tr>
<tr>
	<td class="blockcolor">
		<div class="divstyle">
		<span class="text">
			Username :
		</span>
		</div>
	</td>
	<td>
		<div class="divstyle">
			<input name="username" type="text" size="20">
		</div>
	</td>
</tr>
<tr>
	<td class="blockcolor">
		<div class="divstyle">
		<span class="text">
			Password :
		</span>
		</div>
	</td>
	<td>
		<div class="divstyle">
			<input name="password" type="password" size="20">
		</div>
	</td>
</tr>
	<%
		if (!error.equals("")){
	%>
<tr>
	<td colspan="2">
		<div class="divstyle">
		<span class="title">
		<%=error%>
		</span>
		</div>
	</td>
</tr>
	<%
		}
	%>
</table>
<center>
<input type="submit" name="submit" value="Enter Login">
<input type="reset" name="reset" value="Clear All">
</center><p>&nbsp;</p>
