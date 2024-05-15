package br.edu.up.views.menus;

import br.edu.up.controller.PassageiroController;
import br.edu.up.models.pessoas.Passageiro;
import br.edu.up.utils.Prompt;

public class MenuPassageiro {
    PassageiroController passageiroController = new PassageiroController();

    public void mostrar(){
        boolean sair = false;

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
        Prompt.imprimir("CADASTRAR PASSAGEIRO");
        Prompt.separador();

        String nome = Prompt.lerLinha("Digite o seu nome:");
        String rg = Prompt.lerLinha("Digite o seu rg");

        Passageiro passageiroCadastrado = new Passageiro(nome, rg);

        passageiroController.adicionar(passageiroCadastrado);

        Prompt.separador();
        Prompt.imprimir("PASSAGEIRO CADASTRADO\n" + passageiroCadastrado.toString());
        Prompt.separador();
    }

    public void listar(){
        Prompt.separador();
        Prompt.imprimir("LISTAR PASSAGEIROS");
        Prompt.separador();

        Prompt.imprimir(passageiroController.listar());
    }

    public void alterar(){

        Prompt.separador();
        Prompt.imprimir("ALTERAR PASSAGEIRO");
        Prompt.separador();

        String rgAntigo = Prompt.lerLinha("Digite o rg do passageiro que deseja alterar:");
        Passageiro passageiro = passageiroController.buscar(rgAntigo);

        if (passageiro == null) {
            Prompt.separador();
            Prompt.imprimir("Não foi achado nenhum passageiro com este rg!");
            Prompt.separador();
        }else{
            String nomeAlterar = Prompt.lerLinha("Digite o novo nome do passageiro:");
            String rgAlterar = Prompt.lerLinha("Digite o seu rg");

            passageiro.setNome(nomeAlterar);
            passageiro.setRg(rgAlterar);

            passageiroController.alterar(passageiro);

            Prompt.separador();
            Prompt.imprimir("Passageiro alterado com suscesso!");
            Prompt.separador();
        } 
    }

    public void deletar(){
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
    }
}
