package br.edu.up.models;

import java.time.LocalDateTime;

public class Evento {
    private String id;
    private String nome;
    private LocalDateTime data;
    private String local;
    private int lotacaoMaxima;
    private int quantIgressosVendidos;
    private double precoIngresso;

    public Evento(String id){
        this.id = id;
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
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Evento [nome=" + nome + ", data=" + data + ", local=" + local + ", lotacaoMaxima=" + lotacaoMaxima
                + ", quantIgressosVendidos=" + quantIgressosVendidos + ", precoIngresso=" + precoIngresso + "]";
    }
}
