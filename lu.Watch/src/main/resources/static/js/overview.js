$(document).ready(function() { 



	rulesReceive = null;
	selectedRuleId = null;
	circle = null;
	drawingManager = null;

	idThing = getUrlParameter('id');

	console.log(idThing);

	$("#search").click(searchService);


	$(".buttonView").click(function() {
		alert("ADD");

		thing.setMap(null);
		cityCircle.setMap(null);
   /*thing = new google.maps.Marker({
                map: map,
                position: new google.maps.LatLng(51.508742,-0.120850),
                zindex: 100
            });*/
        });

	updateRules();
	setInterval(updateRules, 5000);

	center = true;

	map.addListener('mouseover', function() {
		center = false;
	});

	map.addListener('mouseout', function() {
		center = true;
	});

	
	$(".btn-day").click(function() {
		if($(this).hasClass('btn-success'))
		{
			//alert("selected");
			$(this).removeClass('btn-success');
		}
		else
		{
			//alert("not selected");
			$(this).addClass('btn-success');
		}


	})

	$("#addRule").click(addNewRule);


	$("#myModal").on("shown.bs.modal", function () {



		google.maps.event.trigger(map2, "resize");

		if(drawingManager == null)
		{
			drawingManager = new google.maps.drawing.DrawingManager({
				drawingMode: google.maps.drawing.OverlayType.MARKER,
				drawingControl: true,
				drawingControlOptions: {
					position: google.maps.ControlPosition.TOP_CENTER,
					drawingModes: [
					google.maps.drawing.OverlayType.CIRCLE]
				},
				circleOptions: {
					fillColor: '#169F85',
					fillOpacity: 0.4,
					strokeWeight: 3,
					clickable: false,
					editable: true,
					zIndex: 10000000000
				}
			});    

			drawingManager.setMap(map2);
			google.maps.event.addListener(drawingManager, 'circlecomplete', onCircleComplete);
		}




	});

	

});

function addNewRule() {
	
	var newRule = {};


	newRule.daysMonday = $("#scheduleDayMonday").hasClass('btn-success');
	newRule.daysTuesday = $("#scheduleDayTuesday").hasClass('btn-success');
	newRule.daysWednesday = $("#scheduleDayWednesday").hasClass('btn-success');
	newRule.daysThursday = $("#scheduleDayThursday").hasClass('btn-success');
	newRule.daysFriday = $("#scheduleDayFriday").hasClass('btn-success');
	newRule.daysSaturday = $("#scheduleDaySaturday").hasClass('btn-success');
	newRule.daysSunday = $("#scheduleDaySunday").hasClass('btn-success');


	newRule.name = $("#ruleName").val();
	newRule.timeFrom = $("#timeFrom").val();
	newRule.timeTo = $("#timeTo").val();

	newRule.notificationEmail = $("#email").val();
	newRule.notificationSms = $("#sms").val();

	newRule.positionAreaRadius = positionArea.radius;
	newRule.positionAreaLat = positionArea.lat;
	newRule.positionAreaLng = positionArea.lng;

	console.log(JSON.stringify(newRule));

	/*function sendData() {
		$.ajax({
			url: '/helloworld',
			type: 'POST',
			data: { json: JSON.stringify(newRule)},
			dataType: 'json'
		});
	}*/

	var xhr = new XMLHttpRequest();
	xhr.withCredentials = true;

	xhr.addEventListener("readystatechange", function () {
		if (this.readyState === 4) {
			if(this.responseText === "true")
			{
				$("#myModal").modal('hide');
				resetRule();
				updateRules();
			}
			else
			{
				alert("An error occured...");
			}
		}
	});

	xhr.open("POST", "/newRule");
	xhr.setRequestHeader("content-type", "application/json");
	xhr.setRequestHeader("cache-control", "no-cache");

	xhr.send(JSON.stringify(newRule));




}

