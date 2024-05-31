package br.edu.up.controllers;

import br.edu.up.models.Reserva;

public class ControleDeReserva {
    private Reserva[] listaReservas = new Reserva[0];
    Integer idReserva = 0;
    
    public Reserva incluirReserva(Reserva reserva){
        reserva.setIdReserva(idReserva);   
        idReserva++;

        Reserva[] aux = new Reserva[listaReservas.length + 1];
        System.arraycopy(listaReservas, 0, aux, 0, listaReservas.length);
        
        aux[listaReservas.length] = reserva;

        listaReservas = aux;
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

        if(lista.equals("")){
            lista = "Nada cadastrado";
            lista += "\n---------------------------------------------------\n";
        }
        
        return lista;
    }

    public void excluirReserva(int id){
        Reserva[] novolistaReservas = new Reserva[listaReservas.length - 1];

        for (int i = 0; i < listaReservas.length; i++) {
            if(listaReservas[i].getId() == id){

                for (int j = i; j < listaReservas.length-1; j++) {
                    novolistaReservas[j] = listaReservas[j+1];
                }
                break;
            }else{
                novolistaReservas[i] = listaReservas[i];
            }
        }
        
        listaReservas = new Reserva[listaReservas.length-1];
        listaReservas = novolistaReservas;
    }
}
