package br.edu.up.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Evento {
    private UUID id;
    private String nome;
    private LocalDateTime data;
    private String local;
    private int lotacaoMaxima;
    private int quantIgressosVendidos;
    private double precoIngresso;
    private List<Reserva> reservas;

    public Evento(){
        id = UUID.randomUUID();
    }    

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public LocalDateTime getData() {
        return data;
    }
    public void setData(LocalDateTime data) {
        this.data = data;
    }
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }
    public int getLotacaoMaxima() {
        return lotacaoMaxima;
    }
    public void setLotacaoMaxima(int lotacaoMaxima) {
        this.lotacaoMaxima = lotacaoMaxima;
    }
    public int getQuantIgressosVendidos() {
        return quantIgressosVendidos;
    }
    public void setQuantIgressosVendidos(int quantIgressosVendidos) {
        this.quantIgressosVendidos = quantIgressosVendidos;
    }
    public double getPrecoIngresso() {
        return precoIngresso;
    }
    public void setPrecoIngresso(double precoIngresso) {
        this.precoIngresso = precoIngresso;
    }

    public UUID getId() {
        return id;
    }
    
}
