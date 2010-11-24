<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page import="edu.austral.lab1.odontobook.model.*, edu.austral.lab1.odontobook.web.*, java.util.ResourceBundle"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<link rel="icon" type="image/png" href="/img/logo.png" />
<title>Odontobook</title>

</head>

<html><body>
<%  
	ResourceBundle bundle = Bundle.getBundle(); %>

  <div align="right">
      <%@include file="/jsp/menu.jsp" %>
  </div>
  
  <table id="tablaPrincipal">
<th></th>
<th id="thMedio"></th>
<th></th>
<tr>
<td valign="top">

<%@include file="/jsp/lista.jsp" %>

</td>
<td></td>
<td id="tdLista" valign="top">
  
  <% Boolean fechaCorrecta = (Boolean) request.getAttribute("fechaCorrecta"); %>
 
 <div > 
  <% if(fechaCorrecta){ %>
  		<p id="sel">
			<% String fecha = (String) request.getAttribute("fecha"); %>
			<% String hora = (String) request.getAttribute("hora"); %>
			<% String doctor = (String) request.getAttribute("doctor"); %>
		<%= bundle.getString("confSacarTurno1") +" " %> <%= doctor %> <%= bundle.getString("confSacarTurno2")+" " %> <%= fecha %> <%= bundle.getString("confSacarTurno3")+" " %> <%= hora %>
		</p>
		
		
		<form method="POST" action="Confirmado.do">

		<input name="hora"  type = "hidden" value= <%= request.getAttribute("hora") %> />
		<input name="date"  type = "hidden" value= <%= request.getAttribute("fecha") %> />
		<input name="doctor"  type = "hidden" value= "<%= request.getAttribute("doctor") %>" />
		<p id="opcion">
			<button name="oA" id="oA" value="aceptar"> <%= bundle.getString("aceptar")%> </button>

			<button name="oC" id="oC" value="cancelar"> <%= bundle.getString("cancelar")%> </button>
		</p>
		</form>
		
	<%}else{ %>
		<p id="sel"> 
		<%= bundle.getString("fechaInvalida1") %> <br />
		<%= bundle.getString("fechaInvalida2") %> <br />
		<%= bundle.getString("fechaInvalida3") %>
		</p>
		<%}%>
  </div>
  
</td>
</tr>
</table>  
</body>
</html>
