package br.edu.up.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.models.Voo;

public class VooController {
    List<Voo> voosCadastrados = new ArrayList<>();

    public void adicionar(Voo voo){
        voosCadastrados.add(voo);
    }

    public String listar(){
        String lista = ""; 
        int i = 1;
        
        for (Voo voo : voosCadastrados) {
            lista += "Voo  " + i + " " + voo.toString();
            lista += "\n---------------------------------------------------\n";
            i++;
        }

        if(lista.equals("")){
            lista = "Nada cadastrado";
            lista += "\n---------------------------------------------------\n";
        }

        return lista;
    }

    public Voo buscar(String idVoo){
        Voo busca = null;

        for (Voo voo : voosCadastrados) {
            if(voo.getIdVoo().toString().equals(idVoo)){
                busca = voo;
                break;
            }
        }

        return busca;
    }

    public void alterar(Voo voo){
        int index = voosCadastrados.indexOf(voo);
        voosCadastrados.set(index, voo);
    }

    public void deletar(Voo voo){
        voosCadastrados.remove(voo);
    }
}