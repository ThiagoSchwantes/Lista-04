package br.edu.up.views;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.edu.up.models.Passagem;
import br.edu.up.models.Pessoa.Passageiro;
import br.edu.up.utils.Prompt;

public class PassageiroView {
    public void cadastrarPassageiro(){
        String nome = Prompt.lerLinha("Digite o seu nome:");
        String rg = Prompt.lerLinha("Digite o seu RG:");

        Passageiro passageiro = new Passageiro();
        passageiro.setNome(nome);
        passageiro.setRg(rg);


        Controller Controller = new Controller();
    }

    public void listarPassageiros(){

    }

    public void alterarPassageiro(){

    }

    public void deletarPassageiro(){

    }
}
