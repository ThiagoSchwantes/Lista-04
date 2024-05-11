package br.edu.up.views;
import br.edu.up.utils.*;

import java.util.Scanner;
import java.util.UUID;

import br.edu.up.Controllers.*;
import br.edu.up.models.*;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    public void menuPrincipal(){

        Prompt.separador();
        Prompt.imprimir("MENU PRINCIPAL");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Eventos");
        Prompt.imprimir("\t2 - Reservas");
        Prompt.imprimir("\t3 - Fechar Programa\n");

        int opcao1 = Prompt.lerInteiro("Digite aqui: ");

        switch (opcao1) {
            case 1:
                menuEventos();
                break;
            case 2:
                menuReserva();
                break;
            case 3:
                encerrarPrograma();
                break;
            default:
                Prompt.imprimir("Valor Inválido.");
                menuPrincipal();
                break;
        }
    }

    public void menuEventos(){

        ControleDeEvento controleDeEvento = new ControleDeEvento();
        Prompt.separador();
        Prompt.imprimir("MENU DE EVENTOS");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Inclusão de evento.");
        Prompt.imprimir("\t2 - Alteração de evento.");
        Prompt.imprimir("\t3 - Listagem de evento.");
        Prompt.imprimir("\t4 - Exclusão de evento.");
        Prompt.imprimir("\t5 - Voltar ao Menu Principal\n\n");

        int opcao2 = Prompt.lerInteiro("Digite aqui: ");

        switch (opcao2) {
            case 1:
                Evento evento = controleDeEvento.incluirEvento();
                Prompt.separador();
                Prompt.imprimir("Evento cadastrado com sucesso!");
                Prompt.imprimir(evento);
                Prompt.separador();
                continuar();
                break;
            case 2:
                String idString = Prompt.lerLinha("Informe o id do evento: ");
                try{
                    UUID id = UUID.fromString(idString);
                    Evento evento2 = controleDeEvento.alterarEvento(id);
                    if(evento2 == null){
                        Prompt.imprimir("Id não encontrado.");
                    }else{
                        Prompt.separador();
                        Prompt.imprimir("Alteração realizada com sucesso.");
                        Prompt.imprimir(evento2);
                        Prompt.separador();
                    }
                }catch (IllegalArgumentException e) {
                    Prompt.imprimir("Formato de UUID inválido. Certifique-se de inserir um UUID válido.");
                }
                
                continuar();
                break;
            case 3:
                controleDeEvento.listaDeEventos();
                continuar();
                break;
            case 4:
                String idString2 = Prompt.lerLinha("Informe o id do evento: ");
                try{
                    UUID id = UUID.fromString(idString2);
                    boolean evento2 = controleDeEvento.ExcluirEvento(id);
                    if(evento2 == false){
                        Prompt.imprimir("Evento não encontrado.");
                    }else{
                        Prompt.imprimir("Evento excluido com sucesso.");
                    }
                }catch (IllegalArgumentException e) {
                    Prompt.imprimir("Formato de UUID inválido. Certifique-se de inserir um UUID válido.");
                }
                continuar();
                break;
            case 5:
                menuPrincipal();
                break;
            default:
                Prompt.imprimir("Valor Inválido.");
                break;
        }
    }

    public void menuReserva(){
        Prompt.separador();
        Prompt.imprimir("MENU DE RESERVAS");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Inclusão de reserva.");
        Prompt.imprimir("\t2 - Alteração de reserva.");
        Prompt.imprimir("\t3 - Listagem de reserva.");
        Prompt.imprimir("\t4 - Exclusão de reserva.");
        Prompt.imprimir("\t5 - Voltar ao Menu Principal\n\n");

        int opcao3 = Prompt.lerInteiro("Digite aqui: ");

        switch (opcao3) {
            case 1:
                //incluirReserva();
                break;
            case 2:
                //alterarReserva();
                break;
            case 3:
                //listarReserva();
                break;
            case 4:
                //excluirReserva();
                break;
            case 5:
                menuPrincipal();
                break;
            default:
                Prompt.imprimir("Valor Inválido.");
                break;
        }
    }

    public void encerrarPrograma(){
        Prompt.imprimir("Encerrando o programa...");
        System.exit(3);
    }

    public void continuar(){
        Prompt.imprimir("Pressione qualquer tecla para continuar...");
        scanner.nextLine();
        menuPrincipal();
    }
}
