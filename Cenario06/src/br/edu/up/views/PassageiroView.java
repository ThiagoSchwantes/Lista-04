package br.edu.up.views;

import br.edu.up.models.Pessoas.Passageiro;
import br.edu.up.utils.Prompt;

public class PassageiroView {
    public Passageiro cadatrar(){
        Prompt.separador();
        Prompt.imprimir("CADASTRAR PASSAGEIRO");
        Prompt.separador();

        String nome = Prompt.lerLinha("Digite o seu nome:");
        String rg = Prompt.lerLinha("Digite o seu rg");

        return new Passageiro(nome, rg);
    }

    public Passageiro alterar(Passageiro passageiro){
        String nome = Prompt.lerLinha("Digite o seu novo nome:");
        String rg = Prompt.lerLinha("Digite o seu novo rg");

        passageiro.setNome(nome);
        passageiro.setRg(rg);

        return passageiro;
    }
}
