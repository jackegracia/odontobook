<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="style.css" media="screen" />
<title>Documento sin t&iacute;tulo</title>
<style type="text/css">
<!--
.Estilo3 {font-weight: bold}

-->
</style>
</head>

<body>
<div align="center" class="Estilo3">
  <h1 align="center">Odontobook  </h1>
</div>
<p align="right">&nbsp;</p>

<div id="loginForm">

	<form id="<%=Constants.LOGIN_FORM_ID%>" name="form1" method="post" action="<%=response.encodeURL(Constants.LOGIN_FORM_ACTION)%>">
		<label>Name <input id="<%=Constants.LOGIN_USERNAME_FIELD%>" name="<%=Constants.LOGIN_USERNAME_FIELD%>" type="text"  />
		</label> 
		<label>Password <input type="password" name="<%=Constants.LOGIN_PASSWORD_FIELD%>"  style="margin-top: 5px;" />
		</label> 
		<label>
		<input type="submit" name="button" id="button" value="Submit" style="cursor: pointer" /> 
		</label>
		</form>
</div>
</body>
</html>
