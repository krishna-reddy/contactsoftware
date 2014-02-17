<html lang="en">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signin Template for Bootstrap</title>

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
      			
      			<li><a href="welcome.jsp">Home</a></li>

    		</ul>
  		 </div>
     </div>
</nav>

    <div class="container">

      <form class="form-signin" role="form" action="login.do" method="post">
        <h2 class="form-signin-heading" style="color:red">Invalid Login!</h2>
        <input type="text" name="uname" class="form-control" placeholder="Enter username " required autofocus pattern="[0-9A-Za-z._-]{0,100}">
        <input type="password"  name="password" class="form-control" placeholder="Enter Password" required>
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        
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
