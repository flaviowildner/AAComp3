package dados;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AtletaProvaPA {

    public static ResultSet findAtletaProva(String matricula_atleta, String nome_prova) throws SQLException, ClassNotFoundException {
        return Banco.executeReturn("SELECT * FROM atletaprova WHERE matricula_atleta = '" + matricula_atleta + "' and nome_prova= '" + nome_prova + "';");
    }

    public static void cadastrarAtletaProva(String matricula_atleta, String nome_prova) throws SQLException, ClassNotFoundException {
        Banco.execute("INSERT INTO atletaprova( matricula_atleta, nome_prova) VALUES('"+ matricula_atleta +"', '"+ nome_prova +"');");
    }

    public static ResultSet findAtletasProva(String nome_prova) throws SQLException, ClassNotFoundException {
        return Banco.executeReturn("SELECT a.matricula, a.nome from atleta as a JOIN atletaprova as b on" +
                " b.matricula_atleta = a.matricula WHERE b.nome_prova = '"+ nome_prova +"';");
    }

    public static void inserirTempo(String nome_prova, String matricula_atleta, String tempo) throws SQLException, ClassNotFoundException {
        Banco.execute("UPDATE atletaprova SET  tempo = '" + tempo + "' WHERE nome_prova = '" + nome_prova + "' and matricula_atleta = '" + matricula_atleta + "' ;");
    }

}
