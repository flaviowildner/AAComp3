package dados;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AssociacaoPA{
    public static void update(String numero_oficio, String data_oficio, String nome, String sigla, String endereco, String telefone, String comprovante_pagamento, String matricula) throws SQLException, ClassNotFoundException {
        Banco.execute("UPDATE associacao SET numero_oficio = '" + numero_oficio + "', data_oficio = '" + data_oficio + "', nome = '" + nome + "', sigla = '" + sigla + "', endereco = '" +
        endereco + "', telefone = '" + telefone + "', comprovante_pagamento = '" + comprovante_pagamento + "' WHERE matricula = '" + matricula + "';");
    }
    public static void inserir(String numero_oficio, String data_oficio, String nome, String sigla, String endereco, String telefone, String comprovante_pagamento, String matricula, String senha) throws SQLException, ClassNotFoundException {
        Banco.execute("INSERT INTO associacao(numero_oficio, data_oficio, nome, sigla, endereco, telefone, comprovante_pagamento, matricula, senha)" +
                            " VALUES('" + numero_oficio + "', '" + data_oficio + "', '" + nome + "', '" + sigla + "', '" + endereco + "', '" + telefone + "', '" + comprovante_pagamento + "', '" + matricula + "', '" + senha + "');");
    }

    public static ResultSet buscarSigla(String matricula) throws SQLException, ClassNotFoundException{
        return Banco.executeReturn("SELECT sigla FROM associacao WHERE matricula = (SELECT matricula_associacao FROM atleta WHERE matricula = '" + matricula + "');");
    }
    public static ResultSet buscarTodasAssociacoes() throws SQLException, ClassNotFoundException {
        return Banco.executeReturn("SELECT matricula, nome FROM associacao ORDER BY nome ASC;");
    }
    public static ResultSet buscarAssociacao(String matricula) throws SQLException, ClassNotFoundException{
        return Banco.executeReturn("SELECT * FROM associacao WHERE matricula = '" + matricula + "';");
    }
    public static ResultSet buscarAssociacaoDados(String matricula) throws SQLException, ClassNotFoundException{
        return Banco.executeReturn("SELECT numero_oficio, data_oficio, nome, sigla, endereco, telefone, comprovante_pagamento, matricula FROM associacao WHERE matricula = '" + matricula + "';");
    }


}