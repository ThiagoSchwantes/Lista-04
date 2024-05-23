package br.edu.up.views.menus;

import br.edu.up.controller.AeronaveController;
import br.edu.up.controller.ComissarioController;
import br.edu.up.models.Aeronave;
import br.edu.up.models.pessoa.tripulantes.Comissario;
import br.edu.up.utils.Prompt;

public class MenuComissario {
    ComissarioController comissarioController = new ComissarioController();
    
    public void mostrar(AeronaveController aeronaveController){
        boolean sair = false;

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

        switch (opcao) {
            case 1:
                cadastrar(aeronaveController);
                break;
            case 2:
                listar();
                break;
            case 3:
                alterar(aeronaveController);
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
            mostrar(aeronaveController);
        }
    }

    public void cadastrar(AeronaveController aeronaveController){
        if (!aeronaveController.listar().equals("")) {
            Prompt.separador();
            Prompt.imprimir("CADASTRAR COMISSÁRIO");
            Prompt.separador();

            String nome = Prompt.lerLinha("Digite o seu nome:");
            String rg = Prompt.lerLinha("Digite o seu rg");

            String matriculaFuncionario = Prompt.lerLinha("Digite a mátricula de Funcionário:");
            String idAeronautica = Prompt.lerLinha("Digite a sua identificação de aernoáutica:");

            Prompt.clearConsole();
            Prompt.separador();
            Prompt.imprimir("IDIOMAS DO COMISSÁRIO");
            Prompt.separador();

            String[] idiomas = new String[1];

            idiomas[0]  =  Prompt.lerLinha("Digite o seu idioma nativo:");

            boolean repetir = false;
            do {
                Prompt.separador(); 
                Character opcao = Prompt.lerCaractere("Deseja adicionar mais algum idioma? (S/N)");

                if (Character.toLowerCase(opcao) == 's') {
                    repetir = true;
                    
                    String[] idiomasAux = new String[idiomas.length+1];
                    System.arraycopy(idiomas, 0, idiomasAux, 0, idiomas.length);

                    idiomasAux[idiomas.length] = Prompt.lerLinha("Digite seu outro idioma:");
                    
                    idiomas = new String[idiomas.length + 1];
                    idiomas = idiomasAux;
                    
                }else if(Character.toLowerCase(opcao) != 'n'){
                    Prompt.imprimir("Erro, digite uma das opções!");
                    repetir = true;
                }else{
                    repetir = false;
                } 
                        
            } while (repetir);     

            Comissario comissario = new Comissario(nome, rg, matriculaFuncionario, idAeronautica, idiomas);
            
            boolean achado = false;
            do {
                Prompt.clearConsole();
                Prompt.imprimir("LISTA DE AVIÕES:");
                Prompt.separador();

                Prompt.imprimir(aeronaveController.listar());

                Prompt.separador();
                int opcao = Prompt.lerInteiro("Digite o código do avião ao qual vai estar");
                Prompt.separador();

                Aeronave aeronaveEscolhida = aeronaveController.buscar(opcao);

                if(aeronaveEscolhida == null){
                    Prompt.imprimir("Valor digitado incorreto! Digite corretamente!");
                    Prompt.pressionarEnter();
                }else{
                    achado = true;
                    comissario.setAeronave(aeronaveEscolhida);
                }
            } while (achado != true);

            comissarioController.adicionar(comissario);

            Prompt.clearConsole();
            Prompt.separador();
            Prompt.imprimir("COMISSARIO CADASTRADO COM SUCESSO!\n" + comissario.toString());
            Prompt.separador();
        }else{
            Prompt.separador();
            Prompt.imprimir("Não é possível cadastrar nenhuma Pessoa ainda! Não possui nenhuma aeronave cadastrada");
            Prompt.separador();
        }
    }

    public void listar(){
        Prompt.separador();
        Prompt.imprimir("LISTAR COMISSARIOS");
        Prompt.separador();

        Prompt.imprimir(comissarioController.listar());
    }

