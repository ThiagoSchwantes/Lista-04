package br.edu.up.modelos;

public class Ano {
    
    private int ano;
    private boolean bissexto;
    private Mes[] meses;

    public Ano(int ano, boolean isBissexto) {
        this.ano = ano;
        this.bissexto = isBissexto;
    }

    public void adicionarMes(Mes mes){
        if(meses == null){
            meses = new Mes[12];
        }

        for (int i = 0; i < meses.length; i++) {
            if (meses[i] == null) {
                meses[i] = mes;
                break;
            }
        }
    }

    public void excluirCompromisso(String nomeMes, int diaMes, int hora){
        for (Mes mes : meses) {
            if (mes != null && mes.getNome().equalsIgnoreCase(nomeMes)) {
                mes.excluirCompromisso(diaMes, hora);
                break;
            }
        }
    }

    public String listarCompromissos(String nomeMes){
        String listaCompromissos = "";
        for (Mes mes : meses) {
            if (mes != null && mes.getNome().equalsIgnoreCase(nomeMes)) {
                listaCompromissos += "Compromissos do mês de " + nomeMes + ":\n";
                listaCompromissos += mes.listarCompromissos() + "\n";
                break;
            }
        }
        return listaCompromissos;
    }

    public String listarCompromissos(){
        String listaCompromissos = "";
        for (Mes mes : meses) {
            if (mes != null) {
                listaCompromissos += "Compromissos do mês de " + mes.getNome() + ":\n";
                listaCompromissos += mes.listarCompromissos() + "\n";
            }
        }
        return listaCompromissos;
    }
}
