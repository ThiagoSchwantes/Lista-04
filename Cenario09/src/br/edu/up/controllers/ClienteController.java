package br.edu.up.controllers;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.models.ClienteEmpresa;
import br.edu.up.models.ClientePessoa;

public class ClienteController {
    
    List<ClientePessoa> listaClientesPessoa = new ArrayList<>();
    List<ClienteEmpresa> listaClientesEmpresa = new ArrayList<>();

    public void incluirClientePessoa(ClientePessoa clientePessoa){
        listaClientesPessoa.add(clientePessoa);
    }

    public void incluirClienteEmpresa(ClienteEmpresa clienteEmpresa){
        listaClientesEmpresa.add(clienteEmpresa);
    }

    public List<ClientePessoa> getListaClientesPessoa() {
        return listaClientesPessoa;
    }

    public void setListaClientesPessoa(List<ClientePessoa> listaClientesPessoa) {
        this.listaClientesPessoa = listaClientesPessoa;
    }

    public List<ClienteEmpresa> getListaClientesEmpresa() {
        return listaClientesEmpresa;
    }

    public void setListaClientesEmpresa(List<ClienteEmpresa> listaClientesEmpresa) {
        this.listaClientesEmpresa = listaClientesEmpresa;
    }
    
    
}
