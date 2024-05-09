package br.edu.up.models;

public enum Competencia {
    NECESSARIA,
    COMPLEMENTAR;

    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
