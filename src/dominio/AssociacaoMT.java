package dominio;

import dados.AssociacaoPA;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "AssociacaoMT", urlPatterns = {"/AssociacaoMT"})
public class AssociacaoMT extends HttpServlet {
    public static ResultSet listarAssociacao() {
        AssociacaoPA associacaoPA = new AssociacaoPA();
        try {
            System.out.println("AA");
            ResultSet res = AssociacaoPA.findAll();
            return associacaoPA.findAll();
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarAssociacao.jsp");
        dispatcher.forward(request, response);
    }
}
