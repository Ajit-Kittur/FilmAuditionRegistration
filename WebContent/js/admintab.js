function loadUsersListPage() {
	
	$("#admintablist").load("html/userList.html");
/*	$('#userList_table tr:last').after('<tr>'
	        +'<td>"1"</td>'
	        +'<td>"Anna"</td>'
	        +'<td>"Pitt"</td>'
	        +'<td>"example@gmail.com"</td>'
	        +'<td>"9900099000"</td>'
	      +'</tr>');*/
}

function loadadminHomePage(){
	$("#admintablist").load("html/adminHomePage.html");
}