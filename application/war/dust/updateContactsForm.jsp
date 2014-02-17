
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

  <form action="updateContact.htm" class="form-horizontal" role="form" method="post">
     
  <div class="form-group">
    <label for="fname" class="col-sm-2 control-label">First Name</label>
    <div class="col-sm-10">
      <input  type="text" name="fname" value="${contact.fname }"  class="form-control" id="fname" placeholder="First Name" required autofocus>
    </div>
  </div>
  
  <div class="form-group">
    <label for="lname" class="col-sm-2 control-label">Last Name</label>
    <div class="col-sm-10">
      <input  type="text" name="lname" value="${contact.lname }"  class="form-control" id="lname" placeholder="Last Name" required>
    </div>
  </div>
  
  <div class="form-group">
    <label for="company" class="col-sm-2 control-label">Company</label>
    <div class="col-sm-10">
      <input  type="text" name="company" value="${contact.company }"  class="form-control" id="company" placeholder="company" required>
    </div>
  </div>
 
  <div class="form-group">
    <label for="email" class="col-sm-2 control-label">Email</label>
    <div class="col-sm-10">
      <input  type="email" name="email" value="${contact.email }"  class="form-control" id="email" placeholder="email" readonly>
    </div>
  </div>
  
   <div class="form-group">
    <label for="mnumber" class="col-sm-2 control-label">Mobile Number</label>
    <div class="col-sm-10">
      <input  type="text" name="mnumber" value="${contact.mnumber }"  class="form-control" id="mnumber" placeholder="Mobile Number">
    </div>
  </div>
  
   <div class="form-group">
    <label for="address" class="col-sm-2 control-label">Address</label>
    <div class="col-sm-10">
    <textarea rows="5" cols="50" id="address" name="address" class="form-control"  placeholder="address" >${contact.address }</textarea>
    </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Update</button>
    </div>
  </div>
</form>
 
    </div> <!-- /container -->
	
	
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="jquery/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
