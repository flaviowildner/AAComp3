package testes.testesUnitarios;

import dominio.AssociacaoMT;
import exceptions.ExceptionDadosIncompletos;
import org.junit.jupiter.api.Test;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class AssociacaoTeste {
    @Test
    public void testeCadastrarAssociacaoNull() throws  SQLException, ClassNotFoundException {
        boolean sucesso = true;
        try {
            AssociacaoMT.cadastrarAssociacao("teste", "teste", "teste", "", "", "", "teste");
            sucesso = true;
        }catch (ExceptionDadosIncompletos exceptionDadosIncompletos) {
            sucesso = false;
        }
        assertFalse(sucesso);
    }
    @Test
    public void testeCadastrarAssociacao() throws SQLException, ClassNotFoundException {
        boolean sucesso = false;
        try {
            AssociacaoMT.cadastrarAssociacao("testeAssociacao", "testeAssociacao", "testeAssociacao", "testeAssociacao", "testeAssociacao", "testeAssociacao", "testeAssociacao");
        }catch (ExceptionDadosIncompletos exceptionDadosIncompletos) {
            sucesso = false;
        }
        ResultSet res = AssociacaoMT.listarAssociacao();
        while(res.next()){
            if(res.getString("nome").equals("testeAssociacao")) {
                sucesso = true;
                break;
            }
        }
        assertTrue(sucesso);
    }
    @Test
    public void testeListarAsssociacaoOrdenado() throws SQLException {
        boolean sucesso = false;
        ResultSet res = AssociacaoMT.listarAssociacao();
        ArrayList<String> nomes = new ArrayList<String>();
        while(res.next()) {
            nomes.add(res.getString("nome"));
        }
        Collections.sort(nomes);
        int i = 0;
        res.beforeFirst();
        while(res.next()){
            if(!res.getString("nome").equals(nomes.get(i))) {
                sucesso = false;
                break;
            }
            i++;
            sucesso = true;
        }
        assertTrue(sucesso);
    }
//    @Test
//    public void testeAlterarAssociacaoDadosNull() throws ClassNotFoundException, SQLException{
//        boolean sucesso = true;
//        try {
//            AssociacaoMT.alterarAssociacaoDados("teste","teste", "teste", "", "", "", "teste","362019432");
//        } catch (ExceptionDadosIncompletos exceptionDadosIncompletos) {
//            sucesso = false;
//        }
//        assertFalse(sucesso);
//    }
//    @Test
//    public void testeAlterarAssociacaoDados() throws ClassNotFoundException, SQLException{
//        boolean sucesso = false;
//        try {
//            AssociacaoMT.alterarAssociacaoDados("testeAssociacaoAlterar","testeAssociacaoAlterar", "testeAssociacaoAlterar", "testeAssociacaoAlterar", "testeAssociacaoAlterar", "testeAssociacaoAlterar", "testeAssociacaoAlterar","362019432");
//        } catch (ExceptionDadosIncompletos exceptionDadosIncompletos) {
//            sucesso = false;
//        }
//        ResultSet res = AssociacaoMT.listarAssociacao();
//        while(res.next()){
//            if(res.getString("nome").equals("testeAssociacaoAlterar")) {
//                sucesso = true;
//                break;
//            }
//        }
//        assertTrue(sucesso);
//    }
}