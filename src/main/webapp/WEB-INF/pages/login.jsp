	
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			
		<div class="container">
			<div class="row fluid">
				<!-- Creating a login form -->
				<div class="col-md-5">
					<h1>Employee Login</h1>
					<div class="loginpanel" style="padding-left: 30px">
						<div class="wrapper" style="width: 400px">
						<br><br>
						<form id="loginForm" name="loginForm">
						        <div class="form-group">
						            <label>Username</label>
						            <input type="text" 
						            	name="username" 
						            	class="form-control"
						            	ng-class="{ 'has-error' : loginForm.username.$invalid && !loginForm.username.$pristine }" 
						            	ng-model="username" 
						            	ng-maxlength="25"
						            	ng-pattern="/^[a-zA-Z0-9]+$/">
						            <p ng-show="loginForm.username.$error.maxlength" class="help-block">Username is too long.</p>
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
						            <p ng-show="loginForm.password.$error.maxlength" class="help-block">Password is too long.</p>
						        </div>
									<button ng-click="update()" 
											ng-disabled="loginForm.$invalid">Submit</button>
							</form>
						</div>
					</div>
				</div>
				<div class="col-md-7">
					<h1>HR Login</h1>
					<div class="loginpanel" style="padding-left: 30px">
						<div class="wrapper" style="width: 400px">
						<br><br>
						<form id="loginFormHr" name="loginFormHr">
						        <div class="form-group">
						            <label>Username</label>
						            <input type="text" 
						            	name="usernameHr" 
						            	class="form-control"
						            	ng-class="{ 'has-error' : loginFormHr.usernameHr.$invalid && !loginFormHr.usernameHr.$pristine }" 
						            	ng-model="usernameHr" 
						            	ng-maxlength="25"
						            	ng-pattern="/^[a-zA-Z0-9]+$/">
						            <p ng-show="loginFormHr.usernameHr.$error.maxlength" class="help-block">Username is too long.</p>
						        </div>
						        <div class="form-group">
						        	<label>Password</label>
						        	<input type="text" 
						        		name="passwordHr" 
						        		class="form-control"
						        		ng-class="{ 'has-error' : loginFormHr.passwordHr.$invalid && !loginFormHr.passwordHr.$pristine }" 
						        		ng-model="passwordHr" 
						        		ng-maxlength="25"
						        		ng-pattern="/^[a-zA-Z0-9]+$/">
						            <p ng-show="loginFormHr.passwordHr.$error.maxlength" class="help-block">Password is too long.</p>
						        </div>
									<button ng-click="updateHr()" 
											ng-disabled="loginFormHr.$invalid">Submit</button>
							</form>
						</div>
					</div>
				</div>
			</div>
			<br><br>
			<div class="alert alert-danger" ng-show="incorrectLogin == true">
			  <strong>Alert!</strong> Login Incorrect!
			</div>
		</div>
		<br>
	<div>

	
