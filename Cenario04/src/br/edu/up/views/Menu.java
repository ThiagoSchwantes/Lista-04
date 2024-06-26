package br.edu.up.views;
import java.util.Scanner;
import br.edu.up.controller.*;
import br.edu.up.models.*;
import br.edu.up.utils.Prompt;

public class Menu {
    private EstacionamentoController estacionamento = new EstacionamentoController();
    Scanner scanner = new Scanner(System.in);
    
    public void menuPrincipal(){
        
        Prompt.separador();
        Prompt.imprimir("MENU PRINCIPAL");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Entrada de um carro");
        Prompt.imprimir("\t2 - Saída de um carro");
        Prompt.imprimir("\t3 - Finalizar periodo");

        int opcao = Prompt.lerInteiro();

        switch (opcao) {
            case 1:
                Carro carro = cadastrarCarro();
                Boolean estacionou = estacionamento.ocuparVaga(carro);
                Prompt.separador();

                if(estacionou){
                    Prompt.imprimir("Carro estacionado com sucesso!");

                    Prompt.imprimir(estacionamento.toString());

                }else{
                    Prompt.imprimir("Não foi possível estacionar o carro. Estacionamento lotado.");
                }
                break;
            case 2:
                String placa = Prompt.lerLinha("Informe a placa do carro:");
                Prompt.imprimir(estacionamento.cobranca(placa));
                Boolean desocupou = estacionamento.desocuparVaga(placa);

                if(desocupou){
                    Prompt.imprimir("Vaga liberada com sucesso!");
                }else{
                    Prompt.imprimir("Não foi possível encontar a placa fornecida.");
                }
                break;

            case 3:
                System.out.println(estacionamento.relatorioPeriodo());
                break;
            default:
                Prompt.imprimir("Valor inválido.");
                break;
            }
            
            Prompt.imprimir("Pressione qualquer tecla para continuar...");
            scanner.nextLine();
            menuPrincipal();
    }

    public Carro cadastrarCarro(){
        Carro carro = new Carro();

        carro.setModelo(Prompt.lerLinha("Informe o modelo do veiculo: "));
        carro.setPlaca(Prompt.lerLinha("Informe a placa do veiculo: "));
        carro.setCor(Prompt.lerLinha("Informe a cor do veiculo: "));

        return carro;
    }
}
