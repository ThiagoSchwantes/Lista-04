package br.edu.up.controller;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.up.*;
import br.edu.up.models.Carro;
import br.edu.up.utils.Prompt;

public class EstacionamentoController {
    private List<Carro> carrosEstacionados = new ArrayList<Carro>();
    private Integer quantCarrosEntrou = 0;
    private Integer quantCarrosSaiu = 0;
    private double valorTotalPagoPorPeriodo = 0.0;

    private LocalTime periodoManha = LocalTime.of(6, 0);
    private LocalTime periodoTarde = LocalTime.of(12, 0);
    private LocalTime periodoNoite = LocalTime.of(18, 0);
    private LocalTime fechado = LocalTime.of(0, 0);

    public Boolean ocuparVaga(Carro carro){
        Boolean estacionou = false;
        
        if(carrosEstacionados.size() <= 10){
            carro.setHorarioEntrada();
            carrosEstacionados.add(carro);

            estacionou = true;
            quantCarrosEntrou++;
        }

        return estacionou;
    }

    public Boolean desocuparVaga(String placa){
        Boolean desocupou = false;
        
        for (int i = 0; i < carrosEstacionados.size(); i++) {
            Carro carro = carrosEstacionados.get(i);

            if(carro != null && carro.getPlaca().equals(placa)){
                carro.setHorarioSaida();
    
                double valorCobrado = carro.getPeriodos() * 5.00;
    
                Prompt.imprimir("O carro permaneceu estacionado por " + carro.getPeriodos() + " periodos.");
                Prompt.imprimir("Foram cobrados R$ " + valorCobrado + " pelo estacionamento.");
                valorTotalPagoPorPeriodo += valorCobrado;
                quantCarrosSaiu++;
                desocupou = true;
                // Limpar a vaga
                carrosEstacionados.remove(carro);
                break; // Sair do loop após encontrar o carro
            }
        }
        
        return desocupou;
    }

    public void relatorioPeriodo(){
        LocalTime horarioAtual = LocalTime.now();

        if (horarioAtual.getHour() == 6 || horarioAtual.getHour() == 12 || horarioAtual.getHour() == 18) {
            Prompt.imprimir("Nesse periodo entrou " + quantCarrosEntrou + " veiculos.");
            Prompt.imprimir("Nesse periodo saiu " + quantCarrosSaiu + " veiculos.");
            Prompt.imprimir("Total recebido: R$" + valorTotalPagoPorPeriodo);

            quantCarrosEntrou = 0;
            quantCarrosSaiu = 0;
            valorTotalPagoPorPeriodo = 0.0;

            for (Carro carro : carrosEstacionados) {
                if(carro != null){
                    carro.setPeriodos(carro.getPeriodos() + 1);
                }               
            }
        }
    }

    @Override
    public String toString() {
        String toString = "";
        for (int i = 0; i < carrosEstacionados.size(); i++) {
            
            toString += "Vaga "+ (i+1) +"[" + carrosEstacionados.get(i) + "]\n";
        }

        return toString;
    }
}
