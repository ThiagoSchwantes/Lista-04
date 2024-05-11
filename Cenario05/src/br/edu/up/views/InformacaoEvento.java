package br.edu.up.views;
import java.time.LocalDate;

import br.edu.up.utils.*;

public class InformacaoEvento {

    public String registrarNome(){
        String nome = Prompt.lerLinha("Informe o nome do evento: ");
        return nome;
    }

    public LocalDate registrarData(){
        int ano = Prompt.lerInteiro("Informe o ano do evento: ");
        int mes = Prompt.lerInteiro("Informe o mês do evento: ");
        int dia = Prompt.lerInteiro("Informe o dia do evento: ");

        return LocalDate.of(ano, mes, dia);
    }

    public String registrarLocal(){
        String local = Prompt.lerLinha("Informe o local do evento: ");
        return local;
    }

    public int registrarLotacaoMax(){
        int lotacao = Prompt.lerInteiro("Informe a locação máxima do evento: ");
        return lotacao;
    }

    public double registrarPrecoIngresso(){
        double precoIngresso = Prompt.lerDecimal("Informe o preço do ingresso: ");
        return precoIngresso;
    }
    
    

    public String registrarNovoNome(){
        String nome = Prompt.lerLinha("Informe o novo nome do evento: ");
        return nome;
    }

    public LocalDate registrarNovoData(){
        int ano = Prompt.lerInteiro("Informe o novo ano do evento: ");
        int mes = Prompt.lerInteiro("Informe o novo mês do evento: ");
        int dia = Prompt.lerInteiro("Informe o novo dia do evento: ");

        return LocalDate.of(ano, mes, dia);
    }
    
    public String registrarNovoLocal(){
        String local = Prompt.lerLinha("Informe o novo local do evento: ");
        return local;
    }

    public int registrarNovoLotacaoMax(){
        int lotacao = Prompt.lerInteiro("Informe a nova locação máxima do evento: ");
        return lotacao;
    }

    public double registrarNovoPrecoIngresso(){
    double precoIngresso = Prompt.lerDecimal("Informe o novo preço do ingresso: ");
        return precoIngresso;
    }            
}