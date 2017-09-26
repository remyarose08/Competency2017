$( document ).ready(function() {
	$("#submitEmployee").click(function(){
		console.log("clicked");
		insertEmployees();
	});
});

$( document ).ready(function() {
	$("#searchemployee").click(function(){
		console.log("clicked");
		getEmployee();
	});
});


function insertEmployees(){
    $.ajax({
           type : "POST",
           contentType : 'application/json; charset=utf-8',
           dataType : 'json',
           url : "/edm-uiservice-rest/api/employee/add",
           data : JSON.stringify(getEmployeeJson()),
           success : function(result) {
                  alert("Employee saved successfully");  
                
           },
           error : function(e) {  
                  alert('Error occured please contact admin');    
     }  
    });

}

function getEmployeeJson() {
	return empJson = {
         "firstName" : $("#firstName").val(),
         "lastName" : $("#lastName").val(),
         "empId" : $("#empId").val(),
         "dept" : $("#dept").val()
	};
}