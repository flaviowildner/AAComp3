package testes;

import dominio.AtletaMT;
import exceptions.ExceptionDadosIncompletos;
import exceptions.MatriculaInvalidaException;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static dominio.AtletaMT.cadastrarAtleta;
import static dominio.AtletaMT.listarAtletas;
import static dominio.AtletaMT.transferirAtleta;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AtletaTeste {
    //EXPECTED DADOSINCOMPLETOS
    @Test
    public void testeCadastrarAtletasNull() throws ClassNotFoundException, SQLException, MatriculaInvalidaException {
        boolean sucesso = true;
        try {
            AtletaMT.cadastrarAtleta("teste", "teste", "teste", "", "", "", "teste");
        }catch (ExceptionDadosIncompletos exceptionDadosIncompletos){
            sucesso = false;
        }
    }
    //EXPECTED DADOSINCOMPLETOS
    @Test
    public void testeTransferirAtleta() throws ClassNotFoundException, SQLException {
        boolean sucesso = true;
        try {
            AtletaMT.transferirAtleta("teste", "teste", "teste","","teste","teste");
        }catch (ExceptionDadosIncompletos exceptionDadosIncompletos) {
            sucesso = false;
        }catch (MatriculaInvalidaException MatriculaInvalidaException) {
            sucesso = false;
        }

        assertFalse(sucesso);
    }
    //EXPECTED DADOSINCOMPLETOS
    @Test
    public void testeTransferirAtletaMat() throws ClassNotFoundException, SQLException, ExceptionDadosIncompletos {
        boolean sucesso = true;
        try {
            AtletaMT.transferirAtleta("teste", "teste", "teste","teste","","teste");
        } catch (MatriculaInvalidaException e) {
            sucesso = false;
        }
        assertFalse(sucesso);
    }
}
