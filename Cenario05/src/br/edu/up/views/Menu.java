package br.edu.up.views;
import br.edu.up.utils.*;

import java.time.LocalDate;
import br.edu.up.Controllers.*;
import br.edu.up.models.*;

public class Menu {
    ControleDeEvento controleDeEvento = new ControleDeEvento();
    ControleDeReserva controleDeReserva = new ControleDeReserva();

    public void menuPrincipal(){
        Prompt.limparConsole();
        Prompt.separador();
        Prompt.imprimir("MENU PRINCIPAL");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Eventos");
        Prompt.imprimir("\t2 - Reservas");
        Prompt.imprimir("\t3 - Fechar Programa\n");

        boolean sair = false;

        int opcao = Prompt.lerInteiro("Digite aqui: ");

        switch (opcao) {
            case 1:
                menuEventos();
                break;
            case 2:
                menuReserva();
                break;
            case 3:
                sair = true;
                break;
            default:
                Prompt.imprimir("Valor Inválido.");
                Prompt.pressionarEnter();
                menuPrincipal();
                break;
        }

        if(sair != true){
            menuPrincipal();
        }else{
            encerrarPrograma();
        }
    }

    public void menuEventos(){
        Prompt.limparConsole();
        Prompt.separador();
        Prompt.imprimir("MENU DE EVENTOS");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Inclusão de evento.");
        Prompt.imprimir("\t2 - Listagem de evento.");
        Prompt.imprimir("\t3 - Alteração de evento.");
        Prompt.imprimir("\t4 - Exclusão de evento.");
        Prompt.imprimir("\t5 - Voltar ao Menu Principal\n");

        int opcao = Prompt.lerInteiro("Digite aqui: ");
        boolean sair = false;

        switch (opcao) {
            case 1:
                incluirEvento();
                break;
            case 2:
                listarEventos();
                break;
            case 3:
                alterarEvento();
                break;
            case 4:
                deletarEvento();
                break;
            case 5:
                sair = true;
                break;
            default:
                Prompt.imprimir("Valor Inválido.");
                break;
        }

        if (sair != true) {
            Prompt.pressionarEnter();
            menuEventos();
        }
    }

    public void incluirEvento(){
        Prompt.limparConsole();
        Prompt.separador();
        Prompt.imprimir("INCLUIR EVENTO:");
        Prompt.separador();

        boolean dataCorreta = false;
        LocalDate data = null;

        do{
            try {
                
                int ano = Prompt.lerInteiro("Informe o ano do evento: ");
                int mes = Prompt.lerInteiro("Informe o mês do evento: ");
                int dia = Prompt.lerInteiro("Informe o dia do evento: ");
                data =  LocalDate.of(ano, mes, dia);
                dataCorreta = true;
                
            } catch (Exception e) {
                Prompt.imprimir("Data incorreta, por favor digite corretamente");
                Prompt.pressionarEnter();
                
                Prompt.limparConsole();
                Prompt.separador();
                Prompt.imprimir("INCLUIR EVENTO:");
                Prompt.separador();

                dataCorreta = false;
            }
        }while(dataCorreta != true && data == null);
        
        String nome =  Prompt.lerLinha("Informe o nome do evento: ");
        String local = Prompt.lerLinha("Informe o local do evento: ");
        int lotacao = Prompt.lerInteiro("Informe a locação máxima do evento: ");
        double precoIngresso = Prompt.lerDecimal("Informe o preço do ingresso: ");

        Evento evento = new Evento(nome, data, local, lotacao, precoIngresso);

        controleDeEvento.incluirEvento(evento);

        Prompt.separador();
        Prompt.imprimir("Evento cadastrado com sucesso!");
        Prompt.imprimir(evento);
        Prompt.separador();
    }

