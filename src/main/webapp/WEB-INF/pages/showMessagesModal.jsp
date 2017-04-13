<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body ng-app="rcs" ng-controller="getMessages">


	
	<div id="showMessages" class="modal fade">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h3 class="modal-title">Messages</h3>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      
	      <div>
	      <div class="modal-body">
	        <h5>New Message</h5>
				<input type="text" name = "newMessageContext" ng-model="newMessageContext" placeholder="message">
				<button type="button" ng-click="newMessage()">Send</button>
	      </div>
	      <div class="modal-body">
	      	<div id = "messages">
	      		<div class="message-context" ng-repeat="msg in msgs">
	      			{{msg.message}}
	      		</div>
	      	
	      	</div>
	      
	      </div>

	        
	      </div>
	    </div>
	  </div>
	</div>
	
</body>
</html>