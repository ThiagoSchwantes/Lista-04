package br.edu.up.telas;

import br.edu.up.controles.CadastroCompromissos;

public class CriarCompromisso {

    public void mostrar(){

        String pessoa = Prompt.lerLinha("Informe o nome da pessoa que estará no compromisso: ");
        String local = Prompt.lerLinha("Informe o local do compromisso: ");
        String assunto = Prompt.lerLinha("Informe o assunto do compromisso: ");
        int hora = Prompt.lerInteiro("Informe a hora do compromisso:");
        String data = Prompt.lerLinha("Informe a data do compromisso (dd/mm/aaaa):");

        CadastroCompromissos cadastroCompromisso = new CadastroCompromissos();

        if(cadastroCompromisso.adicionarCompromisso(pessoa, local, assunto, hora, data)){
            Prompt.imprimir("Compromisso agendado com sucesso!");
        }else{
            Prompt.imprimir("A data digitada já possui muitos compromissos!");
        }
    }
}