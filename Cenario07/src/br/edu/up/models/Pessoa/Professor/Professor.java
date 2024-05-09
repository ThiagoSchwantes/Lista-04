package br.edu.up.models.Pessoa.Professor;

import br.edu.up.models.Pessoa.Pessoa;

public class Professor extends Pessoa{
    private Long LattesId;
    private Titulacao titulacao;

    public Long getLattesId() {
        return LattesId;
    }
    public void setLattesId(Long lattesId) {
        LattesId = lattesId;
    }
    public Titulacao getTitulacao() {
        return titulacao;
    }
    public void setTitulacao(Titulacao titulacao) {
        this.titulacao = titulacao;
    }
}
