package br.edu.up.models;
import java.util.UUID;

public class Passagem {
    private UUID idProtocolo = UUID.randomUUID();
    private Acento acento;
    private String dataDoVoo;

    public Passagem(Integer numeroAcento, String classeAcento, String dataDoVoo) {
        this.acento = new Acento(numeroAcento, classeAcento);
        this.dataDoVoo = dataDoVoo;
    }

    public Integer getNumeroAcento() {
        return acento.getNumeroAcento();
    }
    public void setNumeroAcento(Integer numeroAcento) {
        this.acento.setNumeroAcento(numeroAcento);
    }
    public String getClasseAcento() {
        return acento.getClasseAcento();
    }
    public void setClasseAcento(String classeAcento) {
        this.acento.setClasseAcento(classeAcento);
    }
    public String getDataDoVoo() {
        return dataDoVoo;
    }
    public void setDataDoVoo(String dataDoVoo) {
        this.dataDoVoo = dataDoVoo;
    }
    public UUID getIdProtocolo(){
        return idProtocolo;
    }

    @Override
    public String toString() {
        return "Passagem [idProtocolo=" + idProtocolo + ", acento=" + acento + ", dataDoVoo="
                + dataDoVoo + "]";
    }
}
