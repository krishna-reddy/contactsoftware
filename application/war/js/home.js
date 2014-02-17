$(document).ready(function(){
    	 
    $(".save").hide();
    
	$(".delete").click(function(){
	    
		var isOk=confirm("You want to delete!");
		if(isOk){
	    $("form").attr("action","deleteContact.htm");
	    
		}
	  
	  });
  
	$(".edit").click(function(){
	    
		var isOk=confirm("You want to edit!")
		if(isOk){
		$(".save").show();
		
	    $("input").attr("disabled",false);
		}
	  
	  });
	  
	$(".save").click(function(){
    
	var isOk=confirm("You want to update!");
	if(isOk){
    $("form").attr("action","updateContact.htm");
    }
  	});
	
	
  });
