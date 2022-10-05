package Dao;

import Model.Logradouro;
import Model.Telefone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class LogradouroDao {
    private Connection conexao;
    private PreparedStatement comandoSQL = null;

    public void inserir(Logradouro logradouro, UUID id_usuario){
        try {
            conexao = Gerenciador.iniciarConexao();
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO T_C4H_LOGRADOURO (ID_LOGRADOURO, NM_TIPO, NM_LOGRADOURO, NR_LOGRADOURO, NR_CEP, VL_COMPLEMENTO, NM_BAIRRO, NM_CIDADE, NM_ESTADO, T_C4H_USUARIO_ID_USUARIO) VALUES (?,?,?,?,?,?,?,?,?,?)");
            comandoSQL.setString(1, logradouro.get_id().toString());
            comandoSQL.setString(2, logradouro.getTipo());
            comandoSQL.setString(3, logradouro.getLogradouro());
            comandoSQL.setInt(4, logradouro.getNumero());
            comandoSQL.setInt(5, logradouro.getCep());
            comandoSQL.setString(6, logradouro.getComplemento());
            comandoSQL.setString(7, logradouro.getBairro());
            comandoSQL.setString(8, logradouro.getCidade());
            comandoSQL.setString(9, logradouro.getEstado());
            comandoSQL.setString(10, id_usuario.toString());
            comandoSQL.executeUpdate();
            conexao.close();
            comandoSQL.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void alterar(Logradouro logradouro){
        try {
            comandoSQL = conexao.prepareStatement("UPDATE T_C4H_LOGRADOURO SET NM_TIPO = ?, NM_LOGRADOURO = ?, NR_LOGRADOURO = ?, NR_CEP = ?, VL_COMPLEMENTO = ?, NM_BAIRRO = ?, NM_CIDADE = ?, NM_ESTADO = ? WHERE ID_LOGRADOURO = ?");
            comandoSQL.setString(1, logradouro.getTipo());
            comandoSQL.setString(2, logradouro.getLogradouro());
            comandoSQL.setInt(3, logradouro.getNumero());
            comandoSQL.setInt(4, logradouro.getCep());
            comandoSQL.setString(5, logradouro.getComplemento());
            comandoSQL.setString(6, logradouro.getBairro());
            comandoSQL.setString(7, logradouro.getCidade());
            comandoSQL.setString(8, logradouro.getEstado());
            comandoSQL.setString(9, logradouro.get_id().toString());
            comandoSQL.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void remover(UUID id){
        try {
            comandoSQL = conexao.prepareStatement("DELETE FROM T_C4H_LOGRADOURO WHERE ID_LOGRADOURO = ?");
            comandoSQL.setString(1, id.toString());
            comandoSQL.executeUpdate();
            conexao.close();
            comandoSQL.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Logradouro localizar(UUID id){
        Logradouro logradouro = null;
        try {
            conexao = Gerenciador.iniciarConexao();
            comandoSQL = conexao.prepareStatement("SELECT * FROM T_C4H_LOGRADOURO WHERE ID_LOGRADOURO = ?");
            comandoSQL.setString(1, id.toString());
            ResultSet resultados = comandoSQL.executeQuery();
            if (resultados.next()){
                logradouro =  new Logradouro();
                logradouro.set_id(UUID.fromString(resultados.getString(1)));
                logradouro.setTipo(resultados.getString(2));
                logradouro.setLogradouro(resultados.getString(3));
                logradouro.setNumero(resultados.getInt(4));
                logradouro.setCep(resultados.getInt(5));
                logradouro.setComplemento(resultados.getString(6));
                logradouro.setBairro(resultados.getString(7));
                logradouro.setCidade(resultados.getString(8));
                logradouro.setEstado(resultados.getString(9));
            }
            conexao.close();
            comandoSQL.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return logradouro;

    }

}
