package dominio;

import java.sql.ResultSet;
import java.util.Random;
import dados.AssociacaoPA;
import dados.AtletaPA;
import java.sql.SQLException;
import exceptions.ExceptionDadosIncompletos;
import exceptions.MatriculaAssociacaoInvalidaException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AtletaMT", urlPatterns = {"/dominio/AtletaMT"})
public class AtletaMT extends HttpServlet {

    public static ResultSet listarAtletas() {
        try {
            return AtletaPA.buscarTodosAtletas();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void alterarAtletaDados(String nome, String numero, String data_entrada, String data_oficio, String matricula) throws ExceptionDadosIncompletos, SQLException, ClassNotFoundException {
        if(nome.isEmpty() | numero.isEmpty() | data_entrada.isEmpty() | data_oficio.isEmpty() | matricula.isEmpty()){
            throw new ExceptionDadosIncompletos();
        }else {
            AtletaPA.update(nome, numero, data_entrada, data_oficio, matricula);
        }
    }

    public static void transferirAtleta(String numero, String data_oficio, String comprovante, String data_entrada, String matricula, String matricula_associacao) throws ExceptionDadosIncompletos, SQLException, ClassNotFoundException, MatriculaAssociacaoInvalidaException {
        if(AssociacaoPA.buscarAssociacao(matricula_associacao).next() == false){
            throw new MatriculaAssociacaoInvalidaException();
        }
        if(comprovante.isEmpty() | numero.isEmpty() | data_entrada.isEmpty() | data_oficio.isEmpty() | matricula.isEmpty() | matricula_associacao.isEmpty() ){
            throw new ExceptionDadosIncompletos();
        }else {
            AtletaPA.transferir(numero, data_oficio, comprovante, data_entrada, matricula_associacao, matricula);
        }
    }

    public static ResultSet getDadosAtleta(String matricula){
        try {
            return AtletaPA.buscarAtletaDados(matricula);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void cadastrarAtleta(String nome, String numero, String data_entrada, String data_oficio, String data_nascimento, String comprovante, String matricula_associacao) throws SQLException, ClassNotFoundException, ExceptionDadosIncompletos, MatriculaAssociacaoInvalidaException {
        if(nome.isEmpty() | numero.isEmpty() | data_entrada.isEmpty() | data_oficio.isEmpty() | data_nascimento.isEmpty() | comprovante.isEmpty() | matricula_associacao.isEmpty()){
            throw new ExceptionDadosIncompletos();
        }else if(AssociacaoPA.buscarAssociacao(matricula_associacao).next() == false){
            throw new MatriculaAssociacaoInvalidaException();
        }else {
            try {
                String matricula;
                while(AtletaPA.buscarAtleta(matricula = Integer.toString(new Random().nextInt(999999999) + 1)).next()){}
                System.out.println(matricula);
                AtletaPA.inserir(nome, numero, data_entrada, data_oficio, data_nascimento, comprovante, matricula_associacao, matricula);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                //ERRO NO BANCO DE DADOS
            } catch (ClassNotFoundException e) {
                System.out.println("EXCEPTION CLASSNOTFOUND");
                //ERRO NO BANCO DE DADOS
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int acao;
        ResultSet resultSet;
        try{
            acao = Integer.parseInt(request.getParameter("acao"));
        } catch (NumberFormatException e){
            acao = 0;
        }

        switch(acao){
            case 1:
                try {
                    cadastrarAtleta(request.getParameter("nome"),
                            request.getParameter("numero"),
                            request.getParameter("data_entrada"),
                            request.getParameter("data_oficio"),
                            request.getParameter("data_nascimento"),
                            request.getParameter("comprovante"),
                            request.getParameter("matricula_associacao"));
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (ExceptionDadosIncompletos exceptionDadosIncompletos) {
                    request.getRequestDispatcher("/ExcecaoDadosIncompletos.jsp").forward(request, response);
                } catch (MatriculaAssociacaoInvalidaException e) {
                    request.getRequestDispatcher("/ExcecaoMatriculaAssociacaoInvalida.jsp").forward(request, response);
                }
                request.getRequestDispatcher("/PaginaInicial.jsp").forward(request, response);
            case 2:
                resultSet = getDadosAtleta(request.getParameter("matricula"));
                request.setAttribute("atleta", resultSet);
                request.getRequestDispatcher("/AlterarAtletaDados.jsp").forward(request, response);
            case 3:
                try {
                    alterarAtletaDados(request.getParameter("nome"),
                            request.getParameter("numero"),
                            request.getParameter("data_entrada"),
                            request.getParameter("data_oficio"),
                            request.getParameter("matricula"));
                } catch (ExceptionDadosIncompletos exceptionDadosIncompletos) {
                    request.getRequestDispatcher("/ExcecaoDadosIncompletos.jsp").forward(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                request.getRequestDispatcher("/PaginaInicial.jsp").forward(request, response);
            case 4:
                resultSet = getDadosAtleta(request.getParameter("matricula"));
                request.setAttribute("atleta", resultSet);
                request.getRequestDispatcher("/TransferirAtletaDados.jsp").forward(request, response);
            case 5:
                try {
                    transferirAtleta(request.getParameter("numero"),
                            request.getParameter("data_oficio"),
                            request.getParameter("comprovante_pagamento"),
                            request.getParameter("data_entrada"),
                            request.getParameter("matricula"),
                            request.getParameter("matricula_associacao"));
                } catch (ExceptionDadosIncompletos exceptionDadosIncompletos) {
                    request.getRequestDispatcher("/ExcecaoDadosIncompletos.jsp").forward(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (MatriculaAssociacaoInvalidaException e){
                    request.getRequestDispatcher("/ExcecaoMatriculaAssociacaoInvalida.jsp").forward(request, response);
                }
                request.getRequestDispatcher("/PaginaInicial.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

