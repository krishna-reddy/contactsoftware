<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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

  <form:form action="addContact.htm" class="form-horizontal" role="form" method="post">
     
  <div class="form-group">
    <form:label path="firstname" class="col-sm-2 control-label">First Name</form:label>
    <div class="col-sm-10">
     <form:input path="firstname" class="form-control"/>
    </div>
  </div>
  
  <div class="form-group">
    <form:label path="lastname" class="col-sm-2 control-label">Last Name</form:label>
    <div class="col-sm-10">
      <form:input  path="lastname" class="form-control"/>
    </div>
  </div>
  
  <div class="form-group">
    <form:label path="company" class="col-sm-2 control-label">Company</form:label>
    <div class="col-sm-10">
      <form:input   path="company" class="form-control" />
    </div>
  </div>
 
  <div class="form-group">
    <form:label path="email" class="col-sm-2 control-label">Email</form:label>
    <div class="col-sm-10">
      <form:input  path="email" class="form-control"/>
    </div>
  </div>
  
   <div class="form-group">
    <form:label path="telephone" class="col-sm-2 control-label">Mobile Number</form:label>
    <div class="col-sm-10">
      <form:input  path="telephone" class="form-control" />
    </div>
  </div>
  
   <div class="form-group">
    <form:label path="address" class="col-sm-2 control-label">Address</form:label>
    <div class="col-sm-10">
    <form:textarea rows="5" cols="50"  path="address" class="form-control"></form:textarea>
    </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Add Contact</button>
    </div>
  </div>
</form:form>
 
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
