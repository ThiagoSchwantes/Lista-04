package br.edu.up.views;

import br.edu.up.utils.Prompt;

public class InformacaoAluno {
    public int registrarAnoIngresso(){
        int anoIngresso = Prompt.lerInteiro("Informe o ano de ingresso na instituição: ");
        return anoIngresso;
    }

    public String registrarNomeCurso(){
        String curso = Prompt.lerLinha("Informe o nome do curso do aluno: ");
        return curso;
    }

    public String registrarTurno(){
        String turno = Prompt.lerLinha("Informe o turno do aluno: ");
        return turno;
    }
}
