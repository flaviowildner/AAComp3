package dados;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AssociacaoPA{
    public void update(String nome, String sigla){

    }
    public static void insert(String nome, String sigla, String matricula, String comprovante) throws SQLException, ClassNotFoundException {
        Banco.executeQuery("INSERT INTO associacao(nome, sigla, matricula, senha, comprovante, numeroOficio, endereco, telefone) VALUES(" + nome + ", " + sigla + ", " + matricula + ");");
    }
    public static void delete(int id) throws SQLException, ClassNotFoundException {
        Banco.executeQuery("DELETE FROM associacao WHERE id = '" + id + "';");
    }
    public static ResultSet findAll() throws SQLException, ClassNotFoundException {
        return Banco.executeQuery("SELECT matricula, nome FROM associacao ORDER BY nome ASC;");
    }
}