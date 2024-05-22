package br.edu.up.views.menus;

import br.edu.up.controller.ComandanteController;
import br.edu.up.models.Aeronave;
import br.edu.up.models.pessoas.tripulantes.Comandante;
import br.edu.up.utils.Prompt;

public class MenuComandante {
    ComandanteController comandanteController = new ComandanteController();

    public void mostrar(MenuAeronave menuAeronave){
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
                cadastrar(menuAeronave);
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
            mostrar(menuAeronave);
        }
    }

    public void cadastrar(MenuAeronave menuAeronave){
        if (!menuAeronave.aeronaveController.listar().equals("")) {
            Prompt.separador();
            Prompt.imprimir("CADASTRAR COMANDANTE");
            Prompt.separador();

            String nome = Prompt.lerLinha("Digite o seu nome:");
            String rg = Prompt.lerLinha("Digite o seu rg");
            Double totalHorasDeVoo = Prompt.lerDecimal("Digite quantas horas têm de voo:");
            String matriculaFuncionario = Prompt.lerLinha("Digite a mátricula de Funcionário:");
            String idAeronautica = Prompt.lerLinha("Digite a sua identificação de aernoáutica:");

            Comandante comandanteCadastrar = new Comandante(nome, rg, matriculaFuncionario, idAeronautica, totalHorasDeVoo);

            boolean achado = false;
            do {
                Prompt.clearConsole();
                Prompt.imprimir("LISTA DE AVIÕES:");
                Prompt.separador();

                menuAeronave.aeronaveController.listar();

                Prompt.separador();
                int opcao = Prompt.lerInteiro("Em qual avião o comandente vai estar?");
                Prompt.separador();

                Aeronave aeronaveEscolhida = menuAeronave.aeronaveController.buscar(opcao);

                if(aeronaveEscolhida == null){
                    Prompt.imprimir("Valor digitado incorreto! Digite corretamente!");
                    Prompt.pressionarEnter();
                }else{
                    achado = true;
                    comandanteCadastrar.setAeronave(aeronaveEscolhida);
                }
            } while (achado != true);

            comandanteController.adicionar(comandanteCadastrar);
            Prompt.separador();
            Prompt.imprimir("COMANDANTE CADASTRADO\n" + comandanteCadastrar.toString());
            Prompt.separador(); 
        }else{
            Prompt.imprimir("Não é possível cadastrar nenhuma Pessoa ainda! Não possui nenhuma aeronave cadastrada");
        }
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
        Comandante comandanteAntigo = comandanteController.buscar(matriculaFuncionarioAlterar);

        if (comandanteAntigo == null) {
            Prompt.separador();
            Prompt.imprimir("Não foi achado nenhum comandante com esta matricula!");
            Prompt.separador();
        }else{
            String nome = Prompt.lerLinha("Digite o seu nome:");
            String rg = Prompt.lerLinha("Digite o seu rg");
            Double totalHorasDeVoo = Prompt.lerDecimal("Digite quantas horas têm de voo:");

            String matriculaFuncionario = Prompt.lerLinha("Digite a mátricula de Funcionário:");
            String idAeronautica = Prompt.lerLinha("Digite a sua identificação de aernoáutica:");

            Comandante comandanteNovo = comandanteAntigo;    
            comandanteNovo.setNome(nome);
            comandanteNovo.setRg(rg);
            comandanteNovo.setTotalHorasDeVoo(totalHorasDeVoo);
            comandanteNovo.setMatriculaFuncionario(matriculaFuncionario);
            comandanteNovo.setIdAeronautica(idAeronautica);
            
            comandanteController.alterar(comandanteAntigo, comandanteNovo);

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