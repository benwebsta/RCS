<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body ng-app="rcs">



	<div id="showMessages" class="modal fade">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h3 class="modal-title">Messages</h3>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<div>
					<div class="modal-body" ng-controller="getMessages">

<!-- 						<h5>New Message</h5> -->

						<div id="messages">
							<form class="form-inline pull-right">
								<div class="form-group">
									<label>New Message: </label> <input type="text"
										name="newMessageContext" 
										ng-model="newMessageContext" placeholder="message">
								</div>
								<button type="submit" class="btn btn-primarty"
									ng-click="newMessage()">Send</button>
							</form>
							<br><br>
							<ul class="list-group">

								<li
									class="messages-loading list-group-item list-group-item-info"
									ng-if="loadingMessages">Loading</li>
								<li
									class="messages-loading list-group-item list-group-item-danger"
									ng-if="error">Error Getting Messages</li>
								<li 
									class="message-loading list-group-item list-group-item-danger"
									ng-if="sendingError">Error Sending Message</li>
								<li class="message-context list-group-item"
									ng-repeat="msg in msgs">{{msg.message}}</li>
							</ul>

						</div>

					</div>


				</div>
			</div>
		</div>
	</div>

</body>
</html>