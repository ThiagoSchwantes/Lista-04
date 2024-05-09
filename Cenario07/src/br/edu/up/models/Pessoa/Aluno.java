package br.edu.up.models.Pessoa;

import java.time.Year;

import br.edu.up.models.Curso;

public class Aluno extends Pessoa{
    private Year anoIngresso;
    private Curso curso;
    private String turno; //diurno, vespertino, noturno
    
    public Year getAnoIngresso() {
        return anoIngresso;
    }
    public void setAnoIngresso(Year anoIngresso) {
        this.anoIngresso = anoIngresso;
    }
    public Curso getNomeCurso() {
        return curso;
    }
    public void setNomeCurso(Curso curso) {
        this.curso = curso;
    }
    public String getTurno() {
        return turno;
    }
    public void setTurno(String turno) {
        this.turno = turno;
    }

    
}
