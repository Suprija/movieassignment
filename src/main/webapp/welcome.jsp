<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<c:set var="contextPath" value="${pageContext.request.contextPath}"/> 

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

    <title>Create an account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<%-- <h1> ${contextPath}</h1> --%>
<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2><i>Welcome ${pageContext.request.userPrincipal.name}</i> | <a onclick="document.forms['logoutForm'].submit()">Logout</a> | <a href="${contextPath}/profile">Profile</a></h2>
         

  <form action=" ${contextPath}/choices" method="post"/>
  <table align="center"><tr>
 <td>Location :</td>
 <td><form:select path="locations" name="locations" required="required">
            <form:option value="" label="--- Select ---" />
            <form:options  items="${locations}"  />
        </form:select></td>
 </tr>
 
 <tr> 
 <td>Language :</td>
 <td>
 <form:radiobuttons path="languages" name="languages" items="${languages}" required="required"/>
 </td>
 </tr>
 <tr>
<td><input type="date" id="myDate" name="date" min="" max="" onfocus="myFunction1()" required>
</td>
</tr>
 
 <%-- <tr><td><c:forEach var=movies items=${locations}>
		
			<span>LOcation : </span> <span> ${locations.loc} </span>
			<span>Theatre :</span> <span> ${locations.theatre} </span>
			
			</c:forEach></td></tr> --%>
         
         
         <tr><td></td><td><button class="w3-btn w3-black">Submit</button></td> </table> 
        <!--  <div id="welcomeDiv"  style="display:none;" class="answer_list" > 
         <br><br>
         WELCOME</div> -->
         
    </c:if>

</div>


 <script>
/* function myFunction() {
	window.location = '/options.jsp';
	   //document.getElementById('welcomeDiv').style.display = "block";
}  */
</script>
<!-- <button onclick="myFunction()">Click me</button>
<p id="error">
</p>
/containerdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
<script>
function myFunction() {
	  var s=document.getElementById("source");
			 document.getElementById("error").innerHTML="source and destination are not same"; 
	  
	  document.getElementById("error").innerHTML="source and destination cant be same para";
	}ddddddd
</script> -->
<!-- <script>
 function myFunction() {
	 var lang=document.querySelector('input[name="movie"]:checked').value;
	localStorage.langselected=lang;
	   //document.getElementById('welcomeDiv').style.display = "block";
}  
</script> -->
<script>
    function myFunction1(){
        var d=new Date();
    var y=d.getFullYear()+"-0"+(d.getMonth()+1)+"-"+d.getDate();
     document.getElementById("myDate").min=y;
    var z=d.getFullYear()+"-0"+(d.getMonth()+1)+"-"+(d.getDate()+7);
    document.getElementById("myDate").max=z;
    //alert(""+document.getElementById("myDate").value);
    }
    
    /* function func()
    {
    	alert(""+document.getElementById("myDate").value);
    } */
    </script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>