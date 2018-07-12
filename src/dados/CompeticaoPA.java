package dados;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompeticaoPA {
    public static ResultSet buscarTodasCompeticoes() throws SQLException, ClassNotFoundException {
        return Banco.executeReturn("SELECT nome, data FROM competicao ORDER BY nome ASC;");
    }

    public static void inserir(String nome, String data) throws SQLException, ClassNotFoundException {
        Banco.execute("INSERT INTO competicao(nome, data)" +
                " VALUES('" + nome + "', '" + data + "');");
    }

    public static void updateLocal(String nome, String local) throws SQLException, ClassNotFoundException {
        Banco.execute("UPDATE competicao SET nomelocal = '" + local + "' WHERE nome = '" + nome + "';");
    }

    public static void update(String nome, String data, String nome_antigo) throws SQLException, ClassNotFoundException {
        Banco.execute("UPDATE competicao SET nome = '" + nome + "', data = '" + data + "' WHERE nome = '" + nome_antigo + "';");
    }

    public static ResultSet buscarCompeticaoDados(String nome) throws SQLException, ClassNotFoundException{
        return Banco.executeReturn("SELECT nome, data FROM competicao WHERE nome = '" + nome + "';");
    }

}
