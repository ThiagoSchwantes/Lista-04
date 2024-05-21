package br.edu.up.views;
import java.util.Scanner;

import br.edu.up.controllers.ClienteController;
import br.edu.up.models.*;
import br.edu.up.utils.*;

public class Menu {

    ClienteController controleCliente = new ClienteController();
    public ClientePessoa incluirClientePessoa(){
        String nome = Prompt.lerLinha("Informe o nome do cliente: ");
        String telefone = Prompt.lerLinha("Informe o telefone do cliente: ");
        String email = Prompt.lerLinha("Informe o email do cliente: ");

        String cpf = Prompt.lerLinha("Informe o cpf do cliente: ");
        double peso = Prompt.lerDecimal("Informe o peso do cliente: ");
        double altura = Prompt.lerDecimal("Informe a altura do cliente: ");

        String rua = Prompt.lerLinha("Informe a rua do cliente: ");
        String numero = Prompt.lerLinha("Informe o número da casa do cliente: ");
        String bairro = Prompt.lerLinha("Informe o bairro do cliente: ");
        String cep = Prompt.lerLinha("Informe o CEP do cliente: ");

        String nomeCidade = Prompt.lerLinha("Informe o nome da cidade do cliente: ");
        String uf = Prompt.lerLinha("Informe o estado que o cliente mora: ");

        Double maxCredito = Prompt.lerDecimal("Informe o valor máximo permitido de crédito ao cliente: ");
        Double valorEmprestado = 0.0;

        Cidade cidade = new Cidade(nomeCidade, uf);
        Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade);
        ClientePessoa clientePessoa = new ClientePessoa(nome, telefone, email, endereco, maxCredito, valorEmprestado, cpf, peso, altura);
        controleCliente.incluirClientePessoa(clientePessoa);
        return clientePessoa;
    }

    public ClienteEmpresa incluirClienteEmpresa(){
        String nome = Prompt.lerLinha("Informe o nome do cliente: ");
        String telefone = Prompt.lerLinha("Informe o telefone do cliente: ");
        String email = Prompt.lerLinha("Informe o email do cliente: ");

        String cnpj = Prompt.lerLinha("Informe o cnpj do cliente: ");
        String inscEstadual = Prompt.lerLinha("Informe a inscrição estadual do cliente: ");
        int anoFundacao = Prompt.lerInteiro("Informe o ano de fundação da empresa do cliente: ");

        String rua = Prompt.lerLinha("Informe a rua do cliente: ");
        String numero = Prompt.lerLinha("Informe o número da casa do cliente: ");
        String bairro = Prompt.lerLinha("Informe o bairro do cliente: ");
        String cep = Prompt.lerLinha("Informe o CEP do cliente: ");

        String nomeCidade = Prompt.lerLinha("Informe o nome da cidade do cliente: ");
        String uf = Prompt.lerLinha("Informe o estado que o cliente mora: ");

        Double maxCredito = Prompt.lerDecimal("Informe o valor máximo permitido de crédito ao cliente: ");
        Double valorEmprestado = 0.0;

        Cidade cidade = new Cidade(nomeCidade, uf);
        Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade);
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(nome, telefone, email, endereco, maxCredito, valorEmprestado, cnpj, inscEstadual, anoFundacao);
        controleCliente.incluirClienteEmpresa(clienteEmpresa);
        return clienteEmpresa;
    }

    public void mostrarClientePessoa() {
        for (Cliente cliente : controleCliente.getListaClientesPessoa()) {
            System.out.println(cliente.toString());
        }
    }

    public void mostrarClienteEmpresa() {
        for (Cliente cliente : controleCliente.getListaClientesEmpresa()) {
            System.out.println(cliente.toString());
        }
    }
    
    private void emprestarClientePessoa() {
        String nome = Prompt.lerLinha("Informe o nome do cliente: ");
        boolean clienteEncontrado = false;
    
        for (Cliente cliente : controleCliente.getListaClientesPessoa()) {
            if (cliente.getNome().equals(nome)) {
                double valor = Prompt.lerDecimal("Informe o valor do empréstimo: ");
                cliente.emprestar(valor);
                Prompt.imprimir("Empréstimo realizado com sucesso.");
                clienteEncontrado = true;
                break;
            }
        }
        
        if (!clienteEncontrado) {
            Prompt.imprimir("Cliente não encontrado ou não é uma pessoa.");
        }
    }

    private void emprestarClienteEmpresa() {
        String nome = Prompt.lerLinha("Informe o nome da empresa do cliente: ");
        boolean clienteEncontrado = false;
    
        for (Cliente cliente : controleCliente.getListaClientesEmpresa()) {
            if (cliente.getNome().equals(nome)) {
                double valor = Prompt.lerDecimal("Informe o valor do empréstimo: ");
                cliente.emprestar(valor);
                Prompt.imprimir("Empréstimo realizado com sucesso.");
                clienteEncontrado = true;
                break;
            }
        }
        
        if (!clienteEncontrado) {
            Prompt.imprimir("Cliente não encontrado ou não é uma pessoa.");
        }
    }
    
    private void devolucaoClientePessoa() {
        String nome = Prompt.lerLinha("Informe o nome do cliente: ");
        boolean clienteEncontrado = false;
    
        for (Cliente cliente : controleCliente.getListaClientesPessoa()) {
            if (cliente.getNome().equals(nome)) {
                double valor = Prompt.lerDecimal("Informe o valor da devolução: ");
                cliente.devolver(valor);
                Prompt.imprimir("Devolução realizado com sucesso.");
                clienteEncontrado = true;
                break;
            }
        }
        
        if (!clienteEncontrado) {
            Prompt.imprimir("Cliente não encontrado ou não é uma pessoa.");
        }
    }

    private void devolucaoClienteEmpresa() {
        String nome = Prompt.lerLinha("Informe o nome da empresa do cliente: ");
        boolean clienteEncontrado = false;
    
        for (Cliente cliente : controleCliente.getListaClientesEmpresa()) {
            if (cliente.getNome().equals(nome)) {
                double valor = Prompt.lerDecimal("Informe o valor da devolução: ");
                cliente.devolver(valor);
                Prompt.imprimir("Devolução realizado com sucesso.");
                clienteEncontrado = true;
                break;
            }
        }
        
        if (!clienteEncontrado) {
            Prompt.imprimir("Cliente não encontrado ou não é uma pessoa.");
        }
    }

    Scanner scanner = new Scanner(System.in);
    public void menuPrincipal(){

        Prompt.separador();
        Prompt.imprimir("MENU PRINCIPAL");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Incluir cliente pessoa");
        Prompt.imprimir("\t2 - Incluir cliente empresa");
        Prompt.imprimir("\t3 - Mostrar dados cliente pessoa");
        Prompt.imprimir("\t4 - Mostrar dados cliente empresa");
        Prompt.imprimir("\t5 - Emprestar para cliente pessoa");
        Prompt.imprimir("\t6 - Emprestar para cliente empresa");
        Prompt.imprimir("\t7 - Devolução de cliente pessoa");
        Prompt.imprimir("\t8 - Devolução de cliente empresa");
        Prompt.imprimir("\t9 - Sair");

        int opcao1 = Prompt.lerInteiro("Digite aqui: ");

        switch (opcao1) {
            case 1:
                incluirClientePessoa();
                Prompt.separador();
                Prompt.imprimir("cliente cadastrado com sucesso.");
                Prompt.separador();
                continuar();
                break;
            case 2:
                incluirClienteEmpresa();
                Prompt.separador();
                Prompt.imprimir("cliente cadastrado com sucesso.");
                Prompt.separador();
                continuar();
                break;
            case 3:
                mostrarClientePessoa();
                continuar();
                break;
            case 4:
                mostrarClienteEmpresa();
                continuar();
                break;
            case 5:
                emprestarClientePessoa();
                Prompt.separador();
                continuar();
                break;
            case 6:
                emprestarClienteEmpresa();
                Prompt.separador();
                continuar();
                break;
            case 7:
                devolucaoClientePessoa();
                Prompt.separador();
                continuar();
                break;
            case 8:
                devolucaoClienteEmpresa();
                Prompt.separador();
                continuar();
                break;
            case 9:
                encerrarPrograma();
                break;
            default:
                Prompt.imprimir("Valor Inválido.");
                menuPrincipal();
                break;
        }
    }

    public void encerrarPrograma(){
        Prompt.imprimir("Encerrando o programa...");
        System.exit(9);
    }

    public void continuar(){
        Prompt.imprimir("Pressione qualquer tecla para continuar...");
        scanner.nextLine();
        menuPrincipal();
    }
}
