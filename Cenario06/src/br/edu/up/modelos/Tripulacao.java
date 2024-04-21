package br.edu.up.modelos;

public class Tripulacao {
    private String matriculaFuncionario;
    private Integer idAeronautica;
    private Double totalHorasDeVoo;
    private String[] idiomas;
    
    public String getMatriculaFuncionario() {
        return matriculaFuncionario;
    }
    public void setMatriculaFuncionario(String matriculaFuncionario) {
        this.matriculaFuncionario = matriculaFuncionario;
    }
    public Integer getIdAeronautica() {
        return idAeronautica;
    }
    public void setIdAeronautica(Integer idAeronautica) {
        this.idAeronautica = idAeronautica;
    }
    public Double getTotalHorasDeVoo() {
        return totalHorasDeVoo;
    }
    public void setTotalHorasDeVoo(Double totalHorasDeVoo) {
        this.totalHorasDeVoo = totalHorasDeVoo;
    }
    public String[] getIdiomas() {
        return idiomas;
    }
    public void setIdiomas(String[] idiomas) {
        this.idiomas = idiomas;
    }

    
    
}
