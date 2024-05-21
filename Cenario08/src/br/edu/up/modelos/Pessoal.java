package br.edu.up.modelos;

public class Pessoal extends Contato{
    
    private String aniversario;

    public Pessoal(String nome, String telefone, String aniversario){
        super(nome, telefone);
        this.aniversario = aniversario;
    }

    public String getAniversario() {
        return aniversario;
    }

    public void setAniversario(String aniversario) {
        this.aniversario = aniversario;
    }

    @Override
    public String toString() {
        return "Pessoal [getCodigo()=" + getCodigo() + ", getNome()=" + getNome()
                + ", getTelefone()=" + getTelefone() + " , aniversario=" + aniversario + "]";
    }

    
    
}
