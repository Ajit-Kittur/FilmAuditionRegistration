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

function adminSignUpUser(){
	
	alert("Admin Sign Up");
}