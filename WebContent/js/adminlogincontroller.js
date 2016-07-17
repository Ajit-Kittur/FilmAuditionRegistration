function showAdminLoginPopup(){
	
	$("#myModal3").modal("show");
}

function adminloginUser(){
	
	alert($('#admin_login_form').serialize());
	$.ajax({
    	url: "adminservlet?action=login",
    	method: "POST",
    	data:  $('#login_form').serialize(),
    	dataType: 'JSON',
        success: function(data) {
        	if(data != null){
        		sessionStorage.setItem("loginStatus", true);
        		jQuery.each( data, function( i, field ) {
        			if(i=="adminId" || i=="loginStatus"){
        				return true;
        			}
        			sessionStorage.setItem(i, field);
        		 });;
        		 $("#myModal").modal("hide");
        		 $("#logindiv").hide();
        		 $("#userdiv").show();
        		 $("#livediv").show();
        		 $("#userlabel").text("Welcome, " + sessionStorage.getItem("firstName"));
        	}
        	else{
        		$("#errordetails").text("Not a Valid User, please enter proper username and password !!!").delay(3000).fadeOut();
        	}
        },
    	error: function(data) {
    		$("#errordetails").text("Not a Valid User, please enter proper username and password !!!").delay(10000).fadeOut();
        }
      });
	event.preventDefault();
	

}

function showAdminSignUpModal(){
	$("#myModal3").modal("hide");
	$("#myModal3").on('hidden.bs.modal', function (event) {
		  if ($('.modal:visible').length) //check if any modal is open
		  {
		    $('body').addClass('modal-open');//add class to body
		  }
		});

	$("#myModalAdminSignUp").modal("show");
	
}

function showAdminForgotPasswordModal(){
	$("#myModal3").modal("hide");
	$("#myModal3").on('hidden.bs.modal', function (event) {
		  if ($('.modal:visible').length) //check if any modal is open
		  {
		    $('body').addClass('modal-open');//add class to body
		  }
		});
	
	$("#myModalAdminForgotPsw").modal("show");
	
}

function adminforgotPassword(){
	
	alert("Password Reset");
}

