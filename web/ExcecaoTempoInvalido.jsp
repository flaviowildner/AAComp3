<%@ page import="dominio.UsuarioMT" %><% UsuarioMT.idenficarUsuario(request, response); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tempo Inválido</title>
</head>
<body>
    <h2>Tempo informado inválido, siga o padrão HH:MM.SS (Hora:Minuto.Segundo)</h2>
    <br>
    <button type="button" name="back" onclick="history.back()">voltar</button>
</body>
</html>
