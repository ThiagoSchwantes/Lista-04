package br.edu.up.controllers;

import java.util.ArrayList;
import java.util.List;
import br.edu.up.modelos.Seguro;

public class ControleSeguros {
    List<Seguro> seguros = new ArrayList<>();
    
    public boolean adicionarSeguro(Seguro seguro){
        seguros.add(seguro);
        return true;
    }

    public String localizarSeguro(String apolice){
        
        for (Seguro seguro : seguros) {
            if (seguro.getApolice().equals(apolice)) {
                return seguro.getDados();
            }
        }
        
        return null;
    }

    public String listarTodosSeguros(){
        String lista = "";

        int contador = 0;
        for (Seguro seguro : seguros) {

            if (contador == 0) {
                lista += seguro.getDados();
                contador++;
            }else{
                lista += "\n\n"+seguro.getDados();
            }
        }

        return lista;
    }

    public boolean excluirSeguro(String apolice) {        
        for (Seguro seguro : seguros) {
            if (seguro.getApolice().equals(apolice)) { 
                seguros.remove(seguro);
                return true; 
            }
        }
        
        return false;
    }

    public int getQuantidadeSeguros(){
        return seguros.size();
    }

    public void excluirTodosOsSeguros() {
        seguros.clear();
    }
}
