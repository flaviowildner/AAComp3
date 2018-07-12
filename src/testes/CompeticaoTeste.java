package testes;

import dominio.CompeticaoMT;
import exceptions.ExceptionDadosIncompletos;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class CompeticaoTeste {
    @Test
    public void testeCadastrarCompeticao() throws SQLException, ExceptionDadosIncompletos, ClassNotFoundException {
        boolean sucesso = true;
        CompeticaoMT.cadastrarCompeticao("teste", "");
        ResultSet res = CompeticaoMT.listarCompeticoes();
        while (res.next()) {
            if (res.getString("nome") == "teste") sucesso = false;
            break;
        }
        assertFalse(sucesso);
    }
    @Test
    public void testeUpdateLocal() throws ExceptionDadosIncompletos, SQLException, ClassNotFoundException {
        boolean sucesso = true;
        CompeticaoMT.updateLocal("teste", "");
        ResultSet res = CompeticaoMT.listarCompeticoes();
        while (res.next()) {
            if (res.getString("nome") == "teste") sucesso = false;
            break;
        }
        assertFalse(sucesso);
    }
}
