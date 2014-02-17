<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet"> 
</head>
<body>

<c:forEach items="${companyCount}" var="company">
<ul class="nav nav-pills nav-stacked">
  <li>
    <a href='showUsers.do?company=${company.key}' target="frame3">
      <span class="badge pull-right">${company.value}</span>
      ${company.key}
    </a>
    </li>
  </ul>
<hr>
</c:forEach>

	
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="jquery/jquery.min.js"></script>
 	<script src="jquery/jquery.min.map"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>
 


