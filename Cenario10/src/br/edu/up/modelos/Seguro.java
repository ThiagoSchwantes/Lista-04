package br.edu.up.modelos;

import java.time.LocalDate;

public abstract class Seguro {
    private String apolice;
    private Segurado segurado;
    private Double vlrApolice;
    private LocalDate dtaInicio;
    private LocalDate dtaFim;


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

    //ficou faltando o getDados():String
}
