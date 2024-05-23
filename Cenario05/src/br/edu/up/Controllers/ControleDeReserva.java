package br.edu.up.Controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.edu.up.models.Evento;
import br.edu.up.models.Reserva;
import br.edu.up.utils.Prompt;
import br.edu.up.views.InformacaoReserva;

public class ControleDeReserva {
    private static List<Reserva> listaReservas = new ArrayList<>();
    
    public Reserva incluirReserva(Reserva reserva){        
        listaReservas.add(reserva);
        return reserva;
    }

    public Reserva alterarReserva(UUID id){
        List<Reserva> listaReservas = Reserva.getListaReservas();
        InformacaoReserva ir = new InformacaoReserva();

        for (Reserva reserva : listaReservas) {
            if(reserva.getId().equals(id)){

                Evento eventoOriginal = reserva.getEvento();
                eventoOriginal.setQuantIgressosVendidos(eventoOriginal.getQuantIgressosVendidos() - reserva.getQuantPessoas());

                reserva.setNomeResponsavel(ir.registrarNovoNome());
                reserva.setQuantPessoas(ir.registrarNovaQuantPessoas());
                reserva.setData(ir.registrarNovaData());

                List<Evento> eventosDisponiveis = Evento.getListaEventos();

                Prompt.separador();
                Prompt.imprimir("Eventos disponíveis:");
                for (int i = 0; i < eventosDisponiveis.size(); i++) {
                    Evento evento = eventosDisponiveis.get(i);
                    Prompt.imprimir((i + 1) + ". " + evento.getNome());
                }
                int opcaoEvento = Prompt.lerInteiro("Selecione o evento desejado: ");
            
                if (opcaoEvento < 1 || opcaoEvento > eventosDisponiveis.size()) {
                    Prompt.imprimir("Opção inválida.");
                    return null;
                }
            
                Evento eventoSelecionado = eventosDisponiveis.get(opcaoEvento - 1);
                reserva.setValorTotal(eventoSelecionado.getPrecoIngresso() * reserva.getQuantPessoas());
                eventoSelecionado.setQuantIgressosVendidos(eventoSelecionado.getQuantIgressosVendidos() + reserva.getQuantPessoas());

                return reserva;
            }
        }
        return null;
    }

    public void listaDeReservas(){
        List<Reserva> listaReservas = Reserva.getListaReservas();

        for (Reserva reserva : listaReservas) {
            Prompt.imprimir(reserva);
        }
    }

    public boolean excluirReserva(UUID id){

        List<Reserva> listaReserva = Reserva.getListaReservas();

        for ( Reserva reserva : listaReserva) {
            if(reserva.getId().equals(id)){
                return listaReserva.remove(reserva);
            }
        }
        return false;
    }
    
}
