package br.edu.up.controller;

import java.time.LocalDateTime;
import java.time.LocalTime;
import br.edu.up.*;
import br.edu.up.models.Carro;

public class EstacionamentoController {
    private Carro carrosEstacionados[] = new Carro[10];
    private Integer quantCarrosEntrou = 0;
    private Integer quantCarrosSaiu = 0;
    Private double valorTotalPagoPorPeriodo = 0.0;

    private LocalTime periodoManha = LocalTime.of(6, 0);
    private LocalTime periodoTarde = LocalTime.of(12, 0);
    private LocalTime periodoNoite = LocalTime.of(18, 0);
    private LocalTime fechado = LocalTime.of(0, 0);

    public Boolean ocuparVaga(Carro carro){
        Boolean estacionou = false;
        
        for (Carro eachCarro : carrosEstacionados) {
            if(eachCarro == null){
                eachCarro = carro;
                eachCarro.setHorarioEntrada();


                estacionou = true;
                quantCarrosEntrou++;
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

                int periodos = calcularQuantPeriodos(eachCarro.getHorarioEntrada(), eachCarro.getHorarioSaida());
                double valorCobrado = periodos * 5.00;

                Prompt.imprimir("O carro permaneceu estacionado por " + periodos + " minutos.");
                Prompt.imprimir("Foram cobrados R$ " + valorCobrado + " pelo estacionamento.");
                valorTotalPagoPorPeriodo = valorCobrado;
                quantCarrosSaiu++;
                desocupou = true;
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
        }
    }

    public int calcularQuantPeriodos(LocalTime entrada, LocalTime saida){
        
    }

}
