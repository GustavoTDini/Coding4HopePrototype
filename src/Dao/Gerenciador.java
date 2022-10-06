package Dao;


import java.sql.*;
import java.time.LocalDate;

public class Gerenciador {
    public static Connection iniciarConexao(){
        Connection conexao = null;
        String url = "jdbc:oracle:thin:@192.168.0.115:1521:XE";
        String login = "System";
        String senha = "password";
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

    public static LocalDate  getDateTesteNull(ResultSet resultados, int coluna) throws SQLException {
        if (resultados.getDate(coluna) == null){
            return null;
        } else{
            return resultados.getDate(coluna).toLocalDate();
        }
    }

}
