package br.edu.up.controller;
import java.time.LocalTime;
import br.edu.up.*;
import br.edu.up.models.Carro;

public class EstacionamentoController {
    private Carro carrosEstacionados[] = new Carro[10];
    private Integer quantCarrosEntrou = 0;
    private Integer quantCarrosSaiu = 0;
    private double valorTotalPagoPorPeriodo = 0.0;

    private LocalTime periodoManha = LocalTime.of(6, 0);
    private LocalTime periodoTarde = LocalTime.of(12, 0);
    private LocalTime periodoNoite = LocalTime.of(18, 0);
    private LocalTime fechado = LocalTime.of(0, 0);

    public Boolean ocuparVaga(Carro carro){
        Boolean estacionou = false;
        
        for (int i = 0; i < carrosEstacionados.length; i++) {
            if(carrosEstacionados[i] == null){
                carrosEstacionados[i] = carro;
                carro.setHorarioEntrada();

                estacionou = true;
                quantCarrosEntrou++;
                break;
            }
        }

        for (int i = 0; i < carrosEstacionados.length; i++) {
            if(carrosEstacionados[i] != null){
                Prompt.separador();
                Prompt.imprimir("vaga " + (i + 1));
                Prompt.imprimir(carrosEstacionados[i].getModelo());
                Prompt.imprimir(carrosEstacionados[i].getPlaca());
                Prompt.imprimir(carrosEstacionados[i].getCor());
                Prompt.separador();
            }
        }
        return estacionou;
    }

    public Boolean desocuparVaga(String placa){
        Boolean desocupou = false;
        
        for (int i = 0; i < carrosEstacionados.length; i++) {
            Carro eachCarro = carrosEstacionados[i];
            if(eachCarro != null && eachCarro.getPlaca().equals(placa)){
                eachCarro.setHorarioSaida();
    
                double valorCobrado = eachCarro.getPeriodos() * 5.00;
    
                Prompt.imprimir("O carro permaneceu estacionado por " + eachCarro.getPeriodos() + " minutos.");
                Prompt.imprimir("Foram cobrados R$ " + valorCobrado + " pelo estacionamento.");
                valorTotalPagoPorPeriodo += valorCobrado;
                quantCarrosSaiu++;
                desocupou = true;
                // Limpar a vaga
                carrosEstacionados[i] = null;
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

}
