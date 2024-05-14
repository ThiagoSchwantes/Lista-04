package br.edu.up.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.models.Passagem;

public class PassagemController {
    List<Passagem> passagensCadastrados = new ArrayList<>();

    public void adicionar(Passagem passagem){
        passagensCadastrados.add(passagem);
    }

    public String listar(){
        String lista = ""; 
        int i = 1;
        for (Passagem passagem : passagensCadastrados) {
            lista += "Passagem  " + i + " " + passagem.toString();
            lista += "\n---------------------------------------------------\n";
            i++;
        }

        return lista;
    }

    public Passagem buscar(String idProtocolo){
        Passagem busca = null;

        for (Passagem passagem : passagensCadastrados) {
            if(passagem.getIdProtocolo().toString() == idProtocolo){
                busca = passagem;
                break;
            }
        }
        return busca;
    }

    public void alterar(Passagem passagem){
        int index = passagensCadastrados.indexOf(passagem);
        passagensCadastrados.set(index, passagem);
    }

    public void deletar(Passagem comissario){
        passagensCadastrados.remove(comissario);
    }
}
