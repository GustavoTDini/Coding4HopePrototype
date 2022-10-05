package Dao;

import Model.Doacao;
import Model.Noticia;

import java.sql.*;
import java.util.UUID;

public class DoacaoDao {
    private Connection conexao;
    private PreparedStatement comandoSQL = null;

    public void inserir(Doacao doacao, UUID id_usuario){
        try {
            conexao = Gerenciador.iniciarConexao();
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO T_C4H_DOACAO (ID_DOACAO, DT_DATA_DOACAO, VL_DOACAO, T_C4H_USUARIO_ID_USUARIO) VALUES (?,?,?,?)");
            comandoSQL.setString(1, doacao.get_id().toString());
            comandoSQL.setDate(2, Date.valueOf(doacao.getDataDoacao()));
            comandoSQL.setFloat(3, doacao.getValorDoacao());
            comandoSQL.setString(4, id_usuario.toString());
            comandoSQL.executeUpdate();
            conexao.close();
            comandoSQL.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void alterar(Doacao doacao){
        try {
            comandoSQL = conexao.prepareStatement("UPDATE T_C4H_DOACAO SET DT_DATA_DOACAO = ?, VL_DOACAO = ?  WHERE ID_DOACAO = ?");
            comandoSQL.setDate(2, Date.valueOf(doacao.getDataDoacao()));
            comandoSQL.setFloat(3,doacao.getValorDoacao());
            comandoSQL.setString(3,doacao.get_id().toString());
            comandoSQL.executeUpdate();
            conexao.close();
            comandoSQL.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void remover(UUID id){
        try {
            comandoSQL = conexao.prepareStatement("DELETE FROM T_C4H_DOACAO WHERE ID_DOACAO = ?");
            comandoSQL.setString(1, id.toString());
            comandoSQL.executeUpdate();
            conexao.close();
            comandoSQL.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Doacao localizar(UUID id){
        Doacao doacao = null;
        try {
            conexao = Gerenciador.iniciarConexao();
            comandoSQL = conexao.prepareStatement("SELECT * FROM T_C4H_NOTICIA WHERE ID_NOTICIA = ?");
            comandoSQL.setString(1, id.toString());
            ResultSet resultados = comandoSQL.executeQuery();
            if (resultados.next()){
                doacao =  new Doacao();
                doacao.set_id(UUID.fromString(resultados.getString(1)));;
                doacao.setDataDoacao(resultados.getDate(2).toLocalDate());
                doacao.setValorDoacao(resultados.getFloat(3));
            }
            conexao.close();
            comandoSQL.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return doacao;

    }

}
