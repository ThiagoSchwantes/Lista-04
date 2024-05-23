package br.edu.up.views;
import br.edu.up.utils.*;

import java.time.LocalDate;
import java.util.UUID;
import br.edu.up.Controllers.*;
import br.edu.up.models.*;

public class Menu {
    ControleDeEvento controleDeEvento = new ControleDeEvento();
    ControleDeReserva controleDeReserva = new ControleDeReserva();

    public void menuPrincipal(){

        Prompt.separador();
        Prompt.imprimir("MENU PRINCIPAL");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Eventos");
        Prompt.imprimir("\t2 - Reservas");
        Prompt.imprimir("\t3 - Fechar Programa\n");

        int opcao1 = Prompt.lerInteiro("Digite aqui: ");

        switch (opcao1) {
            case 1:
                menuEventos();
                break;
            case 2:
                menuReserva();
                break;
            case 3:
                encerrarPrograma();
                break;
            default:
                Prompt.imprimir("Valor Inválido.");
                menuPrincipal();
                break;
        }
    }

    public void menuEventos(){
        Prompt.separador();
        Prompt.imprimir("MENU DE EVENTOS");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Inclusão de evento.");
        Prompt.imprimir("\t2 - Alteração de evento.");
        Prompt.imprimir("\t3 - Listagem de evento.");
        Prompt.imprimir("\t4 - Exclusão de evento.");
        Prompt.imprimir("\t5 - Voltar ao Menu Principal\n\n");

        int opcao2 = Prompt.lerInteiro("Digite aqui: ");

        switch (opcao2) {
            case 1:

                String nome =  Prompt.lerLinha("Informe o nome do evento: ");

                int ano = Prompt.lerInteiro("Informe o ano do evento: ");
                int mes = Prompt.lerInteiro("Informe o mês do evento: ");
                int dia = Prompt.lerInteiro("Informe o dia do evento: ");
                LocalDate data =  LocalDate.of(ano, mes, dia);

                String local = Prompt.lerLinha("Informe o local do evento: ");
                int lotacao = Prompt.lerInteiro("Informe a locação máxima do evento: ");
                double precoIngresso = Prompt.lerDecimal("Informe o preço do ingresso: ");

                Evento evento = new Evento(nome, data, local, lotacao, precoIngresso);

                controleDeEvento.incluirEvento(evento);

                Prompt.separador();
                Prompt.imprimir("Evento cadastrado com sucesso!");
                Prompt.imprimir(evento);
                Prompt.separador();
                Prompt.pressionarEnter();
                menuPrincipal();
                break;
            case 2:
                int id = Prompt.lerInteiro("Informe o id do evento: ");
                try{

                    Evento evento2 = controleDeEvento.buscar(id);
                    
                    if(evento2 == null){
                        Prompt.imprimir("Id não encontrado.");
                    }else{
                        String nomeAlterar = Prompt.lerLinha("Informe o novo nome do evento: ");
                        int anoAlterar = Prompt.lerInteiro("Informe o novo ano do evento: ");
                        int mesAlterar = Prompt.lerInteiro("Informe o novo mês do evento: ");
                        int diaAlterar = Prompt.lerInteiro("Informe o novo dia do evento: ");
                        String localAlterar = Prompt.lerLinha("Informe o novo local do evento: ");
                        int lotacaoAlterar = Prompt.lerInteiro("Informe a nova locação máxima do evento: ");
                        double precoIngressoAlterar = Prompt.lerDecimal("Informe o novo preço do ingresso: ");

                        Evento eventoAlterado = controleDeEvento.alterarEvento(id, nomeAlterar, anoAlterar, mesAlterar, diaAlterar, localAlterar, lotacaoAlterar, precoIngressoAlterar);

                        Prompt.separador();
                        Prompt.imprimir("Alteração realizada com sucesso.");
                        Prompt.imprimir(eventoAlterado);
                        Prompt.separador();
                    }
                }catch (IllegalArgumentException e) {
                    Prompt.imprimir("Formato de UUID inválido. Certifique-se de inserir um UUID válido.");
                }
                
                Prompt.pressionarEnter();
                menuPrincipal();
                break;
            case 3:
                controleDeEvento.listaDeEventos();

                Prompt.pressionarEnter();
                menuPrincipal();
                break;
            case 4:
                int idDeletar = Prompt.lerInteiro("Informe o id do evento: ");
                try{
                    boolean evento2 = controleDeEvento.ExcluirEvento(idDeletar);
                    if(evento2 == false){
                        Prompt.imprimir("Evento não encontrado.");
                    }else{
                        Prompt.imprimir("Evento excluido com sucesso.");
                    }
                }catch (IllegalArgumentException e) {
                    Prompt.imprimir("Formato de UUID inválido. Certifique-se de inserir um UUID válido.");
                }

                Prompt.pressionarEnter();
                menuPrincipal();
                break;
            case 5:
                menuPrincipal();
                break;
            default:
                Prompt.imprimir("Valor Inválido.");
                break;
        }
    }

