<%@ page import="java.util.*"%>
<jsp:useBean id="frm" class="forum.bean.Forum"/>
<%
	Vector listcategory = new Vector();
	Vector listforum = new Vector();
	forum.bean.User moderatorusr = new forum.bean.User();
	forum.bean.User usrpost = new forum.bean.User();
	forum.bean.Message msg = new forum.bean.Message();

	listcategory = frm.listCategory();
%>

<table width="100%" border="1" cellspacing="0" cellpadding="0" bordercolor="#999999" class="tablestyle">
<tr class="title">
	<td><div class="divstyle">Forum: </div></td>
        <td><div class="divstyle">Topics: </div></td>
        <td><div class="divstyle">Posts: </div></td>
        <td><div class="divstyle">Last Post: </div></td>
</tr>
	<%
		for (int i=0;i<listcategory.size();i++){
			frm = new forum.bean.Forum();
			frm = (forum.bean.Forum) listcategory.elementAt(i);
	%>
<tr>
        <td colspan="4" class="subtitle"><div style="margin-left: 5"><%=frm.getCategory()%></div></td>
</tr>
		<%
			listforum = frm.listForum(frm.getCategory());

			for (int j=0;j<listforum.size();j++){
				forum.bean.Forum frm2 = new forum.bean.Forum();
				frm2 = (forum.bean.Forum)listforum.elementAt(j);
				moderatorusr = frm2.getModeratorusr();
				usrpost = frm2.getUsrpost();
				msg = frm2.getMessage();
		%>
<tr>
        <td class="forumdetails">
        	<div class="divstyle">
        	<a href="./jsps/topics.jsp?idforum=<%=frm2.getId()%>" class="linkforum"><%=frm2.getName()%></a> (Modetare by: <%=moderatorusr.getUsername()%>)<br>
        	<%=frm2.getDetails()%>
        	</div>
        </td>
        <td class="blockcolor" align="center"><div class="divstyle"><%=frm2.getCounttopic()%></div></td>
        <td align="center"><div class="divstyle"><%=frm2.getCountpost()%></div></td>
        <td class="blockcolor">
        	<div class="divstyle">on <%=msg.getDatetimes()%> by <%=usrpost.getUsername()%></div>
        </td>
</tr>
	<%
			}
		}
	%>
<!--<tr>
        <td colspan="4" class="blockcolor">&nbsp;</td>
</tr>-->
</table>

