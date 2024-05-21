package br.edu.up.models;

public class ClienteEmpresa extends Cliente {
    
    private String cnpj;
    private String inscEstadual;
    private int anoFundacao;

    public ClienteEmpresa(String nome,String telefone,String email,Endereco endereco,Double vlrMaxCredito,Double vlrEmprestado,String cnpj, String inscEstadual, int anoFundacao) {
        super(nome, telefone, email, endereco, vlrMaxCredito, vlrEmprestado);
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
        return "ClienteEmpresa [cnpj=" + cnpj + ", inscEstadual=" + inscEstadual + ", anoFundacao=" + anoFundacao
                + ", getNome()=" + getNome() + ", getTelefone()=" + getTelefone() + ", getEmail()=" + getEmail()
                + ", getEndereco()=" + getEndereco() + ", getVlrMaxCredito()=" + getVlrMaxCredito()
                + ", getVlrEmprestado()=" + getVlrEmprestado() + "]";
    }

    @Override
    public void emprestar(double valor) {
        if (valor + getVlrEmprestado() <= getVlrMaxCredito()) {
            setVlrEmprestado(getVlrEmprestado() + valor);
        } else {
            System.out.println("Valor de crédito excedido!");
        }
    }

    @Override
    public void devolver(double valor) {
        if (getVlrEmprestado() >= valor) {
            setVlrEmprestado(getVlrEmprestado() - valor);
        } else {
            System.out.println("Valor de devolução maior que o valor emprestado!");
        }
    }
    
}
