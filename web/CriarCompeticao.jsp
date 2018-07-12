<%--
  Created by IntelliJ IDEA.
  User: renan
  Date: 10/07/2018
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Criar Nova Competição</title>
</head>
<body>
    <form action="/dominio/CompeticaoMT" method="post">
        Nome: <br><input type="input" name="nome"><br>
        Data: <br><input type="input" name="data"><br>
        <input type="hidden" name="acao" value="1">
        <br><input type="submit" value="Enviar">
    </form>
    <br><br>
    <a href="/">Voltar para página inicial</a>
</body>
</html>