function resetRule() {

	circle.setMap(null);

	$("#scheduleDayMonday").removeClass('btn-success');
	$("#scheduleDayTuesday").removeClass('btn-success');
	$("#scheduleDayWednesday").removeClass('btn-success');
	$("#scheduleDayThursday").removeClass('btn-success');
	$("#scheduleDayFriday").removeClass('btn-success');
	$("#scheduleDaySaturday").removeClass('btn-success');
	$("#scheduleDaySunday").removeClass('btn-success');

	$("#ruleName").val("");
	$("#timeFrom").val("");
	$("#timeTo").val("");
	$("#email").val("");
	$("#sms").val("");
}

function onCircleComplete(shape) {
	if (shape == null || (!(shape instanceof google.maps.Circle))) return;

	if (circle != null) {
		circle.setMap(null);
		circle = null;
	}

	circle = shape;
	console.log('radius', circle.getRadius());
	console.log('lat', circle.getCenter().lat());
	console.log('lng', circle.getCenter().lng());

	positionArea = {};

	positionArea.radius = circle.getRadius();
	positionArea.lat = circle.getCenter().lat();
	positionArea.lng = circle.getCenter().lng();
}  

function mapCenter(mustCenter)
{
	alert(mustCenter);
	if(mustCenter === true)
	{
		center = true;
	}
	else
	{
		center = false;
	}
}

function addMarkerThing(Lat,Lng, titleName) {

	var infowindow = new google.maps.InfoWindow({
		content: "User"
	});


	thing = new google.maps.Marker({
		map: map,
		position: new google.maps.LatLng(Lat,Lng),
		zindex: 100,
		label:titleName
	});

	thing.addListener('click', function() {
		infowindow.open(map, thing);
	});
}

function addMarkerZone(Lat,Lng, titleName) {

	var infowindow = new google.maps.InfoWindow({
		content: "Authorized area"
	});


	zone = new google.maps.Marker({
		map: map,
		position: new google.maps.LatLng(Lat,Lng),
		zindex: 100,
		label:titleName
	});

	zone.addListener('click', function() {
		infowindow.open(map, zone);
	});
}

function addCircle(Lat, Lng, color, radiusMeter) {
	
	if(color === "green")
	{
		//alert("green");
		var sunCircle = {
			strokeColor: "#c3fc49",
			strokeOpacity: 0.8,
			strokeWeight: 2,
			fillColor: "#c3fc49",
			fillOpacity: 0.35,
			map: map,
			center: new google.maps.LatLng(Lat,Lng),
			radius: radiusMeter
		};
		cityCircle = new google.maps.Circle(sunCircle);
		return; 
	}
	if(color === "red")
	{
		//alert("green");
		var sunCircle = {
			strokeColor: "#e93335",
			strokeOpacity: 0.8,
			strokeWeight: 2,
			fillColor: "#e93335",
			fillOpacity: 0.35,
			map: map,
			center: new google.maps.LatLng(Lat,Lng),
			radius: radiusMeter
		};
		cityCircle = new google.maps.Circle(sunCircle);
		return;
	} 
	if(color === "gray")
	{
		var sunCircle = {
			strokeColor: "#2A3F54",
			strokeOpacity: 0.8,
			strokeWeight: 2,
			fillColor: "#ededed",
			fillOpacity: 0.35,
			map: map,
			center: new google.maps.LatLng(Lat,Lng),
			radius: radiusMeter
		};
		cityCircle = new google.maps.Circle(sunCircle);
		return;
	}
}

function deleteMarker() {
	thing.setMap(null);
	zone.setMap(null);
}

function deleteCircle() {
	cityCircle.setMap(null);
}

