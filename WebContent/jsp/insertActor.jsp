<%@ page import="com.samson.sakilaproject.service.ActorService" %>
<%@ page import="com.samson.sakilaproject.service.IActorService" %>
<%@ page import="com.samson.sakilaproject.bo.ActorBo" %>
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
		String FirstName = request.getParameter("fName");
		String LastName = request.getParameter("lName");
	//	String id = request.getParameter("id");
		int id = Integer.parseInt(request.getParameter("id"));
	
	 	ActorBo bo = new ActorBo();
	//	bo.setId(id);
	//	bo.setId(new Integer(id).toString());
		bo.setActorId(id);
		bo.setFirstName(FirstName);
		bo.setLastName(LastName);
		IActorService service = new ActorService();
		int i = service.insert(bo);
		
		
		if (i == 1) {
	%>

	Data Inserted Successfully for First Name: ${param.fName}
	<br> Last Name: ${param.lName}
	<br> ID: ${param.id}

	<%
		} else {%>
			
		Insert Not Successful !!

	<% 	}
	%> 
	 
	
	
<%-- <%= request.getParameter("id") %>

<%= request.getParameter("fName") %>

<%= request.getParameter("lName") %> --%>

<br><br>
<%-- using param 

ID : ${param.id}
FN : ${param.fName}
LN : ${param.lName}
 --%>





</body>
</html>