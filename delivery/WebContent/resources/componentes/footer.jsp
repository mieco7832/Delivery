<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="resources/js/ajaxs.js" type="text/javascript"></script>
<script src="resources/js/functions.js" type="text/javascript"></script>
<link href="resources/css/estilo.css" rel="stylesheet" type="text/css"/>
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
</script>
</head>
</html>