//This handles retrieving data and is used by controllers. 3 options (server, factory, provider) with 
//each doing the same thing just structuring the functions/data differently.
employeeManagerApp.service('employeesService', function ($rootScope) {
	function getEmployeeJson() {
		return empJson = {
	         "firstName" : $("#firstName").val(),
	         "lastName" : $("#lastName").val(),
	         "employeeId" : $("#empId").val(),
	         "department" : $("#dept").val()
		};
	};
	
    this.insertEmployee = function(firstName, lastName, empId, dept, $scope) {
    	var currentScope = $scope;
    	 $.ajax({
             type : "POST",
             contentType : 'application/json; charset=utf-8',
             dataType : 'json',
             url : "/edm-uiservice-rest/api/employee/add",
             data : JSON.stringify(getEmployeeJson()),
             success : function(result) {
                 currentScope.$apply(function(){
                	 currentScope.employees.push(result); 
                 });
                  
             },
             error : function(e) {  
                    alert('Error occured please contact admin');    
       }  
      });
	};
	
	this.getEmployees = function ($scope) {
		var currentScope = $scope;
		 $.ajax({
             type : "GET",
             contentType : 'application/json; charset=utf-8',
             dataType : 'json',
             url : "/edm-uiservice-rest/api/employee/all/employees",
             success : function(result) {
                    currentScope.$apply(function (){
                    	currentScope.employees = result;
                    });
                    return result;
             },
             error : function(e) {  
                    alert('Error occured please contact admin');    
             }  
      });
    };
    
  this.getEmployeeDetails = function (empId, $scope) {
	  var currentScope = $scope;
	  $.ajax({
          type : "GET",
          contentType : 'application/json; charset=utf-8',
          dataType : 'json',
          url : "/edm-uiservice-rest/api/employee/details/" +empId,
          success : function(result) {
                
                 currentScope.$apply(function () {
                	 currentScope.employee = result;
					}); 
          },
          error : function(e) {  
                 alert('Error occured please contact admin');    
          }  
   });
};

	this.deleteEmployee = function(empId) {

		$.ajax({
			type : "POST",
			contentType : 'application/json; charset=utf-8',
			dataType : 'json',
			url: "/edm-uiservice-rest/api/employee/delete/" + empId,
			success : function(result) {

			},
			error : function(e) {
				alert('Error occured please contact admin');
			}
		});
	};

});