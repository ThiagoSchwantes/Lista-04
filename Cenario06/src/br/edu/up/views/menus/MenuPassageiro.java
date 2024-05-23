package br.edu.up.views.menus;

import br.edu.up.controller.AeronaveController;
import br.edu.up.controller.PassageiroController;
import br.edu.up.controller.PassagemController;
import br.edu.up.models.Aeronave;
import br.edu.up.models.Passagem;
import br.edu.up.models.pessoas.Passageiro;
import br.edu.up.utils.Prompt;

public class MenuPassageiro {
    protected PassageiroController passageiroController = new PassageiroController();
    protected PassagemController passagemController = new PassagemController();

    public void mostrar(AeronaveController controllerAeronave){
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
                cadastrar(controllerAeronave);
                break;
            case 2:
                listar();
                break;
            case 3:
                alterar(controllerAeronave);
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
            mostrar(controllerAeronave);
        }
    }

    public void cadastrar(AeronaveController controllerAeronave){
        if (!controllerAeronave.listar().equals("")) {
            Prompt.separador();
            Prompt.imprimir("CADASTRAR PASSAGEIRO");
            Prompt.separador();

            String nome = Prompt.lerLinha("Digite o seu nome:");
            String rg = Prompt.lerLinha("Digite o seu rg");

            Passageiro passageiroCadastrado = new Passageiro(nome, rg);

            boolean achado = false;
            do {
                Prompt.clearConsole();
                Prompt.imprimir("LISTA DE AVIÕES:");
                Prompt.separador();

                Prompt.imprimir(controllerAeronave.listar());
                int opcao = Prompt.lerInteiro("Digite o código do avião ao qual vai viajar");
                Prompt.separador();

                Aeronave aeronaveEscolhida = controllerAeronave.buscar(opcao);

                if(aeronaveEscolhida == null){
                    Prompt.imprimir("Valor digitado incorreto! Digite corretamente!");
                    Prompt.pressionarEnter();
                }else{
                    achado = true;
                    passageiroCadastrado.setAeronave(aeronaveEscolhida);
                }
            } while (achado != true);

            Prompt.clearConsole();
            Prompt.separador();
            Prompt.imprimir("EMITIR SUA PASSAGEM:");
            Prompt.separador();

            Integer numeroAcento = Prompt.lerInteiro("Digite o numero do acento que deseja centar!");
            String classe = Prompt.lerLinha("Digite em qual classe você vai centar");
            String data = Prompt.lerLinha("Digite a data do voo:");

            Passagem passagem = new Passagem(numeroAcento, classe, data);
            passageiroCadastrado.setPassagem(passagem);
            
            passagemController.adicionar(passagem);
            passageiroController.adicionar(passageiroCadastrado);

            Prompt.separador();
            Prompt.imprimir("PASSAGEIRO CADASTRADO\n" + passageiroCadastrado.toString());
            Prompt.separador();
        }else{
            Prompt.separador();
            Prompt.imprimir("Não é possível cadastrar nenhuma Pessoa ainda! Não possui nenhuma aeronave cadastrada");
            Prompt.separador();
        }
    }

    public void listar(){
        Prompt.separador();
        Prompt.imprimir("LISTAR PASSAGEIROS");
        Prompt.separador();

        Prompt.imprimir(passageiroController.listar());
    }

    public void alterar(AeronaveController controllerAeronave){

        Prompt.separador();
        Prompt.imprimir("ALTERAR PASSAGEIRO");
        Prompt.separador();

        String rgAntigo = Prompt.lerLinha("Digite o rg do passageiro que deseja alterar:");
        Passageiro passageiroAntigo = passageiroController.buscar(rgAntigo);

        if (passageiroAntigo == null) {
            Prompt.separador();
            Prompt.imprimir("Não foi achado nenhum passageiro com este rg!");
            Prompt.separador();
        }else{
            String nomeAlterar = Prompt.lerLinha("Digite o novo nome do passageiro:");
            String rgAlterar = Prompt.lerLinha("Digite o seu rg");

            Passageiro passageiroNovo = passageiroAntigo;
            passageiroNovo.setNome(nomeAlterar);
            passageiroNovo.setRg(rgAlterar);

            boolean achado = false;
            do {
                Prompt.clearConsole();
                Prompt.imprimir("LISTA DE AVIÕES:");
                Prompt.separador();

                Prompt.imprimir(controllerAeronave.listar());
                int opcao = Prompt.lerInteiro("Digite o código do avião ao qual vai viajar");
                Prompt.separador();

                Aeronave aeronaveEscolhida = controllerAeronave.buscar(opcao);

                if(aeronaveEscolhida == null){
                    Prompt.imprimir("Valor digitado incorreto! Digite corretamente!");
                    Prompt.pressionarEnter();
                }else{
                    achado = true;
                    passageiroNovo.setAeronave(aeronaveEscolhida);
                }
            } while (achado != true);

            Prompt.clearConsole();
            Prompt.separador();
            Prompt.imprimir("EMITIR SUA PASSAGEM:");
            Prompt.separador();

            Integer numeroAcento = Prompt.lerInteiro("Digite o numero do acento que deseja centar!");
            String classe = Prompt.lerLinha("Digite em qual classe você vai centar");
            String data = Prompt.lerLinha("Digite a data do voo:");

            Passagem passagemNova = new Passagem(numeroAcento, classe, data);
            
            passagemController.alterar(passageiroAntigo.getPassagem(), passagemNova);
            
            passageiroNovo.setPassagem(passagemNova);

            passagemController.deletar(passageiroAntigo.getPassagem());
            passagemController.adicionar(passagemNova);
            passageiroController.alterar(passageiroAntigo, passageiroNovo);

            Prompt.separador();
            Prompt.imprimir("PASSAGEIRO CADASTRADO\n" + passageiroNovo.toString());
            Prompt.separador();

            passageiroController.alterar(passageiroAntigo, passageiroNovo);

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
            passagemController.deletar(passageiroDeletar.getPassagem());
            passageiroController.deletar(passageiroDeletar);

            Prompt.separador();
            Prompt.imprimir("Passageiro deletado com sucesso!");
            Prompt.separador();
        }
    }
}