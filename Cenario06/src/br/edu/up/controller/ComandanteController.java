package br.edu.up.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.models.Pessoas.Tripulantes.Comandante;

public class ComandanteController {
    List<Comandante> comandantesCadastrados = new ArrayList<>();

    public Comandante adicionar(Comandante comandante){
        comandantesCadastrados.add(comandante);

        return comandante;
    }

    public String listar(){
        String lista = ""; 
        int i = 1;
        for (Comandante comandante : comandantesCadastrados) {
            lista += "Comandante  " + i + " " + comandante.toString();
            lista += "\n---------------------------------------------------\n";
            i++;
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

    public void alterar(Comandante comandanteAntiga, Comandante comandanteNovo){
        int index = comandantesCadastrados.indexOf(comandanteAntiga);
        comandantesCadastrados.set(index, comandanteNovo);
    }

    public void deletar(Comandante comandante){
        comandantesCadastrados.remove(comandante);
    }
}
