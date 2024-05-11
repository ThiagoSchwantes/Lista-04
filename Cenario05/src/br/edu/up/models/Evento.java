package br.edu.up.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Evento {
    private static List<Evento> listaEventos = new ArrayList<>();
    private UUID id;
    private String nome;
    private LocalDate data;
    private String local;
    private int lotacaoMaxima;
    private int quantIgressosVendidos = 0;
    private double precoIngresso;
    private List<Reserva> reservas;

    public Evento(String nome, LocalDate data, String local, int lotacaoMaxima,
            double precoIngresso) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.lotacaoMaxima = lotacaoMaxima;
        this.precoIngresso = precoIngresso;
    }



    public Evento(){
        id = UUID.randomUUID();
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

    public UUID getId() {
        return id;
    }

    public static List<Evento> getListaEventos() {
        return listaEventos;
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
