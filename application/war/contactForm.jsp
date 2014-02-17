
<html lang="en">
  <head>
   
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>Add Contact Template for Bootstrap</title>

   <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/signin.css" rel="stylesheet">
     </head>

  <body>

    <div class="container">

  <form action="addContact.do" class="form-signin" role="form" method="post">
     
  <div class="form-group">
    <label for="firstname" class="col-sm-2 control-label">First Name</label>
    <div class="col-sm-10">
      <input  type="text" name="firstname"  class="form-control" placeholder="First Name" required autofocus>
    </div>
  </div>
  
  <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">Last Name</label>
    <div class="col-sm-10">
      <input  type="text" name="lastname"   class="form-control"  placeholder="Last Name" required>
    </div>
  </div>
  
  <div class="form-group">
    <label for="company" class="col-sm-2 control-label">Company</label>
    <div class="col-sm-10">
      <input  type="text" name="company"  class="form-control"  placeholder="company" required>
    </div>
  </div>
 
  <div class="form-group">
    <label for="email" class="col-sm-2 control-label">Email</label>
    <div class="col-sm-10">
      <input  type="email" name="email"  class="form-control"  placeholder="email" required>
    </div>
  </div>
  
   <div class="form-group">
    <label for="telephone" class="col-sm-2 control-label">Mobile Number</label>
    <div class="col-sm-10">
      <input  type="text" name="telephone"  class="form-control"  placeholder="Mobile Number">
    </div>
  </div>
  
   <div class="form-group">
    <label for="address" class="col-sm-2 control-label">Address</label>
    <div class="col-sm-10">
    <textarea rows="5" cols="50"  name="address" class="form-control"  placeholder="address" ></textarea>
    </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">Add Contact</button>
    </div>
  </div>
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
