package br.edu.up.views;

import br.edu.up.controllers.ClienteController;
import br.edu.up.models.*;
import br.edu.up.models.clientes.ClienteEmpresa;
import br.edu.up.models.clientes.ClientePessoa;
import br.edu.up.utils.*;

public class Menu {

    ClienteController controleCliente = new ClienteController();

    public void menuPrincipal(){
        Prompt.clearConsole();
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
        Prompt.clearConsole();

        switch (opcao1) {
            case 1:
                incluirClientePessoa();
                break;
            case 2:
                incluirClienteEmpresa();
                break;
            case 3:
                mostrarClientePessoa();
                break;
            case 4:
                mostrarClienteEmpresa();
                break;
            case 5:
                emprestarClientePessoa();
                break;
            case 6:
                emprestarClienteEmpresa();
                break;
            case 7:
                devolucaoClientePessoa();
                break;
            case 8:
                devolucaoClienteEmpresa();
                break;
            case 9:
                encerrarPrograma();
                break;
            default:
                Prompt.imprimir("Valor Inválido.");
                break;
        }

        Prompt.separador();
        Prompt.pressionarEnter();
        Prompt.clearConsole();
        menuPrincipal();
    }

    public void incluirClientePessoa(){
        Prompt.separador();
        Prompt.imprimir("INCLUIR CLIENTE PESSOA");
        Prompt.separador();

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

        Double valorEmprestado = 0.0;

        Cidade cidade = new Cidade(nomeCidade, uf);
        Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade);
        ClientePessoa clientePessoa = new ClientePessoa(nome, telefone, email, endereco, valorEmprestado, cpf, peso, altura);
        controleCliente.incluirClientePessoa(clientePessoa);
        
