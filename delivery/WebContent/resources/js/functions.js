/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* Bloque del Menu desplegable */
var sidebar = document.getElementsByClassName("sidebar")[0];
var content = document.getElementsByClassName("content")[0];

function toggleSidebar() {
    if (sidebar.style.display === "none" && device === "mobil") {
        sidebar.style.display = "block";
    } else {
        sidebar.style.display = "none";
    }
}

/* Bloque de proporcion de grids */

var grids = document.getElementsByClassName("grids").length;
var i = 0;
for (i = 0; i < grids; i++) {
	var padre = document.getElementsByClassName("grids")[i];
	var grid = padre.getElementsByClassName("grid").length;
	for (var j = 0; j < grid; j++) {
		padre.getElementsByClassName("grid")[j].style.width = ((100 / grid) + "%");
	}
}