package br.edu.up.models.pessoa.tripulantes;

import br.edu.up.models.pessoa.Tripulante;

public class Comandante extends Tripulante{
    private Double totalHorasDeVoo;

    public Comandante(String nome, String rg, String matriculaFuncionario, String idAeronautica, Double totalHorasDeVoo) {
        this.setNome(nome);
        this.setRg(rg);
        this.setMatriculaFuncionario(matriculaFuncionario);
        this.setIdAeronautica(idAeronautica);
        this.totalHorasDeVoo = totalHorasDeVoo;
    }

    public Double getTotalHorasDeVoo() {
        return totalHorasDeVoo;
    }
    
    public void setTotalHorasDeVoo(Double totalHorasDeVoo) {
        this.totalHorasDeVoo = totalHorasDeVoo;
    }

    @Override
    public String toString() {
        return "[Nome: " + getNome()  +  ", RG: " + getRg() + ", Matricula do Funcionario: " + getMatriculaFuncionario() 
        + ", Identificacao Aeronautica: " + getIdAeronautica()+ ", total de horas de voo: " + totalHorasDeVoo  + "Aeronave: " + getAeronave() +"]";        
    }
}
