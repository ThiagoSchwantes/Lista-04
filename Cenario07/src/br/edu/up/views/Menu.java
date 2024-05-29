package br.edu.up.views;
import java.util.Scanner;

import br.edu.up.utils.*;
import br.edu.up.controllers.*;
import br.edu.up.models.Competencia;
import br.edu.up.models.Disciplina;
import br.edu.up.models.pessoas.Aluno;
import br.edu.up.models.pessoas.Professor;
import br.edu.up.models.pessoas.Titulacao;

public class Menu {
    
    ControleDeAluno controleAluno = new ControleDeAluno();

    public Aluno incluirAluno(){

        String nome = Prompt.lerLinha("Informe o nome do aluno: ");
        String rg = Prompt.lerLinha("Informe o rg do aluno: ");
        String matricula = Prompt.lerLinha("Informe a matricula do aluno: ");
        int anoIngresso = Prompt.lerInteiro("Informe o ano de ingresso na instituição: ");
        String curso = Prompt.lerLinha("Informe o nome do curso do aluno: ");
        String turno = Prompt.lerLinha("Informe o turno do aluno: ");

        Aluno aluno = new Aluno(nome,rg,matricula,anoIngresso,curso,turno);

        controleAluno.incluirAluno(aluno);

        return aluno;
    }
    ControleDeProfessor controleProfessor = new ControleDeProfessor();
    
    public Professor incluirProfessor(){
        String nome = Prompt.lerLinha("Informe o nome do professor: ");
        String rg = Prompt.lerLinha("Informe o rg do professor: ");
        String matricula = Prompt.lerLinha("Informe a matricula do professor: ");

        int lattesId = Prompt.lerInteiro("Informe o id do seu currículo Lattes: ");

        String nomeInstituicao = Prompt.lerLinha("Informe o nome da instituição da sua titulação: ");
        int anoConclusao = Prompt.lerInteiro("Informe o ano de conclusão da sua titulação: ");
        String nomeTitulo = Prompt.lerLinha("Informe o nome do titulo da titulação: ");
        String tituloTrabalho = Prompt.lerLinha("Informe o titulo do trabalho de conclusão da titulação: ");

        Titulacao titulacao = new Titulacao(nomeInstituicao,anoConclusao,nomeTitulo,tituloTrabalho);
        Professor professor = new Professor(nome,rg,matricula,lattesId,titulacao);

        return professor;
    }

    ControleDeDisciplina controleDisciplina = new ControleDeDisciplina();
    public Disciplina incluirDisciplina(){
        //adiciona nome e id 
        String nomeDisciplina = Prompt.lerLinha("Informe o nome da disciplina: ");
        int idDisciplina = Prompt.lerInteiro("Informe o id da disciplina: ");
        //adiciona competencia necessarias 
        Competencia[] competenciasNecessarias = new Competencia[0];
        
        boolean continuar = true;
        do{
            Competencia competencia = new Competencia(Prompt.lerLinha("Informe uma competencia necessaria: "));

            //adicionar compentencia necessária
            Competencia[] aux = new Competencia[competenciasNecessarias.length + 1];
            System.arraycopy(competenciasNecessarias, 0, aux, 0, competenciasNecessarias.length);
            aux[competenciasNecessarias.length] = competencia;
            competenciasNecessarias = aux;

            do{
                System.out.print("Deseja adicionar outra competência necessária? (s/n): ");
                char input = scanner.next().charAt(0);

                if(input == 'n'){
                    continuar = false;
                    break;
                }else if(input == 's'){
                    break;
                }else{
                    Prompt.imprimir("Erro! Digitado incorreto digite novamente!");
                }

            }while(true);
        }while(continuar);

        //adiciona competencia complementar
        Competencia[] competenciasComplementares = new  Competencia[0];
        continuar = true;
        do{
            Competencia competencia = new Competencia(Prompt.lerLinha("Informe uma competencia complementar: "));

            //adicionar compentencia complementar
            Competencia[] aux = new Competencia[competenciasComplementares.length + 1];
            System.arraycopy(competenciasComplementares, 0, aux, 0, competenciasComplementares.length);
            aux[competenciasComplementares.length] = competencia;
            competenciasComplementares = aux;

            do{
                System.out.print("Deseja adicionar outra competência complementar? (s/n): ");
                char input = scanner.next().charAt(0);

                if(input == 'n'){
                    continuar = false;
                    break;
                }else if(input == 's'){
                    break;
                }else{
                    Prompt.imprimir("Erro! Digitado incorreto digite novamente!");
                }

            }while(true);
        }while (continuar);
        
        //adiciona professor
        Professor[] professoresDisponiveis = controleProfessor.getProfessores();
        Prompt.separador();
        Prompt.imprimir("Professores disponíveis:");
        for (int i = 0; i < professoresDisponiveis.length; i++) {
            Professor professor = professoresDisponiveis[i];
            Prompt.imprimir((i + 1) + ". " + professor.getNome());
        }
        int opcaoProfessor = Prompt.lerInteiro("Selecione o professor desejado: ");
        if (opcaoProfessor < 1 || opcaoProfessor > professoresDisponiveis.length) {
            Prompt.imprimir("Opção inválida.");
            return null;
        }
        Professor professorSelecionado = professoresDisponiveis[opcaoProfessor - 1];
        //adicionar alunos
        Aluno[] alunosMatriculado = new Aluno[0];
        boolean adicionarMaisAlunos = true;
        while (adicionarMaisAlunos) {
            Aluno[] alunosDisponiveis = controleAluno.getAlunos();

            Prompt.separador();
            Prompt.imprimir("Alunos disponíveis:");
            for (int i = 0; i < alunosDisponiveis.length; i++) {
                Aluno aluno = alunosDisponiveis[i];
                Prompt.imprimir((i + 1) + ". " + aluno.getNome());
            }
            int opcaoAluno = Prompt.lerInteiro("Selecione o aluno desejado: ");
            if (opcaoAluno < 1 || opcaoAluno > alunosDisponiveis.length) {
                Prompt.imprimir("Opção inválida.");
                return null;
            }
            Aluno alunoSelecionado = alunosDisponiveis[opcaoAluno - 1];


            //adicionar compentencia necessária
            Aluno[] aux = new Aluno[alunosMatriculado.length + 1];
            System.arraycopy(alunosMatriculado, 0, aux, 0, alunosMatriculado.length);
            aux[alunosMatriculado.length] = alunoSelecionado;
            alunosMatriculado = aux;

            System.out.print("Deseja adicionar outro aluno? (true/false): ");
            String input = scanner.nextLine();
            adicionarMaisAlunos = Boolean.parseBoolean(input);
        }
        Disciplina disciplina = new Disciplina(nomeDisciplina, idDisciplina, competenciasNecessarias, competenciasComplementares, professorSelecionado, alunosMatriculado);

        return disciplina;
        
    }

