package br.edu.up.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.models.Competencia;
import br.edu.up.models.Disciplina;
import br.edu.up.models.Evento;
import br.edu.up.models.Pessoa.Aluno;
import br.edu.up.models.Pessoa.Professor;
import br.edu.up.utils.Prompt;
import br.edu.up.views.InformacaoDisciplina;

public class ControleDeDisciplina {
    Scanner scanner = new Scanner(System.in);
    public Disciplina incluirDisciplina(){
        InformacaoDisciplina iDisciplina = new InformacaoDisciplina();
        //adiciona nome e id 
        String nomeDisciplina = iDisciplina.registrarNomeDisciplina();
        int idDisciplina = iDisciplina.registrarIdDisciplina();
        //adiciona competencia necessarias 
        List<Competencia> competenciasNecessarias = new ArrayList<>();
        boolean adicionarMaisCompetencias = true;
        while (adicionarMaisCompetencias) {
            Competencia competencia = new Competencia(iDisciplina.registrarCompetenciaNecessaria());
            competenciasNecessarias.add(competencia);

            System.out.print("Deseja adicionar outra competência necessária? (true/false): ");
            String input = scanner.nextLine();
            adicionarMaisCompetencias = Boolean.parseBoolean(input);
        }
        //adiciona competencia complementar
        List<Competencia> competenciasComplementares = new ArrayList<>();
        boolean adicionarMaisCompetencias2 = true;
        while (adicionarMaisCompetencias2) {
            Competencia competencia = new Competencia(iDisciplina.registrarCompetenciaComplementar());
            competenciasComplementares.add(competencia);

            System.out.print("Deseja adicionar outra competência necessária? (true/false): ");
            String input = scanner.nextLine();
            adicionarMaisCompetencias2 = Boolean.parseBoolean(input);
        }
        //adiciona professor
        List<Professor> professoresDisponiveis = Professor.getListaProfessores();
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
            List<Aluno> alunosDisponiveis = Aluno.getListaAlunos();
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
        Disciplina disc = new Disciplina(nomeDisciplina, idDisciplina, competenciasNecessarias, competenciasComplementares, professorSelecionado, alunoMatriculado);

        return disc;
        
    }
}
