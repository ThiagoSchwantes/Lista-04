package br.edu.up.models;

public abstract class Cliente {
    
    private String nome;
    private String telefone;
    private String email;
    private Endereco endereco;
    private Double vlrMaxCredito;
    private Double vlrEmprestado;
    
    public Cliente(String nome, String telefone, String email, Endereco endereco, Double vlrMaxCredito,
            Double vlrEmprestado) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.vlrMaxCredito = vlrMaxCredito;
        this.vlrEmprestado = vlrEmprestado;
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

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Double getVlrMaxCredito() {
        return vlrMaxCredito;
    }
    public void setVlrMaxCredito(Double vlrMaxCredito) {
        this.vlrMaxCredito = vlrMaxCredito;
    }

    public Double getVlrEmprestado() {
        return vlrEmprestado;
    }
    public void setVlrEmprestado(Double vlrEmprestado) {
        this.vlrEmprestado = vlrEmprestado;
    }

    public void emprestar(double valor) {
        if (valor + getVlrEmprestado() <= getVlrMaxCredito()) {
            setVlrEmprestado(getVlrEmprestado() + valor);
        } else {
            System.out.println("Valor de crédito excedido!");
        }
    }

    public void devolver(double valor) {
        if (getVlrEmprestado() >= valor) {
            setVlrEmprestado(getVlrEmprestado() - valor);
        } else {
            System.out.println("Valor de devolução maior que o valor emprestado!");
        }
    }

    public double getSaldo(){
        return vlrMaxCredito - vlrEmprestado;
    }

    @Override
    public String toString() {
        return "Cliente [nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", endereco=" + endereco
                + ", vlrMaxCredito=" + vlrMaxCredito + ", vlrEmprestado=" + vlrEmprestado + "]";
    }

    
    
}
