<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delivery</title>
</head>
<body>
	<%@include file="../resources/componentes/head.jsp"%>
	<div class="content">
		<div class="container">
			<div class="row">
				<div class="col-12 left">
					<h3>Perfil de Supervisor:</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="row">
							<div class="col-4">
								<div class="grids">
									<div class="grid">
										<img src="resources/img/supervisor.png" width="80%"
											alt="Super" />
									</div>
									<div class="grid">
										<p>
											<b>Nombre:</b>
										</p>
										<p>${supervisor.nombre_per}</p>
										<p>
											<b>Cargo:</b>
										</p>
										<p>${supervisor.rol}</p>
									</div>
								</div>
								<br>
								<div class="grids">
									<div class="grid">
										<p>
											<b>Turno:</b> ${supervisor.turno}
										</p>
										<p>
											<b>Sucursal Actual:</b> ${supervisor.nombre_suc}
										</p>
										<p>
											<b>Ubicación:</b> ${supervisor.ubicacion}
										</p>
										<p>
											<b>Telefono:</b> +503 ${supervisor.telefono}
										</p>
									</div>
								</div>
							</div>
							<div class="col-8">
								<div class="row">
									<div class="col-6"></div>
									<div class="col-3">
										<button id="newUnidadButton"
											onclick="openForm('newUnidModal');">Nueva Unidad</button>
									</div>
									<div class="col-3">
										<button id="newRegsButton" onclick="openForm('newRegsModal');">Nuevo
											Registro</button>
									</div>
								</div>
								<div class="row">
									<div class="col-1"></div>
									<div class="col-10">
										<!-- TABLA INICIA -->
										<table>
											<tr>
												<th style="width: 220px">Nombre</th>
												<th style="width: 160px">Cargo</th>
												<th style="width: 140px">Estado</th>
											</tr>
										</table>
										<div id="container-table" style="overflow: auto;">
											<table id="tabla">
												<thead>
													<tr>
														<td colspan="3" style="text-align: left;"><input
															id="buscar" type="search" placeholder="Buscar..." /></td>
													</tr>
												</thead>
												<tbody class="hoverable">
													<c:forEach items="${listaPersonal}" var="lis">
														<tr>
															<td style="width: 220px">${lis.nombre_per}</td>
															<td style="width: 160px">${lis.rol}</td>
															<td style="width: 140px">¡Todo Bien!</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
										<!-- TABLA FINALIZA -->
										<div class="col-1"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="newRegsModal" class="modal">
		<form id="newRegsForm" action="regs" method="post">
			<!-- Modal content -->
			<div class="modal-content">
				<div class="modal-header">
					<button type="reset" class="close"
						onclick="closeForm('newRegsModal')">&times;</button>
					<h2>Nuevo Registro</h2>
				</div>
				<div class="modal-body">
					<div class="conatiner">
						<div class="row">
							<div class="col-6">
								<div class="field">
									<input type="text" maxlength="20" id="nombre_personal"
										name="nombre" required> <label for="nombre_personal">Nombres</label>
								</div>
								<div class="field">
									<input type="text" maxlength="20" id="apellido_personal"
										name="apellido" required> <label
										for="apellido_personal">Apellidos</label>
								</div>
								<div class="field">
									<input type="text" maxlength="20" id="nombre_usuario"
										name="usuario" required> <label for="nombre_usuario">Nombre
										de Usuario</label>
								</div>
								<div class="field">
									<input type="password" maxlength="16" id="clave_usuario"
										name="pass" required> <label for="clave_usuario">Contraseña</label>
								</div>
								<div class="field">
									<input type="text" maxlength="50" id="ubicacion_personal"
										name="direccion" required> <label
										for="ubicacion_personal">Dirección</label>
								</div>
							</div>
							<div class="col-6">
								<div class="field">
									<input type="text" maxlength="10" id="dui_personal" name="dui"
										required> <label for="dui_personal">DUI:
										Incluir guión</label>
								</div>
								<div class="field">
									<select id="sucursal" name="sucursal" required="required">
										<option selected="selected" disabled="disabled">Seleccione
											Sucursal</option>
										<c:forEach items="${listaSucursal}" var="liss">
											<option value="${liss.id_suc}">${liss.nombre_suc}</option>
										</c:forEach>
									</select>
								</div>
								<div class="field">
									<select id="cargo" name="rol" required="required"
										onchange="selectEmelent()">
										<option selected="selected" disabled="disabled">Seleccione
											Un Cargo</option>
										<option value="1">Cajero</option>
										<option value="2">Motorista</option>
									</select>
								</div>
								<div id="verificar_unidad" class="field"></div>
								<div id="asignar_unidad" style="margin-top: 26px;"></div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<input type="submit" value="Enviar" />
					</div>
				</div>
			</div>
		</form>
	</div>
	<div id="newUnidModal" class="modal">
		<form id="newUnidForm" action="nunid" method="post">
			<!-- Modal content -->
			<div class="modal-content">
				<div class="modal-header">
					<button type="reset" class="close"
						onclick="closeForm('newUnidModal')">&times;</button>
					<h2>Nueva Unidad</h2>
				</div>
				<div class="modal-body">
					<div class="conatiner">
						<div class="row">
							<div class="col-6">
								<div class="field">
									<input type="text" maxlength="8" id="placa_unidad"
										name="placa_unidad" required> <label
										for="placa_unidad">Placa</label>
								</div>
							</div>
							<div class="col-6">
								<div class="field">
									<input type="text" maxlength="20" id="modelo_unidad"
										name="modelo_unidad" required> <label
										for="modelo_unidad">Modelo</label>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<input type="submit" value="Enviar" />
					</div>
				</div>
			</div>
		</form>
	</div>
	<%@include file="../resources/componentes/footer.jsp"%>
	<script>
		/* Bloque de buscador en tabla */

		var busqueda = document.getElementById("buscar");
		if (document.getElementById("buscar") !== null) {
			if (document.getElementById("tabla").tBodies[0] !== null) {
				var table = document.getElementById("tabla").tBodies[0];
			}
		}

		buscaTabla = function() {
			texto = busqueda.value.toLowerCase();
			var r = 0;
			while (row = table.rows[r++]) {
				if (row.innerText.toLowerCase().indexOf(texto) !== -1) {
					row.style.display = null;
				} else {
					row.style.display = "none";
				}
			}
		}
		busqueda.addEventListener("keyup", buscaTabla);

		/* Modal */

		var modal = document.getElementsByClassName("modal");
		var modal_i = document.getElementsByClassName("modal").length;
		function openForm(modalHidden) {
			document.getElementById(modalHidden).style.display = "block";
		}

		function closeForm(modalBlock) {
			document.getElementById(modalBlock).style.display = "none";
			document.getElementById("asignar_unidad").innerHTML = "";
		}

		var device;
		if (navigator.userAgent.match(/Android/i)
				|| navigator.userAgent.match(/webOS/i)
				|| navigator.userAgent.match(/iPhone/i)
				|| navigator.userAgent.match(/iPad/i)
				|| navigator.userAgent.match(/iPod/i)
				|| navigator.userAgent.match(/BlackBerry/i)
				|| navigator.userAgent.match(/Windows Phone/i)) {
			device = "mobil";
			var verficar_unidad_select = "<label id='asignacion-unidad'><select name='unidad' id='in_unidad' disabled='true'>";
			verficar_unidad_select += "<option value='0' selected='selected' disabled='disabled'>¿Posee Motocicleta?</option>";
			verficar_unidad_select += "<option value='true'>Si</option>";
			verficar_unidad_select += "<option value='false'>No</option>";
			verficar_unidad_select += "</select></label>";
			document.getElementById("verificar_unidad").innerHTML = verficar_unidad_select;
			document.getElementById("container-table").style.height = "600px";
		} else {
			device = "desktop";
			var checkbox_unidad = "<label id='asignacion-unidad' class='checkcontent'>";
			checkbox_unidad += "¿Posee Motocicleta?";
			checkbox_unidad += "<input type='checkbox' name='unidad' id='in_unidad' disabled='true'/> <span class='checkmark'></span>";
			checkbox_unidad += "</label>";
			document.getElementById("verificar_unidad").innerHTML = checkbox_unidad;
			document.getElementById("container-table").style.height = "300px";
		}

		/* Asignación de Unidades a nuevo ingreso */

		function selectEmelent() {
			if (document.getElementById("cargo").value === '2') {
				document.getElementById("in_unidad").disabled = false;
			} else {
				document.getElementById("in_unidad").disabled = true;

				if (device === "mobil") {
					document.getElementById("in_unidad").value = '0';
				} else {
					document.getElementById("in_unidad").checked = false;
				}
			}
		}
	</script>
</body>
</html>
