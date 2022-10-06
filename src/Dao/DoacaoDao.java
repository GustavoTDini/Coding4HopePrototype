package Dao;

import Model.Doacao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DoacaoDao {
    private static Connection conexao;
    private static PreparedStatement comandoSQL = null;

    public static void inserir(Doacao doacao, UUID id_usuario){
        try {
            conexao = Gerenciador.iniciarConexao();
            comandoSQL = conexao.prepareStatement("INSERT INTO T_C4H_DOACAO (ID_DOACAO, DT_DATA_DOACAO, VL_DOACAO, ID_USUARIO) VALUES (?,?,?,?)");
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

    public static List<Doacao> mostrarTodasDoacoes() {
        List<Doacao> lista = new ArrayList<>();
        try {
            conexao = Gerenciador.iniciarConexao();
            comandoSQL = conexao.prepareStatement("SELECT * FROM T_C4H_DOACAO");
            ResultSet resultados = comandoSQL.executeQuery();
            while (resultados.next()){
                Doacao doacao =  new Doacao();
                doacao.set_id(UUID.fromString(resultados.getString(1)));;
                doacao.setDataDoacao(resultados.getDate(2).toLocalDate());
                doacao.setValorDoacao(resultados.getFloat(3));
                lista.add(doacao);
            }
            conexao.close();
            comandoSQL.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }

    public static void alterar(Doacao doacao){
        try {
            conexao = Gerenciador.iniciarConexao();
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

    public static void remover(UUID id){
        try {
            conexao = Gerenciador.iniciarConexao();
            comandoSQL = conexao.prepareStatement("DELETE FROM T_C4H_DOACAO WHERE ID_DOACAO = ?");
            comandoSQL.setString(1, id.toString());
            comandoSQL.executeUpdate();
            conexao.close();
            comandoSQL.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static Doacao localizar(UUID id){
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
