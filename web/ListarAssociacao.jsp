<%@ page import="dominio.AssociacaoMT" %>
<%@ page import="java.sql.ResultSet" %><%--
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
<body>
<h2 style="text-align: center">Sistema SISFARJ</h2>
<b>Lista de associações</b><br><br>
<table border="1px">
    <thead>
    <tr>
        <th>Matrícula</th>
        <th>Nome da associação</th>
    </tr>
    </thead>
    <tbody>
    <%
        ResultSet res = AssociacaoMT.listarAssociacao();
        if(!res.isClosed()){
            while(res.next()){
    %>
    <tr>
        <td><%=res.getString("matricula") %></td>
        <td><%=res.getString("nome") %></td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>
<a href="/">Voltar para página inicial</a>
</body>
</html>
