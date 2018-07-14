package testes.testesUnitarios;

import org.junit.jupiter.api.Test;
import testes.Mocks.MockAssociacao;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class AssociacaoTesteUnitario {
    @Test
    public void testeCadastrarAssociacaoNull() throws  SQLException, ClassNotFoundException {
        MockAssociacao associacaoTeste = new MockAssociacao();
        associacaoTeste.cadastrarAssociacao("testeAssociacao", "testeAssociacao", "testeAssociacao", "", "", "", "testeAssociacao");
        associacaoTeste.validateFail();
    }
    @Test
    public void testeAlterarAssociacaoDadosNull() throws ClassNotFoundException, SQLException{
        MockAssociacao associacaoTeste = new MockAssociacao();
        associacaoTeste.alterarAssociacaoDados("testeAssociacao", "testeAssociacao", "testeAssociacao", "", "", "", "testeAssociacao", "teste");
        associacaoTeste.validateFail();
    }
    @Test
    public void testeAlterarAssociacaoMatriculaInvalida() throws ClassNotFoundException, SQLException{
        MockAssociacao associacaoTeste = new MockAssociacao();
        associacaoTeste.alterarAssociacaoDados("testeAssociacao", "testeAssociacao", "testeAssociacao", "testeAssociacao", "testeAssociacao", "testeAssociacao", "testeAssociacao", "matriculaInvalida");
        associacaoTeste.validateFail();
    }
}