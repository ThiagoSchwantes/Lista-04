package br.edu.up.views;

import br.edu.up.utils.Prompt;

public class InformacaoTitulacao {
    public String registrarNomeInstituicao(){
        String nomeInstituicao = Prompt.lerLinha("Informe o nome da instituição da sua titulação: ");
        return nomeInstituicao;
    }

    public int resgistrarAnoConclusao(){
        int anoConclusao = Prompt.lerInteiro("Informe o ano de conclusão da sua titulação: ");
        return anoConclusao;
    }

    public String registrarNomeTitulo(){
        String nomeTitulo = Prompt.lerLinha("Informe o nome do titulo da titulação: ");
        return nomeTitulo;
    }

    public String registrarTituloTrabalho(){
        String tituloTrabalho = Prompt.lerLinha("Informe o titulo do trabalho de conclusão da titulação: ");
        return tituloTrabalho;
    }
}
