package br.edu.up.controllers;


import br.edu.up.models.pessoas.Aluno;

public class ControleDeAluno {

    private Aluno[] alunos = new Aluno[0];

    public void incluirAluno(Aluno aluno){
        Aluno[] aux = new Aluno[alunos.length + 1];
        System.arraycopy(alunos, 0, aux, 0, alunos.length);
        
        aux[alunos.length] = aluno;

        alunos = aux;
    }


    public Aluno[] getAlunos() {
        return alunos;
    }

    public void setAlunos(Aluno[] alunos) {
        this.alunos = alunos;
    }
    
}
