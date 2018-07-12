<%@ page import="java.sql.ResultSet" %>
<%@ page import="dominio.LocalMT"%>
<%--
  Created by IntelliJ IDEA.
  User: renan
  Date: 11/07/2018
  Time: 00:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Alterar Local</title>
</head>
<body>
    <form action="/MudarLocal.jsp" method="post">
        <select name="local">
            <%
                ResultSet res = LocalMT.listarLocais();
                if(!res.isClosed()){
                    while(res.next()){
            %>
            <option name="local" value="Campinho"><%=res.getString("nomelocal") %></option>
            <%
                    }
                }
            %>
        </select>
        <br><br>
        <input type="hidden" name="acao" value="2">
        <input type="submit">
    </form>
</body>
</html>
