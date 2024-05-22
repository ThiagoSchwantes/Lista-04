package br.edu.up.views;
import br.edu.up.utils.Prompt;

import br.edu.up.views.menus.MenuAeronave;
import br.edu.up.views.menus.MenuComandante;
import br.edu.up.views.menus.MenuComissario;
import br.edu.up.views.menus.MenuPassageiro;
import br.edu.up.views.menus.MenuPassagem;

public class Menu {
    MenuPassageiro menuPassageiro = new MenuPassageiro();
    MenuComandante menuComandante= new MenuComandante();
    MenuComissario menuComissario = new MenuComissario();
    MenuAeronave menuAeronave = new MenuAeronave();
    MenuPassagem menuPassagem = new MenuPassagem();

    public void menuPrincipal(){
        Prompt.clearConsole();
        Prompt.separador();
        Prompt.imprimir("MENU PRINCIPAL");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções para gerenciar:");
        Prompt.imprimir("\t1 - Passageiros");
        Prompt.imprimir("\t2 - Tripulação");
        Prompt.imprimir("\t3 - Aeronaves");
        Prompt.imprimir("\t4 - Voos / passagens");
        Prompt.imprimir("\t5 - Fechar Programa\n");

        int opcao1 = Prompt.lerInteiro("Digite aqui: ");
        Prompt.clearConsole();

        switch (opcao1) {
            case 1:
                menuPassageiro.mostrar(menuAeronave);
                break;
            case 2:
                menuTripulacao();
                break;
            case 3:
                menuAeronave.mostrar();
                break;
            case 4:
                menuPassagem.mostrar(menuPassageiro);
                break;
            case 5:
                encerrarPrograma();
                break;
            default:
                Prompt.separador();
                Prompt.imprimir("VALOR INVÁLIDO.");
                Prompt.separador();

                Prompt.pressionarEnter();
                menuPrincipal();
                break;
        }
        menuPrincipal();
    }


    public void menuTripulacao(){
        Prompt.separador();
        Prompt.imprimir("MENU DA TRIPULAÇÃO:");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Comandante");
        Prompt.imprimir("\t2 - Comissário");
        Prompt.imprimir("\t3 - Voltar ao menu principal");

        int opcao = Prompt.lerInteiro("Digite aqui: ");
        Prompt.clearConsole();

        switch (opcao) {
            case 1:
                menuComandante.mostrar(menuAeronave);
                break;
            case 2:
                menuComissario.mostrar(menuAeronave);
                break;
            case 3:
                menuPrincipal();
                break;
            default:
                Prompt.imprimir("Valor Inválido.");
                menuTripulacao();
                break;
        }
    }

    public void encerrarPrograma(){
        Prompt.imprimir("Encerrando o programa...");
        System.exit(3);
    }

}
