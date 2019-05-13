function onPageLoaded(){
	document.getElementById("welcome_text").innerHTML="Welcome " +localStorage.getItem("username");
	return null;	
}

$(document).ready(function(){
	$("form#main_input_box").submit(function(event){
		event.preventDefault();
		var deleteButton = "<button class='delete btn btn-warning'>Delete</button>";
		var editButton = "<button class='edit btn btn-success'>Edit</button>";

		var twoButtons = "<div class='btn-group pull-right'>" + deleteButton + editButton + "</div>";
		var checkBox = "<div class='checkbox'><label><input type='checkbox' id='checkbox_value' class='pull-right'></label></div>";
		$(".list_of_items").append("<li class='list-group-item'>" + "<div class='text_holder'>" + $("#custom_textbox").val() + twoButtons + "</div>" + checkBox +"</li>");
		//$("#custom_textbox").val('');

		var params = {item_name:document.getElementById("custom_textbox").value,
					completed_item:document.getElementById("checkbox_value").checked};

$.ajax({
	url:encodeURI("http://localhost:8080/user/add_items"),
			method: 'POST',
			crossDomain: true,
			data: params,
	
	success: function (response) {
		console.log(response);
		if(response=="")
		{
			window.alert("Item could not be added");
		}
		else
		{
		console.log(response);

		}
	},
	error: function (xhr,status) {
		console.log("hata" ,xhr,status);
	}

});


	});

	$(".list_of_items").on("click", "button.delete", function(){
		$(this).closest("li").remove();
	});

	$(".list_of_items").on("click", "button.edit", function (){
		var editItemBox = "<form class='edit_input_box'><input type='text' class='itembox'></form>";
		var originalItem = $(this).parent().val();
		var deleteButton = "<button class='delete btn btn-warning'>Delete</button>";
		var editButton = "<button class='edit btn btn-success'>Edit</button>";
		var twoButtons = "<div class='btn-group pull-right'>" + deleteButton + editButton + "</div>";
		$(this).closest("div.text_holder").replaceWith(editItemBox);
		$("form.edit_input_box ").on("submit", function(){
			event.preventDefault(); 
			var checkBox = "<label><input type='checkbox'></label>";
			$(this).replaceWith("<div>" + $(".itembox").val() + twoButtons + "</div>");
			var params = {item_name:document.getElementById("custom_textbox").value,
			completed_item:document.getElementById("checkbox_value").checked};
			console.log(params)

			$.ajax({
			url:encodeURI("http://localhost:8080/user/edit_items"),
				method: 'POST',
				crossDomain: true,
				data: params,

			success: function (response) {
			console.log(response);
			if(response=="")
			{
				window.alert("Item could not be added");
			}
			else
			{
			console.log(response);

			}
			},
			error: function (xhr,status) {
			console.log("hata" ,xhr,status);
			}

			});
		}); 
	});
	
	$(".list_of_items").on("click", ":checkbox", function (){
		$(this).closest("li").toggleClass("completed_item");
	});
});