function updateRules() {
	console.log("update");

	var xhr = new XMLHttpRequest();
	xhr.withCredentials = true;

	xhr.addEventListener("readystatechange", function () { 
		if (this.readyState === 4) {
			var jsonResponse = JSON.parse(this.responseText);

			rulesReceive = jsonResponse;

			$("#rules").empty();
			for (i = 0; i < jsonResponse.length; i++) {
				addRule(jsonResponse[i]);
				var toggleId = "#toggle"  +jsonResponse[i].id;
				var notificationEnable = jsonResponse[i].notificationEnable ? "on" : "off";

				$(toggleId+"").bootstrapToggle(notificationEnable);

				$(".toggleNotification").change(changeNotification);


				if(selectedRuleId == null || selectedRuleId === jsonResponse[i].id)
				{
		    	// remove Marker
		    	deleteMarker();
		    	// remove circle
		    	if(selectedRuleId != null)
		    	{
		    		deleteCircle();
		    	}

		    	// centerMap
		    	// add circle
		    	var color;
		    	console.log(jsonResponse[i].state);
		    	if(jsonResponse[i].state === "secure")
		    	{
		    		color = "green";
		    	}
		    	else if(jsonResponse[i].state === "unsecure")
		    	{
		    		color = "red";
		    	}
		    	else
		    	{
		    		color = "gray";
		    	}

		    	console.log(color);
		    	addCircle(jsonResponse[i].zone.lat, jsonResponse[i].zone.lng,color, 30);
		    	addMarkerZone(jsonResponse[i].zone.lat, jsonResponse[i].zone.lng, "Z");
		    	addMarkerThing(jsonResponse[i].userPosition.lat, jsonResponse[i].userPosition.lng, "U");
		    	// add marker
		    	//addMarker()
		    	selectedRuleId = jsonResponse[i].id;

		    	var bounds = new google.maps.LatLngBounds();
				//addMarker(jsonResponse.Lat,jsonResponse.Lng, 'U');



				
				bounds.extend(new google.maps.LatLng(cityCircle.getCenter().lat(),cityCircle.getCenter().lng()));
				bounds.extend(thing.getPosition());

				//var extendPoint = new google.maps.LatLng(bounds.getNorthEast().lat() + 0.002, bounds.getNorthEast().lng() + 0.001);
   				//bounds.extend(extendPoint);
   				if(center !== false)
   				{
   					map.fitBounds(bounds);
   				}

   			}

   			$(".viewPosition").click(function() {

   				var idClick = this.id.replace("view", "");
   				selectedRuleId = idClick;

   				updateRules();
   			});


   		}
   		



	    //$('#toggleId1').bootstrapToggle();
	    //$('.toggleNotification').bootstrapToggle();
	    
	}
});

	xhr.open("GET", "/rules?id=" + idThing);
	xhr.setRequestHeader("cache-control", "no-cache");
	xhr.setRequestHeader("postman-token", "69be90e5-1cbf-a061-e8c4-5d9bd0d5b993");

	var send = null;
	xhr.send(send);
}

var getUrlParameter = function getUrlParameter(sParam) {
	var sPageURL = decodeURIComponent(window.location.search.substring(1)),
	sURLVariables = sPageURL.split('&'),
	sParameterName,
	i;

	for (i = 0; i < sURLVariables.length; i++) {
		sParameterName = sURLVariables[i].split('=');

		if (sParameterName[0] === sParam) {
			return sParameterName[1] === undefined ? true : sParameterName[1];
		}
	}
};

function searchService() {
	var data = JSON.stringify({
		"category": "hospital",
		"name": "chl"
	});

	var xhr = new XMLHttpRequest();
	xhr.withCredentials = true;

	xhr.addEventListener("readystatechange", function () {
		if (this.readyState === 4) {
			//("$result").empty();
			console.log(this.responseText);
			var jsonResult = JSON.parse(this.responseText);

			for (i = 0; i < jsonResult.length; i++) {
				console.log(jsonResult);
			}

			
		}
	});

	xhr.open("POST", "http://localhost:8080/getService");
	xhr.setRequestHeader("content-type", "application/json");
	xhr.setRequestHeader("cache-control", "no-cache");
	xhr.setRequestHeader("postman-token", "6062e1ca-6026-2c95-a052-efc1ecb3dc81");

	xhr.send(data);
}

function changeNotification() {
	

	var data = null;

	var xhr = new XMLHttpRequest();
	xhr.withCredentials = true;

	xhr.addEventListener("readystatechange", function () {
		if (this.readyState === 4) {
			console.log(this.responseText);
		}
	});
	xhr.open("GET", "/notification?id=" + (this).id.replace("toggle", "") + "&state=" + $(this).prop('checked'));
	xhr.setRequestHeader("cache-control", "no-cache");

	xhr.send(data);
}

