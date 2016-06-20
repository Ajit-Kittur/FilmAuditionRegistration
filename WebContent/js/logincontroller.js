var users = [{"username":"john","password":"john123"},{"username":"smith","password":"smith123"},{"username":"mat","password":"mat123"}];

function showLoginPopup() {
	$("#myModal").modal("show");
}

function showSignUpModal(){
	
	$("#myModal").modal("hide");
	
	$("#signupmodal").modal("show");
	
}

function liveAudition(){
	
	$("#myModal1").modal("show");
	
}

function loginUser(){
	
	var usrname = $("#usrname").val();
	var psw = $("#psw").val();
	
	if(validateUser(usrname, psw)){
		$("#myModal").modal("hide");
		$("#logindiv").hide();
		$("#userdiv").show();
		$("#userlabel").text("Welcome, " + usrname);
		
		userLoggedInFlag = true;
	}else{
		$("#errordetails").text("Not a Valid User, please enter proper username and password !!!");
	}
}

function validateUser(usrnm, psw){
	
	for(var userObj in users){
		if(users[userObj].username == usrnm &&  users[userObj].password == psw){
			return true;
			
			$("#uploaddiv").hide();
		}
	}
	return false;
}


