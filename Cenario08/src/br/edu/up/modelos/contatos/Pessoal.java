package br.edu.up.modelos.contatos;

import br.edu.up.modelos.Contato;

public class Pessoal extends Contato{
    
    private String aniversario;

    public Pessoal(int codigo, String nome, String telefone, String aniversario){
        super(codigo, nome, telefone);
        this.aniversario = aniversario;
    }

    public String getAniversario() {
        return aniversario;
    }

    public void setAniversario(String aniversario) {
        this.aniversario = aniversario;
    }

    @Override
    public String toString() {
        return "Pessoal [Codigo()=" + getCodigo() + ", Nome()=" + getNome()
                + ", Telefone()=" + getTelefone() + " , aniversario=" + aniversario + "]";
    }
}
