function showAdminLoginPopup(){
	
	$("#myModal3").modal("show");
}

function adminloginUser(){
	
	alert("sucessfully logged")
	
}

function showSignUpModal(){
	$("#myModal3").modal("hide");
	$("#myModal3").on('hidden.bs.modal', function (event) {
		  if ($('.modal:visible').length) //check if any modal is open
		  {
		    $('body').addClass('modal-open');//add class to body
		  }
		});

	$("#myModalAdminSignUp").modal("show");
	
}

function hideAdminSignUpModal(){
	$("#myModalAdminSignUp").modal("hide");
	$("#myModalAdminSignUp").on('hidden.bs.modal', function (event) {
		  if ($('.modal:visible').length) //check if any modal is open
		  {
		    $('body').addClass('modal-open');//add class to body
		  }
		});
	$("#myModal3").modal("show");
}



function showForgotPasswordModal(){
	$("#myModal3").modal("hide");
	$("#myModal3").on('hidden.bs.modal', function (event) {
		  if ($('.modal:visible').length) //check if any modal is open
		  {
		    $('body').addClass('modal-open');//add class to body
		  }
		});
	
	$("#myModalAdminForgotPsw").modal("show");
	
}
