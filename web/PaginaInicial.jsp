<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: flavi
  Date: 7/4/2018
  Time: 10:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teste</title>
</head>
<body>
    <h2 style="text-align: center">Sistema SISFARJ</h2>
    <table>
        <thead>
            <tr>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <tr><td><a href="">Listar balizamento competição</a></td></tr>
            <tr><td><a href="">Listar pontuação competição</a></td></tr>
            <tr><td><a href="">Listar pontuação final</a></td></tr>
            <tr><td><a class="feito" href="/FiliarAssociacao.jsp">Filiar Associação</a></td></tr>
            <tr><td><a class="feito" href="/AlterarAssociacaoLista.jsp">Alterar filiação de associação</a></td></tr>
            <tr><td><a class="feito" href="/ListarAssociacao.jsp">Listar associação</a></td></tr>
            <tr><td><a class="feito" href="/CadastrarAtleta.jsp">Cadastrar atleta</a></td></tr>
            <tr><td><a class="feito" href="/AlterarAtletaLista.jsp">Alterar cadastro de atleta</a></td></tr>
            <tr><td><a class="feito" a href="/TransferirAtletaLista.jsp">Transferir atleta</a></td></tr>
            <tr><td><a class="feito" href="/InscreverAtletaListaCompeticoes.jsp">Increver atleta em competição</a></td></tr>
            <tr><td><a class="feito" href="/CriarLocal.jsp">Incluir locais de competição</a></td></tr>
            <tr><td><a href="">Alterar locais de competição</a></td></tr>
            <tr><td><a class="feito" href="/ListarLocais.jsp">Listar locais de competição</a></td></tr>
            <tr><td><a class="feito" href="/CriarCompeticao.jsp">Criar competição</a></td></tr>
            <tr><td><a href="/AlterarCompeticaoLista.jsp">Alterar competição</a></td></tr>
            <tr><td><a href="">Inserir resultado do atleta</a></td></tr>
            <tr><td><a href="">Listar competição</a></td></tr>

        </tbody>
    </table>
</body>
</html>

<<style>

.feito{
    font-weight: bold;
    text-decoration: inherit;
}

</style>