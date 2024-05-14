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

        for (Passagem passagem : passagensCadastrados) {
            lista += "--------------------------\n";
            lista += passagem.toString()+"\n";
            lista += "--------------------------\n";
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

    public void alterar(Passagem passagemNova){
        int index = passagensCadastrados.indexOf(passagemNova);
        passagensCadastrados.set(index, passagemNova);
    }

    public void deletar(Passagem comissario){
        passagensCadastrados.remove(comissario);
    }
}
