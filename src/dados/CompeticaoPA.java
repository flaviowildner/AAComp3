package dados;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompeticaoPA {
    public static ResultSet buscarTodasCompeticoes() throws SQLException, ClassNotFoundException {
        return Banco.executeReturn("SELECT nome, data FROM competicao ORDER BY nome ASC;");
    }
}
