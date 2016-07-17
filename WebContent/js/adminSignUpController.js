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
	
	alert($('#admin_signup_form').serialize());
	if($("#admin_sign_psw").val()==$("#admin_sign_conf_psw").val()){
    	$.ajax({
            url: "adminservlet?action=register",
            method: "POST",
            data:  $('#admin_signup_form').serialize(),
            dataType: 'JSON',
            success: function(data) {
              	if(data.check){
              		$("#myModalAdminSignUp").modal("hide");
               		$("#myModal3").modal("show");
                }
                else{
                		alert('This email id is already registered')
                		$("#errordetails_signup").text("This email id is already registered").delay(3000).fadeOut();
                }
            },
            error: function(data) {
            	alert('Unknown Error Occured');
            }
        });
    }else{
    	alert('not correct')
    	$("#errordetails_signup").text("Password and confirm password fields are different...!").delay(3000).fadeOut();
    }   
    event.preventDefault();
}