package br.edu.up.models.Pessoas;
import br.edu.up.models.Pessoa;

public class Aluno extends Pessoa{
    private int anoIngresso;
    private String curso;
    private String turno; //diurno, vespertino, noturno
    private String estaAprovado = null;

    public Aluno(String nome, String rg, String matricula, int anoIngresso, String curso, String turno) {
        super(nome, rg, matricula);
        this.anoIngresso = anoIngresso;
        this.curso = curso;
        this.turno = turno;
    }
    public int getAnoIngresso() {
        return anoIngresso;
    }
    public void setAnoIngresso(int anoIngresso) {
        this.anoIngresso = anoIngresso;
    }
    public String getNomeCurso() {
        return curso;
    }
    public void setNomeCurso(String curso) {
        this.curso = curso;
    }
    public String getTurno() {
        return turno;
    }
    public void setTurno(String turno) {
        this.turno = turno;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }

    
    @Override
    public String toString() {
        return "Aluno [anoIngresso=" + anoIngresso + ", curso=" + curso + ", turno=" + turno + ", estaAprovado="
                + estaAprovado + "]";
    }
    public String getEstaAprovado() {
        return estaAprovado;
    }
    public void setEstaAprovado(String estaAprovado) {
        this.estaAprovado = estaAprovado;
    }

    
    
    
}
