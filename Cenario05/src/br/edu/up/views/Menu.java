package br.edu.up.views;
import br.edu.up.utils.*;

public class Menu {

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
                break;
        }
    }

    public void menuEventos(){
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
                //incluirEvento();
                break;
            case 2:
                //alterarEvento();
                break;
            case 3:
                //listarEventos();
                break;
            case 4:
                //excluirEvento();
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
}
