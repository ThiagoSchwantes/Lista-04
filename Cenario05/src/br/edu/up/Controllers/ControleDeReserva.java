package br.edu.up.Controllers;

import java.util.ArrayList;
import java.util.List;
import br.edu.up.models.Reserva;

public class ControleDeReserva {
    private static List<Reserva> listaReservas = new ArrayList<>();
    Integer idReserva = 0;
    
    public Reserva incluirReserva(Reserva reserva){
        reserva.setIdReserva(idReserva);   
        idReserva++;

        listaReservas.add(reserva);
        return reserva;
    }

    public Reserva alterarReserva(Reserva antiga, Reserva nova){
        for (Reserva reserva : listaReservas) {
            if(reserva.getId() == (antiga.getId())){                
                reserva.setData(nova.getData());
                reserva.setEvento(nova.getEvento());
                reserva.setQuantPessoas(nova.getQuantPessoas());
                reserva.setNomeResponsavel(nova.getNomeResponsavel());
                reserva.setValorTotal(nova.getValorTotal());

                return reserva;
            }
        }
        return null;
    }

    public Reserva buscar(int id){
        for (Reserva reserva : listaReservas) {
            if(reserva.getId() == id){
                return reserva;
            }
        }
        return null;
    }

    public String listaDeReservas(){
        String lista = "";
        for (Reserva reserva : listaReservas) {
            lista += "Reserva " + reserva.toString();
            lista += "\n---------------------------------------------------\n";
        }
        return lista;
    }

    public boolean excluirReserva(int id){
        for (Reserva reserva : listaReservas) {
            if(reserva.getId() == id){
                return listaReservas.remove(reserva);
            }
        }
        return false;
    }    
}
