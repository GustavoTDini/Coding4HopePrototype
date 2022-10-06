package Model;

import java.time.LocalDate;
import java.util.UUID;

public class Assinatura {

    private UUID _id;
    private float valorDoacao;
    private int diaDoacao;
    private LocalDate dataInicio;
    private LocalDate dataTermino;

    public Assinatura() {
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

    public int getDiaDoacao() {
        return diaDoacao;
    }

    public void setDiaDoacao(int diaDoacao) {
        this.diaDoacao = diaDoacao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }
}
