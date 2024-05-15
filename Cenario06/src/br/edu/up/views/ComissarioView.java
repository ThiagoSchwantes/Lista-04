package br.edu.up.views;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.models.Pessoas.Tripulantes.Comissario;
import br.edu.up.utils.Prompt;

public class ComissarioView {
    public Comissario cadatrar(){
        Prompt.separador();
        Prompt.imprimir("CADASTRAR COMISSÁRIO");
        Prompt.separador();

        String nome = Prompt.lerLinha("Digite o seu nome:");
        String rg = Prompt.lerLinha("Digite o seu rg");

        String matriculaFuncionario = Prompt.lerLinha("Digite a mátricula de Funcionário:");
        String idAeronautica = Prompt.lerLinha("Digite a sua identificação de aernoáutica:");

        List<String> idiomas = new ArrayList<>();

        Prompt.clearConsole();
        Prompt.separador();
        Prompt.imprimir("IDIOMAS DO COMISSÁRIO");
        Prompt.separador();

        idiomas.add(Prompt.lerLinha("Digite o seu idioma nativo:"));

        boolean repetir = false;
        do {
            Prompt.separador(); 
            Character opcao = Prompt.lerCaractere("Deseja adicionar mais algum idioma? (S/N)");

            if (Character.toLowerCase(opcao) == 's') {
                repetir = true;
                idiomas.add(Prompt.lerLinha("Digite seu outro idioma:"));
            }else if(Character.toLowerCase(opcao) != 'n'){
                Prompt.imprimir("Erro, digite uma das opções!");
                repetir = true;
            }else{
                repetir = false;
            }
            
                       
        } while (repetir);        

        return new Comissario(nome, rg, matriculaFuncionario, idAeronautica, idiomas);
    }

    public Comissario alterar(Comissario comissarioAlterar){
        Prompt.clearConsole();
        Prompt.separador();
        Prompt.imprimir("ALTERAR COMISSÁRIO");
        Prompt.separador();
        
        String nomeAlterar = Prompt.lerLinha("Digite o novo nome:");
        String rgAlterar = Prompt.lerLinha("Digite o novo rg");
        String matriculaFuncionarioAlterar = Prompt.lerLinha("Digite a nova mátricula de Funcionário:");
        String idAeronauticaAlterar = Prompt.lerLinha("Digite a nova identificação de aernoáutica:");

        List<String> idiomas = new ArrayList<>();

        Prompt.clearConsole();
        Prompt.separador();
        Prompt.imprimir("ALTERAR IDIOMAS DO COMISSÁRIO");
        Prompt.separador();

        idiomas.add(Prompt.lerLinha("Digite o seu idioma nativo:"));

        boolean repetir = false;

        do {
            Prompt.separador();  
            Character opcao = Prompt.lerCaractere("Deseja adicionar mais algum idioma? (S/N)");
            
            if (Character.toLowerCase(opcao) == 's') {
                repetir = true;
                idiomas.add(Prompt.lerLinha("Digite seu outro idioma:"));
            }else if(Character.toLowerCase(opcao) != 'n'){
                Prompt.imprimir("Erro, digite uma das opções!");
                repetir = true;
            }else{
                repetir = false;
            }
            
                     
        } while (repetir);

        comissarioAlterar.setNome(nomeAlterar);
        comissarioAlterar.setRg(rgAlterar);
        comissarioAlterar.setMatriculaFuncionario(matriculaFuncionarioAlterar);
        comissarioAlterar.setIdAeronautica(idAeronauticaAlterar);
        comissarioAlterar.setIdiomas(idiomas);

        return comissarioAlterar;
    }
}
