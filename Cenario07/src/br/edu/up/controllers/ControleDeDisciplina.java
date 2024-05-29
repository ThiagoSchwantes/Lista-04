package br.edu.up.controllers;

import br.edu.up.models.Disciplina;

public class ControleDeDisciplina {

    private Disciplina[] disciplinas = new Disciplina[0];

    public void incluirDisciplina(Disciplina disciplina){
        Disciplina[] aux = new Disciplina[disciplinas.length + 1];
        System.arraycopy(disciplinas, 0, aux, 0, disciplinas.length);
        
        aux[disciplinas.length] = disciplina;

        disciplinas = aux;
    }

    public Disciplina[] getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Disciplina[] disciplinas) {
        this.disciplinas = disciplinas;
    }
    
}