    public void alterar(AeronaveController aeronaveController){
        //menu de busca de comissario
        Prompt.separador();
        Prompt.imprimir("ALTERAR COMISSARIO");
        Prompt.separador();

        String matriculaFuncionario = Prompt.lerLinha("Digite a Matrícula de Funcionário do comissário que deseja alterar:");
        Comissario comissarioAntigo = comissarioController.buscar(matriculaFuncionario);

        if (comissarioAntigo == null) {
            Prompt.separador();
            Prompt.imprimir("Não foi achado nenhum comissario com esta matricula!");
            Prompt.separador();
        }else{
            //menu de alteracao dos dados do comissario
            Prompt.clearConsole();
            Prompt.separador();
            Prompt.imprimir("ALTERAR COMISSÁRIO");
            Prompt.separador();
            
            String nomeAlterar = Prompt.lerLinha("Digite o novo nome:");
            String rgAlterar = Prompt.lerLinha("Digite o novo rg");
            matriculaFuncionario = Prompt.lerLinha("Digite a nova mátricula de Funcionário:");
            String idAeronauticaAlterar = Prompt.lerLinha("Digite a nova identificação de aernoáutica:");

            //menu de adicionar novos idiomas do comissario
            String[] idiomas = new String[1];

            Prompt.clearConsole();
            Prompt.separador();
            Prompt.imprimir("ALTERAR IDIOMAS DO COMISSÁRIO");
            Prompt.separador();

            
            idiomas[0] = Prompt.lerLinha("Digite o seu idioma nativo:");

            boolean repetir = false;

            do {
                Prompt.separador();  
                Character opcao = Prompt.lerCaractere("Deseja adicionar mais algum idioma? (S/N)");
                
                if (Character.toLowerCase(opcao) == 's') {
                    repetir = true;

                    String[] idiomasAux = new String[idiomas.length+1];
                    System.arraycopy(idiomas, 0, idiomasAux, 0, idiomas.length);

                    idiomasAux[idiomas.length] = Prompt.lerLinha("Digite seu outro idioma:");
                    idiomas = new String[idiomas.length + 1];
                    idiomas = idiomasAux;
                }else if(Character.toLowerCase(opcao) != 'n'){
                    Prompt.imprimir("Erro, digite uma das opções!");
                    repetir = true;
                }else{
                    repetir = false;
                }     
            } while (repetir);

             //alterar o comissario
             Comissario comissarioNovo = comissarioAntigo;

             comissarioNovo.setNome(nomeAlterar);
             comissarioNovo.setRg(rgAlterar);
             comissarioNovo.setMatriculaFuncionario(matriculaFuncionario);
             comissarioNovo.setIdAeronautica(idAeronauticaAlterar);
             comissarioNovo.setIdiomas(idiomas);
                 

            boolean achado = false;
            do {
                Prompt.clearConsole();
                Prompt.imprimir("LISTA DE AVIÕES:");
                Prompt.separador();

                Prompt.imprimir(aeronaveController.listar());
                int opcao = Prompt.lerInteiro("Digite o código do avião ao qual vai estar:");
                Prompt.separador();

                Aeronave aeronaveEscolhida = aeronaveController.buscar(opcao);

                if(aeronaveEscolhida == null){
                    Prompt.imprimir("Valor digitado incorreto! Digite corretamente!");
                    Prompt.pressionarEnter();
                }else{
                    achado = true;
                    comissarioNovo.setAeronave(aeronaveEscolhida);
                }
            } while (achado != true);            
           
            comissarioController.alterar(comissarioAntigo, comissarioNovo);

            Prompt.clearConsole();
            Prompt.separador();
            Prompt.imprimir("COMISSARIO ALTERADO COM SUCESSO!\n" + comissarioNovo.toString());
            Prompt.separador();
        }
    }

    public void deletar(){
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
    }
}