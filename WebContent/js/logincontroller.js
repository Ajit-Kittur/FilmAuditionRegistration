var users = [{"username":"john","password":"john123"},{"username":"smith","password":"smith123"},{"username":"mat","password":"mat123"}];

function showLoginPopup() {
	$("#myModal").modal("show");
}

function showSignUpModal(){
	
	$("#myModal").modal("hide");
	$("#myModal").on('hidden.bs.modal', function (event) {
		  if ($('.modal:visible').length) //check if any modal is open
		  {
		    $('body').addClass('modal-open');//add class to body
		  }
		});

	$("#signupmodal").modal("show");

}

function liveAudition(){
	$("#myModal1").modal("show");
	$('#myModal1').modal({
	    backdrop: 'static',
	    keyboard: false
	})
}

function loginUser(event){
		
        alert($('#login_form').serialize());
    	$.ajax({
        	url: "actorservlet?action=login",
        	method: "POST",
        	data:  $('#login_form').serialize(),
        	dataType: 'JSON',
            success: function(data) {
            	if(data != null){
            		sessionStorage.setItem("loginStatus", true);
            		jQuery.each( data, function( i, field ) {
            			if(i=="actorId" || i=="loginStatus"){
            				return true;
            			}
            			sessionStorage.setItem(i, field);
            		 });;
            		 $("#myModal").modal("hide");
            		 $("#logindiv").hide();
            		 $("#userdiv").show();
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



