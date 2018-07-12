package testes;

import dominio.LocalMT;
import exceptions.ExceptionDadosIncompletos;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class LocalTeste {
    @Test
    public void testeCadastrarLocal() throws SQLException, ClassNotFoundException {
        boolean sucesso = true;
        try {
            LocalMT.cadastrarLocal("teste2", "", "");
        }catch (ExceptionDadosIncompletos exceptionDadosIncompletos) {
            sucesso = false;
        }
        assertFalse(sucesso);
    }
}
