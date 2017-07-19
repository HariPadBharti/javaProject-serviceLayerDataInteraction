<%@ page import="com.samson.sakilaproject.service.ActorService" %>
<%@ page import="com.samson.sakilaproject.service.IActorService" %>
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
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}
th{
	color : dddddd;
	border: 2px solid #A18036;
    text-align: left;
    padding: 8px
}

td {
    border: 2px solid #A18036;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #ECF1B1;
}
tr:nth-child(odd) {
    background-color: #AAF065;
}
</style>
<body>

<%

ActorService service = new ActorService();
List<ActorBo> list = new ArrayList<ActorBo>();
	 list = service.findAll();

%>

<table >
	<tr>
    <th> Actor Id</th>
    <th>First Name</th>
    <th>Last Name </th>
    
  </tr>
  
  <%
for(ActorBo bo : list){%>

	<tr>
<%-- 	<td><%= bo.getFilmId() %></td> --%>
<%-- 	<td><%= bo.getActorId()%></td>  --%>
	<td><%= bo.getActorId() %></td>
	<td><%= bo.getFirstName()%></td> 
	<td><%= bo.getLastName() %> </td>
	
<%--	<td><%= bo.getLastName() %></td> --%>
	</tr>
<% } %>

</table>
  
  
  
<%--   

<table id="myTable" style="border: 1px solid;">
	<tr>

	
    <th onclick="sortTable(0)" bgcolor="3F749E">Actor Name</th>
    <th onclick="sortTable(1)" bgcolor="3F749E">Film Id</th>
    
    
  </tr>
<%
for(ActorBo bo : list){%>

	<tr>

	
	<td><%= bo.getFirstName() %></td>
	<td>
	 <table>

        <tr>
        
          
          <%
            List<ActorBo> filmList = bo.getActorId();
             for(ActorBo filmBo : filmList){
            	 %>
            	   <tr><%= filmBo.getTitle() %></tr>
            	   <br></br>
            	   
            	 <%
           
             }
          
          %>
     
        </tr>
      </table>
	
	</td> 
	</tr>
<% } %>

</table>
<script type="text/javascript">
function sortTable(n) {
  var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
  table = document.getElementById("myTable");
  switching = true;
  //Set the sorting direction to ascending:
  dir = "asc"; 
  /*Make a loop that will continue until
  no switching has been done:*/
  while (switching) {
    //start by saying: no switching is done:
    switching = false;
    rows = table.getElementsByTagName("TR");
    /*Loop through all table rows (except the
    first, which contains table headers):*/
    for (i = 1; i < (rows.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /*Get the two elements you want to compare,
      one from current row and one from the next:*/
      x = rows[i].getElementsByTagName("TD")[n];
      y = rows[i + 1].getElementsByTagName("TD")[n];
      /*check if the two rows should switch place,
      based on the direction, asc or desc:*/
      if (dir == "asc") {
        if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
          //if so, mark as a switch and break the loop:
          shouldSwitch= true;
          break;
        }
      } else if (dir == "desc") {
        if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
          //if so, mark as a switch and break the loop:
          shouldSwitch= true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /*If a switch has been marked, make the switch
      and mark that a switch has been done:*/
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
      //Each time a switch is done, increase this count by 1:
      switchcount ++;      
    } else {
      /*If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again.*/
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}
</script> --%>


</body>
</html>