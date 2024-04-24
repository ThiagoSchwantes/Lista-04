package br.edu.up.modelos;

import java.time.LocalDateTime;

public class Carro{
    
    private String modelo;
    private String placa;
    private String cor;
    private LocalDateTime horarioEntrada;
    private LocalDateTime horarioSaida;
    

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
}
