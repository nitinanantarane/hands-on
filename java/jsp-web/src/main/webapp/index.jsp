<%@page language="java" import="java.util.*" %>

<jsp:useBean id="count" scope="session" class="com.nitin.quickstart.jsp.bean.Counter" />

<% 
	String userName = System.getProperty("user.name");
	out.println("<h2>Hello " + userName + "</h2");
	out.println("<p>It's a " + new Date() + " now");
	int newCount = count.getCount() + 1;
	count.setCount(newCount);
	
	out.println("<p>You have visited this page " + newCount + " times");
%>