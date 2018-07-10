<%--
  Created by IntelliJ IDEA.
  User: flavi
  Date: 7/8/2018
  Time: 9:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Filiar Associação</title>
</head>
<body>
    <form action="/dominio/AssociacaoMT" method="post">
        Número de ofício:<br><input type="input" name="numero_oficio"><br>
        Data:<br><input type="input" name="data_oficio"><br>
        Nome:<br><input type="input" name="nome"><br>
        Sigla:<br><input type="input" name="sigla"><br>
        Endereço:<br><input type="input" name="endereco"><br>
        Telefone:<br><input type="input" name="telefone"><br>
        Número do comprovate de pagamento:<br><input type="input" name="comprovante_pagamento"><br>
        <input type="hidden" name="acao" value="1">
        <br><input type="submit" value="Enviar">
    </form>
    <br><br>
    <a href="/">Voltar para página inicial</a>
</body>
</html>
