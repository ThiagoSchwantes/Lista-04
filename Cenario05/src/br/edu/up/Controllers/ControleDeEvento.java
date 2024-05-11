package br.edu.up.Controllers;
import br.edu.up.views.*;
import br.edu.up.models.*;
import br.edu.up.utils.Prompt;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class ControleDeEvento {

    public Evento incluirEvento(){
        InformacaoEvento ie = new InformacaoEvento();

        String nome = ie.registrarNome();
        LocalDate data = ie.registrarData();
        String local = ie.registrarLocal();
        int lotacao = ie.registrarLotacaoMax();
        double precoIngresso = ie.registrarPrecoIngresso();

        Evento evento = new Evento(nome,data,local,lotacao,precoIngresso);
        Evento.getListaEventos().add(evento);

        return evento;
    }

    public Evento alterarEvento(UUID id){

        List<Evento> listaEventos = Evento.getListaEventos();
        InformacaoEvento ie = new InformacaoEvento();

        for ( Evento evento : listaEventos) {
            if(evento.getId().equals(id)){
                evento.setNome(ie.registrarNovoNome());
                evento.setData(ie.registrarNovoData());
                evento.setLocal(ie.registrarNovoLocal());
                evento.setLotacaoMaxima(ie.registrarNovoLotacaoMax());
                evento.setPrecoIngresso(ie.registrarNovoPrecoIngresso());

                return evento;
            }
        }

        return null;
    }

    public void listaDeEventos(){
        List<Evento> listaEventos = Evento.getListaEventos();

        for (Evento evento : listaEventos) {
            Prompt.imprimir(evento);
        }
    }

    public boolean ExcluirEvento(UUID id){

        List<Evento> listaEventos = Evento.getListaEventos();

        for ( Evento evento : listaEventos) {
            if(evento.getId().equals(id)){
                return listaEventos.remove(evento);
            }
        }
        return false;
    }
    
}
