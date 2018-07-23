
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Insert title here</title>
</head>
<body>
<form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form><h3><i>Welcome ${pageContext.request.userPrincipal.name}</i></h3>
<a onclick="document.forms['logoutForm'].submit()"><p style="color:blue;"><label style="font-size: 25px;">Logout</label></p></a>
<table class="w3-striped" align="center">
<tr>
      <th>Movie</th>
      <th>Location</th>
      <th>Theatre</th>
      <th>Language</th>
	  <th>Tickets</th>
	  <th>Ticket Class</th>
	  <th>Tickets Price</th>
	  <th>Date</th>
	  
    </tr>
<c:forEach var="history" items="${history}">

<tr>
      <td>${history.movie}</td>
      <td>${history.loc}</td>
      <td>${history.theatre}</td>
      <td>${history.lang}</td>
	  <td>${history.tickets}</td>
	  <td>${history.ticketclass}</td>
	  <td>${history.ticketsprice}</td>
	 <td>${history.dates}</td>
	 
    </tr>


		
			
			</c:forEach>
			</table>
</body>
</html>