package Dao;

import Model.RedeSocial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RedeSocialDao {
    private Connection conexao;
    private PreparedStatement comandoSQL = null;

    public void inserir(RedeSocial redeSocial){

    }

    public void alterar(RedeSocial redeSocial){

    }

    public void remover(RedeSocial redeSocial){

    }

    public RedeSocial localizar(RedeSocial redeSocial){

        return redeSocial;

    }

    private void fecharConexao() throws SQLException {
        conexao.close();
        comandoSQL.close();
    }
}
