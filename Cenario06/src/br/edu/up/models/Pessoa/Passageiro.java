package br.edu.up.models.Pessoa;

import java.util.UUID;

import br.edu.up.models.Passagem;

public class Passageiro extends Pessoa{

    private UUID idBagagem;
    private Passagem passagem;

    public Passageiro(String nome, String rg) {
        this.setNome(nome);
        this.setRg(rg);
        this.idBagagem = UUID.randomUUID();
    }

    public UUID getIdBagagem() {
        return idBagagem;
    }

    public void setIdBagagem(String idBagagem) {
        this.idBagagem = UUID.fromString(idBagagem);
    }

    public Passagem getPassagem() {
        return passagem;
    }

    public void setPassagem(Passagem passagem) {
        this.passagem = passagem;
    }

    @Override
    public String toString() {
        return "[idBagagem: " + idBagagem.toString() + ", Nome: " + getNome()
                + ", RG: " + getRg() + "]" + "\nPassagem: " + passagem + "\n";
    }
}
