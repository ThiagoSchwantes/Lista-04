package br.edu.up.models.clientes;

import br.edu.up.models.Cliente;
import br.edu.up.models.Endereco;

public class ClientePessoa extends Cliente{
    private String cpf;
    private double peso;
    private double altura;

    public ClientePessoa(String nome, String telefone, String email, Endereco endereco, Double vlrEmprestado, String cpf, double peso, double altura) {
        super(nome, telefone, email, endereco, 10000.0, vlrEmprestado);
        this.cpf = cpf;
        this.peso = peso;
        this.altura = altura;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "ClientePessoa [cpf=" + cpf + ", peso=" + peso + ", altura=" + altura + ", Nome=" + getNome()
                + ", Telefone=" + getTelefone() + ", getEmail()=" + getEmail() + ", Endereco=" + getEndereco()
                + ", VlrMaxCredito=" + getVlrMaxCredito() + ", VlrEmprestado=" + getVlrEmprestado() + "]";
    }
}
