<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../resources/componentes/head.jsp"%>
	<div class="content">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<h3>Control de Tiempo de Pedidos</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="row">
							<div class="col-4">
								<div class="grids">
									<div class="grid">
										<img src="resources/img/delivery.png" width="80%" alt="Super" />
									</div>
									<div class="grid">
										<p>
											<b>Nombre:</b>
										</p>
										<p>${perfil.nombre_per}</p>
										<p>
											<b>Cargo:</b>
										</p>
										<p>${perfil.rol}</p>
									</div>
								</div>
								<br>
								<div class="grids">
									<div class="grid">
										<p>
											<b>Turno:</b> ${perfil.turno}
										</p>
										<p>
											<b>Sucursal Actual:</b> ${perfil.nombre_suc}
										</p>
										<p>
											<b>Ubicación:</b> ${perfil.ubicacion}
										</p>
										<p>
											<b>Telefono:</b> ${perfil.telefono}
										</p>
									</div>
								</div>
							</div>
							<div class="col-8">
								<div class="row">
									<div class="col-1"></div>
									<div class="col-10">
										<!-- TABLA INICIA -->
										<table>
											<tr>
												<th style="width: 220px">Descripción</th>
												<th style="width: 160px">Dirección</th>
												<th style="width: 80px">Hora Asignada</th>
												<th Style="width: 60px">Marcar</th>
											</tr>
										</table>
										<div id="container-table" style="overflow: auto;">
											<table id="tabla">
												<tbody class="hoverable">
													<c:forEach items="${list_pedidos}" var="ped">
														<tr>
															<td style="width: 220px">${ped.descripcion}</td>
															<td style="width: 160px">${ped.direccion}</td>
															<td style="width: 80x">${ped.fecha}</td>
															<td style="width: 60px">
																<form action="marcar" method="Post">
																	<input name="pedido" type="text" hidden="true" value="${ped.id}" >
																	<input type="submit" value="Marcar" />
																</form>
															</td>
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
	<%@include file="../resources/componentes/footer.jsp"%>
</body>
</html>