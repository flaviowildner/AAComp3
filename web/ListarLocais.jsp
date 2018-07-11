<%@ page import="java.sql.ResultSet" %>
<%@ page import="dominio.LocalMT"%>
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
    <title>Locais de Competição</title>
</head>
<body>
<h2 style="text-align: center">Sistema SISFARJ</h2>
<b>Lista de Locais</b><br><br>
<table border="1px">
    <thead>
    <tr>
        <th>Nome Local</th>
        <th>Endereço</th>
        <th>Tamanho Piscina</th>
    </tr>
    </thead>
    <tbody>
    <%
        ResultSet res = LocalMT.listarLocais();
        if(!res.isClosed()){
            while(res.next()){
    %>
    <tr>
        <td><%=res.getString("nomelocal") %></td>
        <td><%=res.getString("logradouro") %></td>
        <td><%=res.getString("piscina") %></td>
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
