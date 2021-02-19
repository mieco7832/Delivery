<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delivery</title>
</head>
<body>
	<header>
		<div class="btn">
			<img class="btn-menu" src="resources/img/logo.png" width="70px"
				height="70px" alt="menu" />
		</div>
		<div class="title">¡Bienvenido/a! Inicia Sesion Para Continuar</div>
	</header>
	<div class="content">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<form method="post" action="sesion" class="form-log">
						<div class="field">
							<input id="usuario" type="text" name="nombre_usuario"
								required="required"> <label for="usuario">Nombre
								de Usuario</label>
						</div>
						<div class="field">
							<input id="clave" type="password" name="clave_usuario"
								required="required"> <label for="clave">Contraseña
								Secreta</label>
						</div>
						<div class="row">
							<div class="col-12">
								<input type="submit" value="Enviar" style="width: 160px;">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.js"
		integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
		crossorigin="anonymous"></script>
	<script src="resources/js/ajaxs.js" type="text/javascript"></script>
	<link href="resources/css/estilo.css" rel="stylesheet" type="text/css" />
	<link id="css" href="resources/css/estilo-desktop.css" rel='stylesheet'
		type='text/css' />
	<script type="text/javascript">
		/* Inspector de dispositivo */
		if (navigator.userAgent.match(/Android/i)
				|| navigator.userAgent.match(/webOS/i)
				|| navigator.userAgent.match(/iPhone/i)
				|| navigator.userAgent.match(/iPad/i)
				|| navigator.userAgent.match(/iPod/i)
				|| navigator.userAgent.match(/BlackBerry/i)
				|| navigator.userAgent.match(/Windows Phone/i)) {
			document.getElementById("css").href = "resources/css/estilo-mobil.css";
		} else {
			document.getElementById("css").href = "resources/css/estilo-desktop.css";
		}
		
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
	</script>
</body>
</html>