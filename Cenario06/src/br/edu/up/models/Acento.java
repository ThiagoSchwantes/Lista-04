package br.edu.up.models;

public class Acento {
    private Integer numeroAcento;
    private String classeAcento;

    public Acento(Integer numeroAcento, String classeAcento) {
        this.numeroAcento = numeroAcento;
        this.classeAcento = classeAcento;
    }
    public Integer getNumeroAcento() {
        return numeroAcento;
    }
    public void setNumeroAcento(Integer numeroAcento) {
        this.numeroAcento = numeroAcento;
    }
    public String getClasseAcento() {
        return classeAcento;
    }
    public void setClasseAcento(String classeAcento) {
        this.classeAcento = classeAcento;
    }
    @Override
    public String toString() {
        return "Acento [numeroAcento=" + numeroAcento + ", classeAcento=" + classeAcento + "]";
    }
}
