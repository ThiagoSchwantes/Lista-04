package br.edu.up.models.Pessoas.Tripulantes;

import br.edu.up.models.Pessoas.Tripulante;

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
        return "[totalHorasDeVoo=" + totalHorasDeVoo + ", getNome()=" + getNome()
                + ", getMatriculaFuncionario()=" + getMatriculaFuncionario() + ", getRg()=" + getRg()
                + ", getIdAeronautica()=" + getIdAeronautica() + "]";
    }
}
