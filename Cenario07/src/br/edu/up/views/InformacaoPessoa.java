package br.edu.up.views;

import br.edu.up.utils.Prompt;

public class InformacaoPessoa {
    public String registrarNome(){
        String nome = Prompt.lerLinha("Informe o nome da pessoa: ");
        return nome;
    }

    public String registrarRg(){
        String rg = Prompt.lerLinha("Informe o rg da pessoa: ");
        return rg;
    }

    public String registrarMatricula(){
        String matricula = Prompt.lerLinha("Informe a matricula da pessoa: ");
        return matricula;
    }
}
