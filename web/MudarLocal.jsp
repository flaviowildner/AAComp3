<%@ page import="java.sql.ResultSet" %>
<%@ page import="dominio.LocalMT" %>
<%@ page import="java.sql.ResultSetMetaData" %>
<%--
  Created by IntelliJ IDEA.
  User: renan
  Date: 11/07/2018
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Alterar Dados do Local</title>
</head>
<body>
    <form action="/dominio/LocalMT" method="post">
        <%
            ResultSet res = (ResultSet)request.getAttribute("local");
            ResultSetMetaData meta = res.getMetaData();
            int count = meta.getColumnCount();
            res.next();
            for(int i=1;i<=count;i++){
                Object value = res.getObject(i);
                if(value != null){
        %>
        <% if(meta.getColumnName(i).equals("NOMELOCAL")){%>
        <%=meta.getColumnName(i)%><br>
        <input type="input" name="<%=meta.getColumnName(i).toLowerCase()%>" value="<%=value.toString()%>" disabled="true"><br>
        <input type="hidden" name="<%=meta.getColumnName(i).toLowerCase()%>" value="<%=value.toString()%>"> <br>
        <%
        }
        else{ %>
        <%=meta.getColumnName(i)%><br>
        <input type="input" name="<%=meta.getColumnName(i).toLowerCase()%>" value="<%=value.toString()%>"><br>
        <%
                    }
                }
            }
        %>
        <br>
        <input type="submit" value="Enviar">
        <input type="hidden" name="acao" value="3">
    </form>
    <br><br>
    <a href="/">Voltar para página inicial</a>
</body>
</html>
