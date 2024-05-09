package br.edu.up.views;
import br.edu.up.utils.*;

public class Menu {

    public void menuPrincipal(){

        Prompt.separador();
        Prompt.imprimir("MENU PRINCIPAL");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Incluir contato pessoal");
        Prompt.imprimir("\t1 - Incluir um contato comercial");
        Prompt.imprimir("\t3 - Excluir um contato pelo código");
        Prompt.imprimir("\t4 - Consultar um contato pelo código");
        Prompt.imprimir("\t5 - Listar todos os contatos");
        Prompt.imprimir("\t6 - Sair do programa ");

        int opcao1 = Prompt.lerInteiro("Digite aqui: ");

        switch (opcao1) {
            case 1:
                //incluirContatoPessoal();
                break;
            case 2:
                //incluirContatoComercial();
                break;
            case 3:
                //excluirContato();
                break;
            case 4:
                //consultarContato();
                break;
            case 5:
                //listarContatos();
                break;
            case 6:
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
        System.exit(3);
    }
    
}
