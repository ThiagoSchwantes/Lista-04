package br.edu.up.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.edu.up.models.pessoas.Passageiro;
import br.edu.up.models.pessoas.tripulantes.Comandante;
import br.edu.up.models.pessoas.tripulantes.Comissario;

public class Voo {
    private UUID idVoo = UUID.randomUUID();
    private String dataDoVoo;
    private Comandante comandante;
    private Aeronave aeronave;

    private List<Passageiro> passageiros = new ArrayList<>();
    private List<Comissario> comissarios = new ArrayList<>();

    public Voo(Comandante comandante, Aeronave aeronave, String data){
        this.comandante = comandante;
        this.aeronave = aeronave;
        this.dataDoVoo = data;
    }

    public UUID getIdVoo() {
        return idVoo;
    }

    public void setIdVoo(UUID idVoo) {
        this.idVoo = idVoo;
    }

    public String getDataDoVoo() {
        return dataDoVoo;
    }

    public void setDataDoVoo(String dataDoVoo) {
        this.dataDoVoo = dataDoVoo;
    }

    public Comandante getComandante() {
        return comandante;
    }

    public void setComandante(Comandante comandante) {
        this.comandante = comandante;
    }

    public Aeronave getAeronave() {
        return aeronave;
    }

    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
    }

    public List<Passageiro> getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(List<Passageiro> passageiros) {
        this.passageiros = passageiros;
    }

    public List<Comissario> getComissarios() {
        return comissarios;
    }

    public void setComissarios(List<Comissario> comissarios) {
        this.comissarios = comissarios;
    }

    @Override
    public String toString() {
        return "Voo [idVoo=" + idVoo + ", dataDoVoo=" + dataDoVoo + ", comandante=" + comandante + ", aeronave="
                + aeronave + ", passageiros=" + passageiros + ", comissarios=" + comissarios + "]";
    }

    


}
