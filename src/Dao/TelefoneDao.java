package Dao;

import Model.Telefone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TelefoneDao {
    private Connection conexao;
    private PreparedStatement comandoSQL = null;

    public void inserir(Telefone telefone){

    }

    public void alterar(Telefone telefone){

    }

    public void remover(Telefone telefone){

    }

    public Telefone localizar(Telefone telefone){

        return telefone;

    }

    private void fecharConexao() throws SQLException {
        conexao.close();
        comandoSQL.close();
    }
}
