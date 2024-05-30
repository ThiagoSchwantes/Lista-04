package br.edu.up.models.clientes;

import br.edu.up.models.Cliente;
import br.edu.up.models.Endereco;

public class ClienteEmpresa extends Cliente {
    
    private String cnpj;
    private String inscEstadual;
    private int anoFundacao;

    public ClienteEmpresa(String nome, String telefone, String email, Endereco endereco, Double vlrEmprestado, String cnpj, String inscEstadual, int anoFundacao) {
        super(nome, telefone, email, endereco, 25000.0, vlrEmprestado);
        this.cnpj = cnpj;
        this.inscEstadual = inscEstadual;
        this.anoFundacao = anoFundacao;
    }

    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getInscEstadual() {
        return inscEstadual;
    }
    public void setInscEstadual(String inscEstadual) {
        this.inscEstadual = inscEstadual;
    }
    public int getAnoFundacao() {
        return anoFundacao;
    }
    public void setAnoFundacao(int anoFundacao) {
        this.anoFundacao = anoFundacao;
    }

    @Override
    public String toString() {
        return "ClienteEmpresa [cnpj=" + cnpj + ", insc Estadual=" + inscEstadual + ", ano Fundacao=" + anoFundacao
                + ", Nome=" + getNome() + ", Telefone=" + getTelefone() + ", Email=" + getEmail()
                + ", Endereco=" + getEndereco() + ", MaxCredito=" + getVlrMaxCredito()
                + ", VlrEmprestado=" + getVlrEmprestado() + "]";
    }
}
