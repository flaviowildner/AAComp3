package testes;

import dominio.CompeticaoMT;
import exceptions.ExceptionDadosIncompletos;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class CompeticaoTeste {
    @Test
    public void testeCadastrarCompeticao() throws SQLException, ClassNotFoundException {
        boolean sucesso = true;
        try {
            CompeticaoMT.cadastrarCompeticao("teste", "");
        } catch (ExceptionDadosIncompletos exceptionDadosIncompletos) {
            sucesso = false;
        }
        assertFalse(sucesso);
    }
    @Test
    public void testeUpdateLocal() throws SQLException, ClassNotFoundException {
        boolean sucesso = true;
        try {
            CompeticaoMT.updateLocal("teste", "");
        } catch (ExceptionDadosIncompletos exceptionDadosIncompletos) {
            sucesso = false;
        }
        assertFalse(sucesso);
    }
    @Test
    public void testeAlterarCompeticao() throws SQLException, ClassNotFoundException {
        boolean sucesso = true;
        try {
            CompeticaoMT.alterarCompeticaoDados("","", "teste");
        } catch (ExceptionDadosIncompletos exceptionDadosIncompletos) {
            sucesso = false;
        }
        assertFalse(sucesso);
    }
}
