package br.edu.up.views;

import br.edu.up.models.Aeronave;
import br.edu.up.utils.Prompt;

public class AeronaveView {
    public void cadastrarPassageiro(){
        String nome = Prompt.lerLinha("Digite o seu nome:");
        String rg = Prompt.lerLinha("Digite o seu RG:");

        Aeronave passageiro = new Aeronave();
    }

    public void listarPassageiros(){

    }

    public void alterarPassageiro(){

    }

    public void deletarPassageiro(){

    }
}
