<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page import="edu.austral.lab1.odontobook.util.*, edu.austral.lab1.odontobook.model.*, edu.austral.lab1.odontobook.web.*, java.util.*"%>

<head>
 <link href="css/custom-theme/jquery-ui-1.8.1.custom.css" rel="stylesheet" type="text/css"/>
  
  
  <script>
  $(document).ready(function() {
	
    $("#datepicker").datepicker();
	$( ".selector" ).datepicker( "option", "dayNamesMin", ['Di', 'Lu', 'Ma', 'Me', 'Je', 'Ve', 'Sa'] );

  });
  
  </script>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<title>Odontobook</title>
</head>

<body>
<div align="right">
    <p>
      <%@include file="/jsp/menu.jsp" %>
    </p>
    <p align="left">&nbsp;</p>
</div>

<% List<Doctor> list = (List<Doctor>) request.getAttribute("list"); %>

<form method="POST" action="SacarTurno.do" >

<div>
<p id="sel">
Seleccione el doctor con el que se quiere atender:
</p>

<select name="Doc" id="doc" size ="1">
<option>Todos</option>
<% for(int i =0; i<list.size(); i++){ %>
<option> <%= list.get(i).getNombre() +" "+list.get(i).getApellido() %> </option>
<%}%>
</select>

</div>

<div>
<p id="sel">
Seleccione la fecha en que quiere sacar el turno:
</p>
<input type="text" name="datepicker" id="datepicker" />
<input name="SUBMIT" type = "SUBMIT" value="Buscar" />
</div>

<% String aux = request.getParameter("Doc"); %>
<%if(aux !=null){%>
<% if(!aux.equals("Todos")){ %>

<% String[] listT = (String[]) request.getAttribute("turnosList"); %>

<div>
<p>
<table id="tabD">

<tr >
<th> Fecha  </th>
<th> Hora </th>
<th> Doctor</th>
</tr>
<%if (listT != null){ 
 for (int i = 0; i < listT.length; i++){ %>
 <% if(!listT[i].equals("")){%>
<tr>
<td><%=  request.getAttribute("fecha") %> </td>
<td id="SacarTu"><%= listT[i] %></td>
<td><%= request.getParameter("Doc") %> </td>
<td><form method="POST" action="ConfirmarSacarTurno.do">
<button name="sacarT" id="sacarT"></button>
<% String a = request.getParameter("datepicker"); %>
<% request.setAttribute("f", a); %>

</form>  </td>
</tr>
<%}}}%>

</table>
</p>
</div>
<%} else {%>
<% List<String[]> listT = (List<String[]>) request.getAttribute("turnosList"); %>

<div>
<p>
<% if (listT != null){ 
 for(int k = 0; k<listT.size(); k++){ %>
<p>
<table id="tabD">

<tr >
<th> Fecha  </th>
<th> Hora </th>
<th> Doctor</th>
<th> Accion</th>
</tr>

<% for (int i = 0; i < listT.get(k).length; i++){ %>
<% if(!listT.get(k)[i].equals("")){%>
<tr>
<td><%=  request.getAttribute("fecha") %> </td>
<td> <%= listT.get(k)[i] %> </td>
<td><%= list.get(k).getNombre()+" "+list.get(k).getApellido() %> </td>
<td><form  method="POST" action="ConfirmarSacarTurno.do">
<button name="sacarT" id="sacarT">Sacar Turno</button>

<%--<% request.setAttribute("fecha", request.getAttribute("fecha")); %>
<% request.setAttribute("hora", listT.get(k)[i]); %>
<% request.setAttribute("doctor", list.get(k).getNombre()); %>--%>
 </form></td>
</tr>
<%}}%>

</table>
</p>
<%}}%>
</p>
</div>

<%}}%>
</form>

<script src="jquery/js/jquery-1.4.2.min.js"></script>
  <script src="jquery/js/jquery-ui-1.8.1.custom.min.js"></script>
</body>
</html>
</em>