<jsp:useBean id="frm" class="forum.bean.Forum"/>
<%
	if ((session.getValue("forum")!=null)&&(session.getValue("newtopic")!=null)){
		frm = (forum.bean.Forum)session.getValue("forum");
	}
	else response.sendRedirect("./");
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
            <span class="text"><a href="./" class="linktext">Main Index</a> > <a href="./jsps/topics.jsp?idforum=<%=frm.getId()%>" class="linktext"><%=frm.getName()%></a> > Post New Topic</span>
            <br><br>
            <!--<a href="#" class="linktext">New Topic</a> | <a href="#" class="linktext">New Reply</a>-->
            <jsp:include page="./engines/formtopic.jsp" flush="true"/>
            <!--<a href="#" class="linktext">New Topic</a> | <a href="#" class="linktext">New Reply</a>-->
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
