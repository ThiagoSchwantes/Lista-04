package br.edu.up.models.pessoa.tripulantes;

import br.edu.up.models.pessoa.Tripulante;

public class Comissario extends Tripulante{
    private String[] idiomas;

    public Comissario(String nome, String rg, String matriculaFuncionario, String idAeronautica, String[] idiomas) {
        this.setNome(nome);
        this.setRg(rg);
        this.setMatriculaFuncionario(matriculaFuncionario);
        this.setIdAeronautica(idAeronautica);
        this.idiomas = idiomas;
    }

    public String[] getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String[] idiomas) {
        this.idiomas = idiomas;
    }

    @Override
    public String toString() {
        String frase =  "[Nome: " + getNome()  +  ", RG: " + getRg() + ", Matricula do Funcionario: " + getMatriculaFuncionario() 
        + ", Identificacao Aeronautica: " + getIdAeronautica()+ ", idiomas: ["; 
        
        for (int i = 0; i < idiomas.length; i++) {
            if(i == idiomas.length-1){
                frase += idiomas[i];
            }else{
                frase += idiomas[i]+ ", ";
            }
        }
        return frase + "] ]";
    }
}