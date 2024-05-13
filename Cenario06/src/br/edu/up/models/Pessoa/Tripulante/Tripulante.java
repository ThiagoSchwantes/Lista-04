package br.edu.up.models.Pessoa.Tripulante;

import br.edu.up.models.Pessoa.Pessoa;

public class Tripulante extends Pessoa{
    private String matriculaFuncionario;
    private Long idAeronautica;
    
    public String getMatriculaFuncionario() {
        return matriculaFuncionario;
    }
    public void setMatriculaFuncionario(String matriculaFuncionario) {
        this.matriculaFuncionario = matriculaFuncionario;
    }
    public Long getIdAeronautica() {
        return idAeronautica;
    }
    public void setIdAeronautica(Long idAeronautica) {
        this.idAeronautica = idAeronautica;
    } 
}
