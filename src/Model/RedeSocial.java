package Model;

import java.util.UUID;

public class RedeSocial {

    private final UUID _id;
    private String nomeRedeSocial;
    private String urlRedeSocial;

    public RedeSocial() {
        this._id = UUID.randomUUID();
    }

    public RedeSocial(String nomeRedeSocial, String urlRedeSocial) {
        this._id = UUID.randomUUID();
        this.nomeRedeSocial = nomeRedeSocial;
        this.urlRedeSocial = urlRedeSocial;
    }

    public UUID get_id() {
        return _id;
    }

    public String getNomeRedeSocial() {
        return nomeRedeSocial;
    }

    public void setNomeRedeSocial(String nomeRedeSocial) {
        this.nomeRedeSocial = nomeRedeSocial;
    }

    public String getUrlRedeSocial() {
        return urlRedeSocial;
    }

    public void setUrlRedeSocial(String urlRedeSocial) {
        this.urlRedeSocial = urlRedeSocial;
    }
}

