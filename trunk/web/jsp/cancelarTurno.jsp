<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page import="edu.austral.lab1.odontobook.model.*, edu.austral.lab1.odontobook.web.*, java.util.*"%>

<head>
<link rel="icon" type="image/png" href="/img/logo.png" />
  <link href="css/custom-theme/jquery-ui-1.8.1.custom.css" rel="stylesheet" type="text/css"/>
  <script src="jquery/js/jquery-1.4.2.min.js"></script>
  <script src="jquery/js/jquery-ui-1.8.1.custom.min.js"></script>
  
  <script>
  $(document).ready(function() {
	
    $("#datepicker").datepicker();
	$( ".selector" ).datepicker( "option", "dayNamesMin", ['Di', 'Lu', 'Ma', 'Me', 'Je', 'Ve', 'Sa'] );

  });
  
  function doIt(){
	var txt = document.getElementById("datepicker");
	if(txt.value != ""){
		document.turnoForm.submit();
	}
  }
  
  
  </script>


<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<title>Odontobook</title>

</head>

<html><body>

<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page import="edu.austral.lab1.odontobook.model.*, edu.austral.lab1.odontobook.web.*, java.util.*"%>

<head>
  <link href="css/custom-theme/jquery-ui-1.8.1.custom.css" rel="stylesheet" type="text/css"/>
  <script src="jquery/js/jquery-1.4.2.min.js"></script>
  <script src="jquery/js/jquery-ui-1.8.1.custom.min.js"></script>
  
  <script>
  $(document).ready(function() {
	
    $("#datepicker").datepicker();
	$( ".selector" ).datepicker( "option", "dayNamesMin", ['Di', 'Lu', 'Ma', 'Me', 'Je', 'Ve', 'Sa'] );

  });
  
  function doIt(){
	var txt = document.getElementById("datepicker");
	if(txt.value != ""){
		document.turnoForm.submit();
	}
  }
  
  
  </script>


<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<title>Odontobook</title>

</head>
<html>
<body>
<% ResourceBundle bundle = Bundle.getBundle(); %>

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
  
<div>
<p id="sel">
<%= bundle.getString("selFecha")%>
</p>

<form name="turnoForm" method="POST" action="CancelarTurno.do">
 <input type="text" name="datepicker" id="datepicker" />
<input id="buttonSubmit" type = "button" onClick="doIt()"  value="Buscar" />
</form>
</div>
 
 <% List<Turno> lis = (List)request.getAttribute("listaTurnos");%>

<div align="center">
<p>
<table id="tabD">

<tr >
<th> <%= bundle.getString("fecha")%>  </th>
<th> <%= bundle.getString("hora")%> </th>
<th> Doctor</th>
<th> <%= bundle.getString("accion")%> </th>
</tr>
<%if (lis != null){ 
 for (int i = 0; i < lis.size(); i++){ %>
<tr>
<td> <%=  request.getAttribute("fecha") %> </td>
<td> <%= lis.get(i).hora() +":"+lis.get(i).minutos() %> </td>
<td> <%= lis.get(i).getDoctor().getNombre()+" "+lis.get(i).getDoctor().getApellido() %> </td>
<td><form  method="POST" action="ConfirmarCancelarTurno.do">
<% request.setAttribute("date", request.getAttribute("fecha")); %>
<button name="sacarT" id="sacarT"><%= bundle.getString("cancelarTurno")%></button>
<input name="hora"  type = "hidden" value= "<%= lis.get(i).hora() +":"+lis.get(i).minutos() %>" />
<input name="date"  type = "hidden" value= "<%=  request.getAttribute("fecha") %>" />
<input name="doctor"  type = "hidden" value= "<%= lis.get(i).getDoctor().getNombre()+" "+lis.get(i).getDoctor().getApellido() %>" /> 
</form></td>
</tr>
<%}}%>

</table>
</p>
</div>
</td>
</tr>
</table> 
 
</body>
</html>


</body>
</html>
