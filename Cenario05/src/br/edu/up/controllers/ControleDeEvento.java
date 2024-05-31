package br.edu.up.controllers;
import br.edu.up.models.*;

public class ControleDeEvento {
    private Evento[] listaEventos = new Evento[0];
    Integer id = 0;

    public Evento incluirEvento(Evento evento){
        evento.setId(id);
        id++;

        Evento[] aux = new Evento[listaEventos.length + 1];
        System.arraycopy(listaEventos, 0, aux, 0, listaEventos.length);
        
        aux[listaEventos.length] = evento;
        listaEventos = aux;

        return evento;
    }

    public Evento alterarEvento(Evento antigo, Evento novo){
        for ( Evento evento : listaEventos) {
            if(evento.getId() == (antigo.getId())){                
                evento = novo;
                return evento;
            }
        }
        return null;
    }

    public Evento buscar(int id){
        for (Evento evento : listaEventos) {
            if(evento.getId() == id){
                return evento;
            }
        }
        return null;
    }

    public String listaDeEventos(){
        String lista = ""; 
        int i = 1;
        for ( Evento evento : listaEventos) {
            lista += "Evento  " + i + " " + evento.toString();
            lista += "\n---------------------------------------------------\n";
            i++;
        }

        if(lista.equals("")){
            lista = "Nada cadastrado";
            lista += "\n---------------------------------------------------\n";
        }
        
        return lista;
    }

    public void excluirEvento(int id){
        Evento[] novolistaEventos = new Evento[listaEventos.length - 1];

        for (int i = 0; i < listaEventos.length; i++) {
            if(listaEventos[i].getId() == id){
                for (int j = i; j < listaEventos.length-1; j++) {
                    novolistaEventos[j] = listaEventos[j+1];
                }
                break;
            }else{
                novolistaEventos[i] = listaEventos[i];
            }
        }
        listaEventos = new Evento[listaEventos.length-1];
        listaEventos = novolistaEventos;
    }
}
