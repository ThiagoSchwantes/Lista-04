package br.edu.up.models;

import java.util.List;

import br.edu.up.models.Pessoa.Aluno;

public class AlunoMatriculadoDisciplina {
    private Aluno aluno;
    private Disciplina disciplina;
    private List<SituacaoCompetencia> situacaoCompetenciasAluno;
    
    public Aluno getAluno() {
        return aluno;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    public Disciplina getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    public List<SituacaoCompetencia> getSituacaoCompetenciasAluno() {
        return situacaoCompetenciasAluno;
    }
    public void setSituacaoCompetenciasAluno(List<SituacaoCompetencia> situacaoCompetenciasAluno) {
        this.situacaoCompetenciasAluno = situacaoCompetenciasAluno;
    }

    
}
