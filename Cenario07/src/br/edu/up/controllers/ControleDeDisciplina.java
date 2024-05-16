package br.edu.up.controllers;
import java.util.ArrayList;
import java.util.List;
import br.edu.up.models.Disciplina;

public class ControleDeDisciplina {

    private List<Disciplina> disciplinas = new ArrayList<>();
    public void incluirDisciplina(Disciplina disciplina){
        disciplinas.add(disciplina);
    }
    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }
    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
}
