package br.edu.up.models.Pessoa.Professor;

import java.time.Year;

public class Titulacao {
    private String nomeTitulo;
    private String nomeInstituicao;
    private Year anoConclusao;
    
    public String getNomeTitulo() {
        return nomeTitulo;
    }
    public void setNomeTitulo(String nomeTitulo) {
        this.nomeTitulo = nomeTitulo;
    }
    public String getNomeInstituicao() {
        return nomeInstituicao;
    }
    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }
    public Year getAnoConclusao() {
        return anoConclusao;
    }
    public void setAnoConclusao(Year anoConclusao) {
        this.anoConclusao = anoConclusao;
    }
}