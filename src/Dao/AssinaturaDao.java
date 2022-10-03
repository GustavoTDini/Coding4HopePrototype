package Dao;

import Model.Assinatura;
import Model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static Dao.Gerenciador.fecharConexao;

public class AssinaturaDao {
    private static Connection conexao;
    private static PreparedStatement comandoSQL = null;

    public void inserir(Assinatura assinatura){

    }


    public void alterar(Assinatura assinatura){

    }

    public void remover(Assinatura assinatura){

    }

    public Assinatura localizar(Assinatura assinatura){

        return assinatura;
    }
}
