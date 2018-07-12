package testes;

import dominio.ProvaMT;
import exceptions.AtletaJaInscritoEmProvaException;
import exceptions.ExceptionDadosIncompletos;
import exceptions.MatriculaInvalidaException;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class ProvaTeste {
    @Test
    public void testeCadastrarProva(){
        boolean sucesso = true;
        try {
            ProvaMT.cadastrarProva("teste", "", "", "");
        } catch (ExceptionDadosIncompletos exceptionDadosIncompletos) {
            sucesso = false;
        }
        assertFalse(sucesso);
    }
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
    @Test void testeInscreverAtletaProvaNull() throws ClassNotFoundException, SQLException, AtletaJaInscritoEmProvaException, MatriculaInvalidaException {
        boolean sucesso = true;
        try {
            ProvaMT.inscreverAtletaProva("682705664","");
        } catch (ExceptionDadosIncompletos exceptionDadosIncompletos) {
            sucesso = false;
        }
        assertFalse(sucesso);
    }
}
