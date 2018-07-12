package dominio;

import dados.LocalPA;
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

@WebServlet(name = "LocalMT", urlPatterns = {"/dominio/LocalMT"})
public class LocalMT extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            this.cadastrarLocal(request.getParameter("nome_local"),
                                request.getParameter("endereco"),
                                request.getParameter("piscina"));
        } catch(SQLException e){
            e.printStackTrace();
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        } catch(ExceptionDadosIncompletos exceptionDadosIncompletos){
            request.getRequestDispatcher("/ExcecaoDadosIncompletos.jsp").forward(request, response);
        }
        request.getRequestDispatcher("/PaginaInicial.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public static ResultSet listarLocais(){
        try{
            return LocalPA.buscarTodosLocais();
        } catch(SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        } catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void cadastrarLocal(String nomeLocal, String logradouro, String piscina) throws SQLException, ClassNotFoundException, ExceptionDadosIncompletos{
        if(nomeLocal.isEmpty() | logradouro.isEmpty() | piscina.isEmpty()){
            throw new ExceptionDadosIncompletos();
        } else{
            try{
                LocalPA.inserir(nomeLocal, logradouro, piscina);
            } catch(SQLException e){
                System.out.println(e.getMessage());
            } catch(ClassNotFoundException e){
                System.out.println("EXCEPTION CLASSNOTFOUND");
            }
        }
    }
}
