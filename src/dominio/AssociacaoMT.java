package dominio;

import dados.AssociacaoPA;
import dados.UsuarioPA;
import exceptions.ExceptionDadosIncompletos;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@WebServlet(name = "AssociacaoMT", urlPatterns = {"/dominio/AssociacaoMT"})
public class AssociacaoMT extends HttpServlet {

    public static ResultSet listarAssociacao() {
        try {
            return AssociacaoPA.buscarTodasAssociacoes();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public static void cadastrarAssociacao(String numero_oficio, String data, String nome, String sigla, String endereco, String telefone, String comprovante_pagamento) throws SQLException, ClassNotFoundException, ExceptionDadosIncompletos {
        if(numero_oficio.isEmpty() | data.isEmpty() | nome.isEmpty() | sigla.isEmpty() | endereco.isEmpty() | telefone.isEmpty() | comprovante_pagamento.isEmpty()){
            throw new ExceptionDadosIncompletos();
        }else {
            try {
                String matricula, senha;
                senha = Integer.toString(new Random().nextInt(999999999) + 10000000);
                while(AssociacaoPA.buscarAssociacao(matricula = Integer.toString(new Random().nextInt(999999999) + 1)).next()){}
                AssociacaoPA.inserir(numero_oficio, data, nome, sigla, endereco, telefone, comprovante_pagamento, matricula, senha);
                UsuarioPA.inserir(matricula, senha, "3");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                //ERRO NO BANCO DE DADOS
            } catch (ClassNotFoundException e) {
                System.out.println("EXCEPTION CLASSNOTFOUND");
                //ERRO NO BANCO DE DADOS
            }
        }
    }

    public static ResultSet getDadosAssociacao(String matricula){
        try {
            return AssociacaoPA.buscarAssociacaoDados(matricula);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void alterarAssociacaoDados(String numero_oficio, String data, String nome, String sigla, String endereco, String telefone, String comprovante_pagamento, String matricula) throws ExceptionDadosIncompletos, SQLException, ClassNotFoundException {
        if(numero_oficio.isEmpty() | data.isEmpty() | nome.isEmpty() | sigla.isEmpty() | endereco.isEmpty() | telefone.isEmpty() | comprovante_pagamento.isEmpty() | matricula.isEmpty()){
            throw new ExceptionDadosIncompletos();
        }else {
            AssociacaoPA.update(numero_oficio, data, nome, sigla, endereco, telefone, comprovante_pagamento, matricula);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int acao;
        try{
            acao = Integer.parseInt(request.getParameter("acao"));
        } catch (NumberFormatException e){
            acao = 0;
        }

        switch(acao){
            case 1:
                try {
                    cadastrarAssociacao(request.getParameter("numero_oficio"),
                            request.getParameter("data_oficio"),
                            request.getParameter("nome"),
                            request.getParameter("sigla"),
                            request.getParameter("endereco"),
                            request.getParameter("telefone"),
                            request.getParameter("comprovante_pagamento"));
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (ExceptionDadosIncompletos exceptionDadosIncompletos) {
                    request.getRequestDispatcher("/ExcecaoDadosIncompletos.jsp").forward(request, response);
                }
                request.getRequestDispatcher("/PaginaInicial.jsp").forward(request, response);
            case 2:
                ResultSet resultSet = getDadosAssociacao(request.getParameter("matricula"));
                request.setAttribute("associacao", resultSet);
                request.getRequestDispatcher("/AlterarAssociacaoDados.jsp").forward(request, response);
            case 3:
                try {
                    alterarAssociacaoDados(request.getParameter("numero_oficio"),
                            request.getParameter("data_oficio"),
                            request.getParameter("nome"),
                            request.getParameter("sigla"),
                            request.getParameter("endereco"),
                            request.getParameter("telefone"),
                            request.getParameter("comprovante_pagamento"),
                            request.getParameter("matricula"));
                } catch (ExceptionDadosIncompletos exceptionDadosIncompletos) {
                    request.getRequestDispatcher("/ExcecaoDadosIncompletos.jsp").forward(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                request.getRequestDispatcher("/PaginaInicial.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}