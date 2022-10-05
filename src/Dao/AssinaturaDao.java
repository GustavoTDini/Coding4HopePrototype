package Dao;

import Model.Assinatura;
import Model.Telefone;
import Model.Usuario;

import java.sql.*;
import java.time.Instant;
import java.util.UUID;

import static Dao.Gerenciador.fecharConexao;
import static Dao.Gerenciador.getDateTesteNull;

public class AssinaturaDao {
    private static Connection conexao;
    private static PreparedStatement comandoSQL = null;

    public void inserir(Assinatura assinatura, UUID id_usuario){
        try {
            conexao = Gerenciador.iniciarConexao();
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO T_C4H_ASSINATURA (ID_ASSINATURA, VL_DOACAO, NR_DIA_DOACAO, DT_INICIO, DT_FIM, T_C4H_USUARIO_ID_USUARIO) VALUES (?,?,?,?,?,?)");
            comandoSQL.setString(1, assinatura.get_id().toString());
            comandoSQL.setFloat(2, assinatura.getValorDoacao());
            comandoSQL.setInt(3, assinatura.getDiaDoacao());
            comandoSQL.setDate(4, Date.valueOf(assinatura.getDataInicio()));
            comandoSQL.setDate(5, null);
            comandoSQL.setString(6, id_usuario.toString());
            comandoSQL.executeUpdate();
            conexao.close();
            comandoSQL.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void alterar(Assinatura assinatura){
        try {
            comandoSQL = conexao.prepareStatement("UPDATE T_C4H_ASSINATURA SET VL_DOACAO = ?, NR_DIA_DOACAO = ?, DT_INICIO = ?, DT_FIM = ? WHERE ID_ASSINATURA = ?");
            comandoSQL.setFloat(1, assinatura.getValorDoacao());
            comandoSQL.setInt(2, assinatura.getDiaDoacao());
            comandoSQL.setDate(3, Date.valueOf(assinatura.getDataInicio()));
            comandoSQL.setDate(4, Date.valueOf(assinatura.getDataTermino()));
            comandoSQL.setString(5,assinatura.get_id().toString());
            comandoSQL.executeUpdate();
            conexao.close();
            comandoSQL.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void remover(UUID id){
        try {
            comandoSQL = conexao.prepareStatement("DELETE FROM T_C4H_ASSINATURA WHERE ID_ASSINATURA = ?");
            comandoSQL.setString(1, id.toString());
            comandoSQL.executeUpdate();
            conexao.close();
            comandoSQL.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Assinatura localizar(UUID id){
        Assinatura assinatura = null;
        try {
            conexao = Gerenciador.iniciarConexao();
            comandoSQL = conexao.prepareStatement("SELECT * FROM T_C4H_ASSINATURA WHERE ID_ASSINATURA = ?");
            comandoSQL.setString(1, id.toString());
            ResultSet resultados = comandoSQL.executeQuery();
            if (resultados.next()){
                assinatura =  new Assinatura();
                assinatura.set_id(UUID.fromString(resultados.getString(1)));
                assinatura.setValorDoacao(resultados.getFloat(2));
                assinatura.setDiaDoacao(resultados.getInt(3));
                assinatura.setDataInicio(getDateTesteNull(resultados,4));
                assinatura.setDataTermino(getDateTesteNull(resultados,5));
            }
            conexao.close();
            comandoSQL.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return assinatura;
    }
}
