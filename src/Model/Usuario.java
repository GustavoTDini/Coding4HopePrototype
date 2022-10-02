package Model;

import java.util.UUID;

/**
 * Classe para definir um cadastro básico inicial que incluem o ‘login’, e o endereço eletrônico,
 * e uma senha, além de atribuir um ‘id’ único com o tipo UUID
 * @author Turing
 */
public abstract class Usuario {

    private String login;
    private String senha;
    private String email;
    private final UUID _id;

    public Usuario() {
        this._id = UUID.randomUUID();
    }

    public Usuario(String login, String senha, String email) {
        this._id = UUID.randomUUID();
        this.login = login;
        this.senha = senha;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UUID get_id() {
        return _id;
    }

}