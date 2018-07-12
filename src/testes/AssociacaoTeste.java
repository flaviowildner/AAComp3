package testes;

import dominio.AssociacaoMT;
import exceptions.ExceptionDadosIncompletos;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class AssociacaoTeste {
    //EXPECTED DADOSINCOMPLETOS
    @Test
    public void testeCadastrarAssociacaoNull() throws SQLException, ClassNotFoundException {
        boolean sucesso = false;
        try {
            AssociacaoMT.cadastrarAssociacao("teste", "teste", "teste", "", "", "", "teste");
        } catch (ExceptionDadosIncompletos exceptionDadosIncompletos) {
            sucesso = true;
        }
        ResultSet res = AssociacaoMT.listarAssociacao();
        while(res.next()){
            if(res.getString("nome") == "teste") sucesso = false;
            break;
        }
        assertFalse(sucesso);
    }
    //EXCEPTION CLASSNOTFOUND
    @Test
    public void testeCadastrarAssociacao() throws ExceptionDadosIncompletos, SQLException, ClassNotFoundException {
        boolean sucesso = false;
        AssociacaoMT.cadastrarAssociacao("teste", "teste", "teste", "teste", "teste", "teste", "teste");
        ResultSet res = AssociacaoMT.listarAssociacao();
        while(res.next()){
            System.out.println(res.getString("nome"));
            if(res.getString("nome").equals("teste")){
                sucesso = true;
                break;
            }
        }
        assertTrue(sucesso);
    }

    @Test
    public void testeListarAsssociacaoOrdenado() throws SQLException {
        ResultSet sucesso = AssociacaoMT.listarAssociacao();
        assertNull(sucesso);

    }
    //EXPECTED DADOSINCOMPLETOS
    @Test
    public void testeAlterAssociacaoDados() throws ClassNotFoundException, SQLException, ExceptionDadosIncompletos {
        boolean sucesso = true;
        AssociacaoMT.alterarAssociacaoDados("teste","teste", "teste", "", "", "", "teste","362019432");
        ResultSet res = AssociacaoMT.listarAssociacao();
        while(res.next()){
            if(res.getString("nome") == "teste") sucesso = false;
            break;
        }
        assertFalse(sucesso);
    }
}
