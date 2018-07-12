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
    <title>Novo Local de Competição</title>
</head>
<body>
    <form action="/dominio/LocalMT" method="post">
        Nome Local: <br><input type="input" name="nome_local"><br>
        Endereço: <br><input type="input" name="endereco"><br>
        <br>Tamanho da Piscina:<br>
        <input type="radio" name="piscina" value="50" checked>50m<br>
        <input type="radio" name="piscina" value="25" checked>25m<br>
        <input type="hidden" name="acao" value="1">
        <br><input type="submit" value="Enviar">
    </form>
    <br><br>
    <input type="hidden" name="acao" value="1">
    <a href="/">Voltar para página inicial</a>
</body>
</html>