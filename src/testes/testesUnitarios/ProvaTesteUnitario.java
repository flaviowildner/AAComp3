package testes.testesUnitarios;

import dominio.ProvaMT;
import exceptions.AtletaJaInscritoEmProvaException;
import exceptions.ExceptionDadosIncompletos;
import exceptions.JaExisteException;
import exceptions.MatriculaInvalidaException;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProvaTesteUnitario {
    @Test
    public void testeCadastrarProvaNull() throws ClassNotFoundException, SQLException, JaExisteException {
        boolean sucesso = true;
        try {
            ProvaMT.cadastrarProva("teste", "", "", "");
        } catch (ExceptionDadosIncompletos exceptionDadosIncompletos) {
            sucesso = false;
        }
        assertFalse(sucesso);
    }
    @Test
    public void testeInscreverAtletaProvaMatNull() throws ClassNotFoundException, SQLException, AtletaJaInscritoEmProvaException, ExceptionDadosIncompletos {
        boolean sucesso = true;
        try {
            ProvaMT.inscreverAtletaProva("", "teste");
        } catch (MatriculaInvalidaException e) {
            sucesso = false;
        }
        assertFalse(sucesso);
    }
    @Test
    public void testeInscreverAtletaProvaMatInvalida() throws ClassNotFoundException, SQLException, AtletaJaInscritoEmProvaException, ExceptionDadosIncompletos {
        boolean sucesso = true;
        try {
            ProvaMT.inscreverAtletaProva("matriculaInvalida", "teste");
        } catch (MatriculaInvalidaException e) {
            sucesso = false;
        }
        assertFalse(sucesso);
    }
    @Test
    public void testeInscreverAtletaProvaNull() throws ClassNotFoundException, SQLException, AtletaJaInscritoEmProvaException, MatriculaInvalidaException {
        boolean sucesso = true;
        try {
            ProvaMT.inscreverAtletaProva("682705664", "");
        } catch (ExceptionDadosIncompletos exceptionDadosIncompletos) {
            sucesso = false;
        }
        assertFalse(sucesso);
    }
}
