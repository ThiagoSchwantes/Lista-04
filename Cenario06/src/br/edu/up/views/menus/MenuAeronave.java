package br.edu.up.views.menus;

import br.edu.up.controller.AeronaveController;
import br.edu.up.models.Aeronave;
import br.edu.up.utils.Prompt;

public class MenuAeronave {
    protected AeronaveController aeronaveController = new AeronaveController();

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

        String tipo = Prompt.lerLinha("Digite o tipo do avião:");
        Integer quantidadeAcentos = Prompt.lerInteiro("Digite a quantidade de acentos");

        Aeronave aeronave = new Aeronave(tipo, quantidadeAcentos);

        aeronaveController.adicionar(aeronave);

        Prompt.separador();
        Prompt.imprimir("AERONAVE CADASTRADA\n" + aeronave.toString());
        Prompt.separador();
    }
    
    public void listar(){
        Prompt.separador();
        Prompt.imprimir("LISTAR AERONAVE");
        Prompt.separador();

        if(!aeronaveController.listar().equals("")){
            Prompt.imprimir(aeronaveController.listar());
        }else{
           Prompt.imprimir("Nada cadastrado");
           Prompt.separador();
        }
    }

    public void alterar(){
        Prompt.separador();
        Prompt.imprimir("ALTERAR AERONAVE");
        Prompt.separador();

        Prompt.imprimir(aeronaveController.listar());

        Integer codigo = Prompt.lerInteiro("\nDigite o código do avião que deseja alterar:");
        Aeronave aeronaveAntiga = aeronaveController.buscar(codigo);

        if (aeronaveAntiga == null) {
            Prompt.separador();
            Prompt.imprimir("Não foi achado nenhuma aeronave com este código!");
            Prompt.separador();
        }else{
            String tipo = Prompt.lerLinha("Digite o novo tipo do avião:");
            Integer quantidadeAcentos = Prompt.lerInteiro("Digite a nova quantidade de acentos");

            Aeronave aeronave = aeronaveAntiga;
            aeronave.setQuantidadeAssentos(quantidadeAcentos);
            aeronave.setTipo(tipo);
            
            aeronaveController.alterar(aeronaveAntiga, aeronave);

            Prompt.separador();
            Prompt.imprimir("Aeronave alterada com suscesso!");
            Prompt.separador();
        }
    }

    public void deletar(){
        Prompt.separador();
        Prompt.imprimir("DELETAR AERONAVE");
        Prompt.separador();

        if(!aeronaveController.listar().equals("")){
            Prompt.imprimir(aeronaveController.listar());

            Integer codigo = Prompt.lerInteiro("\nDigite o código do avião que deseja deletar:");
            Aeronave aeronave = aeronaveController.buscar(codigo);

            if (aeronave == null) {
                Prompt.separador();
                Prompt.imprimir("Aeronave não encontrada!");
                Prompt.separador();
            }else{
                aeronaveController.deletar(aeronave);

                Prompt.separador();
                Prompt.imprimir("Aeronave deletada com sucesso!");
                Prompt.separador();
            }
        }else{
           Prompt.imprimir("Nada cadastrado");
           Prompt.separador();
           Prompt.pressionarEnter();
        }
    }
}