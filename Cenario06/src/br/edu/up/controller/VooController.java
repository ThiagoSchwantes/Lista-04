package br.edu.up.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.models.Aeronave;
import br.edu.up.models.Passagem;
import br.edu.up.models.Pessoa.Passageiro;
import br.edu.up.models.Pessoa.Tripulante.Comandante;
import br.edu.up.models.Pessoa.Tripulante.Comissario;

public class VooController {
    private String dataDoVoo;
    private Comandante comandante;
    private Aeronave aeronave;

    private List<Passageiro> passageiros = new ArrayList<>();

    private List<Comissario> comissarios = new ArrayList<>();

    public void Voo(Comandante comandante, Aeronave aeronave, String data){
        this.comandante = comandante;
        this.aeronave = aeronave;
        this.dataDoVoo = data;
    }

    public void adicionarPassageiro(Passageiro passageiro, Integer numeroAcento, String classeAcento){

        passageiro.setPassagem(new Passagem(aeronave, numeroAcento, classeAcento, dataDoVoo));

        passageiros.add(passageiro);
    }



    public void adicionarComissario(Comissario comissario){
        comissarios.add(comissario);
    }
}
