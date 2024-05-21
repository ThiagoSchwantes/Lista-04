package br.edu.up.modelos;

public abstract class Contato{
    private static int contadorCodigo = 0;
    private int codigo;
    private String nome;
    private String telefone;
    
    public Contato(String nome, String telefone) {
        this.codigo = ++contadorCodigo;
        this.nome = nome;
        this.telefone = telefone;
    }

    public Integer getCodigo() {
        return codigo;
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Contato [codigo=" + codigo + ", nome=" + nome + ", telefone=" + telefone + "]";
    } 
}
