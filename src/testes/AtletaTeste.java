package testes;

import dominio.AtletaMT;
import exceptions.ExceptionDadosIncompletos;
import exceptions.MatriculaInvalidaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static dominio.AtletaMT.cadastrarAtleta;
import static dominio.AtletaMT.listarAtletas;
import static dominio.AtletaMT.transferirAtleta;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AtletaTeste {
    @Test
    public void testeCadastrarAtletaNull() throws ClassNotFoundException, SQLException, MatriculaInvalidaException {
        boolean sucesso = true;
        try {
            AtletaMT.cadastrarAtleta("teste", "teste", "teste", "", "", "", "teste");
        }catch (ExceptionDadosIncompletos exceptionDadosIncompletos){
            sucesso = false;
        }
        assertFalse(sucesso);
    }
    @Test
    public void testeCadastrarAtleta() throws SQLException, MatriculaInvalidaException, ClassNotFoundException {
        boolean sucesso = false;
        try {
            AtletaMT.cadastrarAtleta("testeAtleta", "testeAtleta", "testeAtleta", "testeAtleta", "testeAtleta", "testeAtleta", "362019432");
        }catch (ExceptionDadosIncompletos exceptionDadosIncompletos){
            sucesso = false;
        }
        ResultSet res = AtletaMT.listarAtletas();
        while(res.next()){
            if(res.getString("nome").equals("testeAtleta")) {
                sucesso = true;
                break;
            }
        }
        assertTrue(sucesso);
    }
    @Test
    public void testeTransferirAtletaNull() throws ClassNotFoundException, SQLException, MatriculaInvalidaException {
        boolean sucesso = true;
        try {
            AtletaMT.transferirAtleta("teste", "teste", "teste","","320133379","362019432");
        }catch(ExceptionDadosIncompletos exceptionDadosIncompletos) {
            sucesso = false;
        }
        assertFalse(sucesso);
    }
    @Test
    public void testeTransferirAtletaMatNull() throws ClassNotFoundException, SQLException, ExceptionDadosIncompletos {
        boolean sucesso = true;
        try {
            AtletaMT.transferirAtleta("teste", "teste", "teste","teste","320133379","");
        }catch(MatriculaInvalidaException e) {
            sucesso = false;
        }
        assertFalse(sucesso);
    }
//    @Test
//    public void testeTransferirAtleta() throws SQLException, ClassNotFoundException {
//        boolean sucesso = false;
//        try {
//            AtletaMT.transferirAtleta("testeAtletaTransferir", "testeAtletaTransferir", "testeAtletaTransferir","testeAtletaTransferir","320133379","362019432");
//        }catch (ExceptionDadosIncompletos exceptionDadosIncompletos) {
//            sucesso = false;
//        }catch(MatriculaInvalidaException e){
//            sucesso = false;
//        }
//        ResultSet res = AtletaMT.getDadosAtleta("320133379");
//        while(res.next()){
//            if(res.getString("numero").equals("testeAtletaTransferir")) {
//                sucesso = true;
//                break;
//            }
//        }
//        assertTrue(sucesso);
//    }
}
