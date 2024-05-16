package br.edu.up.models;

public class Aeronave {

    private Integer codigo;
    private String tipo;
    private Integer quantidadeAssentos;
    
    public Aeronave(String tipo, Integer quantidadeAssentos) {
        this.tipo = tipo;
        this.quantidadeAssentos = quantidadeAssentos;
    }

    public Integer getCodigo() {
        return codigo;
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Integer getQuantidadeAssentos() {
        return quantidadeAssentos;
    }
    public void setQuantidadeAssentos(Integer quantidadeAssentos) {
        this.quantidadeAssentos = quantidadeAssentos;
    }

    @Override
    public String toString() {
        return "[codigo: " + codigo + ", tipo: " + tipo + ", quantidadeAssentos: " + quantidadeAssentos + "]";
    }
}
