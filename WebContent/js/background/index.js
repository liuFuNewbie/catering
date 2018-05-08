var jsonObj = document.getElementById("dataPilot").value;
var str = "";
if (jsonObj != '') {
	jsonObj = JSON.parse(jsonObj);
	show(jsonObj);
	var side = document.getElementById("side-menu");
	side.innerHTML = side.innerHTML + str;
}
function show(jsonObj) {
	for ( var data in jsonObj) {
		if (jsonObj[data].dataPilotList) {
			if (jsonObj[data].webPagePath) {
				str += "<li><a class='J_menuItem' href='"+getPath()+"/"
						+ jsonObj[data].webPagePath
						+ "'>"
						+ jsonObj[data].dataPilotName + "</a></li>";
			} else {
				str += "<li><a class='J_menuItem'>"
						+ jsonObj[data].dataPilotName + "</a>";
			}
			if (jsonObj[data].grade == 1) {
				str += "<ul class='nav nav-second-level'>";
			} else if (jsonObj[data].grade == 2) {
				str += "<ul class='nav nav-third-level'>";
			}
			show(jsonObj[data].dataPilotList);
			if (jsonObj[data].grade == 1 || jsonObj[data].grade == 2) {
				str += "</ul>";
			}
			str += "</li>";
		}
	}
}