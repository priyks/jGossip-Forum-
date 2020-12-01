<%@ page import="java.util.*"%>
<jsp:useBean id="topic" class="forum.bean.Topic"/>
<jsp:useBean id="msg" class="forum.bean.Message"/>
<jsp:useBean id="usr" class="forum.bean.User"/>
<%
	if (session.getValue("topic")!=null){
		topic = (forum.bean.Topic)session.getValue("topic");
	}

	Vector listmsg = new Vector();

	forum.bean.Message msg2 = new forum.bean.Message();
	listmsg = msg.listMessage(topic.getId());
%>
<table width="100%" border="1" cellspacing="0" cellpadding="0" bordercolor="#999999" class="tablestyle">
  <tr>
    <td class="title"><div class="divstyle">Author:</div></td>
    <td class="title"><div class="divstyle">Topic: <%=topic.getName()%></div></td>
  </tr>
  <%
  	for (int i=0;i<listmsg.size();i++){
  		msg2 = new forum.bean.Message();
  		msg2 = (forum.bean.Message)listmsg.elementAt(i);
  		usr = new forum.bean.User();
  		usr = msg2.getAuthorusr();

  		String blockcolor = new String();
  		if (i%2==0) blockcolor = " class=\"blockcolor\"";
  %>
  <tr<%=blockcolor%>>
    <td rowspan="3" valign="top">
    <div class="divstyle">
    <span class="text"><b><%=usr.getUsername()%><b></span><br>
    <span class="textsml">
    <%=usr.getState()%>
    </span>
    </div>
    </td>
    <td>
    <div class="divstyle">
    posted on <%=msg2.getDatetimes()%> from <%=msg2.getIpaddress()%></td>
    </div>
  </tr>
  <tr<%=blockcolor%>>
    <td class="text">
    <div class="divstyle">
      <%=msg2.getNotes()%>
    </div>
    </td>
  </tr>
  <tr<%=blockcolor%>>
    <td>
    <div class="divstyle">
    <a href="#" class="linktext">edit</a> | <a href="#" class="linktext">delete</a> | <a href="#" class="linktext">profile</a>
    </div>
    </td>
  </tr>
  <%
  	}
  %>
</table>

