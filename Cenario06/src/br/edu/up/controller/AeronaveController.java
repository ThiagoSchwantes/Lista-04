package br.edu.up.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.models.Aeronave;

public class AeronaveController {
    List<Aeronave> aeronavesCadastradas = new ArrayList<>();

    public void cadastrar(Aeronave aeronave){
        aeronavesCadastradas.add(aeronave);
    }

    public String listar(){
        String lista = ""; 
        int i = 1;
        for (Aeronave aeronave : aeronavesCadastradas) {
            lista += "Aeronave " + i + " "+aeronave.toString();
            lista += "\n---------------------------------------------------\n";
            i++;
        }

        return lista;
    }

    public Aeronave buscar(Integer codigo){
        Aeronave busca = null;

        for (Aeronave aeronave : aeronavesCadastradas) {
            if(aeronave.getCodigo() == codigo){
                busca = aeronave;
                break;
            }
        }
        return busca;
    }

    public void alterar(Aeronave aeronaveAntiga, Aeronave passageiroNovo){
        int index = aeronavesCadastradas.indexOf(aeronaveAntiga);
        aeronavesCadastradas.set(index, passageiroNovo);
    }

    public void deletar(Aeronave aeronave){
        aeronavesCadastradas.remove(aeronave);
    }
}
