package testes.testesUnitarios;

import dominio.LocalMT;
import exceptions.ExceptionDadosIncompletos;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocalTeste {
    @Test
    public void testeCadastrarLocalNull() throws SQLException, ClassNotFoundException {
        boolean sucesso = true;
        try {
            LocalMT.cadastrarLocal("teste2", "", "");
        }catch (ExceptionDadosIncompletos exceptionDadosIncompletos) {
            sucesso = false;
        }
        assertFalse(sucesso);
    }
    @Test
    public void testeCadastrarLocal() throws SQLException, ClassNotFoundException {
        boolean sucesso = false;
        try {
            LocalMT.cadastrarLocal("testeLocal", "testeLocal", "50");
        }catch (ExceptionDadosIncompletos exceptionDadosIncompletos) {
            sucesso = false;
        }
        ResultSet res = LocalMT.listarLocais();
        while(res.next()){
            if(res.getString("nomeLocal").equals("testeLocal")) {
                sucesso = true;
                break;
            }
        }
        assertTrue(sucesso);
    }
    @Test
    public void testeSetNewLocalDataNull() throws SQLException, ClassNotFoundException {
        boolean sucesso = true;
        try {
            LocalMT.setNewLocalData("","","");
        } catch (ExceptionDadosIncompletos exceptionDadosIncompletos) {
            sucesso = false;
        }
        assertFalse(sucesso);
    }
    @Test
    public void testeSetNewLocalData() throws SQLException, ClassNotFoundException {
        boolean sucesso = false;
        try {
            LocalMT.setNewLocalData("testeLocal", "SetNewLocalData", "50");
        }catch (ExceptionDadosIncompletos exceptionDadosIncompletos) {
            sucesso = false;
        }
        ResultSet res = LocalMT.listarLocais();
        while(res.next()){
            if(res.getString("logradouro").equals("SetNewLocalData")) {
                sucesso = true;
                break;
            }
        }
        assertTrue(sucesso);
    }
}
