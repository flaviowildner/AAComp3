package dados;


import java.sql.*;

public class Banco {
    static private String driver = "org.h2.Driver";
    static private String user = "sa";
    static private String password = "";
    static private String url = "jdbc:h2:~/test";
    static private Connection conn = null;

    public static ResultSet executeReturn(String sql) throws ClassNotFoundException, SQLException{
        Class.forName(driver);
        conn = DriverManager.getConnection(url, user, password);
        PreparedStatement stmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet res = stmt.executeQuery();
        return res;
    }
    public static void execute(String sql) throws ClassNotFoundException, SQLException{
        Class.forName(driver);
        conn = DriverManager.getConnection(url, user, password);
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.execute();
    }
}
