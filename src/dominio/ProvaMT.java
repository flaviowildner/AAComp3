package dominio;

import java.sql.ResultSet;

import dados.AtletaPA;
import dados.AtletaProvaPA;
import dados.CompeticaoPA;
import dados.ProvaPA;
import java.sql.SQLException;
import exceptions.AtletaJaInscritoEmProvaException;
import exceptions.ExceptionDadosIncompletos;
import exceptions.MatriculaInvalidaException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.SysexMessage;
import java.io.IOException;

@WebServlet(name = "ProvaMT", urlPatterns = {"/dominio/ProvaMT"})
public class ProvaMT extends HttpServlet {

    public static ResultSet getProvasCompeticao(String nome){
        try {
            return ProvaPA.buscarProvasporCompeticao(nome);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void cadastrarProva(String nome, String classe, String categoria, String nome_competicao) throws ExceptionDadosIncompletos {
        if(nome.isEmpty() | classe.isEmpty() | categoria.isEmpty()){
            throw new ExceptionDadosIncompletos();
        }else try {
            ProvaPA.inserir(nome, classe, categoria, nome_competicao);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void inscreverAtletaProva(String matricula_atleta, String nome_prova) throws SQLException, ClassNotFoundException, ExceptionDadosIncompletos, MatriculaInvalidaException, AtletaJaInscritoEmProvaException{
        if(AtletaPA.buscarAtleta(matricula_atleta).next() == false){
            throw new MatriculaInvalidaException();
        }
        else if(matricula_atleta.isEmpty() | nome_prova.isEmpty()){
            throw new ExceptionDadosIncompletos();
        }
        else if(AtletaProvaPA.findAtletaProva(matricula_atleta,nome_prova).next() == true){
            throw new AtletaJaInscritoEmProvaException();
        }
        else{
            AtletaProvaPA.cadastrarAtletaProva(matricula_atleta,nome_prova);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int acao;
        try{
            acao = Integer.parseInt(request.getParameter("acao"));
        } catch (NumberFormatException e){
            acao = 0;
        }

        switch(acao) {
            case 1:
                ResultSet resultSet = getProvasCompeticao(request.getParameter("nome"));
                request.setAttribute("prova", resultSet);
                request.getRequestDispatcher("/InscreverAtletaListaProvas.jsp").forward(request, response);
            case 2:
                try {
                    inscreverAtletaProva(request.getParameter("matricula_atleta"),
                            request.getParameter("nome_prova"));
                }catch (ExceptionDadosIncompletos e){
                    request.getRequestDispatcher("/ExcecaoDadosIncompletos.jsp").forward(request, response);
                }catch (SQLException e){
                    e.printStackTrace();
                }catch (ClassNotFoundException e){
                    e.printStackTrace();
                }catch (MatriculaInvalidaException e){
                    request.getRequestDispatcher("/ExcecaoMatriculaInvalida.jsp").forward(request, response);
                }catch (AtletaJaInscritoEmProvaException e){
                    request.getRequestDispatcher("/AtletaJaInscritoEmProva.jsp").forward(request, response);
                }
                request.getRequestDispatcher("/AtletaInscritoEmProva.jsp").forward(request, response);
            case 3:
                try {
                    cadastrarProva(request.getParameter("nome_prova"),
                            request.getParameter("classe"),
                            request.getParameter("categoria"),
                            request.getParameter("nome_competicao"));
                    CompeticaoMT.updateLocal(request.getParameter("nome_competicao"),
                            request.getParameter("nome_local"));
                }catch (ExceptionDadosIncompletos e){
                    request.getRequestDispatcher("/ExcecaoDadosIncompletos.jsp").forward(request, response);
                }catch (SQLException e){
                    e.printStackTrace();
                }catch (ClassNotFoundException e){
                    e.printStackTrace();
                }
                request.getRequestDispatcher("/ProvaCriada.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
