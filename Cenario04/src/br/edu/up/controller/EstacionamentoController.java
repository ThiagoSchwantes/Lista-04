package br.edu.up.controller;

import br.edu.up.modelos.Carro;

public class EstacionamentoController {
    private Carro carrosEstacionados[] = new Carro[10];

    public Boolean ocuparVaga(Carro carro){
        Boolean estacionou = false;
        
        for (Carro eachCarro : carrosEstacionados) {
            if(eachCarro == null){
                eachCarro = carro;
                eachCarro.setHorarioEntrada();
                estacionou = true;
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
}
