package br.edu.up.models;

import java.util.Arrays;

import br.edu.up.models.pessoas.Aluno;
import br.edu.up.models.pessoas.Professor;

public class Disciplina {
    private String nome;
    private int id;
    private Competencia[] competenciasNecessarias = new Competencia[0];
    private Competencia[] competenciasComplementares = new Competencia[0];
    private Professor professor;
    private Aluno[] alunosMatriculados = new Aluno[0];
    
    public Disciplina(String nome, int id, Competencia[] competenciasNecessarias,
        Competencia[] competenciasComplementares, Professor professor, Aluno[] alunosMatriculados) {
        this.nome = nome;
        this.id = id;
        this.competenciasNecessarias = competenciasNecessarias;
        this.competenciasComplementares = competenciasComplementares;
        this.professor = professor;
        this.alunosMatriculados = alunosMatriculados;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void addCompetenciaNecessaria(Competencia compNesc){
        Competencia[] aux = new Competencia[competenciasNecessarias.length + 1];
        System.arraycopy(competenciasNecessarias, 0, aux, 0, competenciasNecessarias.length);
        aux[competenciasNecessarias.length] = compNesc;
        competenciasNecessarias = aux;
    }

    public void addCompetenciasComplementares(Competencia compComplementar){
        Competencia[] aux = new Competencia[competenciasComplementares.length + 1];
        System.arraycopy(competenciasComplementares, 0, aux, 0, competenciasComplementares.length);
        aux[competenciasComplementares.length] = compComplementar;
        competenciasComplementares = aux;
    }

    public void addAluno(Aluno aluno){
        Aluno[] aux = new Aluno[alunosMatriculados.length + 1];
        System.arraycopy(alunosMatriculados, 0, aux, 0, alunosMatriculados.length);
        aux[alunosMatriculados.length] = aluno;
        alunosMatriculados = aux;
    }

    public Competencia[] getCompetenciasNecessarias() {
        return competenciasNecessarias;
    }
    public void setCompetenciasNecessarias(Competencia[] competenciasNecessarias) {
        this.competenciasNecessarias = competenciasNecessarias;
    }
    public Competencia[] getCompetenciasComplementares() {
        return competenciasComplementares;
    }
    public void setCompetenciasComplementares(Competencia[] competenciasComplementares) {
        this.competenciasComplementares = competenciasComplementares;
    }
    public Professor getProfessor() {
        return professor;
    }
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    public Aluno[] getAlunosMatriculados() {
        return alunosMatriculados;
    }
    public void setAlunosMatriculados(Aluno[] alunosMatriculados) {
        this.alunosMatriculados = alunosMatriculados;
    }

    @Override
    public String toString() {
        return "Disciplina [nome=" + nome + ", id=" + id + ", competenciasNecessarias="
                + Arrays.toString(competenciasNecessarias) + ", competenciasComplementares="
                + Arrays.toString(competenciasComplementares) + ", professor=" + professor + ", alunosMatriculados="
                + Arrays.toString(alunosMatriculados) + "]";
    }
    
    
    
}