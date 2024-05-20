package br.edu.up.controller;
import br.edu.up.models.pessoas.Passageiro;

public class PassageiroController {
    Passageiro[] passageirosCadastrados = new Passageiro[0];

    public void adicionar(Passageiro passageiro){
        Passageiro[] aux = new Passageiro[passageirosCadastrados.length + 1];
        System.arraycopy(passageirosCadastrados, 0, aux, 0, passageirosCadastrados.length);
        
        aux[passageirosCadastrados.length] = passageiro;

        passageirosCadastrados = aux;
    }

    public String listar(){
        String lista = ""; 
        int i = 1;
        for (Passageiro passageiro : passageirosCadastrados) {
            lista += "Passageiro " + i + " "+passageiro.toString();
            lista += "\n---------------------------------------------------\n";
            i++;
        }

        if(lista.equals("")){
            lista = "Nada cadastrado";
            lista += "\n---------------------------------------------------\n";
        }

        return lista;
    }

    public Passageiro buscar(String rg){
        Passageiro busca = null;

        for (Passageiro passageiro : passageirosCadastrados) {
            if(passageiro.getRg().equals(rg)){
                busca = passageiro;
                break;
            }
        }
        
        return busca;
    }

    public boolean alterar(Passageiro passageiroAntigo, Passageiro passageiroNovo){
        for (int i = 0; i < passageirosCadastrados.length; i++) {
            if(passageirosCadastrados[i] == passageiroAntigo){
                passageirosCadastrados[i] = passageiroNovo;
                return true;
            }
        }    
        return false;
    }

    public void deletar(Passageiro passageiro){
        Passageiro[] novoPassageirosCadastrados = new Passageiro[passageirosCadastrados.length - 1];

        for (int i = 0; i < passageirosCadastrados.length; i++) {
            if(passageirosCadastrados[i] == passageiro){

                for (int j = i; j < passageirosCadastrados.length-1; j++) {
                    novoPassageirosCadastrados[j] = passageirosCadastrados[j+1];
                }
                break;
            }else{
                novoPassageirosCadastrados[i] = passageirosCadastrados[i];
            }
        }
        
        passageirosCadastrados = new Passageiro[passageirosCadastrados.length-1];
        passageirosCadastrados = novoPassageirosCadastrados;
    }
}
