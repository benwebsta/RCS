<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Password</title>
</head>

<body ng-app="rcs">


	
	<div id="sendMaintenanceRequestModal" class="modal fade">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h3 class="modal-title">Send Maintenance Request</h3>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      
	      <div>
	      <div class="modal-body">
				To: <input type="text" value="maintenance@revature.com">
	        <h5>Email body</h5>
				<input type="text" placeholder="email">
	      </div>
	      <div class="modal-footer">
    		    	<button type="button" class="btn btn-primary">Send</button>
    				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
	        </div>
	        
	      </div>
	    </div>
	  </div>
	</div>
	
</body>
</html>

