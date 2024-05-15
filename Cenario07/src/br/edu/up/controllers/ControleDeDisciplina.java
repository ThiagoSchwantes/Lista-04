package br.edu.up.controllers;
import java.util.ArrayList;
import java.util.List;

import br.edu.up.models.Disciplina;
import br.edu.up.models.Pessoas.Aluno;




public class ControleDeDisciplina {

    private List<Disciplina> disciplinas = new ArrayList<>();
    public void incluirDisciplina(Disciplina disciplina){
        disciplinas.add(disciplina);
    }
    
}
