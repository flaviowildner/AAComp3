package testes.testesUnitarios;

import dados.CompeticaoPA;
import dominio.CompeticaoMT;
import exceptions.DadoNaoExisteException;
import exceptions.ExceptionDadosIncompletos;
import exceptions.JaExisteException;
import org.junit.jupiter.api.Test;
import testes.Mocks.MockCompeticao;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class CompeticaoTesteUnitario {
    CompeticaoPA GatewayCompeticao = new CompeticaoPA();
    @Test
    public void testeCadastrarCompeticaoNull() throws SQLException, ClassNotFoundException {
        MockCompeticao competicaoTeste = new MockCompeticao();
        competicaoTeste.cadastrarCompeticao("testeCompeticao", "");
        competicaoTeste.validateFail();
    }
    @Test
    public void testeUpdateLocalNull() throws SQLException, ClassNotFoundException {
        MockCompeticao competicaoTeste = new MockCompeticao();
        competicaoTeste.updateLocal("testeCompeticao", "");
        competicaoTeste.validateFail();
    }

    @Test
    public void testeAlterarCompeticaoDadosNull() throws SQLException, ClassNotFoundException {
        MockCompeticao competicaoTeste = new MockCompeticao();
        competicaoTeste.alterarCompeticaoDados("testeCompeticao", "", "");
        competicaoTeste.validateFail();
    }
    @Test
    public void testeListarCompeticoes() throws SQLException {
        MockCompeticao competicaoTeste = new MockCompeticao();
        competicaoTeste.listarCompeticoes();
        competicaoTeste.validateSuccess();
    }
    @Test
    public void testeGetDadosCompeticao() throws SQLException, ClassNotFoundException {
        MockCompeticao competicaoTeste = new MockCompeticao();
        competicaoTeste.getDadosCompeticao("testeCompeticao");
        competicaoTeste.validateSuccess();
    }
    @Test
    public void testeGetDadosCompeticaoNull() throws SQLException, ClassNotFoundException {
        MockCompeticao competicaoTeste = new MockCompeticao();
        competicaoTeste.getDadosCompeticao("");
        competicaoTeste.validateFail();
    }
}
