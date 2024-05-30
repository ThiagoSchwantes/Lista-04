package br.edu.up.modelos;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.modelos.contatos.Comercial;
import br.edu.up.modelos.contatos.Pessoal;

public class Agenda {

    List<Contato> contatos = new ArrayList<>();
    
    public Agenda(){
    }

    public void adicionar(Comercial contato){
        contatos.add(contato);
    }

    public void adicionar(Pessoal contato){
        contatos.add(contato);
    }

    public Contato getContato(int codigo){
        for (Contato contato : contatos) {
            if(contato.getCodigo() == codigo){
                return contato;
            }
        }
        return null;
    }
    
    public boolean excluirContato(int codigo){
        for (Contato contato : contatos) {
            if(contato.getCodigo() == codigo){
                contatos.remove(contato);
                return true;
            }
        }
        return false;
    }
    
    public String listarContatos(){/*dessa forma esta concatenando os contatos */
        StringBuilder frase = new StringBuilder();

        for (Contato contato : contatos) {
            frase.append("[ ").append(contato).append(" ]\n");
        }
        return frase.toString();
    }    
}
