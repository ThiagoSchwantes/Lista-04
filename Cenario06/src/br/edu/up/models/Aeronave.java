package br.edu.up.models;

import java.util.ArrayList;
import java.util.List;

public class Aeronave {

    private Integer codigo;
    private String tipo;
    private Integer quantidadeAssentos;
    private List<Acento> acentosOcupados = new ArrayList<>();
    
    public Integer getCodigo() {
        return codigo;
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public String getAeronave() {
        return tipo;
    }
    public void setAeronave(String tipo) {
        this.tipo = tipo;
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
    
    @Override
    public String toString() {
        return "Aeronave [codigo=" + codigo + ", tipo da Aeronave=" + tipo + ", quantidade de Assentos="
                + quantidadeAssentos + "]";
    }
   
}
