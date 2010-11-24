<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page import="edu.austral.lab1.odontobook.model.*, edu.austral.lab1.odontobook.model.dao.*, edu.austral.lab1.odontobook.web.* , java.util.ResourceBundle"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<title>Odontobook</title>

</head>
<body >
<%  	ResourceBundle bundl = Bundle.getBundle(); %>
<div >
   	<h1 align="center">
	<img id="logo" src="img/logo.png"/>
	<img src="img/odontobook.png" height="93" /></h1>
</div>
	
<div id="wel" align="left" >
  <% 	UsuarioDao aux = new UsuarioDao();
		Usuario user = aux.getUsuario(request.getRemoteUser());
		boolean esDoctor = user.isEsDoctor();
		String nombreCompleto = "";
		if(esDoctor){
			DoctorDao dDao = new DoctorDao();
			 Doctor doctor = dDao.getDoctorByUserID(user.getId());
			nombreCompleto = doctor.getNombre()+" "+doctor.getApellido();
		}else{
			PacienteDao pDao = new PacienteDao();
			Paciente paciente = pDao.getPacienteByUserID(user.getId());
			nombreCompleto = paciente.getNombre()+" "+paciente.getApellido(); } %>

 <%=bundl.getString("bienvenido") +" "+ nombreCompleto %></div>

<div  id="menu" >    

<table>
<form method="POST" action="Lenguaje.do">

<button  id="b" name="leng" value="US"><img src="img/ing.gif" /></button>
<button id="b" name="leng" value="ES"><img src="img/esp.gif" /></button>

<input type="hidden" id="pagina" name="pagina"  value=<%= request.getServletPath() %>>
</form>

<form method="POST" action = "Logout.do">
<button> <%= bundl.getString("logout") %></button>
</form>


</table>
</div>

</body>
</html>