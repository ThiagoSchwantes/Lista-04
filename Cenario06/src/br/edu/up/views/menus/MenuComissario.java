package br.edu.up.views.menus;

import br.edu.up.controller.ComissarioController;
import br.edu.up.models.Aeronave;
import br.edu.up.models.pessoas.tripulantes.Comissario;
import br.edu.up.utils.Prompt;

public class MenuComissario {
    ComissarioController comissarioController = new ComissarioController();
    
    public void mostrar(MenuAeronave menuAeronave){
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

                menuAeronave.aeronaveController.listar();

                Prompt.separador();
                int opcao = Prompt.lerInteiro("Em qual avião o comissario vai estar?");
                Prompt.separador();

                Aeronave aeronaveEscolhida = menuAeronave.aeronaveController.buscar(opcao);

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
            Prompt.imprimir("Não é possível cadastrar nenhuma Pessoa ainda! Não possui nenhuma aeronave cadastrada");
        }
    }

    public void listar(){
        Prompt.separador();
        Prompt.imprimir("LISTAR COMISSARIOS");
        Prompt.separador();

        Prompt.imprimir(comissarioController.listar());
    }

    public void alterar(){
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
            
            Comissario comissarioNovo = comissarioAntigo;
            //alterar o comissario e salvar
            comissarioNovo.setNome(nomeAlterar);
            comissarioNovo.setRg(rgAlterar);
            comissarioNovo.setMatriculaFuncionario(matriculaFuncionario);
            comissarioNovo.setIdAeronautica(idAeronauticaAlterar);
            comissarioNovo.setIdiomas(idiomas);
                
            comissarioController.alterar(comissarioAntigo, comissarioNovo);
    
            Prompt.separador();
            Prompt.imprimir("Comissario alterado com suscesso!");
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