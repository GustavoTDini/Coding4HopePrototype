package Dao;

import Model.Usuario;
import View.CadastroView;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UsuarioDao {
    private static Connection conexao;
    private static PreparedStatement comandoSQL = null;


    public static void inserir(Usuario usuario, String tipo) {
        try {
            conexao = Gerenciador.iniciarConexao();
            comandoSQL = conexao.prepareStatement("INSERT INTO T_C4H_USUARIO (ID_USUARIO, NM_LOGIN, NM_EMAIL, VL_SENHA, ST_ADMIN, ST_DOADOR, NM_RAZAO_SOCIAL, NM_NOME, VL_CPF, VL_CNPJ, DT_NASCIMENTO, VL_URL) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            comandoSQL.setString(1, usuario.get_id().toString());
            comandoSQL.setString(2, usuario.getLogin());
            comandoSQL.setString(3, usuario.getEmail());
            comandoSQL.setString(4, usuario.getSenha());
            comandoSQL.setBoolean(5, false);
            comandoSQL.setBoolean(6, false);
            if(tipo.equals(CadastroView.PF)){
                comandoSQL.setString(7, null);
                comandoSQL.setString(8, usuario.getNome());
                comandoSQL.setString(9, usuario.getCpf());
                comandoSQL.setString(10, null);
            } else if (tipo.equals(CadastroView.PJ)) {
                comandoSQL.setString(7,usuario.getNomeEmpresa());
                comandoSQL.setString(8, null);
                comandoSQL.setString(9, null);
                comandoSQL.setString(10, usuario.getCnpj());
            }
            comandoSQL.setDate(11,null);
            comandoSQL.setString(12, null);
            comandoSQL.executeUpdate();
            conexao.close();
            comandoSQL.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static List<Usuario> mostrarTodosUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        try {
            conexao = Gerenciador.iniciarConexao();
            comandoSQL = conexao.prepareStatement("SELECT * FROM T_C4H_USUARIO");
            ResultSet resultados = comandoSQL.executeQuery();
            if (resultados.next()){
                Usuario usuario =  new Usuario();
                usuario.set_id(UUID.fromString(resultados.getString(1)));
                usuario.setLogin(resultados.getString(2));
                usuario.setEmail(resultados.getString(3));
                usuario.setSenha("");
                usuario.setAdmin(resultados.getBoolean(5));
                usuario.setDoador(resultados.getBoolean(6));
                usuario.setNomeEmpresa(resultados.getString(7));
                usuario.setNome(resultados.getString(8));
                usuario.setCpf(resultados.getString(9));
                usuario.setCnpj(resultados.getString(10));
                usuario.setDataNascimento(resultados.getDate(11).toLocalDate());
                usuario.setUrl(resultados.getString(12));
                lista.add(usuario);
            }
            conexao.close();
            comandoSQL.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }


    public static void alterar(Usuario usuario) {
        try {
            conexao = Gerenciador.iniciarConexao();
            comandoSQL = conexao.prepareStatement("UPDATE T_C4H_USUARIO SET NM_LOGIN = ?, NM_EMAIL = ?, ST_ADMIN = ?, ST_DOADOR = ?, NM_RAZAO_SOCIAL = ?, NM_NOME = ?, VL_CPF = ?, VL_CNPJ = ?, DT_NASCIMENTO = ?, VL_URL = ? WHERE ID_USUARIO = ?");
            comandoSQL.setString(1,usuario.getLogin());
            comandoSQL.setString(2,usuario.getEmail());
            comandoSQL.setBoolean(3,usuario.isAdmin());
            comandoSQL.setBoolean(4,usuario.isDoador());
            comandoSQL.setString(5,usuario.getNomeEmpresa());
            comandoSQL.setString(6,usuario.getNome());
            comandoSQL.setString(7,usuario.getCpf());
            comandoSQL.setString(8,usuario.getCnpj());
            if (usuario.getDataNascimento() != null){
                comandoSQL.setDate(9, Date.valueOf(usuario.getDataNascimento()));
            } else{
                comandoSQL.setDate(9, null);
            }
            comandoSQL.setString(10,usuario.getUrl());
            comandoSQL.setString(11,usuario.get_id().toString());
            comandoSQL.executeUpdate();
            conexao.close();
            comandoSQL.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void remover(UUID id) {
        try {
            conexao = Gerenciador.iniciarConexao();
            comandoSQL = conexao.prepareStatement("DELETE FROM T_C4H_USUARIO WHERE ID_USUARIO = ?");
            comandoSQL.setString(1, id.toString());
            comandoSQL.executeUpdate();
            conexao.close();
            comandoSQL.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static Usuario localizar(UUID id) {
        Usuario usuario = null;
        try {
            conexao = Gerenciador.iniciarConexao();
            comandoSQL = conexao.prepareStatement("select * from T_C4H_USUARIO WHERE ID_USUARIO = ?");
            comandoSQL.setString(1, String.valueOf(id));
            ResultSet resultados = comandoSQL.executeQuery();
            if (resultados.next()){
                usuario =  new Usuario();
                usuario.set_id(UUID.fromString(resultados.getString(1)));
                usuario.setLogin(resultados.getString(2));
                usuario.setEmail(resultados.getString(3));
                usuario.setSenha("");
                usuario.setAdmin(resultados.getBoolean(5));
                usuario.setDoador(resultados.getBoolean(6));
                usuario.setNomeEmpresa(resultados.getString(7));
                usuario.setNome(resultados.getString(8));
                usuario.setCpf(resultados.getString(9));
                usuario.setCnpj(resultados.getString(10));
                usuario.setDataNascimento(Gerenciador.getDateTesteNull(resultados, 11));
                usuario.setUrl(resultados.getString(12));
            }
            conexao.close();
            comandoSQL.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return usuario;
    }

    public static UUID localizarUsuario(String login, String senha) {
        UUID uuid = null;
        try {
            conexao = Gerenciador.iniciarConexao();
            comandoSQL = conexao.prepareStatement("SELECT * FROM T_C4H_USUARIO WHERE NM_LOGIN = ?");
            comandoSQL.setString(1, login);
            ResultSet resultados = comandoSQL.executeQuery();
            if (resultados.next()){
                if (senha.equals(resultados.getString(4)) && login.equals(resultados.getString(2))){
                    uuid = UUID.fromString(resultados.getString(1).trim());
                }
            }
            conexao.close();
            comandoSQL.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return uuid;
    }
}