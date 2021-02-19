<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delivery</title>
</head>
<body>
	<%@include file="../resources/componentes/head.jsp"%>
	<div class="content">
		<div class="container">
			<div class="row">
				<div class="col-12 left">
					<h3>Perfil de Cajero: ${estado}</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="row">
							<div class="col-4">
								<div class="grids">
									<div class="grid">
										<img src="resources/img/buy.png" width="80%" alt="Super" />
									</div>
									<div class="grid">
										<p>
											<b>Nombre: ${perfil.nombre_per}</b>
										</p>
										<p></p>
										<p>
											<b>Cargo: ${perfil.rol}</b>
										</p>
										<p></p>
									</div>
								</div>
								<br>
								<div class="grids">
									<div class="grid">
										<p>
											<b>Turno: ${perfil.turno}</b>
										</p>
										<p>
											<b>Sucursal Actual: ${perfil.nombre_suc}</b>
										</p>
										<p>
											<b>Ubicación: ${perfil.ubicacion}</b>
										</p>
										<p>
											<b>Telefono: ${perfil.telefono}</b>
										</p>
									</div>
								</div>
							</div>
							<div class="col-8">
								<div class="row">
									<div class="col-9"></div>
									<div class="col-3">
										<button id="newRegsButton" onclick="openForm('newAsigModal');">Nuevo
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
													<c:forEach items="${lista_empleado}" var="moto">
														<tr>
															<td style="width: 220px">${moto.nombre_per}</td>
															<td style="width: 160px">${moto.rol}</td>
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
	<div id="newAsigModal" class="modal">
		<form id="newAsigForm" action="regs_ruta" method="post">
			<!-- Modal content -->
			<div class="modal-content">
				<div class="modal-header">
					<button type="reset" class="close"
						onclick="closeForm('newAsigModal')">&times;</button>
					<h2>Ingresar Un Pedido</h2>
				</div>
				<div class="modal-body">
					<div class="container">
						<div class="row">
							<div class="col-12">
								<div class="field">
									<input type="text" maxlength="150" id="descripcion_pedido"
										name="producto" required="required"> <label
										for="descripcion_pedido">Descripción del pedido</label>
								</div>
								<div class="field">
									<input type="text" id="precio"
										name="total" required="required"> <label
										for="precio">Precio total del pedido</label>
								</div>
								<div class="field">
									<input type="text" maxlength="100" id="direccion"
										name="destino" required="required"> <label
										for="direccion">Dirección de entrega</label>
								</div>
								<div class="field">
									<select id="motorista" name="id_motorista" required="required">
										<option selected="selected" disabled="disabled">Asignar Personal</option>
										<c:forEach items="${lista_empleado}" var="liss">
											<option value="${liss.id_per}">${liss.nombre_per}</option>
										</c:forEach>
									</select>
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
	<script type="text/javascript">
		var modal = document.getElementsByClassName("modal");
		var modal_i = document.getElementsByClassName("modal").length;
		function openForm(modalHidden) {
			document.getElementById(modalHidden).style.display = "block";
		}

		function closeForm(modalBlock) {
			document.getElementById(modalBlock).style.display = "none";
		}
	</script>
</body>