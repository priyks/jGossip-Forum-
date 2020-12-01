<jsp:useBean id="user" class="forum.bean.User"/>
<jsp:useBean id="topic" class="forum.bean.Topic"/>
<jsp:useBean id="message" class="forum.bean.Message"/>

<jsp:setProperty name="user" property="username" param="username"/>
<jsp:setProperty name="user" property="password" param="password"/>
<jsp:setProperty name="topic" property="name" param="topic"/>
<jsp:setProperty name="message" property="notes" param="message"/>

<%
	request.setAttribute("user",user);
	request.setAttribute("topic",topic);
	request.setAttribute("message",message);
%>
<jsp:forward page="/servlet/forum.PostTopic"/>
