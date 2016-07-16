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

function signUpUser(event){
    if($("#sign_psw").val()==$("#sign_conf_psw").val()){
    	$.ajax({
            url: "actorservlet?action=register",
            method: "POST",
            data:  $('#signup_form').serialize(),
            dataType: 'JSON',
            success: function(data) {
              	if(data.check){
              		$("#signupmodal").modal("hide");
               		$("#myModal").modal("show");
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