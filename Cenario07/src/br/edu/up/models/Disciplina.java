package br.edu.up.models;
import java.util.List;
import br.edu.up.models.Pessoas.Aluno;
import br.edu.up.models.Pessoas.Professor;

public class Disciplina {
    private String nome;
    private int id;
    private List<Competencia> competenciasNecessarias;
    private List<Competencia> competenciasComplementares;
    private Professor professor;
    private List<Aluno> alunosMatriculados;
    
    public Disciplina(String nome, int id, List<Competencia> competenciasNecessarias,
            List<Competencia> competenciasComplementares, Professor professor, List<Aluno> alunosMatriculados) {
        this.nome = nome;
        this.id = id;
        this.competenciasNecessarias = competenciasNecessarias;
        this.competenciasComplementares = competenciasComplementares;
        this.professor = professor;
        this.alunosMatriculados = alunosMatriculados;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public List<Competencia> getCompetenciasNecessarias() {
        return competenciasNecessarias;
    }
    public void setCompetenciasNecessarias(List<Competencia> competenciasNecessarias) {
        this.competenciasNecessarias = competenciasNecessarias;
    }
    public List<Competencia> getCompetenciasComplementares() {
        return competenciasComplementares;
    }
    public void setCompetenciasComplementares(List<Competencia> competenciasComplementares) {
        this.competenciasComplementares = competenciasComplementares;
    }
    public Professor getProfessor() {
        return professor;
    }
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    public List<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }
    public void setAlunosMatriculados(List<Aluno> alunosMatriculados) {
        this.alunosMatriculados = alunosMatriculados;
    }
    @Override
    public String toString() {
        return "Disciplina [nome=" + nome + ", id=" + id + ", competenciasNecessarias=" + competenciasNecessarias
                + ", competenciasComplementares=" + competenciasComplementares + ", professor=" + professor
                + ", alunosMatriculados=" + alunosMatriculados + "]";
    }
    
}