package br.edu.up.modelos;
import java.time.LocalDate;

public abstract class Seguro {
    private String apolice;
    private Segurado segurado;
    private Double vlrApolice;
    private LocalDate dtaInicio;
    private LocalDate dtaFim;

    public Seguro(String apolice, Segurado segurado, Double vlrApolice, LocalDate dtaInicio, LocalDate dtaFim) {
        this.apolice = apolice;
        this.segurado = segurado;
        this.vlrApolice = vlrApolice;
        this.dtaInicio = dtaInicio;
        this.dtaFim = dtaFim;
    }

    public String getApolice() {
        return apolice;
    }
    public void setApolice(String apolice) {
        this.apolice = apolice;
    }
    public Segurado getSegurado() {
        return segurado;
    }
    public void setSegurado(Segurado segurado) {
        this.segurado = segurado;
    }
    public Double getVlrApolice() {
        return vlrApolice;
    }
    public void setVlrApolice(Double vlrApolice) {
        this.vlrApolice = vlrApolice;
    }
    public LocalDate getDtaInicio() {
        return dtaInicio;
    }
    public void setDtaInicio(LocalDate dtaInicio) {
        this.dtaInicio = dtaInicio;
    }
    public LocalDate getDtaFim() {
        return dtaFim;
    }
    public void setDtaFim(LocalDate dtaFim) {
        this.dtaFim = dtaFim;
    }

    @Override
    public String toString() {
        return "Seguro [apolice=" + apolice + ", segurado=" + segurado + ", vlrApolice=" + vlrApolice + ", dtaInicio="
                + dtaInicio + ", dtaFim=" + dtaFim + "]";
    }
    
}
