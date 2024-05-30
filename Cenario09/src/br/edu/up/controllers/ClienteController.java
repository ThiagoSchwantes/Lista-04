package br.edu.up.controllers;

import java.util.ArrayList;
import java.util.List;
import br.edu.up.models.Cliente;
import br.edu.up.models.clientes.ClienteEmpresa;
import br.edu.up.models.clientes.ClientePessoa;

public class ClienteController {
    
    List<Cliente> clientes = new ArrayList<>();

    public boolean incluirClientePessoa(ClientePessoa clientePessoa){
        Cliente addCliente = clientePessoa;

        clientes.add(addCliente);
        return true;
    }

    public void incluirClienteEmpresa(ClienteEmpresa clienteEmpresa){
        Cliente cliente = clienteEmpresa;
        clientes.add(cliente);
    }

    public Cliente buscar(String identificacao){
        Cliente clienteEmprestar = null;
        
        for (Cliente cliente : clientes) {
            if(cliente instanceof ClientePessoa){
                if(((ClientePessoa) cliente).getCpf().equals(identificacao)){
                    clienteEmprestar = cliente;
                    break;
                }
            }else if(cliente instanceof ClienteEmpresa){
                if(((ClienteEmpresa) cliente).getCnpj().equals(identificacao)){
                    clienteEmprestar = cliente;
                    break;
                }
            }
        }

        return clienteEmprestar;
    }

    public boolean emprestar(double quantEmprestimo, String identificacao){
        Cliente clienteEmprestar = buscar(identificacao);

        if(clienteEmprestar != null && quantEmprestimo <= clienteEmprestar.getSaldo()){
            clienteEmprestar.setVlrEmprestado(clienteEmprestar.getVlrEmprestado() + quantEmprestimo);
            return true;
        }

        return false;
    }

    public boolean devolver(double quantDevolucao, String identificacao){
        Cliente clienteEmprestar = null;

        for (Cliente cliente : clientes) {
            if(cliente instanceof ClientePessoa){
                if(((ClientePessoa) cliente).getCpf().equals(identificacao)){
                    clienteEmprestar = cliente;
                    break;
                }
            }else if(cliente instanceof ClienteEmpresa){
                if(((ClienteEmpresa) cliente).getCnpj().equals(identificacao)){
                    clienteEmprestar = cliente;
                    break;
                }
            }
        }

        if(clienteEmprestar != null){
            clienteEmprestar.setVlrEmprestado(clienteEmprestar.getVlrEmprestado() - quantDevolucao);
            return true;
        }

        return false;
    }

    public String getListaClientesEmpresa() {
        String listaClienteEmpresa = "";
        int indexEmpresa = 0;
        for (int i = 0; i < clientes.size(); i++) {
            if(clientes.get(i) instanceof ClienteEmpresa){
                indexEmpresa++;
                
                if(indexEmpresa == 1){
                    listaClienteEmpresa += clientes.get(i).toString();
                }else{
                    listaClienteEmpresa += "\n\n" + clientes.get(i).toString();
                }
            }
        }
        return listaClienteEmpresa;
    }

    public String getListaClientesPessoa() {
        String listaClientePessoa = "";
        int indexPessoa = 0;

        for (int i = 0; i < clientes.size(); i++) {
            if(clientes.get(i) instanceof ClientePessoa){
                indexPessoa++;
                if(indexPessoa == 1){
                    listaClientePessoa += clientes.get(i).toString();
                }else{
                    listaClientePessoa += "\n\n" +clientes.get(i).toString();
                }
                
            }
        }
        return listaClientePessoa;
    }
}