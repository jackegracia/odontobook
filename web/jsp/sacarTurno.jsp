<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page import="edu.austral.lab1.odontobook.util.*, edu.austral.lab1.odontobook.model.*, edu.austral.lab1.odontobook.web.*, java.util.*"%>

<head>
  <link href="css/custom-theme/jquery-ui-1.8.1.custom.css" rel="stylesheet" type="text/css"/>
  <link rel="icon" type="image/png" href="/img/logo.png" />
  <script src="jquery/js/jquery-1.4.2.min.js"></script>
  <script src="jquery/js/jquery-ui-1.8.1.custom.min.js"></script>
  
  <script>
  $(document).ready(function() {
	$("#SUBMIT")
    $("#datepicker").datepicker();
	$("#datepicker").datepicker($.datepicker.regional['fr']);
	;
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
<% List<Doctor> list = (List<Doctor>) request.getAttribute("list"); %>

<form name="turnoForm" method="POST" action="SacarTurno.do" >

<div>
<p id="sel">
 <%= bundle.getString("seleccionar")%>
</p>

<select name="Doc" id="doc" size ="1">
<option><%= bundle.getString("todos")%></option>
<% for(int i =0; i<list.size(); i++){ %>
<option> <%= list.get(i).getNombre()+" "+list.get(i).getApellido() %> </option>
<%}%>
</select>

</div>

<div>
<p id="sel">
<%= bundle.getString("selFecha")%> 

</p>
<input type="text" name="datepicker" id="datepicker" />
<input id="buttonSubmit" type = "button" onClick="doIt()"  value=<%= bundle.getString("buscar") %> />
</div>

</form>

<% String auxd = request.getParameter("Doc"); %>
<%if(auxd !=null){%>
<% if(!(auxd.equals("Todos") || auxd.equals("All")) ){ %>

<% String[] listT = (String[]) request.getAttribute("turnosList"); %>

<div>
<p>
<table id="tabD">
<tr >
<th>  <%= bundle.getString("fecha")%>  </th>
<th>  <%= bundle.getString("hora")%> </th>
<th> Doctor</th>
<th>  <%= bundle.getString("accion")%> </th>
</tr>
<%if (listT != null){ 
 for (int i = 0; i < listT.length; i++){ %>
 <% if(!listT[i].equals("")){%>
<tr>
<td><%=  request.getAttribute("fecha") %> </td>
<td ><%= listT[i] %></td>
<td><%= request.getParameter("Doc") %> </td>
<td><form  method="POST" action="ConfirmarSacarTurno.do">
<% request.setAttribute("date", request.getAttribute("fecha")); %>
<button name="sacarT" id="sacarT"><%= bundle.getString("sacarTurno") %></button>
<input name="hora"  type = "hidden" value= <%= listT[i] %> />
<input name="date"  type = "hidden" value= <%= request.getAttribute("fecha") %> />
<input name="doctor"  type = "hidden" value= "<%= request.getParameter("Doc") %>" />
</form></td></tr>
<%}}}%>
</table>

</p>
</div>
<%} else {%>
<% List<String[]> listT = (List<String[]>) request.getAttribute("turnosList"); %>

<div>
<table>
<tr>
<th></th>
<th></th>
<th></th>
</tr>
<% if (listT != null){ 
 for(int k = 0; k<listT.size(); k++){ %>
<p>

<% if((k)%3 == 0){ %>
<tr></tr>
<% } %>
<td valign="top">
<table id="tabD">

<tr >
<th>  <%= bundle.getString("fecha")%>  </th>
<th>  <%= bundle.getString("hora")%> </th>
<th> Doctor</th>
<th>  <%= bundle.getString("accion")%> </th>
</tr>

<% for (int i = 0; i < listT.get(k).length; i++){ %>
<% if(!listT.get(k)[i].equals("")){%>
<tr>
<td ><%=  request.getAttribute("fecha") %> </td>
<td> <%= listT.get(k)[i] %> </td>
<td><%= list.get(k).getNombre()+" "+list.get(k).getApellido() %> </td>
<td><form  method="POST" action="ConfirmarSacarTurno.do">
<% request.setAttribute("date", request.getAttribute("fecha")); %>
<button name="sacarT" id="sacarT"><%= bundle.getString("sacarTurno") %></button>
<input name="hora"  type = "hidden" value= <%= listT.get(k)[i] %> />
<input name="date"  type = "hidden" value= <%= request.getAttribute("fecha") %> />
<input name="doctor"  type = "hidden" value= "<%= list.get(k).getNombre()+" "+list.get(k).getApellido() %>" /> 
</form></td>
</tr>
<%}}%>

</table>
</td>


</p>
<%}}%>
</table>
</div>

<%}}%>
</td>
</tr>
</table>
</body>
</html>
