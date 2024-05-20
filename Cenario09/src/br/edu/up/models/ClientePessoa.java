package br.edu.up.models;

public class ClientePessoa extends Cliente{
    private String cpf;
    private double peso;
    private double altura;

    public ClientePessoa(String nome,String telefone,String email,Endereco endereco,Double vlrMaxCredito,Double vlrEmprestado,String cpf, double peso, double altura) {
        super(nome, telefone, email, endereco, vlrMaxCredito, vlrEmprestado);
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
