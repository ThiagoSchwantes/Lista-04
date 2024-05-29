package br.edu.up.controllers;
import br.edu.up.models.pessoas.Professor;

public class ControleDeProfessor {
    
    private Professor[] professores = new Professor[0];

    public void incluirProfessor(Professor professor){
        Professor[] aux = new Professor[professores.length + 1];
        System.arraycopy(professores, 0, aux, 0, professores.length);
        
        aux[professores.length] = professor;

        professores = aux;
    }

    public Professor[] getProfessores() {
        return professores;
    }

    public void setProfessores(Professor[] professores) {
        this.professores = professores;
    }
    
}

