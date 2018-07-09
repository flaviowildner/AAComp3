package dados;


import java.sql.*;

public class Banco {
    static private String driver = "org.h2.Driver";
    static private String user = "db";
    static private String password = "q";
    static private String url = "jdbc:h2:~/db";
    static private Connection conn = null;

    public static ResultSet executeQuery(String sql) throws ClassNotFoundException, SQLException{
        Class.forName(driver);
        conn = DriverManager.getConnection(url, user, password);
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet res = stmt.executeQuery();
        return res;
    }
}
