package br.edu.up.views;
import br.edu.up.controller.ComandanteController;
import br.edu.up.controller.ComissarioController;
import br.edu.up.models.pessoas.tripulantes.Comandante;
import br.edu.up.models.pessoas.tripulantes.Comissario;
import br.edu.up.utils.*;

public class Menu {
    MenuPassageiro menuPassageiro = new MenuPassageiro();
    MenuComandante menuComandante= new MenuComandante();

   
    ComissarioController comissarioController = new ComissarioController();

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
                menuPassageiro.mostrar();
                break;
            case 2:
                menuTripulacao();
                break;
            case 3:
                menuAeronave();
                break;
            case 4:
                menuVoosPassagem();
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
                menuComandante.mostrar();
                break;
            case 2:
                menuComissario();
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

    
    public void menuComissario(){
        Prompt.separador();
        Prompt.imprimir("MENU DE COMISSARIO:");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Cadastrar");
        Prompt.imprimir("\t2 - Listar");
        Prompt.imprimir("\t3 - Alterar");
        Prompt.imprimir("\t4 - Deletar");
        Prompt.imprimir("\t5 - Voltar ao menu principal");

        int opcao = Prompt.lerInteiro("Digite aqui: ");
        Prompt.clearConsole();

        ComissarioView cv = new ComissarioView();

        switch (opcao) {
            case 1:
                Comissario comissarioCadastrar = cv.cadatrar();
                comissarioController.adicionar(comissarioCadastrar);

                Prompt.clearConsole();
                Prompt.separador();
                Prompt.imprimir("COMISSARIO CADASTRADO COM SUCESSO!\n" + comissarioCadastrar.toString());
                Prompt.separador();

                break;
            case 2:
                Prompt.separador();
                Prompt.imprimir("LISTAR COMISSARIOS");
                Prompt.separador();

                Prompt.imprimir(comissarioController.listar());
                break;
            case 3:
                Prompt.separador();
                Prompt.imprimir("ALTERAR COMISSARIO");
                Prompt.separador();

                String matriculaFuncionarioAlterar = Prompt.lerLinha("Digite a Matrícula de Funcionário do comissário que deseja alterar:");
                Comissario comissarioAlterado = comissarioController.buscar(matriculaFuncionarioAlterar);

                if (comissarioAlterado == null) {
                    Prompt.separador();
                    Prompt.imprimir("Não foi achado nenhum comissario com esta matricula!");
                    Prompt.separador();
                    break;
                }

                Prompt.clearConsole();
                Prompt.separador();
                Prompt.imprimir("ALTERAR COMISSÁRIO");
                Prompt.separador();
                
                comissarioController.alterar(cv.alterar(comissarioAlterado));

                Prompt.separador();
                Prompt.imprimir("Comissario alterado com suscesso!");
                Prompt.separador();
                break;
            case 4:
                Prompt.separador();
                Prompt.imprimir("DELETAR COMISSÁRIO");
                Prompt.separador();

                String matriculaFuncionarioDeletar = Prompt.lerLinha("Digite a matricual de funcionário do comissario que deseja deletar:");
                Comissario comissarioDeletar =  comissarioController.buscar(matriculaFuncionarioDeletar);

                if (comissarioDeletar == null) {
                    Prompt.separador();
                    Prompt.imprimir("Comissário não encontrado!");
                    Prompt.separador();
                }else{
                    comissarioController.deletar(comissarioDeletar);

                    Prompt.separador();
                    Prompt.imprimir("Comissário deletado com sucesso!");
                    Prompt.separador();
                }

                break;
            case 5:
                menuPrincipal();
                break;
            default:
                Prompt.separador();
                Prompt.imprimir("VALOR INVÁLIDO.");
                Prompt.separador();
                break;
            }
        Prompt.pressionarEnter();
        Prompt.clearConsole();
        menuComissario();
    }
    
    public void menuAeronave(){
        Prompt.separador();
        Prompt.imprimir("MENU DE COMISSARIO:");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Cadastrar");
        Prompt.imprimir("\t2 - Listar");
        Prompt.imprimir("\t3 - Alterar");
        Prompt.imprimir("\t4 - Deletar");
        Prompt.imprimir("\t5 - Voltar ao menu principal");

        int opcao = Prompt.lerInteiro("Digite aqui: ");
        Prompt.clearConsole();

        ComissarioView cv = new ComissarioView();

        switch (opcao) {
            case 1:
                Comissario comissarioCadastrar = cv.cadatrar();
                comissarioController.adicionar(comissarioCadastrar);

                Prompt.clearConsole();
                Prompt.separador();
                Prompt.imprimir("COMISSARIO CADASTRADO COM SUCESSO!\n" + comissarioCadastrar.toString());
                Prompt.separador();

                break;
            case 2:
                Prompt.separador();
                Prompt.imprimir("LISTAR COMISSARIOS");
                Prompt.separador();

                Prompt.imprimir(comissarioController.listar());
                break;
            case 3:
                Prompt.separador();
                Prompt.imprimir("ALTERAR COMISSARIO");
                Prompt.separador();

                String matriculaFuncionarioAlterar = Prompt.lerLinha("Digite a Matrícula de Funcionário do comissário que deseja alterar:");
                Comissario comissarioAlterado = comissarioController.buscar(matriculaFuncionarioAlterar);

                if (comissarioAlterado == null) {
                    Prompt.separador();
                    Prompt.imprimir("Não foi achado nenhum comissario com esta matricula!");
                    Prompt.separador();
                    break;
                }

                Prompt.clearConsole();
                Prompt.separador();
                Prompt.imprimir("ALTERAR COMISSÁRIO");
                Prompt.separador();
                
                comissarioController.alterar(cv.alterar(comissarioAlterado));

                Prompt.separador();
                Prompt.imprimir("Comissario alterado com suscesso!");
                Prompt.separador();
                break;
            case 4:
                Prompt.separador();
                Prompt.imprimir("DELETAR COMISSÁRIO");
                Prompt.separador();

                String matriculaFuncionarioDeletar = Prompt.lerLinha("Digite a matricual de funcionário do comissario que deseja deletar:");
                Comissario comissarioDeletar =  comissarioController.buscar(matriculaFuncionarioDeletar);

                if (comissarioDeletar == null) {
                    Prompt.separador();
                    Prompt.imprimir("Comissário não encontrado!");
                    Prompt.separador();
                }else{
                    comissarioController.deletar(comissarioDeletar);
                    Prompt.separador();
                    Prompt.imprimir("Comissário deletado com sucesso!");
                    Prompt.separador();
                }

                break;
            case 5:
                menuPrincipal();
                break;
            default:
                Prompt.separador();
                Prompt.imprimir("VALOR INVÁLIDO.");
                Prompt.separador();
                break;
            }
        Prompt.pressionarEnter();
        Prompt.clearConsole();
        menuComissario();
    }

    public void menuVoosPassagem(){
        
        Prompt.separador();
        Prompt.imprimir("MENU DE GERENCIAMENTO DE TRAFEGO:");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Emitir passagem.");
        Prompt.imprimir("\t2 - Deletar passagem");
        Prompt.imprimir("\t3 - Voltar ao menu principal");

        int opcao = Prompt.lerInteiro("Digite aqui: ");
        Prompt.clearConsole();

        switch (opcao) {
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

        Prompt.pressionarEnter();
        Prompt.clearConsole();
        menuVoosPassagem();
    }


    public void encerrarPrograma(){
        Prompt.imprimir("Encerrando o programa...");
        System.exit(3);
    }

}
