package br.edu.up.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.models.Pessoas.Passageiro;

public class PassageiroController {
    List<Passageiro> passageirosCadastrados = new ArrayList<>();

    public Passageiro adicionar(Passageiro passageiro){
        passageirosCadastrados.add(passageiro);
        return buscar(passageiro.getRg());
    }

    public String listar(){
        String lista = ""; 
        int i = 1;
        for (Passageiro passageiro : passageirosCadastrados) {
            lista += "Passageiro " + i + " "+passageiro.toString();
            lista += "\n---------------------------------------------------\n";
            i++;
        }

        return lista;
    }

    public Passageiro buscar(String rg){
        Passageiro busca = null;

        for (Passageiro passageiro : passageirosCadastrados) {
            if(passageiro.getRg().equals(rg)){
                busca = passageiro;
                break;
            }
        }
        
        return busca;
    }

    public void alterar(Passageiro passageiroVelho, Passageiro passageiroNovo){
        int index = passageirosCadastrados.indexOf(passageiroVelho);
        passageirosCadastrados.set(index, passageiroNovo);
    }
    

    public void deletar(Passageiro passageiro){
        passageirosCadastrados.remove(passageiro);
    }
}
