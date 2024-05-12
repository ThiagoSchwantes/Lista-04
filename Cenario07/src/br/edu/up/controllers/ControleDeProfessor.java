package br.edu.up.controllers;

import br.edu.up.models.Pessoa.Professor;
import br.edu.up.models.Pessoa.Titulacao;
import br.edu.up.views.InformacaoPessoa;
import br.edu.up.views.InformacaoProfessor;
import br.edu.up.views.InformacaoTitulacao;

public class ControleDeProfessor {
    public Professor incluirProfessor(){
        InformacaoPessoa iPessoa = new InformacaoPessoa();
        InformacaoProfessor iProfessor  = new InformacaoProfessor();
        InformacaoTitulacao iTitulacao = new InformacaoTitulacao();

        String nome = iPessoa.registrarNome();
        String rg = iPessoa.registrarRg();
        String matricula = iPessoa.registrarMatricula();

        int lattesId = iProfessor.registrarLattesId();

        String nomeInstituicao = iTitulacao.registrarNomeInstituicao();
        int anoConclusao = iTitulacao.resgistrarAnoConclusao();
        String nomeTitulo = iTitulacao.registrarNomeTitulo();
        String tituloTrabalho = iTitulacao.registrarTituloTrabalho();

        Titulacao titulacao = new Titulacao(nomeInstituicao,anoConclusao,nomeTitulo,tituloTrabalho);
        Professor professor = new Professor(nome,rg,matricula,lattesId,titulacao);
        Professor.getListaProfessores().add(professor);

        return professor;
    }
}
