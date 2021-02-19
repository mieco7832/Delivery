/**
 *  Ajax
 */

/*
 * No found
 */

$(document).ready(function(){
	/* Funcion que evalua si el Input ha cambiado de estado (Select)*/
	$("#cargo").change(function(){
		if (document.getElementById("cargo").value == 2 && (document.getElementById("in_unidad").checked === false || document.getElementById("in_unidad").value === "false")){
			$.ajax({
				method: "POST",
				url: "./unids"
			})
			.done(function(data){
				if(document.getElementById("asignar_unidad").classList == "grids"){
					document.getElementById("asignar_unidad").classList.remove("grids");
					document.getElementById("asignar_unidad").style.marginTop = "26px";
					document.getElementById("asignar_unidad").style.textAlign = "left";
				}
				var select_unidad = "<select id='unidad' name='moto' required='required'>";
				select_unidad +="<option value='0' selected='selected' disabled='disabled'>Seleccione Unidades Disponibles</option>";
					$.each(JSON.parse(data), function(indice,obj_unidad){
						select_unidad +="<option value='"+obj_unidad.placa+"'>"+obj_unidad.placa+"</option>";
					});
					select_unidad +="</select>";
					document.getElementById("asignar_unidad").style.textAlign = "left";
					document.getElementById("asignar_unidad").innerHTML = select_unidad;
			});
		}else{
			document.getElementById("asignar_unidad").innerHTML = "";
		}
	});
		/* Evalua el camnio del input Cada vez que cambie */
	$("#asignacion-unidad").change(function(){ 
		if(document.getElementById("in_unidad").checked === true || document.getElementById("in_unidad").value === "true"){
			document.getElementById("asignar_unidad").classList.add("grids");
			document.getElementById("asignar_unidad").style.marginTop = "-4px";
			var nuevaUnidad = "<div class='grid'>";
			nuevaUnidad+="<div class='field'><input type='text' maxlength='8' id='unidad' name='moto' required='required'><label for='unidad'>Placa</label></div>";
			nuevaUnidad+="</div>";
			nuevaUnidad+="<div class='grid'>";
			nuevaUnidad+="<div class='field'><input type='text' maxlength='8' id='marca' name='marca' required='required'><label for='marca'>Modelo</label></div>";
			nuevaUnidad+="</div>";
			document.getElementById("asignar_unidad").innerHTML = nuevaUnidad;
		}else{
			$.ajax({
				method: "POST",
				url: "./unids"
			})
			.done(function(data){
				if(document.getElementById("in_unidad").checked === false || document.getElementById("in_unidad").value === "false"){
					if(document.getElementById("asignar_unidad").classList == "grids"){
						document.getElementById("asignar_unidad").classList.remove("grids");
						document.getElementById("asignar_unidad").style.marginTop = "26px";
						document.getElementById("asignar_unidad").style.textAlign = "left";
					}
					var select_unidad = "<select id='unidad' name='moto' required='required'>";
					select_unidad +="<option value='0' selected='selected' disabled='disabled'>Seleccione Unidades Disponibles</option>";
						$.each(JSON.parse(data), function(indice,obj_unidad){
							select_unidad +="<option value='"+obj_unidad.placa+"'>"+obj_unidad.placa+"</option>";
						});
						select_unidad +="</select>";
						document.getElementById("asignar_unidad").style.textAlign = "left";
						document.getElementById("asignar_unidad").innerHTML = select_unidad;
				} 
			});
		}
	});
});