    public void alterarEvento(){
        Prompt.limparConsole();
        Prompt.separador();
        Prompt.imprimir("ALTERAR EVENTO:");
        Prompt.separador();

        int id = Prompt.lerInteiro("Informe o id do evento: ");

        Evento eventoAntigo = controleDeEvento.buscar(id);

        LocalDate data = null;
        boolean dataCorreta = false;
        if(eventoAntigo == null){
            Prompt.imprimir("nenhum evento encontrado com este id!");
        }else{
            Prompt.limparConsole();
            Prompt.separador();
            Prompt.imprimir("ALTERAR EVENTO (" + eventoAntigo.getNome() + ")");
            Prompt.separador();

            do{
                try {
                    
                    int anoAlterar = Prompt.lerInteiro("Informe o novo ano do evento: ");
                    int mesAlterar = Prompt.lerInteiro("Informe o novo mês do evento: ");
                    int diaAlterar = Prompt.lerInteiro("Informe o novo dia do evento: ");
                    data =  LocalDate.of(anoAlterar, mesAlterar, diaAlterar);
                    dataCorreta = true;
                    
                } catch (Exception e) {
                    Prompt.imprimir("Data incorreta, por favor digite corretamente");
                    Prompt.pressionarEnter();
                    
                    Prompt.limparConsole();
                    Prompt.separador();
                    Prompt.imprimir("ALTERAR EVENTO (" + eventoAntigo.getNome() + ")");
                    Prompt.separador();
    
                    dataCorreta = false;
                }
            }while(dataCorreta != true && data == null);

            String nomeAlterar = Prompt.lerLinha("Informe o novo nome do evento: ");
            
            String localAlterar = Prompt.lerLinha("Informe o novo local do evento: ");
            int lotacaoAlterar = Prompt.lerInteiro("Informe a nova locação máxima do evento: ");
            double precoIngressoAlterar = Prompt.lerDecimal("Informe o novo preço do ingresso: ");

            Evento novoEvento = eventoAntigo;
            novoEvento.setNome(nomeAlterar);
            novoEvento.setData(data);
            novoEvento.setLocal(localAlterar);
            novoEvento.setLotacaoMaxima(lotacaoAlterar);
            novoEvento.setPrecoIngresso(precoIngressoAlterar);

            Evento eventoAlterado = controleDeEvento.alterarEvento(eventoAntigo, novoEvento);

            Prompt.separador();
            Prompt.imprimir("Alteração realizada com sucesso.");
            Prompt.imprimir(eventoAlterado);
            Prompt.separador();
        }
    }
    
    public void listarEventos(){
        Prompt.limparConsole();
        Prompt.separador();
        Prompt.imprimir("LISTA DE EVENTOS:");
        Prompt.separador();

        Prompt.imprimir(controleDeEvento.listaDeEventos());
    }

    public void deletarEvento(){
        Prompt.limparConsole();
        Prompt.separador();
        Prompt.imprimir("DELETAR EVENTO:");
        Prompt.separador();

        int idDeletar = Prompt.lerInteiro("Informe o id do evento: ");
        Evento evento = controleDeEvento.buscar(idDeletar);
    
        if(evento == null){
            Prompt.imprimir("Evento não encontrado.");
        }else{
            controleDeEvento.excluirEvento(idDeletar);
            Prompt.imprimir("Evento excluido com sucesso.");
        }
    }

    public void menuReserva(){
        Prompt.limparConsole();
        Prompt.separador();
        Prompt.imprimir("MENU DE RESERVAS");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Inclusão de reserva.");
        Prompt.imprimir("\t2 - Listagem de reserva.");
        Prompt.imprimir("\t3 - Alteração de reserva.");
        Prompt.imprimir("\t4 - Exclusão de reserva.");
        Prompt.imprimir("\t5 - Voltar ao Menu Principal\n\n");

        int opcao = Prompt.lerInteiro("Digite aqui: ");

        boolean sair = false;
        switch (opcao) {
            case 1:
                incluirReserva();
                break;
            case 2:
                listarReserva();
                break;
            case 3:
                alterarReserva();
                break;
            case 4:
                deletarReserva();
                break;
            case 5:
                sair = true;
                break;
            default:
                Prompt.imprimir("Valor Inválido.");
                break;
        }

        if(sair != true){
            Prompt.pressionarEnter();
            menuReserva();
        }else{
            menuPrincipal();
        }
                
    }

    public void incluirReserva(){
        Prompt.limparConsole();
        Prompt.separador();
        Prompt.imprimir("INCLUIR RESERVA");
        Prompt.separador();
        Prompt.imprimir(controleDeEvento.listaDeEventos());
        
        int idEvento = Prompt.lerInteiro("Selecione o id do evento desejado: ");
        Evento eventoReservar = controleDeEvento.buscar(idEvento);

        if (eventoReservar == null) {
            Prompt.imprimir("Opção inválida.");
        }else{

            String nomeResponsavel = Prompt.lerLinha("Informe o nome do responsável pela reserva: ");
            int quantPessoas = Prompt.lerInteiro("Informe para quantas pessoas é a reserva: ");
            LocalDate data = LocalDate.now();
            double valorTotalReserva = eventoReservar.getPrecoIngresso() * quantPessoas;

            Reserva reserva = new Reserva(nomeResponsavel, quantPessoas, data, eventoReservar, valorTotalReserva);
            eventoReservar.setQuantIgressosVendidos(eventoReservar.getQuantIgressosVendidos() + quantPessoas);

            controleDeReserva.incluirReserva(reserva);

            Prompt.separador();
            Prompt.imprimir("Reserva realizada com sucesso.");
            Prompt.imprimir(reserva);
            Prompt.separador();
        }
    }

