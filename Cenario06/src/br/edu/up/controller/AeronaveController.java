package br.edu.up.controller;

import br.edu.up.models.Aeronave;

public class AeronaveController {
    Aeronave[] aeronavesCadastradas = new Aeronave[0];
    Integer index = 0;

    public void adicionar(Aeronave aeronave){
        aeronave.setCodigo(index);
        index ++;

        Aeronave[] aux = new Aeronave[aeronavesCadastradas.length + 1];
        System.arraycopy(aeronavesCadastradas, 0, aux, 0, aeronavesCadastradas.length);
        
        aux[aeronavesCadastradas.length] = aeronave;

        aeronavesCadastradas = aux;
    }

    public String listar(){
        String lista = "";
        
        for (Aeronave aeronave : aeronavesCadastradas) {
            lista += "Aeronave " + aeronave.toString();
            lista += "\n---------------------------------------------------\n";
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

    public boolean alterar(Aeronave aeronaveAntiga, Aeronave aeronaveNova){
        for (int i = 0; i < aeronavesCadastradas.length; i++) {
            if(aeronavesCadastradas[i] == aeronaveAntiga){
                aeronavesCadastradas[i] = aeronaveNova;
                return true;
            }
        }    
        return false;
    }

    public void deletar(Aeronave aeronave){
        Aeronave[] novaAeronavesCadastradas = new Aeronave[aeronavesCadastradas.length - 1];

        for (int i = 0; i < aeronavesCadastradas.length; i++) {
            if(aeronavesCadastradas[i] == aeronave){

                for (int j = i; j < aeronavesCadastradas.length-1; j++) {
                    novaAeronavesCadastradas[j] = aeronavesCadastradas[j+1];
                }
                break;
            }else{
                novaAeronavesCadastradas[i] = aeronavesCadastradas[i];
            }
        }
        
        aeronavesCadastradas = new Aeronave[aeronavesCadastradas.length-1];
        aeronavesCadastradas = novaAeronavesCadastradas;
    }
}
