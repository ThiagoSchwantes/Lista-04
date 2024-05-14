package br.edu.up.views;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.models.Pessoas.Tripulantes.Comandante;
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
            
            Prompt.separador();            
        } while (repetir);        

        return new Comissario(nome, rg, matriculaFuncionario, idAeronautica, idiomas);
    }

    public Comandante alterar(Comandante comandanteAlterar){
        String nome = Prompt.lerLinha("Digite o seu nome:");
        String rg = Prompt.lerLinha("Digite o seu rg");
        Double totalHorasDeVoo = Prompt.lerDecimal("Digite quantas horas têm de voo:");

        String matriculaFuncionario = Prompt.lerLinha("Digite a mátricula de Funcionário:");
        String idAeronautica = Prompt.lerLinha("Digite a sua identificação de aernoáutica:");

        comandanteAlterar.setNome(nome);
        comandanteAlterar.setRg(rg);
        comandanteAlterar.setTotalHorasDeVoo(totalHorasDeVoo);
        comandanteAlterar.setMatriculaFuncionario(matriculaFuncionario);
        comandanteAlterar.setIdAeronautica(idAeronautica);

        return comandanteAlterar;
    }
}
