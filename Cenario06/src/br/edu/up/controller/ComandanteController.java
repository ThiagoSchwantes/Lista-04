package br.edu.up.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.models.Aeronave;
import br.edu.up.models.Pessoa.Tripulante.Comandante;
import br.edu.up.models.Pessoa.Tripulante.Comissario;

public class ComandanteController {
    List<Comandante> comandantesCadastrados = new ArrayList<>();

    public void adicionar(Comandante comandante){
        comandantesCadastrados.add(comandante);
    }

    public String listar(){
        String lista = ""; 

        for (Comandante comandante : comandantesCadastrados) {
            lista += "--------------------------\n";
            lista += comandante.toString()+"\n";
            lista += "--------------------------\n";
        }

        return lista;
    }

    public Comandante buscar(String matriculaFuncionario){
        Comandante busca = null;

        for (Comandante comandante : comandantesCadastrados) {
            if(comandante.getMatriculaFuncionario() == matriculaFuncionario){
                busca = comandante;
                break;
            }
        }
        return busca;
    }

    public void alterar(Comandante comandanteNovo){
        int index = comandantesCadastrados.indexOf(comandanteNovo);
        comandantesCadastrados.set(index, comandanteNovo);
    }

    public void deletar(Comandante comandante){
        comandantesCadastrados.remove(comandante);
    }
}
