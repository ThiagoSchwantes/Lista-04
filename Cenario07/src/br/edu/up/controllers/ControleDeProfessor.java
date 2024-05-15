package br.edu.up.controllers;

import java.util.ArrayList;
import java.util.List;
import br.edu.up.models.Pessoas.Professor;

public class ControleDeProfessor {
    
    private List<Professor> professores = new ArrayList<>();

    public void incluirProfessor(Professor professor){
        professores.add(professor);
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }
    
}

