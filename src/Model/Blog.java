package Model;

import java.time.LocalDate;
import java.util.UUID;

public class Blog {

    private UUID _id;
    private String titulo;
    private String imagemUrl;
    private String conteudo;
    private boolean mostra;
    private LocalDate dataPublicacao;

    public Blog() {
        this._id = UUID.randomUUID();
    }

    public UUID get_id() {
        return _id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void set_id(UUID _id) {
        this._id = _id;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public boolean isMostra() {
        return mostra;
    }

    public void setMostra(boolean mostra) {
        this.mostra = mostra;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
}
