package br.edu.up.controller;
import java.time.LocalTime;

import br.edu.up.models.Carro;

public class EstacionamentoController {

    private Carro[] carrosEstacionados = new Carro[0];
    Integer index = 0;

    private Integer quantCarrosEntrou = 0;
    private Integer quantCarrosSaiu = 0;
    private double valorTotalPagoPorPeriodo = 0.0;

    public Boolean ocuparVaga(Carro carro){
        Boolean estacionou = false;

        if(carrosEstacionados.length <= 10){
            carro.setHorarioEntrada();
            
            Carro[] aux = new Carro[carrosEstacionados.length + 1];
            System.arraycopy(carrosEstacionados, 0, aux, 0, carrosEstacionados.length);
            
            aux[carrosEstacionados.length] = carro;
            carrosEstacionados = aux;

            estacionou = true;
            quantCarrosEntrou++;
        }

        return estacionou;
    }

    public Boolean desocuparVaga(String placa){
        Boolean desocupou = false;
        
        if(carrosEstacionados.length > 0){
        Carro[] aux = new Carro[carrosEstacionados.length - 1];
        
        for (int i = 0; i < carrosEstacionados.length; i++) {
            Carro carro = carrosEstacionados[i];

            if(carro != null && carro.getPlaca().equals(placa)){
                carro.setHorarioSaida();
                quantCarrosSaiu++;
                desocupou = true;
                // Limpar a vaga
                for (int j = i; j < carrosEstacionados.length - 1; j++) {
                    aux[j] = carrosEstacionados[j+1];
                }

                break; // Sair do loop após encontrar o carro
            }else{
                aux[i] = carrosEstacionados[i];
            }
        }

        carrosEstacionados = new Carro[carrosEstacionados.length - 1];
        carrosEstacionados = aux;
        }
        
        return desocupou;
    }

    public String cobranca(String placa){
        String frase = "";
        for (int i = 0; i < carrosEstacionados.length; i++) {
            Carro carro = carrosEstacionados[i];

            if(carro != null && carro.getPlaca().equals(placa)){
                double valorCobrado = carro.getPeriodos() * 5.00;
    
                frase = "O carro permaneceu estacionado por " + carro.getPeriodos() + " periodos.\n"+
                        "Foram cobrados R$ " + valorCobrado + " pelo estacionamento.";
                
                valorTotalPagoPorPeriodo += valorCobrado;
            }
        }
        return frase;
    }

    public String relatorioPeriodo(){
        String frase = "";
        LocalTime horarioAtual = LocalTime.now();

        if (horarioAtual.getHour() == 6 || horarioAtual.getHour() == 12 || horarioAtual.getHour() == 18) {
            frase = "Nesse periodo entrou " + quantCarrosEntrou + " veiculos.\n" +
                    "Nesse periodo saiu " + quantCarrosSaiu + " veiculos.\n" +
                    "Total recebido: R$" + valorTotalPagoPorPeriodo;

            quantCarrosEntrou = 0;
            quantCarrosSaiu = 0;
            valorTotalPagoPorPeriodo = 0.0;

            for (Carro carro : carrosEstacionados) {
                if(carro != null){
                    carro.setPeriodos(carro.getPeriodos() + 1);
                }               
            }
        }else{
            frase = "Não é possivel finalizar o periodo ainda! (apenas às 6, 12 e 18 horas)";
        }
        return frase;
    }

    @Override
    public String toString() {
        String toString = "";
        for (int i = 0; i < carrosEstacionados.length; i++) {
            
            toString += "Vaga "+ (i+1) +"[" + carrosEstacionados[i] + "]\n";
        }

        return toString;
    }
}
