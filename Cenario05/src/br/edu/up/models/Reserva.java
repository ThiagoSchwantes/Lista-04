package br.edu.up.models;

import java.util.UUID;

public class Reserva {
    private UUID id;
    private Evento evento;
    private String nomeResponsavel;
    private int quantPessoas;
    private double valorTotal;

    public Reserva(){
        id = UUID.randomUUID();
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

    public UUID getId() {
        return id;
    }
}
