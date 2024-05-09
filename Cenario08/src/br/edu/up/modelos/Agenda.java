package br.edu.up.modelos;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.utils.Prompt;

public class Agenda {

    List<Contato> listaContatos = new ArrayList<>();
    
    public Agenda(){

    }

    public void adicionar(Comercial contatoComercial){
        listaContatos.add(contatoComercial);
    }

    public void adicionar(Pessoal contatoPessoal){
        listaContatos.add(contatoPessoal);
    }

    public Contato getContato(int codigo){
        for (Contato contato : listaContatos) {
            if(contato.getCodigo() == codigo){
                return contato;
            }
        }
        return null;
    }
    
    public void excluirContato(int codigo){
        for (Contato contato : listaContatos) {
            if(contato.getCodigo() == codigo){
                listaContatos.remove(contato);
            }
        }
    }
    
    public String listarContatos(){
        String frase = "";
        for (Contato contato : listaContatos) {
            frase = "[ " + contato + " ],\n";
        }
        return frase;
    }
}
