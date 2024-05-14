package br.edu.up.views;
import br.edu.up.controller.PassageiroController;
import br.edu.up.models.Pessoa.Passageiro;
import br.edu.up.utils.*;

public class Menu {
    PassageiroController passageiroController = new PassageiroController();

    public void menuPrincipal(){

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
                Prompt.imprimir("Valor Inválido.");
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

        switch (opcao) {
            case 1:
                String nome = Prompt.lerLinha("Digite o seu nome:");
                String rg = Prompt.lerLinha("Digite o seu rg");
                String passageiroString = passageiroController.adicionar(new Passageiro(nome, rg)).toString();

                Prompt.linhaEmBranco();
                Prompt.separador();
                Prompt.imprimir("Passageiro cadastrado" + passageiroString);
                Prompt.pressionarEnter();
                break;
            case 2:
                Prompt.imprimir(passageiroController.listar());
                break;
            case 3:
                Prompt.separador();
                String rgAntigo = Prompt.lerLinha("Digite o rg do passageiro que deseja alterar:");
                Passageiro passageiroVelho = passageiroController.buscar(rgAntigo);

                if (passageiroVelho == null) {
                    Prompt.imprimir("Não foi achado nenhum passageiro com este rg!");
                    break;
                }
                
                String nomeAlterar = Prompt.lerLinha("Digite o novo nome do passageiro:");
                String rgAlterar = Prompt.lerLinha("Digite o seu rg");

                Passageiro passageiroAlterado = passageiroVelho;
                passageiroAlterado.setNome(nomeAlterar);
                passageiroAlterado.setRg(rgAlterar);

                passageiroController.alterar(passageiroVelho, passageiroAlterado);
                Prompt.separador();
                Prompt.pressionarEnter();
                break;
            case 4:
                String rgDeletar = Prompt.lerLinha("Digite o rg do passageiro que deseja deletar:");
                passageiroController.deletar(passageiroController.buscar(rgDeletar));
                break;
            case 5:
                menuPrincipal();
                break;
            default:
                Prompt.imprimir("Valor Inválido.");
                break;
        }
        menuPassageiro();
    }

    public void cadastrarPassageiro(){
        String nome = Prompt.lerLinha("Digite o seu nome:");
        String rg = Prompt.lerLinha("Digite o seu RG:");

    }
    
    public void menuTripulacao(){
        
        Prompt.separador();
        Prompt.imprimir("MENU DA TRIPULAÇÃO:");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Comandante");
        Prompt.imprimir("\t2 - Comissário");
        Prompt.imprimir("\t5 - Voltar ao menu principal");

        int opcao4 = Prompt.lerInteiro("Digite aqui: ");
        TripulanteView trpView = new TripulanteView();

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

    public void menuVoosPassagem(){
        
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

    public void continuar(){
        Prompt.pressionarEnter();
        menuPrincipal();
    }

    public void encerrarPrograma(){
        Prompt.imprimir("Encerrando o programa...");
        System.exit(3);
    }
}
