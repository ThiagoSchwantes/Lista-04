package br.edu.up.models;

import br.edu.up.models.Pessoa.Aluno;

public enum SituacaoCompetencia {
    ATINGIDA,
    NAO_ATINGIDA;

    private Aluno aluno;
    private Competencia competencia;
    public Aluno getAluno() {
        return aluno;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    public Competencia getCompetencia() {
        return competencia;
    }
    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }

    
}
