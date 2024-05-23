package br.edu.up.controller;

import br.edu.up.models.pessoas.tripulantes.Comandante;

public class ComandanteController {
    Comandante[] comandantesCadastrados = new Comandante[0];

    public void adicionar(Comandante comandante){

        Comandante[] aux = new Comandante[comandantesCadastrados.length + 1];
        System.arraycopy(comandantesCadastrados, 0, aux, 0, comandantesCadastrados.length);
        
        aux[comandantesCadastrados.length] = comandante;

        comandantesCadastrados = aux;
    }

    public String listar(){
        String lista = ""; 
        int i = 1;
        for (Comandante comandante : comandantesCadastrados) {
            lista += "Comandante  " + i + " " + comandante.toString();
            lista += "\n---------------------------------------------------\n";
            i++;
        }

        if(lista.equals("")){
            lista = "Nada cadastrado";
            lista += "\n---------------------------------------------------\n";
        }
        
        return lista;
    }

    public Comandante buscar(String matriculaFuncionario){
        Comandante busca = null;

        for (Comandante comandante : comandantesCadastrados) {
            if(comandante.getMatriculaFuncionario().equals(matriculaFuncionario)){
                busca = comandante;
                break;
            }
        }
        
        return busca;
    }

    public boolean alterar(Comandante comandanteAntigo, Comandante comandanteNovo){
        for (int i = 0; i < comandantesCadastrados.length; i++) {
            if(comandantesCadastrados[i] == comandanteAntigo){
                comandantesCadastrados[i] = comandanteNovo;
                return true;
            }
        }    
        return false;
    }

    public void deletar(Comandante comandante){
        Comandante[] novoComandanteCadastrados = new Comandante[comandantesCadastrados.length - 1];

        for (int i = 0; i < comandantesCadastrados.length; i++) {
            if(comandantesCadastrados[i] == comandante){

                for (int j = i; j < comandantesCadastrados.length-1; j++) {
                    novoComandanteCadastrados[j] = comandantesCadastrados[j+1];
                }
                break;
            }else{
                novoComandanteCadastrados[i] = comandantesCadastrados[i];
            }
        }
        
        comandantesCadastrados = new Comandante[comandantesCadastrados.length-1];
        comandantesCadastrados = novoComandanteCadastrados;
    }
}
