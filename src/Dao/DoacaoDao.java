package Dao;

import Model.Doacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DoacaoDao {
    private Connection conexao;
    private PreparedStatement comandoSQL = null;

    public void inserir(Doacao doacao){

    }

    public void alterar(Doacao doacao){

    }

    public void remover(Doacao doacao){

    }

    public Doacao localizar(Doacao doacao){

        return doacao;

    }

    private void fecharConexao() throws SQLException {
        conexao.close();
        comandoSQL.close();
    }
}
