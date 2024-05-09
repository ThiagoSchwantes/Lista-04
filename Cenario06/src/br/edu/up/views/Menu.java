package br.edu.up.views;
import br.edu.up.utils.*;

public class Menu {

    public void menuPrincipal(){

        Prompt.separador();
        Prompt.imprimir("MENU PRINCIPAL");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        
        Prompt.imprimir("\t1 - Cadastros do sistema.");
        Prompt.imprimir("\t2 - Gerenciamento de operação.");
        Prompt.imprimir("\t3 - Fechar Programa\n");

        int opcao1 = Prompt.lerInteiro("Digite aqui: ");

        switch (opcao1) {
            case 1:
                menuCadastro();
                break;
            case 2:
                menuGerenciamento();
                break;
            case 3:
                encerrarPrograma();
                break;
            default:
                Prompt.imprimir("Valor Inválido.");
                break;
        }
    }
    
    public void menuCadastro(){

        Prompt.separador();
        Prompt.imprimir("MENU DE CADASTRO:");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Passageiros");
        Prompt.imprimir("\t2 - Tripulação");
        Prompt.imprimir("\t3 - Aeronaves");
        Prompt.imprimir("\t4 - Voltar ao menu principal");
        

        int opcao2 = Prompt.lerInteiro("Digite aqui: ");

        switch (opcao2) {
            case 1:
                menuCadastroDePassageiros();
                break;
            case 2:
                menuCadastroDeTripulacao();
                break;
            case 3:
                menuCadastroDeAeronave();
                break;
            case 4:
                menuPrincipal();
                break;
            default:
                Prompt.imprimir("Valor Inválido.");
                break;
        }
    }

    public void menuCadastroDePassageiros(){
        
        Prompt.separador();
        Prompt.imprimir("MENU DE CADASTRO DE PASSAGEIROS:");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Incluir passageiro");
        Prompt.imprimir("\t2 - Listar passageiros");
        Prompt.imprimir("\t3 - Alterar passageiro");
        Prompt.imprimir("\t4 - Deletar passageiro");
        Prompt.imprimir("\t5 - Voltar ao menu principal");

        int opcao3 = Prompt.lerInteiro("Digite aqui: ");

        switch (opcao3) {
            case 1:
                //incluirPassageiro();
                break;
            case 2:
                //listarPassageiros();
                break;
            case 3:
                //alterarPassageiro();
                break;
            case 4:
                //deletarPassageiro();
                break;
            case 5:
                menuPrincipal();
                break;
            default:
                Prompt.imprimir("Valor Inválido.");
                break;
        }
    }
    
    public void menuCadastroDeTripulacao(){
        
        Prompt.separador();
        Prompt.imprimir("MENU DE CADASTRO DA TRIPULAÇÃO:");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Incluir tripulação");
        Prompt.imprimir("\t2 - Listar tripulação");
        Prompt.imprimir("\t3 - Alterar tripulação");
        Prompt.imprimir("\t4 - Deletar tripulação");
        Prompt.imprimir("\t5 - Voltar ao menu principal");

        int opcao4 = Prompt.lerInteiro("Digite aqui: ");

        switch (opcao4) {
            case 1:
                //incluirTripulante();
                break;
            case 2:
                //listarTripulantes();
                break;
            case 3:
                //alterarTripulante();
                break;
            case 4:
                //deletarTripulante();
                break;
            case 5:
                menuPrincipal();
                break;
            default:
                Prompt.imprimir("Valor Inválido.");
                break;
        }
    }

    public void menuCadastroDeAeronave(){
        
        Prompt.separador();
        Prompt.imprimir("MENU DE CADASTRO DA AERONAVE:");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Incluir aeronave");
        Prompt.imprimir("\t2 - Listar aeronaves");
        Prompt.imprimir("\t3 - Alterar aeronave");
        Prompt.imprimir("\t4 - Deletar aeronave");
        Prompt.imprimir("\t5 - Voltar ao menu principal");

        int opcao5 = Prompt.lerInteiro("Digite aqui: ");

        switch (opcao5) {
            case 1:
                //incluirAeronave();
                break;
            case 2:
                //listarAeronaves();
                break;
            case 3:
                //alterarAeronave();
                break;
            case 4:
                //deletarAeronave();
                break;
            case 5:
                menuPrincipal();
                break;
            default:
                Prompt.imprimir("Valor Inválido.");
                break;
        }
    }

    public void menuGerenciamento(){
        
        Prompt.separador();
        Prompt.imprimir("MENU DE GERENCIAMENTO DE TRAFEGO:");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Emitir passagem.");
        Prompt.imprimir("\t2 - Deletar passagem");
        Prompt.imprimir("\t3 - Voltar ao menu principal");

        int opcao6 = Prompt.lerInteiro("Digite aqui: ");

        switch (opcao6) {
            case 1:
                //emitirPassagem();
                break;
            case 2:
                //deletarPassagem();
                break;
            case 3:
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
