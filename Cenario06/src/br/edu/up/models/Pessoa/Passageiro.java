package br.edu.up.models.Pessoa;

import br.edu.up.models.Passagem;

public class Passageiro extends Pessoa{

    private Integer idBagagem;
    private Passagem passagem;

    public Integer getIdBagagem() {
        return idBagagem;
    }

    public void setIdBagagem(Integer idBagagem) {
        this.idBagagem = idBagagem;
    }

    public Passagem getPassagem() {
        return passagem;
    }

    public void setPassagem(Passagem passagem) {
        this.passagem = passagem;
    }
}
