<%@ page import="java.sql.ResultSet" %>
<%@ page import="dominio.LocalMT"%>
<%@ page import="java.sql.ResultSetMetaData" %><%--
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
    <title>Provas</title>
</head>
<body>
<h2 style="text-align: center">Sistema SISFARJ</h2>
<b>Entre com o Atleta</b><br><br>


    Nome da prova: <br>
    <input type="input" name="nome_prova" value="<%=request.getParameter("nome")%>" disabled="true"><br>

<form action="/dominio/ProvaMT" method="post">
    Escreva a matrícula do atleta:<br>
    <input type="text" name="matricula_atleta"><br>
    <input type="hidden" name="nome_prova" value="<%=request.getParameter("nome")%>">
    <input type="submit" value="Enviar">
    <input type="hidden" name="acao" value="2">
</form>
<br><br>

<a href="/">Voltar para página inicial</a>
</body>
</html>
