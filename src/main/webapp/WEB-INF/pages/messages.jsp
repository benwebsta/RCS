
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h1 class="page-header">Messages Page</h1>
	<div ng-controller="getMessageChainsController">
		<div id="message-chain-list">
			<div class="container">
				<button type="button" class="btn btn-primary"
					ng-click="getMessageChains()">Refresh</button>
				<button type="button" class="btn btn-primary pull-right"
					ng-click="showNewMessageModel()">New Message Chain</button>
				<br /> <br />
				<div class="alert alert-info" id="loading-message-chains-feedback"
					ng-if="loadingMessages">Loading</div>
				<div class="alert alert-danger" id="error-loading-chains-feedback"
					ng-if="error">Unable to load messages</div>
			</div>
			<div class="container list-group">
				<a href="#" class="list-group-item"
					ng-click="onChainClick(chain.chainId)" class="chain"
					ng-repeat="chain in chains" style="border: 1px solid black;"> <span
					class="group-one-list"> <span ng-if="chain.group1.employee1">{{chain.group1.employee1.firstName}}
							{{chain.group1.employee1.lastName}}</span><span
						ng-if="chain.group1.employee2">,
							{{chain.group1.employee2.firstName}}
							{{chain.group1.employee2.lastName}}</span><span
						ng-if="chain.group1.employee3">,
							{{chain.group1.employee3.firstName}}
							{{chain.group1.employee3.lastName}}</span><span
						ng-if="chain.group1.employee4">,
							{{chain.group1.employee4.firstName}}
							{{chain.group1.employee4.lastName}}</span><span
						ng-if="chain.group1.employee5">,
							{{chain.group1.employee5.firstName}}
							{{chain.group1.employee5.lastName}}</span><span
						ng-if="chain.group1.employee6">,
							{{chain.group1.employee6.firstName}}
							{{chain.group1.employee6.lastName}}</span>
				</span></br> <span class="group-two-list"> <span
						ng-if="chain.group2.employee1">{{chain.group2.employee1.firstName}}
							{{chain.group2.employee1.lastName}}</span><span
						ng-if="chain.group2.employee2">,
							{{chain.group2.employee2.firstName}}
							{{chain.group2.employee2.lastName}}</span><span
						ng-if="chain.group2.employee3">,
							{{chain.group2.employee3.firstName}}
							{{chain.group2.employee3.lastName}}</span><span
						ng-if="chain.group2.employee4">,
							{{chain.group2.employee4.firstName}}
							{{chain.group2.employee4.lastName}}</span><span
						ng-if="chain.group2.employee5">,
							{{chain.group2.employee5.firstName}}
							{{chain.group2.employee5.lastName}}</span><span
						ng-if="chain.group2.employee6">,
							{{chain.group2.employee6.firstName}}
							{{chain.group2.employee6.lastName}}</span>
				</span>
				</a>
				</ul>
			</div>
		</div>
	</div>
</div>

