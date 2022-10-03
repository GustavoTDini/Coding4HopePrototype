package Dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Gerenciador {
    public static Connection iniciarConexao(){
        Connection conexao = null;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String login = "System";
        String senha = "09102011";
        try {
            conexao = DriverManager.getConnection(url, login, senha);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return conexao;
    }

    public static void fecharConexao(Connection conexao, PreparedStatement comandoSQL) throws SQLException {
        conexao.close();
        comandoSQL.close();
    }

}
