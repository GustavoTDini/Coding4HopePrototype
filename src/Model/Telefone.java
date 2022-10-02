package Model;

import java.util.UUID;

public class Telefone {

    private final UUID _id;
    private int ddd;
    private int numeroTelefone;

    public Telefone() {
        this._id = UUID.randomUUID();
    }

    public Telefone(int ddd, int numeroTelefone) {
        this._id = UUID.randomUUID();
        this.ddd = ddd;
        this.numeroTelefone = numeroTelefone;
    }

    public UUID get_id() {
        return _id;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(int numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }
}
