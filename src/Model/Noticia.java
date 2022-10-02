package Model;

import java.time.LocalDate;
import java.util.UUID;

public class Noticia {

    private final UUID _id;
    private String titulo;
    private LocalDate data;
    private String texto;
    private boolean ligada;

    public Noticia() {
        this._id = UUID.randomUUID();
    }

    public Noticia(String titulo, LocalDate data, String texto, boolean ligada) {
        this._id = UUID.randomUUID();
        this.titulo = titulo;
        this.data = data;
        this.texto = texto;
        this.ligada = ligada;
    }

    public UUID get_id() {
        return _id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isLigada() {
        return ligada;
    }

    public void setLigada(boolean ligada) {
        this.ligada = ligada;
    }
}
