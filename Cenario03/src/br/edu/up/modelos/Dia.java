package br.edu.up.modelos;
import br.edu.up.Prompt;

public class Dia {

    private int diaMes = 0;
    private Compromisso[] compromissos;
    
    Dia(){}
    Dia(int diaMes){
        this.diaMes = diaMes; 
    }

    public void adicionarCompromisso(Compromisso[] comp){
        this.compromissos = comp;
    }

    public String consultarCompromisso(int hora){
        if(compromissos != null){
            for (Compromisso compromisso : compromissos) {
                if(compromisso.getHora() == hora){
                    return compromisso.toString();
                }
            }
        }
        return "Compromisso não encontrado.";
    }

    public String excluirCompromisso(int hora){
        if(compromissos != null){
            for (int i = 0; i < compromissos.length; i++) {
                if(compromissos[i].getHora() == hora){
                    // Movendo os compromissos subsequentes uma posição para trás
                    for (int j = i; j < compromissos.length - 1; j++) {
                        compromissos[j] = compromissos[j + 1];
                    }
                    return "Exclusão realizada com sucesso.";
                }
            }
        }
        return "Compromisso não encontrado";
    }
    
    public void listarCompromissos(){
        if(compromissos != null){
            for (Compromisso compromisso : compromissos) {
                Prompt.separador();
                Prompt.imprimir(compromisso);
                Prompt.separador();
            }
        }
    }
}