    public void gerenciarCompetencias(){
        Disciplina[] disciplinasDisponiveis = controleDisciplina.getDisciplinas();
        Prompt.separador();
        Prompt.imprimir("Disciplinas disponíveis:");
        for (int i = 0; i < disciplinasDisponiveis.length; i++) {
            Disciplina disciplina = disciplinasDisponiveis[i];
            Prompt.imprimir((i + 1) + ". " + disciplina.getNome());
        }
        int opcaoDisciplina = Prompt.lerInteiro("Selecione a disciplina desejada: ");
        if (opcaoDisciplina < 1 || opcaoDisciplina > disciplinasDisponiveis.length) {
            Prompt.imprimir("Opção inválida.");
        }
        Disciplina disciplinaSelecionada = disciplinasDisponiveis[opcaoDisciplina - 1];
        Aluno[] alunosDisciplina = disciplinaSelecionada.getAlunosMatriculados();
        int aptoNecessarias = 0;
        int aptoComplementares = 0;
        for(int i = 0; i < alunosDisciplina.length; i++){
            Aluno aluno = alunosDisciplina[i];
            Competencia[] competenciaNecessaria = disciplinaSelecionada.getCompetenciasNecessarias();
            for(int j = 0; j < competenciaNecessaria.length; j++){
                Competencia competencia = competenciaNecessaria[j];
                char resultado = Prompt.lerCaractere("O aluno " + aluno.getNome() + " possui a competência " + competencia.getNome() + " (s/n): ");
                if(resultado == 's'){
                    aptoNecessarias++;
                }
            }
            Competencia[] competenciaComplementares = disciplinaSelecionada.getCompetenciasComplementares();
            for(int j = 0; j < competenciaComplementares.length; j++){
                Competencia competencia = competenciaComplementares[j];
                char resultado = Prompt.lerCaractere("O aluno " + aluno.getNome() + " possui a competência " + competencia.getNome() + " (s/n): ");
                if(resultado == 's'){
                    aptoComplementares++;
                }
            }
            int mediaNecessarias = competenciaNecessaria.length / 2;
            int mediaComplementar = competenciaComplementares.length / 2;

            if(aptoNecessarias == competenciaNecessaria.length && aptoComplementares >= mediaComplementar){
                Prompt.imprimir("Aluno aprovado.");
                aluno.setEstaAprovado("Aprovado");
            }else if(aptoNecessarias < mediaNecessarias || aptoComplementares < mediaComplementar){
                Prompt.imprimir("Aluno reprovado.");
                aluno.setEstaAprovado("Reprovado");
            }else{
                Prompt.imprimir("Aluno pendente.");
                aluno.setEstaAprovado("Pendente");
            }
            
        }
    }
    Scanner scanner = new Scanner(System.in);

    public void menuPrincipal(){

        Prompt.separador();
        Prompt.imprimir("MENU PRINCIPAL");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Incluir Professor.");
        Prompt.imprimir("\t2 - Incluir Aluno.");
        Prompt.imprimir("\t3 - Incluir Disciplina.");
        Prompt.imprimir("\t4 - Gerenciamento de competências.");
        Prompt.imprimir("\t5 - Fechar Programa\n");

        int opcao1 = Prompt.lerInteiro("Digite aqui: ");

        switch (opcao1) {
            case 1:
                Professor professor = incluirProfessor();
                Prompt.separador();
                Prompt.imprimir("Cadastro do professor realizado com sucesso.");
                Prompt.imprimir(professor);
                Prompt.separador();
                continuar();
                break;
            case 2:
                Aluno aluno = incluirAluno();
                Prompt.separador();
                Prompt.imprimir("Cadastro do aluno realizado com sucesso.");
                Prompt.imprimir(aluno);
                Prompt.separador();
                continuar();
                break;
            case 3:
                Disciplina disciplina = incluirDisciplina();
                Prompt.separador();
                Prompt.imprimir("Cadastro de disciplina realizado com sucesso.");
                Prompt.imprimir(disciplina);
                Prompt.separador();
                continuar();
                break;
            case 4:
                gerenciarCompetencias();
                Prompt.separador();
                continuar();
                break;
            case 5:
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
        System.exit(5);
    }

    public void continuar(){
        Prompt.imprimir("Pressione qualquer tecla para continuar...");
        scanner.nextLine();
        menuPrincipal();
    }

    
}