    public void menuReserva(){
        ControleDeReserva controleDeReserva = new ControleDeReserva();

        Prompt.separador();
        Prompt.imprimir("MENU DE RESERVAS");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Inclusão de reserva.");
        Prompt.imprimir("\t2 - Alteração de reserva.");
        Prompt.imprimir("\t3 - Listagem de reserva.");
        Prompt.imprimir("\t4 - Exclusão de reserva.");
        Prompt.imprimir("\t5 - Voltar ao Menu Principal\n\n");

        int opcao3 = Prompt.lerInteiro("Digite aqui: ");

        switch (opcao3) {
            case 1:
                int opcaoEvento = Prompt.lerInteiro("Selecione o id do evento desejado: ");
                Evento eventoSelecionado = controleDeEvento.buscar(opcaoEvento);

                if (eventoSelecionado == null) {
                    Prompt.imprimir("Opção inválida.");
                }else{

                    String nomeResponsavel = Prompt.lerLinha("Informe o nome do responsável pela reserva: ");
                    int quantPessoas = Prompt.lerInteiro("Informe para quantas pessoas é a reserva: ");
                    LocalDate data = LocalDate.now();
                    

                    Prompt.separador();
                    Prompt.imprimir("Eventos disponíveis:");
                    Prompt.imprimir(controleDeEvento.listaDeEventos());
                    double valorTotalReserva = eventoSelecionado.getPrecoIngresso() * quantPessoas;
                    Reserva reserva = new Reserva(nomeResponsavel, quantPessoas, data, eventoSelecionado, valorTotalReserva);
                    eventoSelecionado.setQuantIgressosVendidos(eventoSelecionado.getQuantIgressosVendidos() + quantPessoas);


                    controleDeReserva.incluirReserva(reserva);
                    Prompt.separador();
                    Prompt.imprimir("Reserva realizada com sucesso.");
                    Prompt.imprimir(reserva);
                    Prompt.separador();
                }
                Prompt.pressionarEnter();
                menuPrincipal();
                break;
            case 2:
                String idString3 = Prompt.lerLinha("Informe o id da reserva: ");
                try{
                    UUID id = UUID.fromString(idString3);
                    Reserva reserva2 = controleDeReserva.alterarReserva(id);
                    if(reserva2 == null){
                        Prompt.imprimir("Id não encontrado.");
                    }else{
                        Prompt.separador();
                        Prompt.imprimir("Alteração realizada com sucesso.");
                        Prompt.imprimir(reserva2);
                        Prompt.separador();
                    }
                }catch (IllegalArgumentException e) {
                    Prompt.imprimir("Formato de UUID inválido. Certifique-se de inserir um UUID válido.");
                }

                Prompt.pressionarEnter();
                menuPrincipal();
                break;
            case 3:
                controleDeReserva.listaDeReservas();

                Prompt.pressionarEnter();
                menuPrincipal();
                break;
            case 4:
                String idString4 = Prompt.lerLinha("Informe o id do evento: ");
                try{
                    UUID idReserva = UUID.fromString(idString4);
                    boolean reserva2 = controleDeReserva.excluirReserva(idReserva);
                    if(reserva2 == false){
                        Prompt.imprimir("Evento não encontrado.");
                    }else{
                        Prompt.imprimir("Evento excluido com sucesso.");
                    }
                }catch (IllegalArgumentException e) {
                    Prompt.imprimir("Formato de UUID inválido. Certifique-se de inserir um UUID válido.");
                }

                Prompt.pressionarEnter();
                menuPrincipal();
                break;
            case 5:
                menuPrincipal();
                break;
            default:
                Prompt.imprimir("Valor Inválido.");
                break;
        }
    }

    public void encerrarPrograma(){
        Prompt.imprimir("Encerrando o programa...");
        System.exit(3);
    }
}
