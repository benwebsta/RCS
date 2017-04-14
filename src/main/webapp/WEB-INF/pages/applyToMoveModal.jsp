<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Password</title>
<style> 
	/*styling stuff*/
	textarea {
	    width: 90%;
	    margin: 0 auto;
	    height: 150px;
	    padding: 12px 20px;
	    box-sizing: border-box;
	    border: 2px solid #ccc;
	    border-radius: 4px;
	    background-color: #f8f8f8;
	    font-size: 16px;
	    resize: none;
	    position: relative;
	    display: block;
	    text-align: center;
	}
	
	h5 {
		text-align: center;
		font-weight: bold;
	}
</style>
</head>

<body>


	
	<div id="applyToMoveModal" class="modal fade">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h3 class="modal-title">Apply to Move</h3>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      
	      <div ng-controller="applyToMoveController">
	      <div class="modal-body">
	        <h5>Reason</h5>
				<textarea placeholder="Reason to move" ng-model="reasonToMove"></textarea>
	      </div>
	      <div class="modal-footer">
	      		
    		    	<button type="button" class="btn btn-primary" ng-click="send()">Submit</button>
    				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
	        </div>
	        
	      </div>
	    </div>
	  </div>
	</div>
	
</body>
</html>

