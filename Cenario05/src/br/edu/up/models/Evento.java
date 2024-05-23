package br.edu.up.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
    
    private int id;
    private String nome;
    private LocalDate data;
    private String local;
    private int lotacaoMaxima;
    private int quantIgressosVendidos = 0;
    private double precoIngresso;

    public Evento(String nome, LocalDate data, String local, int lotacaoMaxima,
            double precoIngresso) {
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.lotacaoMaxima = lotacaoMaxima;
        this.precoIngresso = precoIngresso;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
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
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = data.format(formato);

        return "Evento [id=" + id + ", nome=" + nome + ", data=" + dataFormatada + ", local=" + local + ", lotacaoMaxima="
                + lotacaoMaxima + ", quantIgressosVendidos=" + quantIgressosVendidos + ", precoIngresso="
                + precoIngresso + "]";
    }
}
