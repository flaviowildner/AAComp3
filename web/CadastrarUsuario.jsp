<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<br>
<form action="/dominio/UsuarioMT" method="post">
    Matricula:<br>
    <input type="text" name="matricula"><br>
    Senha:<br>
    <input type="text" name="senha"><br><br>
    <select name="nivel_acesso">
        <option value="1">Secretário</option>
        <option value="2">Diretor técnico</option>
    </select>
    <input type="submit" value="Cadastrar">
    <input type="hidden" name="acao" value="2">
</form>
<br><br>
<a href="/">Voltar para página de login</a>

</body>
</html>
