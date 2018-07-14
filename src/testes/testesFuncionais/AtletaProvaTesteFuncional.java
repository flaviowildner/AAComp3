package testes.testesFuncionais;

import dados.AtletaProvaPA;
import dominio.AtletaProvaMT;
import exceptions.DadoNaoExisteException;
import exceptions.ExceptionDadosIncompletos;
import exceptions.TempoInvalidoException;
import org.junit.jupiter.api.Test;
import testes.Mocks.MockAtleta;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AtletaProvaTesteFuncional {
    private static AtletaProvaPA GatewayAtletaProva= new AtletaProvaPA();
    @Test
    public void testePontuarAtleta() throws SQLException, ClassNotFoundException, TempoInvalidoException {
        boolean sucesso = false;
        try {
            AtletaProvaMT.pontuarAtleta("testeProva", "teste", "1");
        } catch (ExceptionDadosIncompletos exceptionDadosIncompletos) {
            sucesso = false;
        }catch(DadoNaoExisteException DadoNaoExisteException){
            sucesso = false;
        }
        ResultSet res = null;
        try {
            res = AtletaProvaMT.getAtletasProva("testeProva");
        } catch (DadoNaoExisteException e) {
            sucesso = false;
        }
        while (res.next()) {
            if (res.getString("matricula").equals("teste")) {
                sucesso = true;
                break;
            }
        }
        assertTrue(sucesso);
    }
}
