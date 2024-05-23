package br.edu.up.controller;


import br.edu.up.models.pessoas.tripulantes.Comissario;

public class ComissarioController {
    Comissario[] comissariosCadastrados = new Comissario[0];
    Integer index = 0;

    public void adicionar(Comissario comissario){
        Comissario[] aux = new Comissario[comissariosCadastrados.length + 1];
        System.arraycopy(comissariosCadastrados, 0, aux, 0, comissariosCadastrados.length);
        
        aux[comissariosCadastrados.length] = comissario;

        comissariosCadastrados = aux;
    }

    public String listar(){
        String lista = "";
        int i = 1;
        for (Comissario comissario : comissariosCadastrados) {
            lista += "Comissario  " + i + " " + comissario.toString();
            lista += "\n---------------------------------------------------\n";
            i++;
        }

        if(lista.equals("")){
            lista = "Nada cadastrado";
            lista += "\n---------------------------------------------------\n";
        }

        return lista;
    }

    public Comissario buscar(String matriculaFuncionario){
        Comissario busca = null;

        for (Comissario comissario : comissariosCadastrados) {
            if(comissario.getMatriculaFuncionario().equals(matriculaFuncionario)){
                busca = comissario;
                break;
            }
        }

        return busca;
    }

    public boolean alterar(Comissario comissarioAntigo, Comissario comissarioAlterado){
        for (int i = 0; i < comissariosCadastrados.length; i++) {
            if(comissariosCadastrados[i] == comissarioAntigo){
                comissariosCadastrados[i] = comissarioAlterado;
                return true;
            }
        }    
        return false;
    }

    public void deletar(Comissario comissarioDeletar){
        Comissario[] novoComissariosCadastrados = new Comissario[comissariosCadastrados.length - 1];

        for (int i = 0; i < comissariosCadastrados.length; i++) {
            if(comissariosCadastrados[i] == comissarioDeletar){

                for (int j = i; j < comissariosCadastrados.length-1; j++) {
                    novoComissariosCadastrados[j] = comissariosCadastrados[j+1];
                }
                break;
            }else{
                novoComissariosCadastrados[i] = comissariosCadastrados[i];
            }
        }
        
        comissariosCadastrados = new Comissario[comissariosCadastrados.length-1];
        comissariosCadastrados = novoComissariosCadastrados;
    }
}
