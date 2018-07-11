package dados;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AtletaPA {

    public static ResultSet buscarTodosAtletas() throws SQLException, ClassNotFoundException {
        return Banco.executeReturn("SELECT matricula, nome, matricula_associacao FROM atleta ORDER BY nome ASC;");
    }

    public static ResultSet buscarAtleta(String matricula) throws SQLException, ClassNotFoundException{
        return Banco.executeReturn("SELECT * FROM atleta WHERE matricula = '" + matricula + "';");
    }

    public static ResultSet buscarAtletaDados(String matricula) throws SQLException, ClassNotFoundException{
        return Banco.executeReturn("SELECT nome, matricula, matricula_associacao, numero, data_oficio, comprovante_pagamento, data_entrada  FROM atleta WHERE matricula = '" + matricula + "';");
    }

    public static void inserir(String nome, String numero, String data_entrada, String data_oficio, String data_nascimento, String comprovante, String matricula_associacao, String matricula) throws SQLException, ClassNotFoundException {
        Banco.execute("INSERT INTO atleta(nome, numero, data_entrada, data_oficio, data_nascimento, comprovante_pagamento, matricula_associacao, matricula)" +
                " VALUES('" + nome + "', '" + numero + "', '" + data_entrada + "', '" + data_oficio + "', '" + data_nascimento + "', '" + comprovante+ "', '" + matricula_associacao+ "', '" + matricula + "');");
    }

    public static void transferir(String numero, String data_oficio, String comprovante, String data_entrada, String matricula_associacao, String matricula) throws SQLException, ClassNotFoundException {
        Banco.execute("UPDATE atleta SET numero = '" + numero + "', data_oficio = '" + data_oficio + "', comprovante_pagamento = '" + comprovante + "', data_entrada = '" + data_entrada +
                "', matricula_associacao = '" + matricula_associacao + "' WHERE matricula = '" + matricula + "';");
    }
    public static void update(String nome, String numero, String data_entrada, String data_oficio, String matricula) throws SQLException, ClassNotFoundException {
        Banco.execute("UPDATE atleta SET nome = '" + nome+ "', data_oficio = '" + data_oficio + "', numero = '" + numero + "', data_entrada = '" + data_entrada+
                "' WHERE matricula = '" + matricula + "';");
    }

}
