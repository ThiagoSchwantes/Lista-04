package br.edu.up.views;
import br.edu.up.utils.*;

public class Menu {
    
    public void menuPrincipal(){

        Prompt.separador();
        Prompt.imprimir("MENU PRINCIPAL");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Incluir cliente pessoa");
        Prompt.imprimir("\t2 - Incluir cliente empresa");
        Prompt.imprimir("\t3 - Mostrar dados cliente pessoa");
        Prompt.imprimir("\t4 - Mostrar dados cliente empresa");
        Prompt.imprimir("\t5 - Emprestar para cliente pessoa");
        Prompt.imprimir("\t6 - Emprestar para cliente empresa");
        Prompt.imprimir("\t7 - Devolução de cliente pessoa");
        Prompt.imprimir("\t8 - Devolução de cliente empresa");
        Prompt.imprimir("\t6 - Sair");

        int opcao1 = Prompt.lerInteiro("Digite aqui: ");

        switch (opcao1) {
            case 1:
                //incluirClientePessoa();
                break;
            case 2:
                //incluirClienteEmpresa();
                break;
            case 3:
                //mostrarClientePessoa();
                break;
            case 4:
                //mostrarClienteEmpresa();
                break;
            case 5:
                //emprestarClientePessoa();
                break;
            case 6:
                //emprestarClienteEmpresa();
                break;
            case 7:
                //devolucaoClientePessoa();
                break;
            case 8:
                //devolucaoClienteEmpresa();
                break;
            case 9:
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
        System.exit(9);
    }
}
