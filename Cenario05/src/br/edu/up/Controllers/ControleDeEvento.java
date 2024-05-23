package br.edu.up.Controllers;
import br.edu.up.models.*;
import java.time.LocalDate;
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

    public Evento alterarEvento(int id, String nome, int ano, int mes, int dia, String local, int lotacao, double precoIngresso){
        for ( Evento evento : listaEventos) {
            if(evento.getId() == (id)){                
                evento.setNome(nome);
                evento.setData(LocalDate.of(ano, mes, dia));
                evento.setLocal(local);
                evento.setLotacaoMaxima(lotacao);
                evento.setPrecoIngresso(precoIngresso);

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

    public boolean ExcluirEvento(int id){
        for ( Evento evento : listaEventos) {
            if(evento.getId() == id){
                return listaEventos.remove(evento);
            }
        }
        return false;
    }
}
