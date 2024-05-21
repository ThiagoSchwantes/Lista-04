package br.edu.up.modelos;

import java.util.ArrayList;
import java.util.List;

public class Agenda {

    List<Contato> listaContatos = new ArrayList<>();
    
    public Agenda(){

    }

    public void adicionarContatoComercial(Comercial contatoComercial){
        listaContatos.add(contatoComercial);
    }

    public void adicionarContatoPessoal(Pessoal contatoPessoal){
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
    
    public String listarContatos(){/*dessa forma esta concatenando os contatos */
        StringBuilder frase = new StringBuilder();
        for (Contato contato : listaContatos) {
            frase.append("[ ").append(contato).append(" ],\n");
        }
        return frase.toString();
    }

    public List<Contato> getListaContatos() {
        return listaContatos;
    }

    public void setListaContatos(List<Contato> listaContatos) {
        this.listaContatos = listaContatos;
    }

    
}
