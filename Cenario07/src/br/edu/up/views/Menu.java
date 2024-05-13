package br.edu.up.views;
import java.util.Scanner;

import br.edu.up.utils.*;
import br.edu.up.controllers.*;
import br.edu.up.models.Pessoa.Aluno;
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
        Prompt.imprimir("\t4 - Fechar Programa\n");

        int opcao1 = Prompt.lerInteiro("Digite aqui: ");

        switch (opcao1) {
            case 1:
                ControleDeProfessor cp = new ControleDeProfessor();
                Professor professor = cp.incluirProfessor();
                Prompt.separador();
                Prompt.imprimir("Cadastro do professor realizado com sucesso.");
                Prompt.imprimir(professor);
                Prompt.separador();
                continuar();
                break;
            case 2:
                ControleDeAluno ca = new ControleDeAluno();
                Aluno aluno = ca.incluirAluno();
                Prompt.separador();
                Prompt.imprimir("Cadastro do aluno realizado com sucesso.");
                Prompt.imprimir(aluno);
                Prompt.separador();
                continuar();
                break;
            case 3:
                //incluirDisciplina();
                break;
            case 4:
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
        System.exit(4);
    }

    public void continuar(){
        Prompt.imprimir("Pressione qualquer tecla para continuar...");
        scanner.nextLine();
        menuPrincipal();
    }
}
