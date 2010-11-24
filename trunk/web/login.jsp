<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page import="edu.austral.lab1.odontobook.model.*, edu.austral.lab1.odontobook.web.*, java.util.*"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<link rel="icon" type="image/png" href="/img/logo.png" />

<title>Odontobook</title>

</head>

<body background="img/fondo.png">
<div align="center" >
  <h1 align="center" >
  <img id="logo" style=" height:100px; width:100px; padding-bottom:40px" src="img/logo.png"/>
  <img  src="img/odontobook.png"/> </h1>
</div>
<p align="right">&nbsp;</p>

<% Boolean entrarOk = (Boolean) request.getAttribute("entrar"); %>

<%if(entrarOk == null) { %>

<div  id="loginForm">
<div class="rbroundboxLog">
	<div class="rbtopLog"><div></div></div>
		<div class="rbcontent">


<form  name="loginForm" method="POST"
action = "j_security_check">
<label for="name">Usuario:</label><input type="text" name="j_username" id="j_username" />
<label for="password">Password:</label><input type="password" name="j_password" id="j_password" />

<input id="submit" type="submit" value="Conectarse" />
</form>

	</div>
	<div class="rbbotLog"><div></div></div>
</div>
  </div>

<%} else{ %>


<div  id="loginForm">
<div class="rbroundboxLog">
	<div class="rbtopLog"><div></div></div>
		<div class="rbcontent">


<form  name="loginForm" method="POST"
action = "j_security_check">
<label for="name">Usuario:</label><input type="text" name="j_username" id="j_username" />
<label for="password">Password:</label><input type="password" name="j_password" id="j_password" />
<input id="submit" type="submit" value="Conectarse" />




</form>

	</div>
	<div class="rbbotLog"><div></div></div>
</div>


  </div>
<p id="par" align="center"> El usuario o contrase&ntilde;a son incorrectos </p>

<%}%>
<% Bundle bun = new Bundle(); %>
</body>
</html>
