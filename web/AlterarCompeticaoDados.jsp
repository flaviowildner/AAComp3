<%@ page import="java.sql.ResultSet" %>
<%@ page import="dominio.AssociacaoMT" %>
<%@ page import="java.sql.ResultSetMetaData" %><%--
  Created by IntelliJ IDEA.
  User: flavi
  Date: 7/9/2018
  Time: 10:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Alterar Associacao Dados</title>
</head>
<body>
    <form action="/dominio/CompeticaoMT" method="post">
        <%
            ResultSet res = (ResultSet)request.getAttribute("competicao");
            ResultSetMetaData meta = res.getMetaData();
            int count = meta.getColumnCount();
            res.next();
            for(int i=1;i<=count;i++){

                Object value = res.getObject(i);
                if(value != null){
        %>
        <% if(meta.getColumnName(i).equals("NOME")){%>
        <%=meta.getColumnName(i)%><br>
        <input type="input" name="<%=meta.getColumnName(i).toLowerCase()%>" value="<%=value.toString()%>"><br>
        <input type="hidden" name="nome_antigo" value="<%=value.toString()%>"> <br>
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
