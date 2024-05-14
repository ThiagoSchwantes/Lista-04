package br.edu.up.models.Pessoa.Tripulante;

public class Comandante extends Tripulante{
    private Double totalHorasDeVoo;

    public Double getTotalHorasDeVoo() {
        return totalHorasDeVoo;
    }
    
    public void setTotalHorasDeVoo(Double totalHorasDeVoo) {
        this.totalHorasDeVoo = totalHorasDeVoo;
    }

    @Override
    public String toString() {
        return "Comandante [totalHorasDeVoo=" + totalHorasDeVoo + ", getNome()=" + getNome()
                + ", getMatriculaFuncionario()=" + getMatriculaFuncionario() + ", getRg()=" + getRg()
                + ", getIdAeronautica()=" + getIdAeronautica() + "]";
    }
}
