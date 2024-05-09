package br.edu.up.views;
import br.edu.up.utils.*;

public class Menu {
    
    public void menuPrincipal(){

        Prompt.separador();
        Prompt.imprimir("MENU PRINCIPAL");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Incluir seguro");
        Prompt.imprimir("\t2 - Localizar seguro");
        Prompt.imprimir("\t3 - Excluir seguro");
        Prompt.imprimir("\t4 - Excluir todos os seguros");
        Prompt.imprimir("\t5 - Listar todos os seguros");
        Prompt.imprimir("\t6 - Ver quantidade de seguros");
        Prompt.imprimir("\t7 - Sair");

        int opcao1 = Prompt.lerInteiro("Digite aqui: ");

        switch (opcao1) {
            case 1:
                //incluirSeguro();
                break;
            case 2:
                //localizarSeguro();
                break;
            case 3:
                //excluirSeguro();
                break;
            case 4:
                //excluirTodosOsSeguros();
                break;
            case 5:
                //listarTodosSeguros();
                break;
            case 6:
                //quantidadeSeguros();
                break;
            case 7:
                encerrarPrograma();
                break;
            default:
                Prompt.imprimir("Valor Inválido.");
                menuPrincipal();
                break;
        }
    }

    public void encerrarPrograma(){
        Prompt.imprimir("Encerrando o programa...");
        System.exit(7);
    }
}
