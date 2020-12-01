<%@ page import="java.util.*"%>
<jsp:useBean id="topic" class="forum.bean.Topic"/>
<jsp:useBean id="authorusr" class="forum.bean.User"/>
<jsp:useBean id="frm" class="forum.bean.Forum"/>
<jsp:useBean id="lastauthorusr" class="forum.bean.User"/>
<jsp:useBean id="message" class="forum.bean.Message"/>
<%
	Vector listtopic = new Vector();
	frm = (forum.bean.Forum)session.getValue("forum");

	listtopic = topic.listTopic(frm.getId());
%>
<table width="100%" border="1" cellspacing="0" cellpadding="0" bordercolor="#999999" class="tablestyle">
<tr class="title">
	<td><div class="divstyle">Topic: </div></td>
        <td><div class="divstyle">Author: </div></td>
        <td><div class="divstyle">Replies: </div></td>
        <td><div class="divstyle">Views: </div></td>
        <td><div class="divstyle">Last Post: </div></td>
</tr>
	<%
		for (int i=0;i<listtopic.size();i++){
			forum.bean.Topic topic2 = new forum.bean.Topic();
			topic2 = (forum.bean.Topic)listtopic.elementAt(i);
			//authorusr = new forum.bean.User();
			authorusr = topic2.getAuthorusr();
			lastauthorusr = topic2.getLastauthorusr();
			message = topic2.getMessage();
	%>
<tr>
        <td class="forumdetails">
        	<div class="divstyle">
        	<a href="./jsps/messages.jsp?idtopic=<%=topic2.getId()%>" class="linkforum"><%=topic2.getName()%></a>
        	</div>
        </td>
        <td class="blockcolor" align="center"><div class="divstyle"><%=authorusr.getUsername()%></div></td>
        <td align="center"><div class="divstyle"><%=topic2.getReplies()%></div></td>
        <td align="center" class="blockcolor"><div class="divstyle"><%=topic2.getViews()%></div></td>
        <td>
        	<div class="divstyle">on <%=message.getDatetimes()%> by <%=lastauthorusr.getUsername()%></div>
        </td>
</tr>
	<%
		}
	%>
<!--<tr>
        <td colspan="5" class="blockcolor">&nbsp;</td>
</tr>-->
</table>

