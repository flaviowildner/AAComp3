package dominio;

import dados.LocalPA;
import exceptions.DadoNaoExisteException;
import exceptions.ExceptionDadosIncompletos;
import exceptions.JaExisteException;

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

    public static void setNewLocalData(String nomelocal, String logradouro, String piscina) throws ExceptionDadosIncompletos, SQLException, ClassNotFoundException{
        if(logradouro.isEmpty() | piscina.isEmpty()){
            throw new ExceptionDadosIncompletos();
        } else{
            LocalPA.update(nomelocal, logradouro, piscina);
        }
    }

    public static ResultSet getDadosLocal(String nomeLocal) throws DadoNaoExisteException, SQLException, ClassNotFoundException {
        if(LocalPA.buscarLocal(nomeLocal).next() == false){
            throw new DadoNaoExisteException();
        }
        return LocalPA.buscarLocal(nomeLocal);
    }

    public static void cadastrarLocal(String nomeLocal, String logradouro, String piscina) throws SQLException, ClassNotFoundException, ExceptionDadosIncompletos, JaExisteException {
        if(LocalPA.buscarLocal(nomeLocal).next() == true){
            throw new JaExisteException();
        } else if(nomeLocal.isEmpty() | logradouro.isEmpty() | piscina == null){
            throw new ExceptionDadosIncompletos();
        } else{
            LocalPA.inserir(nomeLocal, logradouro, piscina);
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
                } catch (JaExisteException e) {
                    request.setAttribute("dado", "Nome de local");
                    request.getRequestDispatcher("/ExcecaoJaExiste.jsp").forward(request, response);
                }
                request.getRequestDispatcher("/PaginaInicial.jsp").forward(request, response);
                break;
            case 2:
                ResultSet res = null;
                try {
                    res = this.getDadosLocal(request.getParameter("local"));
                } catch (DadoNaoExisteException e) {
                    request.setAttribute("dado", "Local informado");
                    request.getRequestDispatcher("/ExcecaoDadoNaoExiste.jsp").forward(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                request.setAttribute("local", res);
                request.getRequestDispatcher("/MudarLocal.jsp").forward(request, response);
                break;
            case 3:
                try{
                    this.setNewLocalData(request.getParameter("nomelocal"),
                                        request.getParameter("logradouro"),
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
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
