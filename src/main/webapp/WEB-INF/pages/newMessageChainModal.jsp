<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>	
	<div id="newMessageChainModal" class="modal fade">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h3 class="modal-title">New Message Chain</h3>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      
	      <div>
	      <div class="modal-body" ng-app="rcs" ng-controller="newMessageChain">
	        <h5>New Message</h5>
	        	<form>
	        	<div class="form-group">
	        	<label>New Message</label>
				<input type="text" name = "newMessageContext" ng-model="newMessageContext" placeholder="message"/>
				</div>
				<div class="form-group">
				<label>User to Send </label>
				<select ng-model="selectedUser" ng-options="user for user in users">
				</select>
				</div>
				<div class="form-group">
				<label>Viewable to your Apartment</label>
				<input type="checkbox" ng-model="fromApartment"/>
				</div>
				<div class="form-group">
				<label>Viewable to other user's apartment</label>
				<input type="checkbox" ng-model="toApartment"/>
				</div>
				<button type="button" ng-click="newMessageChain()">Send</button>
				</form>
	      </div>

	      
	      </div>

	        
	      </div>
	    </div>
	  </div>
	
	
</body>
</html>