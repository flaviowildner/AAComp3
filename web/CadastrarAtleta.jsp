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
    <title>Cadastrar Atleta</title>
</head>
<body>
    <form action="/dominio/AtletaMT" method="post">
        Nome:<br><input type="input" name="nome"><br>
        Numero:<br><input type="input" name="numero"><br>
        Data de Entrada:<br><input type="input" name="data_entrada"><br>
        Data de Ofício:<br><input type="input" name="data_oficio"><br>
        Data de Nascimento:<br><input type="input" name="data_nascimento"><br>
        Comprovante de Pagamento:<br><input type="input" name="comprovante"><br>
        Matrícula da Associação:<br><input type="input" name="matricula_associacao"><br>
        <input type="hidden" name="acao" value="1">
        <br><input type="submit" value="Enviar">
    </form>
    <br><br>
    <a href="/">Voltar para página inicial</a>
</body>
</html>
