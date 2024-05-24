package br.edu.up.Controllers;
import br.edu.up.models.*;
import java.util.ArrayList;
import java.util.List;

public class ControleDeEvento {
    private static List<Evento> listaEventos = new ArrayList<>();
    Integer id = 0;

    public Evento incluirEvento(Evento evento){
        evento.setId(id);
        id++;
        
        listaEventos.add(evento);
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
        for (Evento evento : listaEventos) {
            lista += "Evento " + evento.toString();
            lista += "\n---------------------------------------------------\n";
        }
        return lista;
    }

    public boolean excluirEvento(int id){
        for ( Evento evento : listaEventos) {
            if(evento.getId() == id){
                return listaEventos.remove(evento);
            }
        }
        return false;
    }
}
