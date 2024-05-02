package br.edu.up.modelos;

//import br.edu.up.modelos.Compromisso;

public class Dia {

    private int diaMes;
    private Compromisso[] compromissos = new Compromisso[24];
    
    public Dia(){}

    public Dia(int diaMes){
        this.diaMes = diaMes; 
    }

    public int getDiaMes() {
        return diaMes;
    }

    public void setDiaMes(int diaMes) {
        this.diaMes = diaMes;
    }

    public void adicionarCompromisso(Compromisso comp){
        for (int i = 0; i < compromissos.length; i++) {
            if (compromissos[i] == null) {
                compromissos[i] = comp;
                break;
            }
        }
    }

    public Compromisso consultarCompromisso(int hora){
        
        for (Compromisso compromisso : compromissos) {
            if(compromisso.getHora() == hora){
                return compromisso;
            }
        }
        return null;
    }

    public void excluirCompromisso(int hora){
        for (int i = 0; i < compromissos.length; i++) {
            if (compromissos[i] != null && compromissos[i].getHora() == hora) {
                compromissos[i] = null;
                break;
            }
        }
    }
    
    public String listarCompromissos(){
        String lista = "";
    
        for (Compromisso compromisso : compromissos) {
            if (compromisso != null) { 
                lista += "Pessoa: " + compromisso.getPessoa() + "\n";
                lista += "Local: " + compromisso.getLocal() + "\n";
                lista += "Assunto: " + compromisso.getAssunto() + "\n";
                lista += "Hora: " + compromisso.getHora() + "\n";
                lista += "-------------------------------------------\n";
            }
        }
        
        return lista;
    }
    
}
