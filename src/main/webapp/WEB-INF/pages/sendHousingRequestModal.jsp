<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Housing Email</title>
<style> 
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
	}
</style>
</head>

<body>


	
	<div id="sendHousingRequestModal" class="modal fade">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h3 class="modal-title">Send Housing Request</h3>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      
	      <div ng-controller="sendHousingRequestController">
		      <div class="modal-body">
		      
				<h3><b>To:</b> housing@revature.com</h3>
				<hr>
				<div style="margin-left: 10px;" >
						<br><label>Who does this concern?</label>
					    <div class="form-group">
					        <div class="radio">
					            <label>
					                <input type="radio" checked="checked" name="Individual" value="individual" ng-model="whoItAffects" >
					                Just you
					            </label>
					        </div>
					        <div class="radio">
					            <label>
					                <input type="radio" name="house" value="Whole House" ng-model="whoItAffects">
					                The Whole House
					            </label>
					        </div>
					 </div>
				</div>
				<hr>
				
				<div class="row">	
					<input style="width: 90%; position: relative; margin: 0 auto; display: block;" type="text" 
					placeholder="Subject line" ng-model="header">
				</div>
				

				<form><br>
					<textarea placeholder="Email body" ng-model="body"></textarea>
		     	</form>	
		      </div>
		      <div class="modal-footer">
		      		<div class="row" ng-show="confirmBoolean">
		      			<div class="col-md-6">
		      				<div class="alert alert-success" ng-show="result == true">
							  <strong>Success!</strong> Email sent!
							</div>
							<div class="alert alert-danger" ng-show="result == false">
							  <strong>Alert!</strong> Email Failed to Send!
							</div>
		      			</div>
		      			<div class="col-md-3">
		      		    	<button type="button" class="btn btn-primary" ng-click="confirm()">Send Email</button>
		      			</div>
		      			<div class="col-md-3">
		      				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
		      			</div>
			        </div>
			        <div class="row" ng-show="!confirmBoolean">
		      			<div class="col-md-6">
		      				<div class="alert alert-success" ng-show="result == true">
							  <strong>Success!</strong> Email sent!
							</div>
							<div class="alert alert-danger" ng-show="result == false">
							  <strong>Alert!</strong> Email Failed to Send!
							</div>
		      			</div>
		      			<div class="col-md-3">
		      		    	<button type="button" class="btn btn-success" ng-click="send()">Send email to Housing</button>
		      			</div>
		      			<div class="col-md-3">
		      				<button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
		      			</div>
			        </div>
		        </div>
	      </div>
	      
	    </div>
	  </div>
	</div>
	
</body>
</html>

