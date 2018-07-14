<%@ page import="dominio.UsuarioMT" %><% UsuarioMT.idenficarUsuario(request, response); %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="dados.AssociacaoPA" %>
<%@ page import="dados.AtletaPA" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Atletas</title>
</head>
<body>
<h2 style="text-align: center">Sistema SISFARJ</h2>
<b>Lista de Atletas da prova escolhida</b><br><br>
<%if(request.getAttribute("id") == null)
        request.setAttribute("id","5"); %>
<table border="1px">
    <thead>
    <tr>
        <th>Matricula</th>
        <th>Nome</th>
        <% if(request.getAttribute("id").equals("3") | request.getAttribute("id").equals("4")){
        %>
        <th>Tempo</th>
        <% } %>
        <% if(request.getAttribute("id").equals("4")){
        %>
        <th>Pontos</th>
        <th>Sigla Associação</th>
        <% } %>
    </tr>
    </thead>
    <tbody>
    <%
        ResultSet res = null;
        if(request.getAttribute("id").equals("5")){
            AtletaPA GatewayAtleta = new AtletaPA();
            res = GatewayAtleta.buscarTodosAtletas();
        }else {
            res = (ResultSet) request.getAttribute("atleta");
        }
        if(!res.isClosed()){
            while(res.next()){
    %>
    <tr>
        <td><%=res.getString("matricula") %></td>
        <td><%=res.getString("nome") %></td>
        <% if(request.getAttribute("id").equals("3") | request.getAttribute("id").equals("4")){
        %>
        <td><%=res.getString("tempo") %></td>
        <% }if(request.getAttribute("id").equals("4")){%>
        <td><%=res.getString("ponto") %></td>
        <%
            AssociacaoPA GatewayAssociacao= new AssociacaoPA();
            ResultSet res2 = GatewayAssociacao.buscarSigla(res.getString("matricula"));
            while(res2.next()){
            %>
        <td><%=res2.getString("sigla") %></td>
        <% } %>
    </tr>
    <%
                }
            }
        }
    %>
    </tbody>
</table>
<% if(request.getAttribute("id").equals("3") | request.getAttribute("id").equals("4") | request.getAttribute("id").equals("5")){
%>
<br>
<% } else {%>
<form action="/dominio/AtletaProvaMT" method="post">
    <br>
     Matrícula do Atleta:<br>
    <input type="text" name="matricula_atleta"><br>
     Tempo do Atleta na Prova:<br>
    <input type="text" name="tempo">
    <input type="hidden" name="nome_prova" value="<%=request.getAttribute("nome_prova")%>"><br>
    <input type="submit" value="Enviar">
    <input type="hidden" name="acao" value="2">
</form>
<% } %>
<a href="/PaginaInicial.jsp">Voltar para página inicial</a>
</body>
</html>
