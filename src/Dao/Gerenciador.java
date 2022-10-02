package Dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Gerenciador {
    public static Connection iniciarConexao(){
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.115:1521:XE", "System", "09102011");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return conexao;
    }

}
