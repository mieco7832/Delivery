<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delivery</title>
<body>
	<!-- Header -->
	<header>
		<div class="btn">
			<img class="btn-menu" src="resources/img/logo.png" width="70px"
				height="70px" alt="menu" onclick="toggleSidebar()" />
		</div>
		<div class="title"></div>
		<div class="navbar">
			<a href="home">Inicio</a>
			<c:choose>
				<c:when test="${user.rol=='Supervisor'}">
					<a href="perfil">Perfil</a>
				</c:when>
				<c:when test="${user.rol=='Cajero'}">
					<a href="despacho">Despacho</a>
				</c:when>
				<c:when test="${user.rol=='Motorista'}">
					<a href="marcado">Marcado</a>
				</c:when>
				<c:otherwise>
					<c:redirect url="login">
						<a href="marcado">Marcado</a>
					</c:redirect>
				</c:otherwise>
			</c:choose>
			<a href="out">Salir</a>
		</div>
	</header>
	<div class="sidebar" style="display: none">
		<a href="home">Inicio</a>
		<c:choose>
			<c:when test="${user.rol=='Supervisor'}">
				<a href="perfil">Perfil</a>
			</c:when>
			<c:when test="${user.rol=='Cajero'}">
				<a href="despacho">Despacho</a>
			</c:when>
			<c:when test="${user.rol=='Motorista'}">
				<a href="marcado">Marcado</a>
			</c:when>
			<c:otherwise>
				<c:redirect url="login"></c:redirect>
			</c:otherwise>
		</c:choose>
		<a href="out">Salir</a>
	</div>
	<c:choose>
		<c:when test="${sesion_estado=='Activo'}">

		</c:when>
		<c:otherwise>
			<c:redirect url="login"></c:redirect>
		</c:otherwise>
	</c:choose>
</body>
</html>