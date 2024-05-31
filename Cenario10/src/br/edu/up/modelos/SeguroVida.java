package br.edu.up.modelos;

import java.time.LocalDate;

public class SeguroVida extends Seguro{

    private boolean cobreDoenca;
    private boolean cobreAcidente;
    
    public SeguroVida(String apolice, Segurado segurado, Double vlrApolice, LocalDate dtaInicio, LocalDate dtaFim,
            boolean cobreDoenca, boolean cobreAcidente) {
        super(apolice, segurado, vlrApolice, dtaInicio, dtaFim);
        this.cobreDoenca = cobreDoenca;
        this.cobreAcidente = cobreAcidente;
    }
    public boolean isCobreDoenca() {
        return cobreDoenca;
    }
    public void setCobreDoenca(boolean cobreDoenca) {
        this.cobreDoenca = cobreDoenca;
    }
    public boolean isCobreAcidente() {
        return cobreAcidente;
    }
    public void setCobreAcidente(boolean cobreAcidente) {
        this.cobreAcidente = cobreAcidente;
    }
    
    @Override
    public String getDados() {
        return "SeguroVida [cobreDoenca=" + cobreDoenca + ", cobreAcidente=" + cobreAcidente + ", Apolice="
                + getApolice() + ", Segurado=" + getSegurado() + ", VlrApolice=" + getVlrApolice()
                + ", DtaInicio=" + getDtaInicio() + ", DtaFim=" + getDtaFim() + "]";
    }
}