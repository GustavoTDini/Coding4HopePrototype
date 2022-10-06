package Model;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.UUID;

public class Doacao {

    private UUID _id;
    private float valorDoacao;
    private LocalDate dataDoacao;
    private UUID _id_usuario;

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

    public UUID get_id_usuario() {
        return _id_usuario;
    }

    public void set_id_usuario(UUID _id_usuario) {
        this._id_usuario = _id_usuario;
    }

    @Override
    public String toString() {
        DecimalFormat formatter =
                (DecimalFormat) NumberFormat.getCurrencyInstance(Locale.getDefault());
        String valorFormatado = formatter.format(valorDoacao);
        return "Doado " + valorFormatado + " no Dia " + dataDoacao.toString();
    }
}
