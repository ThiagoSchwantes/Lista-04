package br.edu.up.models.Pessoa.Tripulante;

import java.util.List;

public class Comissario extends Tripulante{
    private List<String> idiomas;

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public void adicionarIdioma(String idioma){
        this.idiomas.add(idioma);
    }

    public void removerIdioma(String idioma){
        this.idiomas.remove(idioma);
    }

    @Override
    public String toString() {
        return "Comissario [idiomas=" + idiomas + ", getNome()=" + getNome() + ", getIdiomas()=" + getIdiomas()
                + ", getMatriculaFuncionario()=" + getMatriculaFuncionario() + ", getRg()=" + getRg()
                + ", getIdAeronautica()=" + getIdAeronautica() + "]";
    }   
}