function addRule(rule) {

	

	var data = "<tr><td>#</td><td><a class=\"titleRule\">"+rule.name+"</a></td><td><p class=\"textRule\">From "+rule.dateFrom+" to "+rule.dateTo +"</p><div class=\"btn-group\" role=\"group\" aria-label=\"First group\">";

	if(rule.days[0].enable === true)
	{
		data += "<button type=\"button\" class=\"btn btn-default btn-sm btn-success\">L</button>"
	}
	else
	{
		data += "<button type=\"button\" class=\"btn btn-default btn-sm btn-default\">L</button>"
	}

	if(rule.days[1].enable === true)
	{
		data += "<button type=\"button\" class=\"btn btn-default btn-sm btn-success\">M</button>"
	}
	else
	{
		data += "<button type=\"button\" class=\"btn btn-default btn-sm btn-default\">M</button>"
	}

	if(rule.days[2].enable === true)
	{
		data += "<button type=\"button\" class=\"btn btn-default btn-sm btn-success\">M</button>"
	}
	else
	{
		data += "<button type=\"button\" class=\"btn btn-default btn-sm btn-default\">M</button>"
	}

	if(rule.days[3].enable === true)
	{
		data += "<button type=\"button\" class=\"btn btn-default btn-sm btn-success\">J</button>"
	}
	else
	{
		data += "<button type=\"button\" class=\"btn btn-default btn-sm btn-default\">J</button>"
	}

	if(rule.days[4].enable === true)
	{
		data += "<button type=\"button\" class=\"btn btn-default btn-sm btn-success\">V</button>"
	}
	else
	{
		data += "<button type=\"button\" class=\"btn btn-default btn-sm btn-default\">V</button>"
	}

	if(rule.days[5].enable === true)
	{
		data += "<button type=\"button\" class=\"btn btn-default btn-sm btn-success\">S</button>"
	}
	else
	{
		data += "<button type=\"button\" class=\"btn btn-default btn-sm btn-default\">S</button>"
	}

	if(rule.days[6].enable === true)
	{
		data += "<button type=\"button\" class=\"btn btn-default btn-sm btn-success\">D</button>"
	}
	else
	{
		data += "<button type=\"button\" class=\"btn btn-default btn-sm btn-default\">D</button>"
	}

	data += "</div></td><td><p class=\"textRule\">";

	if(rule.email === true)
	{    
		data +="<i class=\"glyphicon glyphicon-envelope\">Email</i>"
	}
	if(rule.phone === true)
	{
		if(rule.email)
		{
			data +=",";
		}
		data += "<i class=\"glyphicon glyphicon-phone\">Phone</i>"
	}

	if(rule.notificationEnable === false)
	{
		data += "</p><input id=\"toggle"+rule.id+"\" class=\"toggleNotification\" data-onstyle=\"success\" data-size=\"small\" type=\"checkbox\" data-toggle=\"toggle\" data-on=\"Enable\" data-off=\"Disable\" ></td>"
	}
	else
	{
		data += "</p><input checked=true id=\"toggle"+rule.id+"\" class=\"toggleNotification\" data-onstyle=\"success\" data-size=\"small\" type=\"checkbox\" data-toggle=\"toggle\" data-on=\"Enable\" data-off=\"Disable\" ></td>"
	}
	

	data += "<td><p class=\"textRule\">"+ rule.description +"</p></td><td>";

	if(rule.state === "secure")
	{
		data += "<button type=\"button\" class=\"btn btn-success btn-xs\">Secure</button>"
	}
	if(rule.state === "unsecure")
	{
		data += "<button type=\"button\" class=\"btn btn-danger btn-xs\">Unsecure</button>"
	}
	if(rule.state === "inactive")
	{
		data += "<button type=\"button\" class=\"btn btn-defult btn-xs\">Incactive</button>"
	}

	data += "</td><td><p href=\"#\" id=\"view"+rule.id+"\" class=\"viewPosition btn btn-primary btn-xs buttonView\"><i class=\"fa fa-folder\"></i> View </p></td></tr>"

	$("#rules").append(data);

	//$("'."+ toggleId + "'").bootstrapToggle();
}
