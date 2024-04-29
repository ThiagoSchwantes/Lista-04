package br.edu.up.modelos;
import br.edu.up.modelos.Dia;
import java.time.Month;

public class Mes {
    private String nome;
    private int qtdeDias;
    private Dia[] dias;
    

    public Mes(){}

    public Mes(int qtdeDias, int nome){
        this.qtdeDias = qtdeDias;
        dias = new Dia[qtdeDias];

        Month mes = Month.of(nome + 1);
        this.nome = mes.toString();

        for (int i = 0; i < qtdeDias; i++) {
            dias[i] =  new Dia(i + 1);
        }
    }

    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarCompromisso(Compromisso comp, int diaMes){
        dias[diaMes - 1].adicionarCompromisso(comp);
    }

    public void adicionarCompromisso(String pessoa, String local, String assunto, int hora, int diaMes){
        Compromisso comp = new Compromisso(pessoa, local, assunto, hora);

        dias[diaMes - 1].adicionarCompromisso(comp);
    }

    public void excluirCompromisso(int diaMes, int hora){
        dias[diaMes-1].excluirCompromisso(hora);
    }
    
    public String listarCompromissos(int diaMes){
        return dias[diaMes - 1].listarCompromissos();
        
    }
    
    public String listarCompromissos(){
        String lista = "";
    
        for (Dia dia : dias) {
            lista += "Compromissos do dia " + dia.getDiaMes() + ":\n";
            lista += dia.listarCompromissos() + "\n";
        }
        
        return lista;
    }

}
