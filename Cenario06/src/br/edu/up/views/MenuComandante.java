package br.edu.up.views;

import br.edu.up.controller.ComandanteController;
import br.edu.up.models.pessoas.tripulantes.Comandante;
import br.edu.up.utils.Prompt;

public class MenuComandante {
    ComandanteController comandanteController = new ComandanteController();

    public void mostrar(){
        boolean sair = false;

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
        Prompt.imprimir("CADASTRAR COMANDANTE");
        Prompt.separador();

        String nome = Prompt.lerLinha("Digite o seu nome:");
        String rg = Prompt.lerLinha("Digite o seu rg");
        Double totalHorasDeVoo = Prompt.lerDecimal("Digite quantas horas têm de voo:");

        String matriculaFuncionario = Prompt.lerLinha("Digite a mátricula de Funcionário:");
        String idAeronautica = Prompt.lerLinha("Digite a sua identificação de aernoáutica:");

        Comandante comandanteCadastrar = new Comandante(nome, rg, matriculaFuncionario, idAeronautica, totalHorasDeVoo);

        comandanteController.adicionar(comandanteCadastrar);

        Prompt.separador();
        Prompt.imprimir("COMANDANTE CADASTRADO\n" + comandanteCadastrar.toString());
        Prompt.separador();
    }
    
    public void listar(){
        Prompt.separador();
        Prompt.imprimir("LISTAR COMANDANTES");
        Prompt.separador();

        Prompt.imprimir(comandanteController.listar());
    }

    public void alterar(){
        Prompt.separador();
        Prompt.imprimir("ALTERAR COMANDANTE");
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
        Prompt.imprimir("DELETAR COMANDANTE");
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
