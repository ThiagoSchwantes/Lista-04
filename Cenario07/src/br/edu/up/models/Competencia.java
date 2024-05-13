package br.edu.up.models;

public class Competencia {
    
    private String nome;
    private boolean atingida;

    public Competencia(String nome) {
        this.nome = nome;
        this.atingida = false;
    }

    public String getNome() {
        return nome;
    }

    public boolean isAtingida() {
        return atingida;
    }

    public void setAtingida(boolean atingida) {
        this.atingida = atingida;
    }
    
}
