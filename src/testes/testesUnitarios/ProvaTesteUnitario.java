package testes.testesUnitarios;

import dominio.ProvaMT;
import exceptions.AtletaJaInscritoEmProvaException;
import exceptions.ExceptionDadosIncompletos;
import exceptions.MatriculaInvalidaException;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProvaTesteUnitario {
    @Test
    public void testeCadastrarProvaNull(){
        boolean sucesso = true;
        try {
            ProvaMT.cadastrarProva("teste", "", "", "");
        } catch (ExceptionDadosIncompletos exceptionDadosIncompletos) {
            sucesso = false;
        }
        assertFalse(sucesso);
    }
//    @Test
//    public void testeCadastrarProva() throws SQLException {
//        boolean sucesso = false;
//        try {
//            ProvaMT.cadastrarProva("testeProva", "testeProva", "testeProva", "testeCompeticaoAlterar");
//        } catch (ExceptionDadosIncompletos exceptionDadosIncompletos) {
//            sucesso = false;
//        }
//        ResultSet res = ProvaMT.getProvasCompeticao("testeCompeticaoAlterar");
//        while(res.next()){
//            if(res.getString("nome").equals("testeProva")) {
//                sucesso = true;
//                break;
//            }
//        }
//        assertTrue(sucesso);
//    }
    @Test
    public void testeInscreverAtletaProvaMat() throws ClassNotFoundException, SQLException, AtletaJaInscritoEmProvaException, ExceptionDadosIncompletos {
        boolean sucesso = true;
        try {
            ProvaMT.inscreverAtletaProva("", "teste");
        }catch (MatriculaInvalidaException e){
            sucesso = false;
        }
        assertFalse(sucesso);
    }
    @Test
    public void testeInscreverAtletaProvaNull() throws ClassNotFoundException, SQLException, AtletaJaInscritoEmProvaException, MatriculaInvalidaException {
        boolean sucesso = true;
        try {
            ProvaMT.inscreverAtletaProva("682705664","");
        } catch (ExceptionDadosIncompletos exceptionDadosIncompletos) {
            sucesso = false;
        }
        assertFalse(sucesso);
    }
//    @Test
//    public void testeInscreverAtletaProva() throws ClassNotFoundException, SQLException, AtletaJaInscritoEmProvaException, MatriculaInvalidaException {
//        boolean sucesso = false;
//        try {
//            ProvaMT.inscreverAtletaProva("682705664","testeProva");
//        } catch (ExceptionDadosIncompletos exceptionDadosIncompletos) {
//            sucesso = false;
//        }
//        ResultSet res = ProvaMT.getProvasCompeticao("testeCompeticaoAlterar");
//        while(res.next()){
//            if(res.getString("nome").equals("testeProva")) {
//                sucesso = true;
//                break;
//            }
//        }
//        assertTrue(sucesso);
//    }
}
