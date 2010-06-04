<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page import="edu.austral.lab1.odontobook.model.*, edu.austral.lab1.odontobook.web.*"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<title>Odontobook</title>

</head>
<body>

<div>
  <h1 align="center">Odontobook</h1>
  </div>
  
<div id="wel" align="left" >Bienvenido <%= request.getRemoteUser()%></div>
  
      
<form id="logout" name="logout" method="POST"
action = "Logout.do">
<button> 
<div align="right">Logout  </div>
</button>

</form>

</body>
</html>