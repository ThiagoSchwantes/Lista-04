package br.edu.up.views.menus;
import br.edu.up.utils.Prompt;

public class MenuPassagem {
    
    
    public void mostrar(MenuPassageiro menuPassageiro){
        Prompt.separador();
        Prompt.imprimir("LISTAR PASSAGENS:");
        Prompt.separador();

        Prompt.imprimir(menuPassageiro.passagemController.listar());
        Prompt.pressionarEnter();
    }
}