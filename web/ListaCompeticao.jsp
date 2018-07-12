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
    <title>Competições</title>
</head>
<body>
<h2 style="text-align: center">Sistema SISFARJ</h2>
<b>Lista de Competições</b><br><br>
<table border="1px">
    <thead>
    <tr>
        <th>Nome</th>
        <th>Data</th>
    </tr>
    </thead>
    <tbody>
    <%
        ResultSet res = CompeticaoMT.listarCompeticoes();
        if(!res.isClosed()){
            while(res.next()){
    %>
    <tr>
        <td><%=res.getString("nome") %></td>
        <td><%=res.getString("data") %></td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>

<form action="/dominio/ProvaMT" method="post">
    <br>
    Escreva o nome da competição que deseja ver as provas:<br>
    <input type="text" name="nome">
    <input type="submit" value="Enviar">
    <% if(request.getParameter("id").equals("2")){
    %>
        <input type="hidden" name="acao" value="5">
    <% }else if(request.getParameter("id").equals("3")){%>
        <input type="hidden" name="acao" value="6">
    <% }else{ %>
        <input type="hidden" name="acao" value="4">
    <% } %>
</form>

<a href="/">Voltar para página inicial</a>
</body>
</html>
