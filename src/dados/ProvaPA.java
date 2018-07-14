package dados;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProvaPA {

    public static ResultSet buscarProvasporCompeticao(String nome_competicao) throws SQLException, ClassNotFoundException {
        return Banco.executeReturn("SELECT nome, categoria, classe FROM prova WHERE nome_competicao = '" + nome_competicao + "';");
    }

    public static ResultSet buscarProva(String nome) throws SQLException, ClassNotFoundException {
        return Banco.executeReturn("SELECT * FROM prova WHERE nome = '" + nome + "';");
    }

    public static void inserir(String nome, String classe, String categoria, String nome_competicao) throws SQLException, ClassNotFoundException {
        Banco.execute("INSERT INTO prova(nome, classe, categoria, nome_competicao)" +
                " VALUES('" + nome + "', '" + classe + "' , '" + categoria + "', '" + nome_competicao + "');");
    }
}
