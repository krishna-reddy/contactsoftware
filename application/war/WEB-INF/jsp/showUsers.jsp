<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>  
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <table class="table table-bordered">
<tr style="color:#FF00FF"><th>firstname</th><th>lastname</th><th>company</th><th>email</th><th>telephone</th><th>address</th>
</tr>
<c:forEach items="${users}" var="user">
<tr style="background-color:#C0C0C0"><td>${user.firstname}</td>
<td>${user.lastname}</td>
<td>${user.company}</td>
<td>${user.email }</td>
<td>${user.telephone }</td>
<td>${user.address}</td>
</tr>
</c:forEach>
</table>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="jquery/jquery.min.js"></script>
 	<script src="jquery/jquery.min.map"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>