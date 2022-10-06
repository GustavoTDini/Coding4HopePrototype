package Dao;

import Model.Blog;
import Model.Noticia;

import java.sql.*;
import java.util.UUID;

public class BlogDao {
    private Connection conexao;
    private PreparedStatement comandoSQL = null;


    public void inserir(Blog blog, UUID id_usuario) {
        try {
            conexao = Gerenciador.iniciarConexao();
            comandoSQL = conexao.prepareStatement("INSERT INTO T_C4H_BLOG_ENTRY (ID_BLOG, NM_TITULO, VL_URL_IMAGEM, TX_CONTEUDO, ST_MOSTRA, DT_PUBLICACAO, ID_USUARIO) VALUES (?,?,?,?,?,?,?)");
            comandoSQL.setString(1, blog.get_id().toString());
            comandoSQL.setString(2, blog.getTitulo());
            comandoSQL.setString(3, blog.getImagemUrl());
            comandoSQL.setString(4, blog.getConteudo());
            comandoSQL.setBoolean(5, true);
            comandoSQL.setDate(6, Date.valueOf(blog.getDataPublicacao()));
            comandoSQL.setString(7, id_usuario.toString());
            comandoSQL.executeUpdate();
            conexao.close();
            comandoSQL.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterar(Blog blog){
        try {
            conexao = Gerenciador.iniciarConexao();
            comandoSQL = conexao.prepareStatement("UPDATE T_C4H_BLOG_ENTRY SET NM_TITULO = ?, VL_URL_IMAGEM = ?, TX_CONTEUDO = ?, ST_MOSTRA = ?, DT_PUBLICACAO = ? WHERE ID_BLOG = ?");
            comandoSQL.setString(1,blog.getTitulo());
            comandoSQL.setString(3,blog.getImagemUrl());
            comandoSQL.setString(3,blog.getConteudo());
            comandoSQL.setBoolean(4,blog.isMostra());
            comandoSQL.setDate(2, Date.valueOf(blog.getDataPublicacao()));
            comandoSQL.executeUpdate();
            conexao.close();
            comandoSQL.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void remover(UUID id){
        try {
            conexao = Gerenciador.iniciarConexao();
            comandoSQL = conexao.prepareStatement("DELETE FROM T_C4H_BLOG_ENTRY WHERE ID_BLOG = ?");
            comandoSQL.setString(1, id.toString());
            comandoSQL.executeUpdate();
            conexao.close();
            comandoSQL.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Blog localizar(UUID id){
        Blog blog = null;
        try {
            conexao = Gerenciador.iniciarConexao();
            comandoSQL = conexao.prepareStatement("SELECT * FROM T_C4H_BLOG_ENTRY WHERE ID_BLOG = ?");
            comandoSQL.setString(1, id.toString());
            ResultSet resultados = comandoSQL.executeQuery();
            if (resultados.next()){
                blog =  new Blog();
                blog.set_id(UUID.fromString(resultados.getString(1)));
                blog.setTitulo(resultados.getString(2));
                blog.setImagemUrl(resultados.getString(3));
                blog.setConteudo(resultados.getString(4));
                blog.setMostra(resultados.getBoolean(5));
                blog.setDataPublicacao(Gerenciador.getDateTesteNull(resultados, 6));
            }
            conexao.close();
            comandoSQL.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return blog;
    }
}
