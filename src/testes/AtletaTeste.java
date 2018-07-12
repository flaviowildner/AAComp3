package testes;

import exceptions.ExceptionDadosIncompletos;
import exceptions.MatriculaInvalidaException;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static dominio.AtletaMT.cadastrarAtleta;
import static dominio.AtletaMT.listarAtletas;
import static dominio.AtletaMT.transferirAtleta;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AtletaTeste {
    //EXPECTED DADOSINCOMPLETOS
    @Test
    public void testeCadastrarAtletasNull() throws ClassNotFoundException, SQLException, ExceptionDadosIncompletos, MatriculaInvalidaException {
        boolean sucesso = true;
        cadastrarAtleta("teste", "teste", "teste", "", "", "", "teste");
        ResultSet res = listarAtletas();
        while(res.next()){
            if(res.getString("nome") == "teste") sucesso = false;
            break;
        }
        assertFalse(sucesso);
    }
    //EXPECTED DADOSINCOMPLETOS
    @Test
    public void testeTransferirAtleta() throws ClassNotFoundException, SQLException, ExceptionDadosIncompletos, MatriculaInvalidaException {
        boolean sucesso = true;
        transferirAtleta("teste", "teste", "teste","","teste","teste");
        ResultSet res = listarAtletas();
        while(res.next()){
            if(res.getString("matricula_associacao") == "teste") sucesso = false;
            break;
        }
        assertFalse(sucesso);
    }
    //EXPECTED DADOSINCOMPLETOS
    @Test
    public void testeTransferirAtletaMat() throws ClassNotFoundException, SQLException, ExceptionDadosIncompletos, MatriculaInvalidaException {
        boolean sucesso = true;
        transferirAtleta("teste", "teste", "teste","teste","","teste");
        ResultSet res = listarAtletas();
        while(res.next()){
            if(res.getString("matricula_associacao") == "teste") sucesso = false;
            break;
        }
        assertFalse(sucesso);
    }
}
