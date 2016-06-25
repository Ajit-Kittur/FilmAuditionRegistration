function hideSignUpModal(){
	
	
	$("#signupmodal").modal("hide");
	
	$("#myModal").modal("show");
	
	$("#signupmodal").on('hidden.bs.modal', function (event) {
		  if ($('.modal:visible').length) //check if any modal is open
		  {
		    $('body').addClass('modal-open');//add class to body
		  }
		});
	
}