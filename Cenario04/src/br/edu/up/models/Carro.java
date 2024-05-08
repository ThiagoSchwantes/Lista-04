package br.edu.up.models;

import java.time.LocalDateTime;

public class Carro{
    
    private String modelo;
    private String placa;
    private String cor;
    private LocalDateTime horarioEntrada;
    private LocalDateTime horarioSaida;
    private Integer periodos = 1;
    

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    public LocalDateTime getHorarioEntrada(){
        return this.horarioEntrada;
    }

    public void setHorarioEntrada(){
        this.horarioEntrada = LocalDateTime.now();
    }

    public LocalDateTime getHorarioSaida(){
        return this.horarioSaida;
    }

    public void setHorarioSaida(){
        this.horarioSaida = LocalDateTime.now();
    }

    public Integer getPeriodos() {
        return periodos;
    }

    public void setPeriodos(Integer periodos) {
        this.periodos = periodos;
    }

    @Override
    public String toString() {
        return "modelo=" + modelo + ", placa=" + placa + ", cor=" + cor;
    }

    
}
