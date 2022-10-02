package Model;

import java.time.LocalDate;
import java.util.UUID;

public class Doacao {

    private final UUID _id;
    private float valorDoacao;
    private LocalDate dataDoacao;
    private UUID idDoador;

    public Doacao() {
        _id = UUID.randomUUID();
    }

    public Doacao(float valorDoacao, LocalDate dataDoacao, UUID idDoador) {
        this._id = UUID.randomUUID();
        this.valorDoacao = valorDoacao;
        this.dataDoacao = dataDoacao;
        this.idDoador = idDoador;
    }

    public UUID get_id() {
        return _id;
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
