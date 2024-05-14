package br.edu.up.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.models.Pessoa.Tripulante.Comandante;
import br.edu.up.models.Pessoa.Tripulante.Comissario;

public class ComissarioController {
    List<Comissario> comissariosCadastrados = new ArrayList<>();

    public void adicionar(Comissario comissario){
        comissariosCadastrados.add(comissario);
    }

    public String listar(){
        String lista = ""; 

        for (Comissario comissario : comissariosCadastrados) {
            lista += "--------------------------\n";
            lista += comissario.toString()+"\n";
            lista += "--------------------------\n";
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

    public void alterar(Comissario comissarioNovo){
        int index = comissariosCadastrados.indexOf(comissarioNovo);
        comissariosCadastrados.set(index, comissarioNovo);
    }

    public void deletar(Comissario comissario){
       comissariosCadastrados.remove(comissario);
    }
}
