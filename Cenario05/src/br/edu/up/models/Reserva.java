package br.edu.up.models;

public class Reserva {
    private String id;
    private Evento evento;
    private String nomeResponsavel;
    private int quantPessoas;
    private double valorTotal;

    public Reserva(String id){
        this.id = id;
    }
    
    public String getNomeResponsavel() {
        return nomeResponsavel;
    }
    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }
    public int getQuantPessoas() {
        return quantPessoas;
    }
    public void setQuantPessoas(int quantPessoas) {
        this.quantPessoas = quantPessoas;
    }

    public Evento getEvento() {
        return evento;
    }
    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Reserva [nomeResponsavel=" + nomeResponsavel + ", quantPessoas=" + quantPessoas + "]";
    }
    
}
