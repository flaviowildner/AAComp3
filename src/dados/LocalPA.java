package dados;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocalPA {
    public static void inserir(String nomeLocal, String logradouro, String piscina) throws SQLException, ClassNotFoundException {
        Banco.execute("INSERT INTO local(nomeLocal, logradouro, piscina)" +
                " VALUES('" + nomeLocal + "', '" + logradouro + "', '" + piscina + "');");
    }

    public static ResultSet buscarTodosLocais() throws SQLException, ClassNotFoundException {
        return Banco.executeReturn("SELECT nomeLocal, logradouro, piscina FROM local ORDER BY nomeLocal ASC;");
    }
}