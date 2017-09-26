employeeManagerApp.service('loginService', function () {
	this.validate = function (userId, password) {
        if(userId == 'volvo' && password == 'volvo'){
            return true;
        }
        return false;
    };
});