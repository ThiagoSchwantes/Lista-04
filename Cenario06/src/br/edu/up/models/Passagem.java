package br.edu.up.models;
import java.time.LocalDateTime;

public class Passagem {
    
    private Integer numeroAcento;
    private String classeAcento;
    private LocalDateTime dataDoVoo;

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
    public LocalDateTime getDataDoVoo() {
        return dataDoVoo;
    }
    public void setDataDoVoo(LocalDateTime dataDoVoo) {
        this.dataDoVoo = dataDoVoo;
    }

    
}
