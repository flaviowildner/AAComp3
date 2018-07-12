<%@ page import="java.sql.ResultSet" %>
<%@ page import="dominio.LocalMT"%>
<%@ page import="dominio.CompeticaoMT" %>
<%--
  Created by IntelliJ IDEA.
  User: renan
  Date: 10/07/2018
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Atletas</title>
</head>
<body>
<h2 style="text-align: center">Sistema SISFARJ</h2>
<b>Lista de Atletas da prova escolhida</b><br><br>
<table border="1px">
    <thead>
    <tr>
        <th>Matricula</th>
        <th>Nome</th>
        <% if(request.getAttribute("id").equals("3")){
        %>
        <th>Tempo</th>
        <% } %>
    </tr>
    </thead>
    <tbody>
    <%
        ResultSet res = (ResultSet)request.getAttribute("atleta");
        if(!res.isClosed()){
            while(res.next()){
    %>
    <tr>
        <td><%=res.getString("matricula") %></td>
        <td><%=res.getString("nome") %></td>
        <% if(request.getAttribute("id").equals("3")){
        %>
        <td><%=res.getString("tempo") %></td>
        <% } %>

    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>
<% if(request.getAttribute("id").equals("3")){
%>
<br>
<% } else {%>
<form action="/dominio/AtletaProvaMT" method="post">
    <br>
     Matrícula do Atleta:<br>
    <input type="text" name="matricula_atleta"><br>
     Tempo do Atleta na Prova:<br>
    <input type="text" name="tempo">
    <input type="hidden" name="nome_prova" value="<%=request.getAttribute("nome_prova")%>"><br>
    <input type="submit" value="Enviar">
    <input type="hidden" name="acao" value="2">
</form>
<% } %>
<a href="/">Voltar para página inicial</a>
</body>
</html>
