package dados;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioPA {
    public static void inserir(String matricula, String senha, String nivel_acesso) throws SQLException, ClassNotFoundException {
        Banco.execute("INSERT INTO usuario(matricula, senha, nivel_acesso)" +
                " VALUES('" + matricula + "', '" + senha + "', '" + nivel_acesso + "');");
    }
    public static ResultSet getDadosUsuario(String matricula, String senha) throws SQLException, ClassNotFoundException {
        return Banco.executeReturn("SELECT nivel_acesso FROM usuario WHERE matricula = '" + matricula + "' AND senha = '" + senha + "';");
    }
}
