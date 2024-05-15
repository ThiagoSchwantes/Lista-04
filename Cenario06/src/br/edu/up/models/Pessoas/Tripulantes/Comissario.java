package br.edu.up.models.pessoas.tripulantes;

import java.util.List;

import br.edu.up.models.pessoas.Tripulante;

public class Comissario extends Tripulante{
    private List<String> idiomas;

    public Comissario(String nome, String rg, String matriculaFuncionario, String idAeronautica, List<String> idiomas) {
        this.setNome(nome);
        this.setRg(rg);
        this.setMatriculaFuncionario(matriculaFuncionario);
        this.setIdAeronautica(idAeronautica);
        this.idiomas = idiomas;
    }

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
        return "[Nome: " + getNome()  +  ", RG: " + getRg() + ", Matricula do Funcionario: " + getMatriculaFuncionario() 
        + ", Identificacao Aeronautica: " + getIdAeronautica()+ ", idiomas: " + idiomas + "]";        
    }
}