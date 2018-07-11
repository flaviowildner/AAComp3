package testes;

import dominio.AssociacaoMT;
import exceptions.ExceptionDadosIncompletos;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static dominio.AssociacaoMT.*;
import static org.junit.jupiter.api.Assertions.*;

public class AssociacaoTeste {
    @Test
    public void testeCadastrarAssociacaoNull() throws ExceptionDadosIncompletos, SQLException, ClassNotFoundException {
        boolean sucesso = true;
        cadastrarAssociacao("teste", "teste", "teste", "", "", "", "teste");
        assertFalse(sucesso);
    }
    //EXCEPTION CLASSNOTFOUND
    @Test
    public void testeCadastrarAssociacao() throws ExceptionDadosIncompletos, SQLException, ClassNotFoundException {
        boolean sucesso = false;
        cadastrarAssociacao("teste", "teste", "teste", "teste", "teste", "teste", "teste");
        assertTrue(sucesso);
    }
    @Test
    public void testeListarAsssociacaoOrdenado() throws SQLException {
        ResultSet sucesso = AssociacaoMT.listarAssociacao();
        assertNull(sucesso);

    }
    @Test
    public void testeAlterAssociacaoDados() throws ClassNotFoundException, SQLException, ExceptionDadosIncompletos {
        boolean sucesso = true;
        alterarAssociacaoDados("teste","teste", "teste", "", "", "", "teste","362019432");
        assertFalse(sucesso);
    }
}
