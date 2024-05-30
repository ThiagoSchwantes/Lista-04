package br.edu.up.views;
import java.util.Scanner;

import br.edu.up.controllers.AgendaController;
import br.edu.up.modelos.*;
import br.edu.up.modelos.contatos.Comercial;
import br.edu.up.modelos.contatos.Pessoal;
import br.edu.up.utils.*;

public class Menu {

    AgendaController agendaController = new AgendaController();

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
        Prompt.clearConsole();
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
        Prompt.clearConsole();

        switch (opcao1) {
            case 1:
                incluirContatoPessoal();
                break;
            case 2:
                incluirContatoComercial();
                break;
            case 3:
                excluirContato();
                break;
            case 4:
                consultarContato();
                break;
            case 5:
                listarTodosContatos();
                break;
            case 6:
                encerrarPrograma();
                break;
            default:
                Prompt.imprimir("Valor Inválido.");
                break;
        }

        Prompt.pressionarEnter();
        Prompt.clearConsole();
        menuPrincipal();
    }

    public void incluirContatoPessoal(){
        Prompt.separador();
        Prompt.imprimir("INCLUIR CONTATO PESSOAL");
        Prompt.separador();

        String nome = Prompt.lerLinha("Informe o nome do contato: ");
        String telefone = Prompt.lerLinha("Informe o telefone do contato: ");
        String aniversario = Prompt.lerLinha("Informe o aniversário do contato: ");

        Pessoal contatoPessoal = agendaController.incluirContatoPessoal(nome, telefone, aniversario);

        Prompt.separador();
        Prompt.imprimir("Contato incluido com sucesso!");
        Prompt.imprimir(contatoPessoal);
        Prompt.separador();
    }

    public void incluirContatoComercial(){
        Prompt.separador();
        Prompt.imprimir("INCLUIR CONTATO COMERCIAL");
        Prompt.separador();

        String nome = Prompt.lerLinha("Informe o nome do contato: ");
        String telefone = Prompt.lerLinha("Informe o telefone do contato: ");
        String cnpj = Prompt.lerLinha("Informe o CNPJ do contato: ");

        Comercial contatoComercial = agendaController.incluirContatoComercial(nome, telefone, cnpj);

        Prompt.separador();
        Prompt.imprimir("Contato incluido com sucesso!");
        Prompt.imprimir(contatoComercial);
        Prompt.separador();
    }

    public void excluirContato(){
        Prompt.separador();
        Prompt.imprimir("EXCLUIR UM CONTATO PELO CÓDIGO");
        Prompt.separador();
        
        int codigo = Prompt.lerInteiro("Informe o código do contato que deseja excluir:");
        
        if(agendaController.excluirContato(codigo)){
            Prompt.separador();
            Prompt.imprimir("Exclusão realizada com sucesso.");
            Prompt.separador();
        }else{
            Prompt.separador();
            Prompt.imprimir("erro ao excluir contato.");
            Prompt.separador();
        }
    }

    public void consultarContato(){
        Prompt.separador();
        Prompt.imprimir("CONSULTAR UM CONTATO PELO CÓDIGO");
        Prompt.separador();

        int codigo = Prompt.lerInteiro("Informe o código do contato: ");

        Contato contato = agendaController.consultarContato(codigo);

        if (contato == null) {
            Prompt.separador();
            Prompt.imprimir("Nenhum contato econtrado com esse código!");
            Prompt.separador();
        }else{
            Prompt.separador();
            Prompt.imprimir(contato);
            Prompt.separador();
        }
        
    }

    public void listarTodosContatos(){
        Prompt.separador();
        Prompt.imprimir("LISTAR TODOS CONTATOS");
        Prompt.separador();


        if(agendaController.listarContatos().equals("")){
            Prompt.imprimir("Nenhum Contato cadastrato!");
        }else{
            Prompt.imprimir(agendaController.listarContatos());
        }
        Prompt.separador();
    }

    public void encerrarPrograma(){
        Prompt.imprimir("Encerrando o programa...");
        System.exit(6);
    }
}
