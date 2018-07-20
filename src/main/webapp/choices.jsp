<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

</head>
<body>
<form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form><h2>Welcome ${pageContext.request.userPrincipal.name}</h2>
<a onclick="document.forms['logoutForm'].submit()" ><p style="color:blue;"><label style="font-size: 20px;">Logout</label></p></a>
<form action=" ${contextPath}/redirect" />

<table align="center">
<tr>
<td>Location :</td><td name="location">${location}</td></tr>
<td>Location :</td><td name=languages>${languages}</td></tr>
 <td>Date :</td><td name="dateb">${dateb}</td></tr> 

<tr><td>Movie--Theatre--Available Tickets : </td>
<c:forEach var="list" items="${list}">
		
			<td>
			<input type="radio" name="movie" value=${list.movie} data=${list.tickets} onchange="checktickets()" id="movie" required><label style="font-size: 20px;">${list.movie} -- ${list.theatre} -- ${list.tickets}</label>
			</td><%-- <td id="availabletickets"><label style="font-size: 20px;"> --${list.tickets}</label>
			</td> --%></c:forEach></tr>
			<tr><td></td><td id="housefull" style="color:red"></td></tr>
			
		<tr>
		<td>Number of Tickets :</td>
		<td>
		<select name="tickets" id="tickets" onchange="checktickets()" required>
<option value="">Select</option>  
<option value=1>1</option>
  <option value=2>2</option>
  <option value=3>3</option>
  <option value=4>4</option>
    <option value=5>5</option>
  
</select>
		</td><td><font color='red'> <DIV id="une"> </DIV> </font></td>
		</tr>
		<tr>
		<td>Ticket Class :</td>
		 <td><input type="radio" name="ticketclass" value=80 data=80 id="silver" onchange="checktickets()" required> Silver-Rs.80</td>
		<td><input type="radio" name="ticketclass" value=100 data=100 id="gold" onchange="checktickets()" required> Gold-Rs.100</td>
  <td><input type="radio" name="ticketclass" value=150 data=150 id="platinum" onchange="checktickets()" required> Platinum-Rs.150</td>

		</tr>
<tr><td id="pricedesc">Price to be paid :</td><td id="price"></td></tr>
			</table>
			
			<h3>Payment:</h3>
<p>-------------</p>
<p>-------------</p>
			<button class="w3-btn w3-black">Pay</button>

<script>
 
 function checktickets()
 {
	 var tickets=document.getElementById("tickets");
var classt=document.querySelector('input[name="movie"]:checked').getAttribute("data");
var tick=parseInt(classt);
if(tick==0)
	{
					document.getElementById('housefull').innerHTML = "Housefull";
					document.getElementById("movie").checked = false;
	}
	else {					document.getElementById('housefull').innerHTML = "";
}
if(tickets.value>tick)
{
document.getElementById('une').innerHTML = "More not allowed";
			tickets.value="";
					document.getElementById("price").innerHTML="";
}
else if(tickets.value<=tick)
		{
					document.getElementById('une').innerHTML = "";
					var price=tickets.value * tick;
					document.getElementById("price").innerHTML=""+price;
		}
else
{
		document.getElementById("price").innerHTML="";
}
	/*if (document.getElementById('movie').checked) {
		var rate = parseInt(document.getElementById('movie').getAttribute("data"));
		//var rate = document.getElementById('first').value;
		if(tickets.value>rate)
		{
			//alert("Wrong");
			document.getElementById('une').innerHTML = "More not allowed";
			one.value="";
					document.getElementById("price").innerHTML="";
			//one.focus();
		}
		else if(tickets.value<=rate)
		{
					document.getElementById('une').innerHTML = "";
		var price=tickets.value * rate;
		document.getElementById("price").innerHTML=""+price;
		}
}*/
/*else if (document.getElementById('second').checked) {
		var rate = parseInt(document.getElementById('second').getAttribute("data"));
		//var rate = document.getElementById('second').value;
		if(one.value>rate)
		{
			//alert("Wrong");
			document.getElementById('une').innerHTML = "More not allowed";
			one.value="";
								document.getElementById("price").innerHTML="";
			//one.focus();
		}
		else if(one.value<=rate)
		{
					document.getElementById('une').innerHTML = "";
					var price=one.value * rate;
					document.getElementById("price").innerHTML=""+price;
		}
}*/
/*else 
{
	document.getElementById("price").innerHTML="";
}*/
	if (document.getElementById('silver').checked) {
var rate = parseInt(document.getElementById('silver').getAttribute("data"));
		var price=tickets.value * rate;
			
		document.getElementById("price").innerHTML=""+price;
//alert(""+price);
			
		}
else if (document.getElementById('gold').checked) {
var rate = parseInt(document.getElementById('gold').getAttribute("data"));
		var price=tickets.value * rate;
			
		document.getElementById("price").innerHTML=""+price;
		
}
else if (document.getElementById('platinum').checked) {
var rate = parseInt(document.getElementById('platinum').getAttribute("data"));
		var price=tickets.value * rate;
			
		document.getElementById("price").innerHTML=""+price;
		
}
else
{
		document.getElementById("price").innerHTML="";
}//alert(""+tickets.value);
}
 
 
 
 
			
</script>			
			
			<!-- <script>
			
			function ticketCheck(){
				var number=document.getElementById("tickets");
				var movie=document.getElementById("movie");
				if(number.value>movie.value)
					{ 
					alert("Selected tickets cannot be more than available!!");
					//document.getElementById("price").innerHTML="Total Price :"+number.value +""+movie.value;
					}
				
			}
			 -->
			 
			
			<!-- <script>
			
  function priceCalculate() {
	 var classt=document.querySelector('input[name="ticketclass"]:checked');
	 var number=document.getElementById("tickets");
	 var price=classt.value * number.value;
	 document.getElementById("price").innerHTML="Total Price :"+price;
	//window.location = '/options.jsp';
	   //document.getElementById('welcomeDiv').style.display = "block";
}   
</script> --> 
			
			
	</form>		
</body>
</html>