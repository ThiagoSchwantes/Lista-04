package br.edu.up.models;
import java.time.LocalDateTime;

public class Passagem {
    private Aeronave aeronave;
    private Integer numeroAcento;
    private String classeAcento;
    private String dataDoVoo;
    

    public Passagem(Aeronave aeronave, Integer numeroAcento, String classeAcento, String dataDoVoo) {
        this.aeronave = aeronave;
        this.numeroAcento = numeroAcento;
        this.classeAcento = classeAcento;
        this.dataDoVoo = dataDoVoo;
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
    public String getDataDoVoo() {
        return dataDoVoo;
    }
    public void setDataDoVoo(String dataDoVoo) {
        this.dataDoVoo = dataDoVoo;
    }

    public Aeronave getAeronave() {
        return aeronave;
    }

    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
    }

    
}
