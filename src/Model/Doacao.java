package Model;

import java.time.LocalDate;
import java.util.UUID;

public class Doacao {

    private UUID _id;
    private float valorDoacao;
    private LocalDate dataDoacao;
    private UUID idDoador;

    public Doacao() {
        _id = UUID.randomUUID();
    }

    public UUID get_id() {
        return _id;
    }

    public void set_id(UUID _id) {
        this._id = _id;
    }

    public float getValorDoacao() {
        return valorDoacao;
    }

    public void setValorDoacao(float valorDoacao) {
        this.valorDoacao = valorDoacao;
    }

    public LocalDate getDataDoacao() {
        return dataDoacao;
    }

    public void setDataDoacao(LocalDate dataDoacao) {
        this.dataDoacao = dataDoacao;
    }

    public UUID getIdDoador() {
        return idDoador;
    }

    public void setIdDoador(UUID idDoador) {
        this.idDoador = idDoador;
    }
}
