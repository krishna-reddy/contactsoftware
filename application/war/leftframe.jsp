<%@ page import="org.springframework.context.ApplicationContext
,com.adaptavant.counter.service.config.ApplicationContextProvider,com.adaptavant.counter.service.sharedcounter.SharedCounterService"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet"> 
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

</head>
<body>
<%
		//get the counter bean object
		ApplicationContext ctx = ApplicationContextProvider.getApplicationContext();
		SharedCounterService app=(SharedCounterService) ctx.getBean("sharedCounterService");
		//get username from the session
		String uname=(String) session.getAttribute("username");
		int count=app.getCount(uname+"-contacts-counter");
		int count1=app.getCount(uname+"-company-counter");
		
%>

<ul class="nav nav-pills nav-stacked">

  <li>
    <a  id="show" href="displayContacts.do" target="frame2">
      <span class="badge pull-right"><%=count %></span>
      My Contacts
    </a>
 	 </li>
  	
	<li>
    <a href="displayCompanies.do" target="frame2">
      <span class="badge pull-right"><%=count1 %></span>
      Companies
    </a>
 	 </li>
 	 <li>
    <a href="contactForm.jsp" target="frame3">
     New Contact
    </a>
  </li>
</ul>

	   
<!--   <script type="text/javascript">
  document.getElementById('show').click();
  </script> -->
<script src="jquery/jquery.min.js"></script>
<script src="jquery/jquery.min.map"></script>
<script src="js/bootstrap.min.js"></script>

<!-- <script type="text/javascript">
$(document).ready(function(){
    $.ajax({
    url:"displayContacts.do",
    success:function(result){
      $("#show").html(result);
      }
    });
 
});
</script> -->
</body>
</html>