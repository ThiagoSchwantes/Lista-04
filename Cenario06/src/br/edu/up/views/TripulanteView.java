package br.edu.up.views;

import br.edu.up.models.Pessoa.Tripulante.Comandante;
import br.edu.up.models.Pessoa.Tripulante.Tripulante;
import br.edu.up.utils.Prompt;

public class TripulanteView {
    public void menuComandante(){
        
        Prompt.separador();
        Prompt.imprimir("MENU COMANDANTE:");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Cadastrar");
        Prompt.imprimir("\t2 - Listar");
        Prompt.imprimir("\t3 - Alterar");
        Prompt.imprimir("\t4 - Deletar");
        Prompt.imprimir("\t5 - Voltar ao menu principal");

        int opcao = Prompt.lerInteiro("Digite uma opção:");

        switch (opcao) {
            case 1:

                break;
        
            default:
                break;
        }
    }

    public void cadastrarComandante(){
        Tripulante comandante = new Comandante();

        String nome = Prompt.lerLinha("Digite o seu nome:");
        String rg = Prompt.lerLinha("Digite o seu RG:");

        
    }


        
}
