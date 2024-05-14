package br.edu.up.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.models.Aeronave;
import br.edu.up.models.Pessoa.Passageiro;

public class AeronaveController {
    List<Aeronave> aeronavesCadastradas = new ArrayList<>();

    public void adicionar(Aeronave aeronave){
        aeronavesCadastradas.add(aeronave);
    }

    public String listar(){
        String lista = ""; 

        for (Aeronave aeronave : aeronavesCadastradas) {
            lista += "--------------------------\n";
            lista += aeronave.toString()+"\n";
            lista += "--------------------------\n";
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

    public void alterar(Aeronave aeronaveNova){
        int index = aeronavesCadastradas.indexOf(aeronaveNova);
        aeronavesCadastradas.set(index, aeronaveNova);
    }

    public void deletar(Aeronave aeronave){
        aeronavesCadastradas.remove(aeronave);
    }
}
