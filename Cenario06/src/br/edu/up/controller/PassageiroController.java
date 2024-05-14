package br.edu.up.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.models.Pessoa.Passageiro;
import br.edu.up.utils.Prompt;

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
            lista += "---------------------------------------------------";
            lista += "\nPassageiro " + i + " "+passageiro.toString();
            lista += "---------------------------------------------------";
            i++;
        }

        return lista;
    }

    public Passageiro buscar(String rg){
        Passageiro busca = null;

        for (Passageiro passageiro : passageirosCadastrados) {
            Prompt.imprimir(passageiro.getRg() == rg);
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
