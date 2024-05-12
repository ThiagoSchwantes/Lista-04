package br.edu.up.views;
import java.util.Scanner;

import br.edu.up.utils.*;
import br.edu.up.controllers.*;
import br.edu.up.models.Pessoa.Professor;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    public void menuPrincipal(){

        Prompt.separador();
        Prompt.imprimir("MENU PRINCIPAL");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Incluir Professor.");
        Prompt.imprimir("\t2 - Incluir Aluno.");
        Prompt.imprimir("\t3 - Incluir Disciplina.");
        Prompt.imprimir("\t3 - Fechar Programa\n");

        int opcao1 = Prompt.lerInteiro("Digite aqui: ");

        switch (opcao1) {
            case 1:
                ControleDeProfessor cp = new ControleDeProfessor();
                Professor professor = cp.incluirProfessor();
                Prompt.separador();
                if(professor != null){
                    Prompt.imprimir("Cadastro do professor realizado com sucesso.");
                    Prompt.imprimir(professor);
                }else{
                    Prompt.imprimir("Ocorreu um erro ao cadastrar,Tente novamente.");
                }
                Prompt.separador();
                continuar();
                break;
            case 2:
                //menuReserva();
                break;
            case 3:
                //encerrarPrograma();
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

    public void continuar(){
        Prompt.imprimir("Pressione qualquer tecla para continuar...");
        scanner.nextLine();
        menuPrincipal();
    }
}
