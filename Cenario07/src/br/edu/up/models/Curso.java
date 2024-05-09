package br.edu.up.models;

import java.util.List;
import java.util.UUID;

public class Curso {
    private String nome;
    private int duracaoMinima;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getDuracaoMinima() {
        return duracaoMinima;
    }
    public void setDuracaoMinima(int duracaoMinima) {
        this.duracaoMinima = duracaoMinima;
    }
}
