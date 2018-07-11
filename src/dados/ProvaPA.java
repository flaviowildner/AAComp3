package dados;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProvaPA {

    public static ResultSet buscarProvasporCompeticao(String nome_competicao) throws SQLException, ClassNotFoundException {
        return Banco.executeReturn("SELECT nome, categoria, classe FROM prova WHERE nome_competicao = '" + nome_competicao + "';");
    }



}
