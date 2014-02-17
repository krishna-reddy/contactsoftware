
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

    <title>Signup Template for Bootstrap</title>

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
      			
      			<li><a href="welcome.html">Home</a></li>

    		</ul>
  		 </div>
     </div>
</nav>

    <div class="container">

      <form method="post" class="form-signin" role="form" action="register.do">
        <h2 class="form-signin-heading" style="color:red">Try Again with valid username </h2>
        <div class="form-group">
    <input type="text" class="form-control" name="username" placeholder="Enter unique user Name" required autocomplete="on" pattern="[0-9A-Za-z._-]{0,100}">
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
  
  <button class="btn btn-lg btn-primary btn-block" type="submit">Sign Up</button>
      </form>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="jquery/jquery.min.js"></script>
 	<script src="jquery/jquery.min.map"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
