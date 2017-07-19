<%@ page import="com.samson.sakilaproject.service.ActorService" %>
<%@ page import="com.samson.sakilaproject.service.IActorService" %>
<%@page import="com.samson.sakilaproject.dbo.ActorDbo" %>
<%@ page import="com.samson.sakilaproject.bo.ActorBo" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 

String id = request.getParameter("id");
int id1 = Integer.parseInt(id);

IActorService service = new ActorService();
ActorBo bo = service.findById(id1);

%>
<%= bo %>
</body>
</html>