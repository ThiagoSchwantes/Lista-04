package br.edu.up.Controllers;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.modelos.Seguro;
import br.edu.up.views.Menu;

public class ControleSeguros {
    List<Seguro> seguros = new ArrayList<>();
    
    public boolean adicionarSeguro(Seguro seguro){
        seguros.add(seguro);
        return true;
    }

    public Seguro localizarSeguro(Menu menu){
        String apolice = menu.pegarApolice();
        
        for (Seguro seguro : seguros) {
            if (seguro.getApolice().equals(apolice)) {
                return seguro;
            }
        }
        
        return null;
    }

    public boolean excluirSeguro(Menu menu) {
        String apolice = menu.pegarApolice();
        
        for (Seguro seguro : seguros) {
            if (seguro.getApolice().equals(apolice)) { 
                seguros.remove(seguro);
                return true; 
            }
        }
        
        return false;
    }

    public void excluirTodosOsSeguros() {
        seguros.clear();
    }

    public List<Seguro> getSeguros() {
        return seguros;
    }

    public void setSeguros(List<Seguro> seguros) {
        this.seguros = seguros;
    }    
}
