/*#######################################################################
  
  Normally like to break AngularJS apps into the following folder structure
  at a minimum:

  /app
      /controllers      
      /directives
      /services
      /partials
      /views

  #######################################################################*/

var employeeManagerApp = angular.module('employeeManagerApp', [ 'ngRoute' ]);

employeeManagerApp.config(function($routeProvider) {
	
	$routeProvider
	.when('/login',
			{
		controller: 'LoginController',
		templateUrl: 'app/scripts/views/loginView.html'
		
	})
	.when('/employeeList', 
			{
		controller : 'EmployeesController',
		templateUrl : 'app/scripts/views/employeeListView.html'
	})
	.when('/employees/:employeeID', 
			{
		controller : 'EmployeeDetailsController',
		templateUrl : 'app/scripts/views/employeeDetailsView.html'
	})
	.when('/departments',
			{
		controller : 'DepartmentsController',
		templateUrl : 'app/scripts/views/listDepartments.html'
	})
	.when('/departments/:departmentID',
			{
		controller : 'DepartmentsDetailsController',
		templateUrl : 'app/scripts/views/departmentDetails.html'
	})
	.otherwise({
		redirectTo : '/login'
	});
});




