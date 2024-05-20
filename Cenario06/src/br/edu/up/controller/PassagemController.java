package br.edu.up.controller;

import br.edu.up.models.Passagem;

public class PassagemController {
    Passagem[] passagensCadastrados = new Passagem[0];

    public void adicionar(Passagem passagem){
        Passagem[] aux = new Passagem[passagensCadastrados.length + 1];
        System.arraycopy(passagensCadastrados, 0, aux, 0, passagensCadastrados.length);
        
        aux[passagensCadastrados.length] = passagem;

        passagensCadastrados = aux;
    }

    public String listar(){
        String lista = ""; 
        int i = 1;
        
        for (Passagem passagem : passagensCadastrados) {
            lista += "Passagem  " + i + " " + passagem.toString();
            lista += "\n---------------------------------------------------\n";
            i++;
        }

        if(lista.equals("")){
            lista = "Nada cadastrado";
            lista += "\n---------------------------------------------------\n";
        }

        return lista;
    }

    public Passagem buscar(String idProtocolo){
        Passagem busca = null;

        for (Passagem passagem : passagensCadastrados) {
            if(passagem.getIdProtocolo().toString().equals(idProtocolo)){
                busca = passagem;
                break;
            }
        }
        return busca;
    }

    public boolean alterar(Passagem passagemAntiga, Passagem passagemNova){
        for (int i = 0; i < passagensCadastrados.length; i++) {
            if(passagensCadastrados[i] == passagemAntiga){
                passagensCadastrados[i] = passagemNova;
                return true;
            }
        }    
        return false;
    }

    public void deletar(Passagem passageiro){
        Passagem[] novoPassagensCadastrados = new Passagem[passagensCadastrados.length - 1];

        for (int i = 0; i < passagensCadastrados.length; i++) {
            if(passagensCadastrados[i] == passageiro){

                for (int j = i; j < passagensCadastrados.length-1; j++) {
                    novoPassagensCadastrados[j] = passagensCadastrados[j+1];
                }
                break;
            }else{
                novoPassagensCadastrados[i] = passagensCadastrados[i];
            }
        }
        
        passagensCadastrados = new Passagem[passagensCadastrados.length-1];
        passagensCadastrados = novoPassagensCadastrados;
    }
}
