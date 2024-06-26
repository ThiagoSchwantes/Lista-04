package br.edu.up.models;

import java.time.LocalDate;

public class Reserva {
    private Integer idReserva;
    private String nomeResponsavel;
    private int quantPessoas;
    private LocalDate data;
    private double valorTotal;
    private Evento evento;

    public Reserva(String nomeResponsavel, int quantPessoas, LocalDate data, Evento evento, double valorTotalReserva) {
        this.nomeResponsavel = nomeResponsavel;
        this.quantPessoas = quantPessoas;
        this.data = data;
        this.evento = evento;
        this.valorTotal = valorTotalReserva;
    }

    public Reserva(){

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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Integer getId() {
        return idReserva;
    }
    
    @Override
    public String toString() {
        return "Reserva [idReserva=" + idReserva + ", nomeResponsavel=" + nomeResponsavel + ", quantPessoas=" + quantPessoas
                + ", data=" + data + ", valorTotal=" + valorTotal + ", evento=" + evento + "]";
    }
}