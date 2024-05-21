package br.edu.up.controllers;

import br.edu.up.modelos.*;
import br.edu.up.views.Menu;

public class ContatoController {

    public Pessoal incluirContatoPessoal(Menu menu, Agenda agenda){
        String nome = menu.getNome();
        String telefone = menu.getTelefone();
        String aniversario = menu.getAniversario();

        Pessoal pessoal = new Pessoal(nome, telefone, aniversario);
        agenda.adicionarContatoPessoal(pessoal);
        return pessoal;
    }

    public Comercial incluirContatoComercial(Menu menu, Agenda agenda){
        String nome = menu.getNome();
        String telefone = menu.getTelefone();
        String cnpj = menu.getCnpj();

        Comercial comercial = new Comercial(nome, telefone, cnpj);
        agenda.adicionarContatoComercial(comercial);
        return comercial;
    }

    public boolean excluirContato(Menu menu, Agenda agenda){
        int codigo = menu.getCodigo();
        agenda.excluirContato(codigo);
        return true;
    }

    public Contato consultarContato(Menu menu, Agenda agenda){
        int codigo = menu.getCodigo();
        Contato contato = agenda.getContato(codigo);
        return contato;
    }

}
