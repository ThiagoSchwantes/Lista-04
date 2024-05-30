package br.edu.up.models.pessoa;

public class Titulacao {
    private String nomeInstituicao;
    private int anoConclusao;
    private String nomeTitulo;
    private String tituloTrabalhoConclusao;
    
    public Titulacao(String nomeInstituicao, int anoConclusao, String nomeTitulo, String tituloTrabalhoConclusao) {
        this.nomeInstituicao = nomeInstituicao;
        this.anoConclusao = anoConclusao;
        this.nomeTitulo = nomeTitulo;
        this.tituloTrabalhoConclusao = tituloTrabalhoConclusao;
    }
    public String getNomeTitulo() {
        return nomeTitulo;
    }
    public void setNomeTitulo(String nomeTitulo) {
        this.nomeTitulo = nomeTitulo;
    }
    public String getNomeInstituicao() {
        return nomeInstituicao;
    }
    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }
    public int getAnoConclusao() {
        return anoConclusao;
    }
    public void setAnoConclusao(int anoConclusao) {
        this.anoConclusao = anoConclusao;
    }
    public String getTituloTrabalhoConclusao() {
        return tituloTrabalhoConclusao;
    }
    public void setTituloTrabalhoConclusao(String tituloTrabalhoConclusao) {
        this.tituloTrabalhoConclusao = tituloTrabalhoConclusao;
    }
    @Override
    public String toString() {
        return "Titulacao [nomeInstituicao=" + nomeInstituicao + ", anoConclusao=" + anoConclusao + ", nomeTitulo="
                + nomeTitulo + ", tituloTrabalhoConclusao=" + tituloTrabalhoConclusao + "]";
    }
    
}