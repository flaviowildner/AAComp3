package testes;

import dominio.AtletaProvaMT;
import exceptions.ExceptionDadosIncompletos;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AtletaProvaTeste {
    @Test
    public void testePontuarAtletaNull() throws ExceptionDadosIncompletos {
        boolean sucesso = true;
        try {
            AtletaProvaMT.pontuarAtleta("","835066250","");
        } catch (ExceptionDadosIncompletos exceptionDadosIncompletos) {
            sucesso = false;
        }
        assertFalse(sucesso);
    }
    @Test
    public void testePontuarAtleta() throws SQLException {
        boolean sucesso = false;
        try {
            AtletaProvaMT.pontuarAtleta("testeProva", "teste", "00:02.00");
        } catch (ExceptionDadosIncompletos exceptionDadosIncompletos) {
            sucesso = false;
        }
        ResultSet res = AtletaProvaMT.getAtletasProva("testeProva");
        while (res.next()) {
            if (res.getString("matricula").equals("teste")) {
                sucesso = true;
                break;
            }
        }
        assertTrue(sucesso);
    }
}
