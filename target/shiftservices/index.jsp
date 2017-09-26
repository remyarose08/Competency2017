<!DOCTYPE html>
<html data-ng-app="employeeManagerApp">
<head>
<meta charset="ISO-8859-1">
<title>Employee Manager</title>
<link href="content/bootstrap.min.css" rel="stylesheet" />
<link href="content/bootstrap-responsive.min.css" rel="stylesheet" />
<link href="content/employeeManagementStyles.css" rel="stylesheet" />
</head>
<body>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="brand " href=""> <img
					src="content/images/people.png" alt="logo"> Employee Manager
				</a>
				<ul data-ng-show="userId" class="nav nav-pills"
					data-ng-controller="NavbarController" data-ng-cloak>
					<li data-ng-class="{'active':getClass('/employeeList')}"><a
						href="#/employeeList">Employees</a></li>
					<li data-ng-class="{'active':getClass('/departments')}"><a
						href="#/departments">Departments</a></li>
				</ul>
				<br/>
				<button data-ng-controller="LoginController" id="submitLogoff" class="btn btn-primary"
					style="float: right !important" type="button"
					data-ng-hide="!userId" data-ng-disabled="false"
					data-ng-click="logOffUser()" data-ng-cloak>Log off</button>
					
				<div class="error" data-ng-messages="errors" data-ng-cloak>					
					<p data-ng-repeat="error in errors"
						style="font-size:xx-medium;font-weight: bold; color: red !important;padding-top:2%; position: static;overflow: auto;"
						data-ng-message="{{error.type}}">{{error.message}}</p>
				</div>	
			</div>
		</div>
	</div>	

	<div>
		<!-- Placeholder for views -->
		<div data-ng-view=""></div>		
	</div>


	<!-- Vendor Libs: jQuery only used for Bootstrap functionality -->

	<script src="app/scripts/vendors/angular.js"></script>
	<script src="app/scripts/vendors/angular-route.js"></script>
	<script src="app/scripts/vendors/jquery.min.js"></script>

	<!-- UI Libs -->
	<script src="app/scripts/vendors/bootstrap.js"></script>

	<!-- App libs -->
	<script src="app/app.js"></script>
	<script src="app/scripts/controllers/controllers.js"></script>
	<script src="app/scripts/services/loginService.js"></script>
	<script src="app/scripts/services/employeeService.js"></script>
	<script src="app/scripts/services/departmentsService.js"></script>
	<script src="app/scripts/controllers/emp.js"></script>
</body>
</html>