package Dao;

import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDao {
    private static Connection conexao;
    private static PreparedStatement comandoSQL = null;

    public void inserir(Usuario usuario){

    }

    public static void mostrarTodosUsuarios() throws SQLException {
        try {
            conexao = Gerenciador.iniciarConexao();
            comandoSQL = conexao.prepareStatement("SELECT * FROM T_C4H_USUARIO");
            System.out.println(comandoSQL);
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            fecharConexao();
        }


    }


    public void alterar(Usuario usuario){

    }

    public void remover(Usuario usuario){

    }

    public Usuario localizar(Usuario usuario){

        return usuario;
    }

    private static void fecharConexao() throws SQLException {
        conexao.close();
        comandoSQL.close();
    }



}
