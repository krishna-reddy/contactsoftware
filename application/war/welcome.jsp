<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
  <head>
    <title>Adaptavant home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet"> 
    
    <link href="css/signin.css" rel="stylesheet">
  </head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
<div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Adaptavant Contact Management Software</a>
        </div>
       <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse">
              <ul class="nav navbar-nav navbar-right">

      			<li><a href="#signUp" data-toggle="modal">SignUp</a></li>

    		</ul>
  		 </div>
     </div>
</nav>

 <div class="container">

      <form class="form-signin" role="form" action="login.do" method="post">
        <h2 class="form-signin-heading" style="color:green"> Login Here!</h2>
        <input type="text" class="form-control" name="username" placeholder="Enter username " required autofocus pattern="[0-9A-Za-z._-]{0,100}">
        <input type="password"  name="password" class="form-control" placeholder="Enter Password" required>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        
      </form>

    </div> <!-- /container -->

<!--********start to create a dropup box for create account******-->
<div class="modal fade" id="signUp" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header" style="color:green">
			Registration Form
			</div>

			<div class="modal-body">
<!-- registration form goes here-->		
 <form action="register.do" method="post" role="form">
 <div class="form-group">
    <input type="text" class="form-control" name="username" placeholder="Enter unique user Name" required pattern="[0-9A-Za-z._-]{0,100}">
  </div>
  <div class="form-group">
    <input type="text" class="form-control" name="firstname" placeholder="Enter First Name" required>
  </div>
  
    <div class="form-group">
    <input type="text" class="form-control" name="lastname" placeholder="Enter Last Name" required>
  </div>
  
  <div class="form-group">
   
    <input type="email" class="form-control" name="email" placeholder="Enter email" required>
  </div>
  <div class="form-group">
      <input type="password" class="form-control" name="password" placeholder="Enter Password" required>
  </div>
 
  <button type="submit" class="btn btn-default">Submit</button>
</form>
<!-- end registration form -->		
		</div>
			<div class="modal-footer">
			<a class="btn btn-default" data-dismiss="modal">close</a>
			</div>
		</div>
	</div>
</div> 
<!--*******end dropup box for create account*********** -->

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
 	<script src="jquery/jquery.min.js"></script>
 	<script src="jquery/jquery.min.map"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>
