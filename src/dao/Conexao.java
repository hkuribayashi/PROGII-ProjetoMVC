package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String url = "jdbc:mysql://10.204.23.52:3306/empresa";
    private static final String user = "root";
    private static final String password = "unifesspa";

    public static Connection obterConexao() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