        Prompt.separador();
        Prompt.imprimir("cliente cadastrado com sucesso.");
    }

    public void incluirClienteEmpresa(){
        Prompt.separador();
        Prompt.imprimir("INCLUIR CLIENTE EMPRESA");
        Prompt.separador();

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

        Double valorEmprestado = 0.0;

        Cidade cidade = new Cidade(nomeCidade, uf);
        Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade);
        ClienteEmpresa clienteEmpresa = new ClienteEmpresa(nome, telefone, email, endereco, valorEmprestado, cnpj, inscEstadual, anoFundacao);
        controleCliente.incluirClienteEmpresa(clienteEmpresa);
        
        Prompt.separador();
        Prompt.imprimir("cliente cadastrado com sucesso.");
    }

    public void mostrarClientePessoa() {
        Prompt.separador();
        Prompt.imprimir("MOSTRAR CLIENTES PESSOA");
        Prompt.separador();

        if(controleCliente.getListaClientesPessoa().equals("")){
            Prompt.imprimir("Nenhum cliente empresa cadastrado ainda!");
        }else{
            Prompt.imprimir(controleCliente.getListaClientesPessoa());
        }
    }

    public void mostrarClienteEmpresa() {
        Prompt.separador();
        Prompt.imprimir("MOSTRAR CLIENTES EMPRESA");
        Prompt.separador();
        
        if(controleCliente.getListaClientesEmpresa().equals("")){
            
            Prompt.imprimir("Nenhum cliente empresa cadastrado ainda!");
        }else{
            Prompt.imprimir(controleCliente.getListaClientesEmpresa());
        }
    }
    
    private void emprestarClientePessoa() {
        Prompt.separador();
        Prompt.imprimir("EMPRESTAR CLIENTE PESSOA");
        Prompt.separador();

        String cpf = Prompt.lerLinha("Informe o cpf do cliente: ");
        Cliente cliente = controleCliente.buscar(cpf);

        if(cliente == null || cliente instanceof ClienteEmpresa){
            Prompt.separador();
            Prompt.imprimir("Nenhum cliente pessoa encontrado com esse cpf!");
        }else{
            double valor = Prompt.lerDecimal("Informe o valor do empréstimo:");

            if(controleCliente.emprestar(valor, cpf)){
                Prompt.separador();
                Prompt.imprimir("Emprestado com sucesso!");
            }else{
                Prompt.separador();
                Prompt.imprimir("Não foi possivel efetuar o emprestimo!");
                Prompt.imprimir("Motivo: o cliente pessoa não pode ter crédito acima de 10 mil!");
                Prompt.imprimir("Você pode emprestar atualmente apenas: " + cliente.getSaldo());
            }
        }
    }

    private void emprestarClienteEmpresa() {
        Prompt.separador();
        Prompt.imprimir("EMPRESTAR CLIENTE EMPRESA");
        Prompt.separador();

        String cnpj = Prompt.lerLinha("Informe o cnpj da empresa do cliente: ");

        Cliente cliente = controleCliente.buscar(cnpj);

        if(cliente == null || cliente instanceof ClientePessoa){
            Prompt.separador();
            Prompt.imprimir("Nenhum cliente empresa encontrado com esse cnpj!");
        }else{
            double valor = Prompt.lerDecimal("Informe o valor do empréstimo:");

            if(controleCliente.emprestar(valor, cnpj)){
                Prompt.separador();
                Prompt.imprimir("Emprestado com sucesso!");
            }else{
                Prompt.separador();
                Prompt.imprimir("Não foi possivel efetuar o emprestimo!");
                Prompt.imprimir("Motivo: o cliente pessoa não pode ter crédito acima de 10 mil!");
                Prompt.imprimir("Você pode emprestar atualmente apenas: " + cliente.getSaldo());
            }
        }
    }
    
    private void devolucaoClientePessoa() {
        Prompt.separador();
        Prompt.imprimir("EMPRESTAR CLIENTE PESSOA");
        Prompt.separador();

        String cpf = Prompt.lerLinha("Informe o cpf do cliente: ");
        Cliente cliente = controleCliente.buscar(cpf);


        if(cliente == null || cliente instanceof ClienteEmpresa){
            Prompt.separador();
            Prompt.imprimir("Nenhum cliente pessoa encontrado com esse cpf!");
        }else{
            double valor = Prompt.lerDecimal("Informe o valor da devolucao: (Total emprestimo: " + cliente.getVlrEmprestado() + ")");

            if(valor > cliente.getVlrEmprestado()){
                Prompt.separador();
                Prompt.imprimir("O máximo que você pode devolver é apenas " + cliente.getVlrEmprestado());
            }else{            
                controleCliente.devolver(valor, cpf);

                Prompt.separador();
                Prompt.imprimir("Devolvido com sucesso!");
                Prompt.imprimir("Valor atual total emprestado do cliente: (" + (cliente.getVlrEmprestado()) + "/ 10000)");
            }
        }
    }

    private void devolucaoClienteEmpresa() {
        Prompt.separador();
        Prompt.imprimir("EMPRESTAR CLIENTE EMPRESA");
        Prompt.separador();

        String cnpj = Prompt.lerLinha("Informe o cnpj da empresa do cliente: ");

        Cliente cliente = controleCliente.buscar(cnpj);

        if(cliente == null || cliente instanceof ClientePessoa){
            Prompt.separador();
            Prompt.imprimir("Nenhum cliente empresa encontrado com esse cnpj!");
        }else{
            double valor = Prompt.lerDecimal("Informe o valor da devolucao: (Total emprestimo: " + cliente.getVlrEmprestado() + ")");

            if(valor > cliente.getVlrEmprestado()){
                Prompt.separador();
                Prompt.imprimir("O máximo que você pode devolver é apenas " + cliente.getVlrEmprestado());
            }else{  
                controleCliente.devolver(valor, cnpj);

                Prompt.separador();
                Prompt.imprimir("Devolvido com sucesso!");
                Prompt.imprimir("Valor atual total emprestado do cliente: (" + (cliente.getVlrEmprestado()) + "/ 25000)");
            }
        }
    }

    public void encerrarPrograma(){
        Prompt.imprimir("Encerrando o programa...");
        System.exit(9);
    }
}
