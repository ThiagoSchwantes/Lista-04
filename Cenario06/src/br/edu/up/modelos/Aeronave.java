package br.edu.up.modelos;

public class Aeronave {

    private Integer codigo;
    private String tipoAeronave;
    private Integer quantidadeAssentos;
    
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
    
    
}
