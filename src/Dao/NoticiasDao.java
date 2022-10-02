package Dao;


import Model.Noticia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NoticiasDao {
    private Connection conexao;
    private PreparedStatement comandoSQL = null;

    public void inserir(Noticia noticia){

    }

    public void alterar(Noticia noticia){

    }

    public void remover(Noticia noticia){

    }

    public Noticia localizar(Noticia noticia){

        return noticia;

    }

    private void fecharConexao() throws SQLException {
        conexao.close();
        comandoSQL.close();
    }

}
