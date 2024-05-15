package br.edu.up.views.menus;

import br.edu.up.controller.AeronaveController;
import br.edu.up.utils.Prompt;

public class MenuAeronave {
    AeronaveController aeronaveController = new AeronaveController();

    public void mostrar(){
        boolean sair = false;

        Prompt.separador();
        Prompt.imprimir("MENU DE AERONAVE:");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Cadastrar");
        Prompt.imprimir("\t2 - Listar");
        Prompt.imprimir("\t3 - Alterar");
        Prompt.imprimir("\t4 - Deletar");
        Prompt.imprimir("\t5 - Voltar ao menu principal");

        int opcao = Prompt.lerInteiro("Digite aqui: ");
        Prompt.clearConsole();

        switch (opcao) {
            case 1:
                cadastrar();
                break;
            case 2:
                listar();
                break;
            case 3:
                alterar();
                break;
            case 4:
                deletar();
                break;
            case 5:
                sair = true;
                break;
            default:
                Prompt.separador();
                Prompt.imprimir("VALOR INVÁLIDO.");
                Prompt.separador();
                break;
            }

        if (!sair) {
            Prompt.pressionarEnter();
            Prompt.clearConsole();
            mostrar();
        }
    }


    public void cadastrar(){
        Prompt.separador();
        Prompt.imprimir("CADASTRAR AERONAVE");
        Prompt.separador();

        String nome = Prompt.lerLinha("Digite o seu nome:");
        String rg = Prompt.lerLinha("Digite o seu rg");
        Double totalHorasDeVoo = Prompt.lerDecimal("Digite quantas horas têm de voo:");

        String matriculaFuncionario = Prompt.lerLinha("Digite a mátricula de Funcionário:");
        String idAeronautica = Prompt.lerLinha("Digite a sua identificação de aernoáutica:");

        Comandante comandanteCadastrar = new Comandante(nome, rg, matriculaFuncionario, idAeronautica, totalHorasDeVoo);

        comandanteController.adicionar(comandanteCadastrar);

        Prompt.separador();
        Prompt.imprimir("AERONAVE CADASTRADA\n" + comandanteCadastrar.toString());
        Prompt.separador();
    }
    
    public void listar(){
        Prompt.separador();
        Prompt.imprimir("LISTAR AERONAVE");
        Prompt.separador();

        Prompt.imprimir(comandanteController.listar());
    }

    public void alterar(){
        Prompt.separador();
        Prompt.imprimir("ALTERAR AERONAVE");
        Prompt.separador();

        String matriculaFuncionarioAlterar = Prompt.lerLinha("Digite a Matrícula de Funcionário do comandante que deseja alterar:");
        Comandante comandante = comandanteController.buscar(matriculaFuncionarioAlterar);

        if (comandante == null) {
            Prompt.separador();
            Prompt.imprimir("Não foi achado nenhum comandante com esta matricula!");
            Prompt.separador();
        }else{
            comandanteController.alterar(comandante);

            Prompt.separador();
            Prompt.imprimir("Comandante alterado com suscesso!");
            Prompt.separador();
        }
    }

    public void deletar(){
        Prompt.separador();
        Prompt.imprimir("DELETAR AERONAVE");
        Prompt.separador();

        String matriculaFuncionarioDeletar = Prompt.lerLinha("Digite a mátricula de Funcionário do comandante que deseja deletar:");
        Comandante comandanteDeletar =  comandanteController.buscar(matriculaFuncionarioDeletar);

        if (comandanteDeletar == null) {
            Prompt.separador();
            Prompt.imprimir("Comandante não encontrado!");
            Prompt.separador();
        }else{
            comandanteController.deletar(comandanteDeletar);

            Prompt.separador();
            Prompt.imprimir("Comandante deletado com sucesso!");
            Prompt.separador();
        }
    }
}
