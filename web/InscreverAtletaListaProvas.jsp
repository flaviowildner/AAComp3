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
<b>Lista de Provas</b><br><br>
<table border="1px">
    <thead>
    <tr>
        <th>Nome</th>
        <th>Categoria</th>
        <th>Classe</th>
    </tr>
    </thead>
    <tbody>
    <%

        ResultSet res = (ResultSet)request.getAttribute("prova");
        if(!res.isClosed()){
            while(res.next()){
    %>
    <tr>
        <td><%=res.getString("nome") %></td>
        <td><%=res.getString("categoria") %></td>
        <td><%=res.getString("classe") %></td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>

<br>
<form action="/InscreverAtletaProvaDados.jsp" method="post">
    Escreva o nome da prova:<br>
    <input type="text" name="nome">
    <input type="submit" value="Enviar">
    <%--<input type="hidden" name="acao" value="2">--%>
</form>
<br><br>

<a href="/">Voltar para página inicial</a>
</body>
</html>
