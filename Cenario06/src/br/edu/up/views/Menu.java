package br.edu.up.views;
import br.edu.up.controller.ComandanteController;
import br.edu.up.controller.ComissarioController;
import br.edu.up.controller.PassageiroController;
import br.edu.up.models.Pessoas.Passageiro;
import br.edu.up.models.Pessoas.Tripulantes.Comandante;
import br.edu.up.models.Pessoas.Tripulantes.Comissario;
import br.edu.up.utils.*;

public class Menu {
    PassageiroController passageiroController = new PassageiroController();
    ComandanteController comandanteController = new ComandanteController();
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
                menuPassageiro();
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
    }

    public void menuPassageiro(){
        Prompt.separador();
        Prompt.imprimir("MENU DE PASSAGEIROS:");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Cadastrar");
        Prompt.imprimir("\t2 - Listar");
        Prompt.imprimir("\t3 - Alterar");
        Prompt.imprimir("\t4 - Deletar");
        Prompt.imprimir("\t5 - Voltar ao menu principal");

        int opcao = Prompt.lerInteiro("Digite aqui: ");
        Prompt.clearConsole();
        PassageiroView pv = new PassageiroView();

        switch (opcao) {
            case 1:
            
                Passageiro passageiroCadastrado = pv.cadatrar();
                passageiroController.adicionar(passageiroCadastrado);

                Prompt.separador();
                Prompt.imprimir("PASSAGEIRO CADASTRADO\n" + passageiroCadastrado.toString());
                Prompt.separador();

                break;
            case 2:
                Prompt.separador();
                Prompt.imprimir("LISTAR PASSAGEIROS");
                Prompt.separador();

                Prompt.imprimir(passageiroController.listar());
                break;
            case 3:
                Prompt.separador();
                Prompt.imprimir("ALTERAR PASSAGEIRO");
                Prompt.separador();

                String rgAntigo = Prompt.lerLinha("Digite o rg do passageiro que deseja alterar:");
                Passageiro passageiroVelho = passageiroController.buscar(rgAntigo);

                if (passageiroVelho == null) {
                    Prompt.separador();
                    Prompt.imprimir("Não foi achado nenhum passageiro com este rg!");
                    Prompt.separador();
                    break;
                }
                
                String nomeAlterar = Prompt.lerLinha("Digite o novo nome do passageiro:");
                String rgAlterar = Prompt.lerLinha("Digite o seu rg");

                passageiroVelho.setNome(nomeAlterar);
                passageiroVelho.setRg(rgAlterar);

                passageiroController.alterar(passageiroVelho);

                Prompt.separador();
                Prompt.imprimir("Passageiro alterado com suscesso!");
                Prompt.separador();
                break;
            case 4:
                Prompt.separador();
                Prompt.imprimir("DELETAR PASSAGEIRO");
                Prompt.separador();

                String rgDeletar = Prompt.lerLinha("Digite o rg do passageiro que deseja deletar:");
                Passageiro passageiroDeletar =  passageiroController.buscar(rgDeletar);

                if (passageiroDeletar == null) {
                    Prompt.separador();
                    Prompt.imprimir("Passageiro não encontrado!");
                    Prompt.separador();
                }else{
                    passageiroController.deletar(passageiroDeletar);

                    Prompt.separador();
                    Prompt.imprimir("Passageiro deletado com sucesso!");
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
        menuPassageiro();
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
                menuComandante();
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

    public void menuComandante(){
        Prompt.separador();
        Prompt.imprimir("MENU DE COMANDANTE:");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Cadastrar");
        Prompt.imprimir("\t2 - Listar");
        Prompt.imprimir("\t3 - Alterar");
        Prompt.imprimir("\t4 - Deletar");
        Prompt.imprimir("\t5 - Voltar ao menu principal");

        int opcao = Prompt.lerInteiro("Digite aqui: ");
        Prompt.clearConsole();

        ComandanteView cv = new ComandanteView();

        switch (opcao) {
            case 1:
                Comandante comandanteCadastrar = cv.cadatrar();
                comandanteController.adicionar(comandanteCadastrar);

                Prompt.separador();
                Prompt.imprimir("COMANDANTE CADASTRADO\n" + comandanteCadastrar.toString());
                Prompt.separador();

                break;
            case 2:
                Prompt.separador();
                Prompt.imprimir("LISTAR COMANDANTES");
                Prompt.separador();

                Prompt.imprimir(comandanteController.listar());
                break;
            case 3:
                Prompt.separador();
                Prompt.imprimir("ALTERAR COMANDANTE");
                Prompt.separador();

                String matriculaFuncionarioAlterar = Prompt.lerLinha("Digite a Matrícula de Funcionário do comandante que deseja alterar:");
                Comandante comandanteAlterar = comandanteController.buscar(matriculaFuncionarioAlterar);

                if (comandanteAlterar == null) {
                    Prompt.separador();
                    Prompt.imprimir("Não foi achado nenhum comandante com esta matricula!");
                    Prompt.separador();
                    break;
                }

                Prompt.clearConsole();
                Prompt.separador();
                Prompt.imprimir("ALTERAR COMANDANTE");
                Prompt.separador();
                
                String nomeAlterar = Prompt.lerLinha("Digite o novo nome do comandante:");
                String rgAlterar = Prompt.lerLinha("Digite o novo rg");

                comandanteAlterar.setNome(nomeAlterar);
                comandanteAlterar.setRg(rgAlterar);

                comandanteController.alterar(comandanteAlterar);

                Prompt.separador();
                Prompt.imprimir("Passageiro alterado com suscesso!");
                Prompt.separador();
                break;
            case 4:
                Prompt.separador();
                Prompt.imprimir("DELETAR PASSAGEIRO");
                Prompt.separador();

                String rgDeletar = Prompt.lerLinha("Digite o rg do passageiro que deseja deletar:");
                Passageiro passageiroDeletar =  passageiroController.buscar(rgDeletar);

                if (passageiroDeletar == null) {
                    Prompt.separador();
                    Prompt.imprimir("Passageiro não encontrado!");
                    Prompt.separador();
                }else{
                    passageiroController.deletar(passageiroDeletar);

                    Prompt.separador();
                    Prompt.imprimir("Passageiro deletado com sucesso!");
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
        menuComandante();
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

                Prompt.imprimir(comandanteController.listar());
                break;
            case 3:
                Prompt.separador();
                Prompt.imprimir("ALTERAR COMISSARIOE");
                Prompt.separador();

                String matriculaFuncionarioAlterar = Prompt.lerLinha("Digite a Matrícula de Funcionário do comandante que deseja alterar:");
                Comandante comandanteAntigo = comandanteController.buscar(matriculaFuncionarioAlterar);

                if (comandanteAntigo == null) {
                    Prompt.separador();
                    Prompt.imprimir("Não foi achado nenhum comandante com esta matricula!");
                    Prompt.separador();
                    break;
                }

                Prompt.clearConsole();
                Prompt.separador();
                Prompt.imprimir("ALTERAR COMISSARIO");
                Prompt.separador();
                
                String nomeAlterar = Prompt.lerLinha("Digite o novo nome do comandante:");
                String rgAlterar = Prompt.lerLinha("Digite o novo rg");

                Comandante comandanteAlterado = comandanteAntigo;
                comandanteAlterado.setNome(nomeAlterar);
                comandanteAlterado.setRg(rgAlterar);

                comandanteController.alterar(comandanteAlterado);

                Prompt.separador();
                Prompt.imprimir("Passageiro alterado com suscesso!");
                Prompt.separador();
                break;
            case 4:
                Prompt.separador();
                Prompt.imprimir("DELETAR COMISSARIO");
                Prompt.separador();

                String rgDeletar = Prompt.lerLinha("Digite o rg do passageiro que deseja deletar:");
                Passageiro passageiroDeletar =  passageiroController.buscar(rgDeletar);

                if (passageiroDeletar == null) {
                    Prompt.separador();
                    Prompt.imprimir("Passageiro não encontrado!");
                    Prompt.separador();
                }else{
                    passageiroController.deletar(passageiroDeletar);

                    Prompt.separador();
                    Prompt.imprimir("Passageiro deletado com sucesso!");
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
        menuComandante();
    }
    
    public void menuAeronave(){
        
        Prompt.separador();
        Prompt.imprimir("MENU DE CADASTRO DA AERONAVE:");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Incluir aeronave");
        Prompt.imprimir("\t2 - Listar aeronaves");
        Prompt.imprimir("\t3 - Alterar aeronave");
        Prompt.imprimir("\t4 - Deletar aeronave");
        Prompt.imprimir("\t5 - Voltar ao menu principal");

        int opcao = Prompt.lerInteiro("Digite aqui: ");
        Prompt.clearConsole();
        switch (opcao) {
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
        Prompt.pressionarEnter();
        Prompt.clearConsole();
        menuAeronave();
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
