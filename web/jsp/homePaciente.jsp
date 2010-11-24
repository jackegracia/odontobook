<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page import="edu.austral.lab1.odontobook.util.*, edu.austral.lab1.odontobook.model.*, edu.austral.lab1.odontobook.web.*, java.util.*"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<link rel="icon" type="image/png" href="/img/logo.png" />
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
<td>
<%@include file="/jsp/lista.jsp" %>
</td>
<td></td>
<td id="tdLista" valign="top">
<p id="par">
<% List<Turno> lis = (List<Turno>) request.getAttribute("lista"); 
	Sorter.ordenarTurnos(lis);
%>
<% if(lis.size() != 0){ %>
<p id="sel"> 
<%= bundle.getString("pacHomeLista") %>
</p>
<table id="tabD">

<tr >
<th> <%= bundle.getString("fecha") %> </th>
<th> <%= bundle.getString("hora")%> </th>
<th> <%= bundle.getString("doctor")%></th>
<th> <%= bundle.getString("accion")%> </th>
</tr>
<%if (lis != null){ 
 for (int i = 0; i < lis.size(); i++){ %>
<tr>

<td> <%= lis.get(i).toString() %> </td>
<td> <%= lis.get(i).hora() +":"+lis.get(i).minutos() %> </td>
<td> <%= lis.get(i).getDoctor().getNombre()+" "+lis.get(i).getDoctor().getApellido() %> </td>

<td><form  method="POST" action="ConfirmarCancelarTurno.do">
<% request.setAttribute("date", lis.get(i).toString()); %>
<button name="sacarT" id="sacarT"><%= bundle.getString("cancelarTurno")%></button>
<input name="hora"  type = "hidden" value= "<%= lis.get(i).hora() +":"+lis.get(i).minutos() %>" />
<input name="date"  type = "hidden" value= "<%=  lis.get(i).toString() %>" />
<input name="doctor"  type = "hidden" value= "<%= lis.get(i).getDoctor().getNombre()+" "+lis.get(i).getDoctor().getApellido() %>" /> 
</form></td>
</tr>
<%}}%>

</table>
<%} else{ %>
<%= bundle.getString("pacHome") %>
<%}%>
</p>
</td>
</tr>
</table>
</body></html>