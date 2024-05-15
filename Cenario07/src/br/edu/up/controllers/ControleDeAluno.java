package br.edu.up.controllers;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.models.Pessoas.Aluno;

public class ControleDeAluno {

    private List<Aluno> alunos = new ArrayList<>();

    public void incluirAluno(Aluno aluno){
        alunos.add(aluno);
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
    
}
