package Dao;

import Model.Logradouro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LogradouroDao {
    private Connection conexao;
    private PreparedStatement comandoSQL = null;

    public void inserir(Logradouro logradouro){

    }

    public void alterar(Logradouro logradouro){

    }

    public void remover(Logradouro logradouro){

    }

    public Logradouro localizar(Logradouro logradouro){

        return logradouro;

    }

    private void fecharConexao() throws SQLException {
        conexao.close();
        comandoSQL.close();
    }
}
