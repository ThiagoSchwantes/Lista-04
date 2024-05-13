package br.edu.up.controllers;

import br.edu.up.models.Pessoa.Aluno;
import br.edu.up.views.InformacaoAluno;
import br.edu.up.views.InformacaoPessoa;

public class ControleDeAluno {
    public Aluno incluirAluno(){
        InformacaoPessoa iPessoa = new InformacaoPessoa();
        InformacaoAluno iAluno = new InformacaoAluno();

        String nome = iPessoa.registrarNome();
        String rg = iPessoa.registrarRg();
        String matricula = iPessoa.registrarMatricula();
        int anoIngresso = iAluno.registrarAnoIngresso();
        String curso = iAluno.registrarNomeCurso();
        String turno = iAluno.registrarTurno();

        Aluno aluno = new Aluno(nome,rg,matricula,anoIngresso,curso,turno);
        Aluno.getListaAlunos().add(aluno);

        return aluno;
    }
    
}
