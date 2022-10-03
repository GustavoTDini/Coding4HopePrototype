package Model;

import java.time.LocalDate;
import java.util.UUID;

public class Assinatura {

    private final UUID _id;
    private float valorDoacao;
    private int diaDoacao;
    private UUID idDoador;

    public Assinatura() {
        _id = UUID.randomUUID();
    }

    public Assinatura(float valorDoacao, int diaDoacao, UUID idDoador) {
        _id = UUID.randomUUID();
        this.valorDoacao = valorDoacao;
        this.diaDoacao = diaDoacao;
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

    public int getDiaDoacao() {
        return diaDoacao;
    }

    public void setDiaDoacao(int diaDoacao) {
        this.diaDoacao = diaDoacao;
    }

    public UUID getIdDoador() {
        return idDoador;
    }

    public void setIdDoador(UUID idDoador) {
        this.idDoador = idDoador;
    }

}