    public void alterarReserva(){
        Prompt.limparConsole();
        Prompt.separador();
        Prompt.imprimir("ALTERAR RESERVA");
        Prompt.separador();

        Integer idReservaAlterar = Prompt.lerInteiro("Informe o id da reserva: ");
        Reserva ReservaAlterar = controleDeReserva.buscar(idReservaAlterar);

        if(ReservaAlterar == null){
            Prompt.imprimir("Id não encontrado.");
        }else{
            Prompt.limparConsole();
            Prompt.separador();
            Prompt.imprimir("ALTERAR RESERVA (ID: " + ReservaAlterar.getId() + " Evento: "+ ReservaAlterar.getEvento().getNome() +")");
            Prompt.separador();

            String nomeResponsavel = Prompt.lerLinha("Informe o nome do responsável pela reserva: ");
            int quantPessoas = Prompt.lerInteiro("Informe para quantas pessoas é a reserva: ");
            LocalDate data = LocalDate.now();

            Reserva novaReservaAlterada = ReservaAlterar;
            novaReservaAlterada.setData(data);
            novaReservaAlterada.setNomeResponsavel(nomeResponsavel);
            novaReservaAlterada.setQuantPessoas(quantPessoas);

            Character continuar = ' ';
            
            do {
                continuar = Prompt.lerCaractere("Deseja alterar o evento "+ReservaAlterar.getEvento().getNome()+"? (s/n)");

                if(Character.toLowerCase(continuar) == 's'){
                    Prompt.limparConsole();
                    Prompt.separador();
                    Prompt.imprimir("ALTERAR RESERVA (ID: " + ReservaAlterar.getId() + " Evento: "+ ReservaAlterar.getEvento().getNome() +")");
                    Prompt.separador();

                    Prompt.imprimir(controleDeEvento.listaDeEventos());
                    
                    int opcaoEventoReserva = Prompt.lerInteiro("Selecione o id do evento desejado: ");
                    Evento eventoDaReserva = controleDeEvento.buscar(opcaoEventoReserva);
                    ReservaAlterar.setEvento(eventoDaReserva);


                    double valorTotalReserva = eventoDaReserva.getPrecoIngresso() * quantPessoas;
                    novaReservaAlterada.setValorTotal(valorTotalReserva);
                    eventoDaReserva.setQuantIgressosVendidos(eventoDaReserva.getQuantIgressosVendidos() + quantPessoas - ReservaAlterar.getQuantPessoas());
                    novaReservaAlterada.setEvento(eventoDaReserva);
                    break;
                }else if (Character.toLowerCase(continuar) != 'n') {
                    Prompt.imprimir("Digite s/n por favor!");
                    Prompt.pressionarEnter();

                    Prompt.limparConsole();
                    Prompt.separador();
                    Prompt.imprimir("ALTERAR RESERVA (ID: " + ReservaAlterar.getId() + " Evento: "+ ReservaAlterar.getEvento().getNome() +")");
                    Prompt.separador();
                }

            } while (Character.toLowerCase(continuar) != 'n');

            controleDeReserva.alterarReserva(ReservaAlterar, novaReservaAlterada);
            
            
            Prompt.imprimir("Alteração realizada com sucesso.");
            Prompt.imprimir(ReservaAlterar);
            Prompt.separador();
        }
    }

    public void listarReserva(){
        Prompt.limparConsole();
        Prompt.separador();
        Prompt.imprimir("LISTAR RESERVAS");
        Prompt.separador();

        Prompt.imprimir(controleDeReserva.listaDeReservas());
    }

    public void deletarReserva(){
        Prompt.limparConsole();
        Prompt.separador();
        Prompt.imprimir("LISTAR RESERVAS");
        Prompt.separador();

        Integer idReservaDeletar = Prompt.lerInteiro("Informe o id do evento: ");
        Reserva reservaDeletar = controleDeReserva.buscar(idReservaDeletar);

        if(reservaDeletar == null){
            Prompt.imprimir("Reserva não encontradoa.");
        }else{
            controleDeReserva.excluirReserva(idReservaDeletar);
            Prompt.imprimir("Reserva excluida com sucesso.");
        }
    }

    public void encerrarPrograma(){
        Prompt.imprimir("Encerrando o programa...");
        System.exit(3);
    }
}
