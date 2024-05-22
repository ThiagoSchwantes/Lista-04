package br.edu.up.modelos;

import java.time.LocalDate;

public class SeguroVeiculo extends Seguro{
    private Double vlrFranquia;
    private boolean temCarroReserva;
    private boolean cobreVidros;

    
    public SeguroVeiculo(String apolice, Segurado segurado, Double vlrApolice, LocalDate dtaInicio, LocalDate dtaFim,
            Double vlrFranquia, boolean temCarroReserva, boolean cobreVidros) {
        super(apolice, segurado, vlrApolice, dtaInicio, dtaFim);
        this.vlrFranquia = vlrFranquia;
        this.temCarroReserva = temCarroReserva;
        this.cobreVidros = cobreVidros;
    }
    
    public Double getVlrFranquia() {
        return vlrFranquia;
    }
    public void setVlrFranquia(Double vlrFranquia) {
        this.vlrFranquia = vlrFranquia;
    }
    public boolean isTemCarroReserva() {
        return temCarroReserva;
    }
    public void setTemCarroReserva(boolean temCarroReserva) {
        this.temCarroReserva = temCarroReserva;
    }
    public boolean isCobreVidros() {
        return cobreVidros;
    }
    public void setCobreVidros(boolean cobreVidros) {
        this.cobreVidros = cobreVidros;
    }

    @Override
    public String toString() {
        return "seguroVeiculo [vlrFranquia=" + vlrFranquia + ", temCarroReserva=" + temCarroReserva + ", cobreVidros="
                + cobreVidros + ", Segurado=" + getSegurado() + ", VlrApolice=" + getVlrApolice()
                + ", DtaInicio=" + getDtaInicio() + ", DtaFim=" + getDtaFim() + "]";
    }
    
    
}
