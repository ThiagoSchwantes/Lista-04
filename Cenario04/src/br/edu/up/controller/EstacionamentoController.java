package br.edu.up.controller;

import java.time.LocalTime;

import br.edu.up.models.Carro;

public class EstacionamentoController {
    private Carro carrosEstacionados[] = new Carro[10];
    private Integer quantCarros = 0;

    private LocalTime periodoManha = LocalTime.of(6, 0);
    private LocalTime periodoTarde = LocalTime.of(12, 0);
    private LocalTime periodoNoite = LocalTime.of(18, 0);
    private LocalTime fechado = LocalTime.of(24, 0);

    public Boolean ocuparVaga(Carro carro){
        Boolean estacionou = false;
        
        for (Carro eachCarro : carrosEstacionados) {
            if(eachCarro == null){
                eachCarro = carro;
                eachCarro.setHorarioEntrada();


                estacionou = true;
                quantCarros++;
                break;
            }
        }

        return estacionou;
    }

    public Boolean desocuparVaga(String placa){
        Boolean desocupou = false;
        
        for (Carro eachCarro : carrosEstacionados) {
            if(eachCarro.getPlaca().equals(placa)){
                eachCarro.setHorarioSaida();
                desocupou = true;
            }
        }

        return desocupou;
    }

    public int getQuantPeriodos(Carro carro){
        if () {
            
        }
    }


}
