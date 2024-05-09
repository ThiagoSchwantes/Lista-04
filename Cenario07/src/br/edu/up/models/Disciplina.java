package br.edu.up.models;

import java.util.List;
import java.util.UUID;

import br.edu.up.models.Pessoa.Aluno;
import br.edu.up.models.Pessoa.Professor.Professor;

public class Disciplina {
    private String nome;
    private UUID id;
    
    private Curso curso;
    
    private Professor professor;
    private List<Competencia> competencias;
    private List<Aluno> alunosMatriculados;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Curso getCurso() {
        return curso;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    public Professor getProfessor() {
        return professor;
    }
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    
    
}