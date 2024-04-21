package br.edu.up.modelos;

public class Seguro {
    private Integer numeroApolice;
    private String[] segurado;
    private Double valorPago;
    private Double valorCobertura;
    private String inicioVigencia;
    private String finalVigencia;
    
    public Integer getNumeroApolice() {
        return numeroApolice;
    }
    public void setNumeroApolice(Integer numeroApolice) {
        this.numeroApolice = numeroApolice;
    }
    public String[] getSegurado() {
        return segurado;
    }
    public void setSegurado(String[] segurado) {
        this.segurado = segurado;
    }
    public Double getValorPago() {
        return valorPago;
    }
    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }
    public Double getValorCobertura() {
        return valorCobertura;
    }
    public void setValorCobertura(Double valorCobertura) {
        this.valorCobertura = valorCobertura;
    }
    public String getInicioVigencia() {
        return inicioVigencia;
    }
    public void setInicioVigencia(String inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }
    public String getFinalVigencia() {
        return finalVigencia;
    }
    public void setFinalVigencia(String finalVigencia) {
        this.finalVigencia = finalVigencia;
    }

    
    
}
