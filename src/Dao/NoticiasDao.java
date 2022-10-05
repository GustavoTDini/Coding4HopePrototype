package Dao;


import Model.Noticia;
import Model.Usuario;
import View.Cadastro;

import java.sql.*;
import java.util.UUID;

public class NoticiasDao {
    private Connection conexao;
    private PreparedStatement comandoSQL = null;

    public void inserir(Noticia noticia, UUID id_usuario){
        try {
            conexao = Gerenciador.iniciarConexao();
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO T_C4H_NOTICIA (ID_NOTICIA, NM_TITULO, DT_PUBLICADO, TX_CONTEUDO, ST_MOSTRA, ST_DESTAQUE, T_C4H_USUARIO_ID_USUARIO) VALUES (?,?,?,?,?,?,?)");
            comandoSQL.setString(1, noticia.get_id().toString());
            comandoSQL.setString(2, noticia.getTitulo());
            comandoSQL.setDate(3, Date.valueOf(noticia.getData()));
            comandoSQL.setString(4, noticia.getTexto());
            comandoSQL.setBoolean(5, true);
            comandoSQL.setBoolean(6, false);
            comandoSQL.setString(7,id_usuario.toString());
            comandoSQL.executeUpdate();
            conexao.close();
            comandoSQL.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void alterar(Noticia noticia){
        try {
            comandoSQL = conexao.prepareStatement("UPDATE T_C4H_NOTICIA SET NM_TITULO = ?, DT_PUBLICADO = ?, TX_CONTEUDO = ?, ST_MOSTRA = ?, ST_DESTAQUE = ? WHERE ID_NOTICIA = ?");
            comandoSQL.setString(1,noticia.getTitulo());
            comandoSQL.setDate(2, Date.valueOf(noticia.getData()));
            comandoSQL.setString(3,noticia.getTexto());
            comandoSQL.setBoolean(4,noticia.isLigada());
            comandoSQL.setBoolean(5,noticia.isDestaque());
            comandoSQL.setString(6,noticia.get_id().toString());
            comandoSQL.executeUpdate();
            conexao.close();
            comandoSQL.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void remover(UUID id){
        try {
            comandoSQL = conexao.prepareStatement("DELETE FROM T_C4H_NOTICIA WHERE ID_NOTICIA = ?");
            comandoSQL.setString(1, id.toString());
            comandoSQL.executeUpdate();
            conexao.close();
            comandoSQL.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Noticia localizar(UUID id){
        Noticia noticia = null;
        try {
            conexao = Gerenciador.iniciarConexao();
            comandoSQL = conexao.prepareStatement("SELECT * FROM T_C4H_NOTICIA WHERE ID_NOTICIA = ?");
            comandoSQL.setString(1, id.toString());
            ResultSet resultados = comandoSQL.executeQuery();
            if (resultados.next()){
                noticia =  new Noticia();
                noticia.set_id(UUID.fromString(resultados.getString(1)));
                noticia.setTitulo(resultados.getString(2));
                noticia.setData(Gerenciador.getDateTesteNull(resultados,3));
                noticia.setTexto(resultados.getString(4));
                noticia.setLigada(resultados.getBoolean(5));
                noticia.setDestaque(resultados.getBoolean(6));
            }
            conexao.close();
            comandoSQL.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return noticia;
    }

}
