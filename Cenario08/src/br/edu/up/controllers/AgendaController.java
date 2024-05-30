package br.edu.up.controllers;

import br.edu.up.modelos.*;
import br.edu.up.modelos.contatos.Comercial;
import br.edu.up.modelos.contatos.Pessoal;

public class AgendaController {

    Agenda agenda = new Agenda();
    int contadorCodigo = 0;

    public Pessoal incluirContatoPessoal(String nome, String telefone, String aniversario){
        Pessoal novoContato = new Pessoal(contadorCodigo, nome, telefone, aniversario);
        contadorCodigo++;
        agenda.adicionar(novoContato);

        return novoContato;
    }

    public Comercial incluirContatoComercial(String nome, String telefone, String cnpj){
        Comercial comercial = new Comercial(contadorCodigo, nome, telefone, cnpj);
        agenda.adicionar(comercial);

        return comercial;
    }

    public boolean excluirContato(int codigo){
        return agenda.excluirContato(codigo);
    }

    public Contato consultarContato(int codigo){
        return agenda.getContato(codigo);
    }

    public String listarContatos(){
        return agenda.listarContatos();
    }
}