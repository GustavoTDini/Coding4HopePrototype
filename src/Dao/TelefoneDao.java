package Dao;

import Model.Telefone;
import Model.Usuario;
import View.Cadastro;

import java.sql.*;
import java.util.UUID;

import static Dao.Gerenciador.fecharConexao;

public class TelefoneDao {
    private Connection conexao;
    private PreparedStatement comandoSQL = null;

    public void inserir(Telefone telefone, UUID id_usuario){
        try {
            conexao = Gerenciador.iniciarConexao();
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO T_C4H_TELEFONE (ID_TELEFONE, NR_TELEFONE, NR_DDD, T_C4H_USUARIO_ID_USUARIO) VALUES (?,?,?,?)");
            comandoSQL.setString(1, telefone.get_id().toString());
            comandoSQL.setInt(2, telefone.getNumeroTelefone());
            comandoSQL.setInt(3, telefone.getDdd());
            comandoSQL.setString(4, id_usuario.toString());
            comandoSQL.executeUpdate();
            conexao.close();
            comandoSQL.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void alterar(Telefone telefone){
        try {
            comandoSQL = conexao.prepareStatement("UPDATE T_C4H_TELEFONE SET NR_TELEFONE = ?, NR_DDD = ? WHERE ID_TELEFONE = ?");
            comandoSQL.setInt(1,telefone.getNumeroTelefone());
            comandoSQL.setInt(2,telefone.getDdd());
            comandoSQL.setString(3,telefone.get_id().toString());
            comandoSQL.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void remover(UUID id){
        try {
            comandoSQL = conexao.prepareStatement("DELETE FROM T_C4H_TELEFONE WHERE ID_TELEFONE = ?");
            comandoSQL.setString(1, id.toString());
            comandoSQL.executeUpdate();
            conexao.close();
            comandoSQL.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Telefone localizar(UUID id){
        Telefone telefone = null;
        try {
            conexao = Gerenciador.iniciarConexao();
            comandoSQL = conexao.prepareStatement("SELECT * FROM T_C4H_TELEFONE WHERE ID_TELEFONE = ?");
            comandoSQL.setString(1, id.toString());
            ResultSet resultados = comandoSQL.executeQuery();
            if (resultados.next()){
                telefone =  new Telefone();
                telefone.set_id(UUID.fromString(resultados.getString(1)));
                telefone.setNumeroTelefone(resultados.getInt(2));
                telefone.setDdd(resultados.getInt(3));
            }
            conexao.close();
            comandoSQL.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return telefone;
    }
}
