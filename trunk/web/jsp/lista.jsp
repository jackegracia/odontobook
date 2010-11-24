<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Documento sin t&iacute;tulo</title>
</head>

<body>


<%  
	ResourceBundle bundle2 = Bundle.getBundle(); %>


<% UsuarioDao auxLista = new UsuarioDao();
		String name = request.getRemoteUser();
		Usuario usuario = auxLista.getUsuario(name);
		boolean esDoctorLista = usuario.isEsDoctor();

 if(esDoctorLista){ %>		

<div class="rbroundbox">
	<div class="rbtop"><div></div></div>
		<div class="rbcontent">

<form  method="POST" action = "GoHome.do">
<button id="botonLista"> <%= bundle2.getString("home") %> </button>
</form><br/>

<form  method="POST" action = "VerTurnos.do">
<button id="botonLista"><%= bundle2.getString("verTurnos") %></button>
</form>

 	</div>
	<div class="rbbot"><div></div></div>
</div>


<% }else { %>

<div class="rbroundbox">
	<div class="rbtop"><div></div></div>
		<div class="rbcontent">


<form  method="POST" action = "GoHome.do">
<button id="botonLista"> <%= bundle2.getString("home") %> </button>
</form><br/>


<form method="POST"
action = "SacarTurnoRed.do">
<button id="botonLista"><%= bundle2.getString("sacarTurno") %></button>
</form><br/>


<form method="POST"
action = "VerTurnos.do">
<button id="botonLista"><%= bundle2.getString("verTurnos") %></button>
</form><br/>


<form method="POST"
action = "CancelarRed.do">
<button id="botonLista"><%= bundle2.getString("cancelarTurno") %></button>
</form>

	</div>
	<div class="rbbot"><div></div></div>
</div>


<%}%>
</body>
</html>
