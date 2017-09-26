/** define controllers here* */
employeeManagerApp.controller('EmployeesController', function($scope,
		$rootScope, $routeParams, employeesService) {

	$scope.employees = [];
//	$scope.HOST='/edm-uiservice-rest/api/';
//	$scope.getEmployees=$scope.HOST+"employee/all/employees";
	init();

	function init() {
		 employeesService.getEmployees($scope);
	}
	
	

	$scope.insertEmployee = function() {
		var firstName = $scope.newEmployee.firstName;
		var lastName = $scope.newEmployee.lastName;
		var empId = $scope.newEmployee.empId;
		var dept = $scope.newEmployee.dept;
		employeesService.insertEmployee(firstName, lastName, empId, dept, $scope);
		$scope.newEmployee.firstName = '';
		$scope.newEmployee.lastName = '';
		$scope.newEmployee.empId = '';
		$scope.newEmployee.dept = '';
	};
	
	$scope.getEmployeeDetails = function(employeeId){
		console.log(employeeId);
		employeesService.getEmployeeDetails(employeeId, $scope);
	};
	
	$scope.deleteEmployee = function(id) {
		employeesService.deleteEmployee(id);
	};
});

employeeManagerApp.controller('NavbarController', function($scope, $location) {
	$scope.getClass = function(path) {
		if ($location.path().substr(0, path.length) == path) {
			return true;
		} else {
			return false;
		}
	};
});

employeeManagerApp
		.controller(
				'EmployeeDetailsController',
				function($scope, $routeParams, employeesService) {

					var controllerScope = $scope;
					controllerScope.employee = {};
					init();
					function init() {
						var temp;
						var employeeID = ($routeParams.employeeID) ? parseInt($routeParams.employeeID)
								: 0;
						if (employeeID > 0) {
							temp = employeesService.getEmployeeDetails(employeeID , controllerScope);
							
						}
					}

				});

employeeManagerApp.controller('DepartmentsController', function($scope,
		departmentsService) {

	$scope.departments = [];

	init();

	function init() {
		$scope.departments = departmentsService.getDepartments();
	}
	;

});
employeeManagerApp
		.controller(
				'DepartmentsDetailsController',
				function($scope, $routeParams, departmentsService) {

					$scope.dept = {};

					init();

					function init() {
						var departmentID = ($routeParams.departmentID) ? parseInt($routeParams.departmentID)
								: 0;
						if (departmentID > 0) {
							$scope.dept = departmentsService
									.getDepartment(departmentID);
						}
					}

				});

employeeManagerApp.controller('LoginController', function($scope, $rootScope,
		$location, loginService) {

	$rootScope.user = {};
	$rootScope.errors = [];

	$scope.validateCredentials = function() {
		var enteredUserId = $scope.userId;
		var enteredPassword = $scope.password;
		if (loginService.validate(enteredUserId, enteredPassword)) {
			$rootScope.userId = enteredUserId;
			$rootScope.password = enteredPassword;
			$rootScope.errors = [];// clear error messages
			$location.path("/employeeList");
		} else {
			$rootScope.errors = [];// clear error messages
			$rootScope.errors.push({
				type : "authError",
				message : "Invalid Credentials!!!"
			});
		}
	};

	$scope.logOffUser = function() {
		$rootScope.userId = "";
		$rootScope.password = "";
		$location.path("/login");
	};

	$scope.$on('$routeChangeStart', function(next, current) {
		$rootScope.errors = [];// clear error messages if any on route change
		if (!$rootScope.userId) {
			$location.path("/login");
		}
	});
});
