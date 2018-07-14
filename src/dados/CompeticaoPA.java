package dados;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompeticaoPA extends Banco{
    public ResultSet buscarTodasCompeticoes() throws SQLException, ClassNotFoundException {
        return super.executeReturn("SELECT nome, data FROM competicao ORDER BY nome ASC;");
    }

    public void inserir(String nome, String data) throws SQLException, ClassNotFoundException {
        super.execute("INSERT INTO competicao(nome, data)" +
                " VALUES('" + nome + "', '" + data + "');");
    }

    public void updateLocal(String nome, String local) throws SQLException, ClassNotFoundException {
        super.execute("UPDATE competicao SET nomelocal = '" + local + "' WHERE nome = '" + nome + "';");
    }

    public void update(String nome, String data, String nome_antigo) throws SQLException, ClassNotFoundException {
        super.execute("UPDATE competicao SET nome = '" + nome + "', data = '" + data + "' WHERE nome = '" + nome_antigo + "';");
    }

    public ResultSet buscarCompeticaoDados(String nome) throws SQLException, ClassNotFoundException{
        return super.executeReturn("SELECT nome, data FROM competicao WHERE nome = '" + nome + "';");
    }
    public ResultSet buscarCompeticaoLocal(String nome) throws SQLException, ClassNotFoundException{
        return super.executeReturn("SELECT nome, nomelocal FROM competicao WHERE nome = '" + nome + "';");
    }
}
