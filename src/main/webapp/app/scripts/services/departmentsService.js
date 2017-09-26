/**
 * Services for Departments 
 */

employeeManagerApp.service('departmentsService', function() {
	this.getDepartments = function () {
		return departments;
	};

	 this.getDepartment = function (id) {
	        for (var i = 0; i < departments.length; i++) {
	            if (departments[i].id === id) {
	                return departments[i];
	            }
	        }
	        return null;
	    };

 var departments = [
        {
            id: 1, code: '001', name: 'DVP', manager:'Deepak', location:'Bagmane-Parin', empno:'60'
        },
        {
            id: 2, code: '002', name: 'SITS', manager:'Sudheer', location:'Bagmane-Parin', empno:'200'
        },
        {
            id: 3, code: '003', name: 'MAS/DCL', manager:'ABC', location:'Bagmane-Parin', empno:'80'
        },
        {
            id: 4, code: '004', name: 'VGT', manager:'DEF', location:'Bagmane-Tridib', empno:'90'
        },
        {
            id: 5, code: '005', name: 'I/O', manager:'XYZ', location:'Bagmane-Lakeview', empno:'200'
        }
    ];


});