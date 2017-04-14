	
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			
		<div class="container">
			<div class="row fluid">
				<!-- Creating a login form -->
				<div class="col-md-5">
					<h1>Employee Login</h1>
					<div class="loginpanel" style="padding-left: 30px">
						<div class="wrapper" style="width: 400px">
						<br><br>
						<form id="loginForm" name="loginForm" ng-submit="loginForm.$valid && update()">
						        <div class="form-group">
						            <label>Username</label>
						            <input type="text" 
						            	name="username" 
						            	class="form-control"
						            	ng-class="{ 'has-error' : loginForm.username.$invalid && !loginForm.username.$pristine }" 
						            	ng-model="username" 
						            	ng-maxlength="25"
						            	ng-pattern="/^[a-zA-Z0-9]+$/">
						            <div ng-show="loginForm.username.$invalid" class="alert alert-danger help-block"><strong>Alert!</strong> Username is invalid</div>
						        </div>
						        <div class="form-group">
						        	<label>Password</label>
						        	<input type="text" 
						        		name="password" 
						        		class="form-control"
						        		ng-class="{ 'has-error' : loginForm.password.$invalid && !loginForm.password.$pristine }" 
						        		ng-model="password" 
						        		ng-maxlength="25"
						        		ng-pattern="/^[a-zA-Z0-9]+$/">
						            <div ng-show="loginForm.password.$invalid" class="alert alert-danger help-block"><strong>Alert!</strong> Password is invalid</div>
						        </div>
									<button type="submit">Submit</button>
									<div ng-init="incorrectLogin = false" ng-show="incorrectLogin" class="alert alert-danger help-block"><strong>Alert!</strong> Login Incorrect!</div>
							</form>
						</div>
					</div>
				</div>
				<div class="col-md-7">
					<h1>HR Login</h1>
					<div class="loginpanel" style="padding-left: 30px">
						<div class="wrapper" style="width: 400px">
						<br><br>
						<form id="loginFormHr" name="loginFormHr" ng-submit="loginFormHr.$valid && updateHr()">
						        <div class="form-group">
						            <label>Username</label>
						            <input type="text" 
						            	name="usernameHr" 
						            	class="form-control"
						            	ng-model="usernameHr" 
						            	ng-maxlength="25"
						            	ng-pattern="/^[a-zA-Z0-9]+$/">
						            <div ng-show="loginFormHr.usernameHr.$invalid" class="alert alert-danger help-block"><strong>Alert!</strong> Username is invalid</div>
						        </div>
						        <div class="form-group">
						        	<label>Password</label>
						        	<input type="text" 
						        		name="passwordHr" 
						        		class="form-control"
						        		ng-model="passwordHr" 
						        		ng-maxlength="25"
						        		ng-pattern="/^[a-zA-Z0-9]+$/">
						            <div ng-show="loginFormHr.passwordHr.$invalid" class="alert alert-danger help-block"><strong>Alert!</strong> Password is invalid</div>
						        </div>
									<button type="submit">Submit</button>
									<div ng-init="incorrectLoginHr = false" class="alert alert-danger help-block" ng-show="incorrectLoginHr"><strong>Alert!</strong> Login Incorrect!</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<br><br>

		</div>
		<br>
	<div>

	
