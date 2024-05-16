package br.edu.up.views;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.utils.*;
import br.edu.up.controllers.*;
import br.edu.up.models.Competencia;
import br.edu.up.models.Disciplina;
import br.edu.up.models.Pessoas.Aluno;
import br.edu.up.models.Pessoas.Professor;
import br.edu.up.models.Pessoas.Titulacao;

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
        List<Competencia> competenciasNecessarias = new ArrayList<>();
        boolean adicionarMaisCompetencias = true;
        while (adicionarMaisCompetencias) {
            Competencia competencia = new Competencia(Prompt.lerLinha("Informe uma competencia necessaria: "));
            competenciasNecessarias.add(competencia);

            System.out.print("Deseja adicionar outra competência necessária? (true/false): ");
            String input = scanner.nextLine();
            adicionarMaisCompetencias = Boolean.parseBoolean(input);
        }
        //adiciona competencia complementar
        List<Competencia> competenciasComplementares = new ArrayList<>();
        boolean adicionarMaisCompetencias2 = true;
        while (adicionarMaisCompetencias2) {
            Competencia competencia = new Competencia(Prompt.lerLinha("Informe uma competencia complementar: "));
            competenciasComplementares.add(competencia);

            System.out.print("Deseja adicionar outra competência necessária? (true/false): ");
            String input = scanner.nextLine();
            adicionarMaisCompetencias2 = Boolean.parseBoolean(input);
        }
        //adiciona professor
        List<Professor> professoresDisponiveis = controleProfessor.getProfessores();
        Prompt.separador();
        Prompt.imprimir("Professores disponíveis:");
        for (int i = 0; i < professoresDisponiveis.size(); i++) {
            Professor professor = professoresDisponiveis.get(i);
            Prompt.imprimir((i + 1) + ". " + professor.getNome());
        }
        int opcaoProfessor = Prompt.lerInteiro("Selecione o professor desejado: ");
        if (opcaoProfessor < 1 || opcaoProfessor > professoresDisponiveis.size()) {
            Prompt.imprimir("Opção inválida.");
            return null;
        }
        Professor professorSelecionado = professoresDisponiveis.get(opcaoProfessor - 1);
        //adicionar alunos
        List<Aluno> alunoMatriculado = new ArrayList<>();
        boolean adicionarMaisAlunos = true;
        while (adicionarMaisAlunos) {
            List<Aluno> alunosDisponiveis = controleAluno.getAlunos();
            Prompt.separador();
            Prompt.imprimir("Alunos disponíveis:");
            for (int i = 0; i < alunosDisponiveis.size(); i++) {
                Aluno aluno = alunosDisponiveis.get(i);
                Prompt.imprimir((i + 1) + ". " + aluno.getNome());
            }
            int opcaoAluno = Prompt.lerInteiro("Selecione o aluno desejado: ");
            if (opcaoAluno < 1 || opcaoAluno > alunosDisponiveis.size()) {
                Prompt.imprimir("Opção inválida.");
                return null;
            }
            Aluno alunoSelecionado = alunosDisponiveis.get(opcaoAluno - 1);
            alunoMatriculado.add(alunoSelecionado);
            System.out.print("Deseja adicionar outro aluno? (true/false): ");
            String input = scanner.nextLine();
            adicionarMaisAlunos = Boolean.parseBoolean(input);
        }
        Disciplina disciplina = new Disciplina(nomeDisciplina, idDisciplina, competenciasNecessarias, competenciasComplementares, professorSelecionado, alunoMatriculado);

        return disciplina;
        
    }

    public void gerenciarCompetencias(){
        List<Disciplina> disciplinasDisponiveis = controleDisciplina.getDisciplinas();
        Prompt.separador();
        Prompt.imprimir("Disciplinas disponíveis:");
        for (int i = 0; i < disciplinasDisponiveis.size(); i++) {
            Disciplina disciplina = disciplinasDisponiveis.get(i);
            Prompt.imprimir((i + 1) + ". " + disciplina.getNome());
        }
        int opcaoDisciplina = Prompt.lerInteiro("Selecione a disciplina desejada: ");
        if (opcaoDisciplina < 1 || opcaoDisciplina > disciplinasDisponiveis.size()) {
            Prompt.imprimir("Opção inválida.");
        }
        Disciplina disciplinaSelecionada = disciplinasDisponiveis.get(opcaoDisciplina - 1);
        List<Aluno> alunosDisciplina = disciplinaSelecionada.getAlunosMatriculados();
        int aptoNecessarias = 0;
        int inaptoNecessarias = 0;
        int aptoComplementares = 0;
        int inaptoComplementares = 0;
        for(int i = 0; i < alunosDisciplina.size(); i++){
            Aluno aluno = alunosDisciplina.get(i);
            List<Competencia> competenciaNecessaria = disciplinaSelecionada.getCompetenciasNecessarias();
            for(int j = 0; j < competenciaNecessaria.size(); j++){
                Competencia competencia = competenciaNecessaria.get(j);
                char resultado = Prompt.lerCaractere("O aluno " + aluno.getNome() + " possui a competência " + competencia.getNome() + " (s/n): ");
                if(resultado == 's'){
                    aptoNecessarias++;
                }else if(resultado == 'n'){
                    inaptoNecessarias++;
                }
            }
            List<Competencia> competenciaComplementares = disciplinaSelecionada.getCompetenciasComplementares();
            for(int j = 0; j < competenciaComplementares.size(); j++){
                Competencia competencia = competenciaComplementares.get(j);
                char resultado = Prompt.lerCaractere("O aluno " + aluno.getNome() + " possui a competência " + competencia.getNome() + " (s/n): ");
                if(resultado == 's'){
                    aptoComplementares++;
                }else if(resultado == 'n'){
                    inaptoComplementares++;
                }
            }
            int mediaNecessarias = competenciaNecessaria.size() / 2;
            int mediaComplementar = competenciaComplementares.size() / 2;

            if(aptoNecessarias == competenciaNecessaria.size() && aptoComplementares >= mediaComplementar){
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
