


	
	<div id="createNewResidentModal" class="modal fade">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h3 class="modal-title">Create New Resident</h3>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      
	      <div class="modal-body" ng-controller="createNewResidentController">
			      <!-- edit form column -->
		        <h3>Personal info</h3>
		        
		        <form name="createResidentInput" class="form-horizontal" role="form">

		          <div class="form-group">
		            <label class="col-md-3 control-label">First Name:</label>
		            <div class="col-md-8">
		              <input class="form-control" type="text" ng-model="newEmployee.firstName">
		            </div>
		          </div>
		          <div class="form-group">
		            <label class="col-md-3 control-label">Last Name:</label>
		            <div class="col-md-8">
		              <input class="form-control" type="text" ng-model="newEmployee.lastName">
		            </div>
		          </div>
   		          <div class="form-group">
		            <label class="col-md-3 control-label">Email:</label>
		            <div class="col-md-8">
		              <input class="form-control" type="email" ng-model="newEmployee.email">
		            </div>
		          </div>
		          <div class="form-group">
		          	<!-- select from apartment list -->
		            <label class="col-md-3 control-label">Select Apartment:</label>
		            <div class="col-md-8">
		            	<select ng-model="selectedApartment" id="selectApartment" ng-focus="loadOptions()">
							<option ng-repeat="apt in apartments" ng-value="apt.apartmentId">{{apt.address}}</option>
						</select>
		            </div>
		          </div>
		          <div class="form-group">
		            <label class="col-md-3 control-label">Select Gender:</label>
		            <div class="col-md-8">
		              <select ng-model="selectedGender">
		              <option ng-value="1">Male</option>
		              <option ng-value="2">Female</option>
		              </select>
		            </div>
		          </div>
		        <div class="modal-footer">
		          <div class="form-group">
		            <div class="col-md-8">
	   		    		<button type="button" class="btn btn-primary" ng-click="update()" data-dismiss="modal">Create Resident</button>
	    				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
		            </div>
		          </div>
		        </div>
		        </form>
		      </div>
	      </div>
	    </div>
	  </div>

