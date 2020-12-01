<%
	if (session.getValue("register")==null) response.sendRedirect("/forum");
%>
<html>
<head>
<jsp:include page="./templates/title.jsp" flush="true"/>
<link rel="stylesheet" type="text/css" href="./templates/style.css">
</head>

<body class="body" leftmargin="0" topmargin=0 marginheight="0" marginwidth="0">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><jsp:include page="./templates/header.jsp" flush="true"/></td>
  </tr>
  <tr>
    <td>
      <table width="100%" border="0">
        <tr>
          <td width="100"><jsp:include page="./templates/leftcol.jsp" flush="true"/></td>
          <td width="100%">
            <jsp:include page="./engines/menu.jsp" flush="true"/>
            <a href="./" class="linktext">Main Index</a> > <span class="text">Register</span>
            <br><br>
            <jsp:include page="./engines/formregister.jsp" flush="true"/>
          </td width="100">
          <td><jsp:include page="./templates/rightcol.jsp" flush="true"/></td>
        </tr>
      </table>
    </td>
  </tr>
  <tr>
    <td><jsp:include page="./templates/footer.jsp" flush="true"/></td>
  </tr>
</table>
</body>
</html>
