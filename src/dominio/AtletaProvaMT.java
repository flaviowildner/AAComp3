package dominio;

import dados.AtletaPA;
import dados.AtletaProvaPA;
import dados.ProvaPA;
import exceptions.AtletaJaInscritoEmProvaException;
import exceptions.ExceptionDadosIncompletos;
import exceptions.MatriculaInvalidaException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "AtletaProvaMT", urlPatterns = {"/dominio/AtletaProvaMT"})
public class AtletaProvaMT extends HttpServlet {

    public static ResultSet getAtletasProva(String nome_prova){
        try {
            return AtletaProvaPA.findAtletasProva(nome_prova);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    public static void pontuarAtleta(String nome_prova,String matricula_atleta, String tempo) throws ExceptionDadosIncompletos {
        if(matricula_atleta.isEmpty() | tempo.isEmpty()){
            throw new ExceptionDadosIncompletos();
        }
        else if(tempo.equals("00:00.00")){
            tempo = "WO";
        }
        try {
            AtletaProvaPA.inserirTempo(nome_prova,matricula_atleta,tempo);
            ResultSet res = AtletaProvaPA.findPosicoes(nome_prova);
            for(int i = 1; res.next() != false; i++) {
                    if(!res.getString("tempo").equals("WO") | !res.getString("tempo").isEmpty()){
                        if(i == 1) AtletaProvaPA.inserirPonto(nome_prova,res.getString("matricula_atleta"), "28");
                        if(i == 2) AtletaProvaPA.inserirPonto(nome_prova,res.getString("matricula_atleta"), "24");
                        if(i == 3) AtletaProvaPA.inserirPonto(nome_prova,res.getString("matricula_atleta"), "20");
                        if(i == 4) AtletaProvaPA.inserirPonto(nome_prova,res.getString("matricula_atleta"), "16");
                        if(i == 5) AtletaProvaPA.inserirPonto(nome_prova,res.getString("matricula_atleta"), "15");
                        if(i == 6) AtletaProvaPA.inserirPonto(nome_prova,res.getString("matricula_atleta"), "14");
                        if(i == 7) AtletaProvaPA.inserirPonto(nome_prova,res.getString("matricula_atleta"), "13");
                        if(i == 8) AtletaProvaPA.inserirPonto(nome_prova,res.getString("matricula_atleta"), "12");
                        if(i == 9) AtletaProvaPA.inserirPonto(nome_prova,res.getString("matricula_atleta"), "09");
                        if(i == 10) AtletaProvaPA.inserirPonto(nome_prova,res.getString("matricula_atleta"), "07");
                        if(i == 11) AtletaProvaPA.inserirPonto(nome_prova,res.getString("matricula_atleta"), "06");
                        if(i == 12) AtletaProvaPA.inserirPonto(nome_prova,res.getString("matricula_atleta"), "05");
                        if(i == 13) AtletaProvaPA.inserirPonto(nome_prova,res.getString("matricula_atleta"), "04");
                        if(i == 14) AtletaProvaPA.inserirPonto(nome_prova,res.getString("matricula_atleta"), "03");
                        if(i == 15) AtletaProvaPA.inserirPonto(nome_prova,res.getString("matricula_atleta"), "02");
                        if(i == 16) AtletaProvaPA.inserirPonto(nome_prova,res.getString("matricula_atleta"), "01");
                        if(i > 16) AtletaProvaPA.inserirPonto(nome_prova,res.getString("matricula_atleta"), "00");
                    }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int acao;
        ResultSet resultSet;
        try{
            acao = Integer.parseInt(request.getParameter("acao"));
        } catch (NumberFormatException e){
            acao = 0;
        }

        switch(acao) {
            case 1:
                resultSet = getAtletasProva(request.getParameter("nome"));
                request.setAttribute("nome_prova", request.getParameter("nome"));
                request.setAttribute("id", "1");
                request.setAttribute("atleta", resultSet);
                request.getRequestDispatcher("/ListaAtletas.jsp").forward(request, response);
            case 2:
                try {
                    pontuarAtleta(request.getParameter("nome_prova"),
                            request.getParameter("matricula_atleta"),
                            request.getParameter("tempo"));
                }catch (ExceptionDadosIncompletos e){
                    request.getRequestDispatcher("/ExcecaoDadosIncompletos.jsp").forward(request, response);
                }
                request.getRequestDispatcher("/DadosLancadosSucesso.jsp").forward(request, response);
            case 3:
                resultSet = getAtletasProva(request.getParameter("nome"));
                request.setAttribute("nome_prova", request.getParameter("nome"));
                request.setAttribute("id", "3");
                request.setAttribute("atleta", resultSet);
                request.getRequestDispatcher("/ListaAtletas.jsp").forward(request, response);
            case 4:
                resultSet = getAtletasProva(request.getParameter("nome"));
                request.setAttribute("id", "4");
                request.setAttribute("atleta", resultSet);
                request.getRequestDispatcher("/ListaAtletas.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
