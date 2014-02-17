<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
 <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet"> 
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="jquery/jquery.min.js"></script>
 	<script src="jquery/jquery.min.map"></script>
    <script src="js/bootstrap.min.js"></script>
   
</head>

<body>

<c:forEach items="${contacts}" var="contact">

<div class='clonedInput'>
<ul class="nav nav-pills nav-stacked">
  	<li><a href="#">${contact.firstname} </a>
  	</li>
  
 	 <li><a href="#">${contact.company}</a>
  	</li>
  
  	<li><a href="#">Contact Methods<span class="badge pull-right">${contact.contactMethods }</span> </a>
  	</li>
  	
    <button><li><a href='getContact.do?email=${contact.email }' target="frame3">update</a></button>
 
  	<button class='btnDel'><a href='deleteContact.do?email=${contact.email }' target="frame3">delete</a></button>
  	</li>
</ul>
<hr>
</div>
</c:forEach>

<script type="text/javascript">
$(function(){
	$('.btnDel').click(function() {
        if (confirm('You want continue to delete?')) {
            $(this).closest('.clonedInput').remove();
           return true;
        }
        else{
        	return false;
        }
    });
});
</script>
</body>
</html>
 


