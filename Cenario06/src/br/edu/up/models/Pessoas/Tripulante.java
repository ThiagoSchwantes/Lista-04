package br.edu.up.models.Pessoas;

import br.edu.up.models.Pessoa;

public class Tripulante extends Pessoa{
    private String matriculaFuncionario;
    private String idAeronautica;
    
    public String getMatriculaFuncionario() {
        return matriculaFuncionario;
    }
    public void setMatriculaFuncionario(String matriculaFuncionario) {
        this.matriculaFuncionario = matriculaFuncionario;
    }
    public String getIdAeronautica() {
        return idAeronautica;
    }
    public void setIdAeronautica(String idAeronautica) {
        this.idAeronautica = idAeronautica;
    } 
}
