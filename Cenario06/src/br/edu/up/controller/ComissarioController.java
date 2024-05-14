package br.edu.up.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.models.Pessoas.Tripulantes.Comissario;

public class ComissarioController {
    List<Comissario> comissariosCadastrados = new ArrayList<>();

    public void adicionar(Comissario comissario){
        comissariosCadastrados.add(comissario);
    }

    public String listar(){
        String lista = ""; 
        int i = 1;
        for (Comissario comissario : comissariosCadastrados) {
            lista += "Comissario  " + i + " " + comissario.toString();
            lista += "\n---------------------------------------------------\n";
            i++;
        }

        return lista;
    }

    public Comissario buscar(String matriculaFuncionario){
        Comissario busca = null;

        for (Comissario comissario : comissariosCadastrados) {
            if(comissario.getMatriculaFuncionario() == matriculaFuncionario){
                busca = comissario;
                break;
            }
        }
        return busca;
    }

    public void alterar(Comissario comissarioAntigo, Comissario comissarioNovo){
        int index = comissariosCadastrados.indexOf(comissarioAntigo);
        comissariosCadastrados.set(index, comissarioNovo);
    }

    public void deletar(Comissario comissario){
       comissariosCadastrados.remove(comissario);
    }
}
