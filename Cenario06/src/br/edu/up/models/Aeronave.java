package br.edu.up.models;

import java.util.ArrayList;
import java.util.List;

public class Aeronave {

    private Integer codigo;
    private String tipoAeronave;
    private Integer quantidadeAssentos;
    private List<Acento> acentosOcupados = new ArrayList<>();
    
    public Integer getCodigo() {
        return codigo;
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public String getTipoAeronave() {
        return tipoAeronave;
    }
    public void setTipoAeronave(String tipoAeronave) {
        this.tipoAeronave = tipoAeronave;
    }
    public Integer getQuantidadeAssentos() {
        return quantidadeAssentos;
    }
    public void setQuantidadeAssentos(Integer quantidadeAssentos) {
        this.quantidadeAssentos = quantidadeAssentos;
    }
    public List<Acento> getAcentosOcupados() {
        return acentosOcupados;
    }
    public void ocuparAcento(Integer numeroAcento, String classeAcento) {
        Acento acento = new Acento(numeroAcento, classeAcento);

        acentosOcupados.add(acento);
    }
    public void desocuparAcento(Integer numeroAcento, String classeAcento) {
        Acento acento = new Acento(numeroAcento, classeAcento);

        acentosOcupados.remove(acento);
    }

    @Override
    public String toString() {
        return "Aeronave [codigo=" + codigo + ", tipoAeronave=" + tipoAeronave + ", quantidadeAssentos="
                + quantidadeAssentos + "]";
    }
   
}
