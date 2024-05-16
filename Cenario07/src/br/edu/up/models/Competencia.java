package br.edu.up.models;

public class Competencia {
    
    private String nome;
    
    public Competencia() {
    }

    public Competencia(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Competencia [nome=" + nome + "]";
    }
}
