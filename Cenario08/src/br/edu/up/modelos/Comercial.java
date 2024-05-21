package br.edu.up.modelos;

public class Comercial extends Contato{

    private String cnpj;

    public Comercial(String nome, String telefone, String cnpj){
        super(nome, telefone);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "Comercial [" + 
                ", Codigo=" + getCodigo() + 
                ", Nome=" + getNome() + 
                ", Telefone=" + getTelefone() +
                ", cnpj=" + cnpj + 
                 "]";
    }

    
}
