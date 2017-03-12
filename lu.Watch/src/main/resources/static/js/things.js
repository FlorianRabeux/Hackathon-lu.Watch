$(document).ready(function() { 

	$("#addNewEntity").click(addNewEntity);
	

	$(".imageAvatar").click(selectAvatar);

	$("#addThing").click(addThing);

	receive = [];

	refreshThing();	


});

function addNewEntity(evt) {
	evt.preventDefault();
	$("#modalAddThing").modal('show');
}

function refreshThing() {
	var data = null;

	var xhr = new XMLHttpRequest();
	xhr.withCredentials = true;

	xhr.addEventListener("readystatechange", function () {
		if (this.readyState === 4) {
			var jsonResponse = JSON.parse(this.responseText);
			for (i = 0; i < jsonResponse.length; i++) {
				console.log(jsonResponse[i]);

				var add = true;
				for (var j = 0; j < receive.length; j++) {

					if(receive[j] === jsonResponse[i].id)
					{
						add = false;
					}

				}

				if(add == true)
				{
					var tmpData = "<div class=\"col-md-4 col-sm-4 col-xs-12 profile_details\"> <div class=\"well profile_view\"> <div class=\"col-sm-12\"> <h4 class=\"brief\"><i>"+jsonResponse[i].isSecure+"</i></h4> <div class=\"left col-xs-7\"> <h2>"+jsonResponse[i].name+"</h2>";
					
					if(jsonResponse[i].currentRule !== "")
					{
						tmpData += "<p><strong>Current rule : </strong>"+jsonResponse[i].currentRule+"</p> <ul class=\"list-unstyled\"> <li><i class=\"fa fa-clock-o\"></i> From "+jsonResponse[i].timeFrom+" to "+jsonResponse[i].timeTo+"</li> </ul>";
					}
					tmpData +=" <p>"+jsonResponse[i].description+"</p> </div> <div class=\"right col-xs-5 text-center\"> <img id=\"img"+i+"\" src=\"images/"+ jsonResponse[i].img+".png\" alt=\"\" class=\"img-circle img-responsive\"> </div> </div> <div class=\"col-xs-12 bottom text-center\"> </i> </button> <button id=\""+jsonResponse[i].id+"\" type=\"button\" class=\"btn btn-primary btn-xs buttonOverview\"> <i class=\"fa fa-user\"> </i> Show details </button> </div> </div> </div> </div>";
					

					$("#things").append(tmpData);

					receive.push(jsonResponse[i].id);
				}


			}
			console.log(receive);
			$(".buttonOverview").click(switchToOverview);
		}
	});
	xhr.open("GET", "/things");
	xhr.setRequestHeader("cache-control", "no-cache");
	xhr.setRequestHeader("postman-token", "69be90e5-1cbf-a061-e8c4-5d9bd0d5b993");

	xhr.send(data);
}

function switchToOverview() {
	window.location.href = "/overview.html?id=" + this.id;
}

function selectAvatar() {
	$(".imageAvatar").removeClass("imageSelected");

	$(this).addClass("imageSelected");
}

function addThing() {
	var newThing = {};



	newThing.name = $("#thingName").val();
	newThing.sensorId = $("#sensor").val();
	newThing.description = $("#description").val();
	newThing.image = $(".imageSelected").attr('id');

	var xhr = new XMLHttpRequest();
	xhr.withCredentials = true;

	xhr.addEventListener("readystatechange", function () {
		if (this.readyState === 4) {
			if(this.responseText === "true")
			{
				refreshThing();
				$("#modalAddThing").modal('hide');
				resetThing()
			}
			else
			{
				alert("An error occured...");
			}
		}
	});

	xhr.open("POST", "/newThing");
	xhr.setRequestHeader("content-type", "application/json");
	xhr.setRequestHeader("cache-control", "no-cache");
	xhr.setRequestHeader("postman-token", "c6e4c24c-8f4e-1430-2d09-e2188d2b977e");

	xhr.send(JSON.stringify(newThing));

	console.log(JSON.stringify(newThing));
}

function resetThing() {
	$("#thingName").val("");
	$("#sensor").val("");
	$("#description").val("");
	$(".imageAvatar").removeClass("imageSelected");
	$(".imageAvatar")[0].addClass("imageSelected");
}

