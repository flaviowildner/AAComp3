<%@ page import="dominio.AssociacaoMT" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="dominio.CompeticaoMT" %><%--
  Created by IntelliJ IDEA.
  User: flavi
  Date: 7/8/2018
  Time: 6:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Listar Associacao</title>
</head>
<script>

</script>
<body>
<h2 style="text-align: center">Sistema SISFARJ</h2>
<b>Lista de associações</b><br><br>
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
<br>
<form action="/dominio/CompeticaoMT" method="post">
    Escreva o nome da competição que deseja alterar:<br>
    <input type="text" name="nome">
    <input type="submit" value="Enviar">
    <input type="hidden" name="acao" value="2">
</form>
<br><br>
<a href="/">Voltar para página inicial</a>
</body>
</html>
