package br.edu.up.views;
import java.util.Scanner;

import br.edu.up.controllers.ContatoController;
import br.edu.up.modelos.*;
import br.edu.up.utils.*;

public class Menu {

    Agenda agenda = new Agenda();

    public String getNome(){
        String nome = Prompt.lerLinha("Informe o nome do contato: ");
        return nome;
    }
    public String getTelefone(){
        String telefone = Prompt.lerLinha("Informe o telefone do contato: ");
        return telefone;
    }
    public String getAniversario(){
        String aniversario = Prompt.lerLinha("Informe o aniversário do contato: ");
        return aniversario;
    }
    public String getCnpj(){
        String cnpj = Prompt.lerLinha("Informe o CNPJ do contato: ");
        return cnpj;
    }
    public int getCodigo(){
        int codigo = Prompt.lerInteiro("Informe o código do contato: ");
        return codigo;
    }

    Scanner scanner = new Scanner(System.in);

    public void menuPrincipal(){

        Prompt.separador();
        Prompt.imprimir("MENU PRINCIPAL");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Incluir contato pessoal");
        Prompt.imprimir("\t2 - Incluir um contato comercial");
        Prompt.imprimir("\t3 - Excluir um contato pelo código");
        Prompt.imprimir("\t4 - Consultar um contato pelo código");
        Prompt.imprimir("\t5 - Listar todos os contatos");
        Prompt.imprimir("\t6 - Sair do programa ");

        int opcao1 = Prompt.lerInteiro("Digite aqui: ");

        ContatoController contatoController = new ContatoController();

        switch (opcao1) {
            case 1:
                Pessoal pessoal = contatoController.incluirContatoPessoal(this, agenda);
                Prompt.imprimir(pessoal);
                continuar();
                break;
            case 2:
                Comercial comercial = contatoController.incluirContatoComercial(this, agenda);
                Prompt.imprimir(comercial);
                continuar();
                break;
            case 3:
                if(contatoController.excluirContato(this, agenda)){
                    Prompt.imprimir("Exclusão realizada com sucesso.");
                }else{
                    Prompt.imprimir("erro ao excluir contato.");
                }

                continuar();
                break;
            case 4:
                Contato contato = contatoController.consultarContato(this, agenda);
                Prompt.imprimir(contato);
                continuar();
                break;
            case 5:
                String lista = agenda.listarContatos();
                Prompt.imprimir(lista);
                continuar();
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
        System.exit(6);
    }
    public void continuar(){
        Prompt.imprimir("Pressione qualquer tecla para continuar...");
        scanner.nextLine();
        menuPrincipal();
    }
}
