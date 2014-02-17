<html>
  <head>
    <title>Adaptavant home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/bootstrap.min.css" rel="stylesheet"> 
 </head>
 
<body bgcolor="#FFFFcc">


<nav class="navbar navbar-inverse " role="navigation">
	<div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Contact Details</a>
        </div>
        
       <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav navbar-right">
        
		<li><a href="logout.do"><button type="button" class="btn btn-default">Sign Out</button></a></li>
		<li><a href="#"><button type="button" class="btn btn-primary">${username }</button></a></li>
		</ul>
       </div>
  	</div>
  	
</nav>
<iframe src="leftframe.jsp" name="frame1" width="20%" height="100%"></iframe>
<iframe src="displayContacts.do" name="frame2" width="25%" height="100%"></iframe>
<iframe srcdoc="<h1><marquee> Welcome to contact management</marquee></h1>" name="frame3" width="54%" height="100%"></iframe>




    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="jquery/jquery.min.js"></script>
 	<script src="jquery/jquery.min.map"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>