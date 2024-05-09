package br.edu.up.modelos;

public class seguroVeiculo {
    private Double vlrFranquia;
    private boolean temCarroReserva;
    private boolean cobreVidros;

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
    
     //faltou o getDados():String   
}
