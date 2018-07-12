package dominio;

import exceptions.ExceptionDadosIncompletos;
import dados.CompeticaoPA;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CompeticaoMT", urlPatterns = {"/dominio/CompeticaoMT"})
public class CompeticaoMT extends HttpServlet {

    public static void cadastrarCompeticao(String nome, String data) throws SQLException, ClassNotFoundException, ExceptionDadosIncompletos {
        if(nome.isEmpty() | data.isEmpty()){
            throw new ExceptionDadosIncompletos();
        }else {
            try {
                CompeticaoPA.inserir(nome, data);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                //ERRO NO BANCO DE DADOS
            } catch (ClassNotFoundException e) {
                System.out.println("EXCEPTION CLASSNOTFOUND");
                //ERRO NO BANCO DE DADOS
            }
        }
    }

    public static void updateLocal(String nome, String local) throws SQLException, ClassNotFoundException, ExceptionDadosIncompletos {
        if(nome.isEmpty() | local.isEmpty()){
            throw new ExceptionDadosIncompletos();
        }else {
            try {
                CompeticaoPA.updateLocal(nome, local);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static ResultSet listarCompeticoes(){
        try{
            return CompeticaoPA.buscarTodasCompeticoes();
        } catch(SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        } catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
            return null;
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
                    cadastrarCompeticao(request.getParameter("nome"),
                            request.getParameter("data"));
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (ExceptionDadosIncompletos exceptionDadosIncompletos) {
                    request.getRequestDispatcher("/ExcecaoDadosIncompletos.jsp").forward(request, response);
                }
                request.setAttribute("nome_competicao", request.getParameter("nome"));
                request.getRequestDispatcher("/ListarLocaisCadastroCompeticao.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
