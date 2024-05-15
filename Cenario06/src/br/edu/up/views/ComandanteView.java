package br.edu.up.views;

import br.edu.up.models.Pessoas.Tripulantes.Comandante;
import br.edu.up.utils.Prompt;

public class ComandanteView {
    public Comandante cadatrar(){
        Prompt.separador();
        Prompt.imprimir("CADASTRAR COMANDANTE");
        Prompt.separador();

        String nome = Prompt.lerLinha("Digite o seu nome:");
        String rg = Prompt.lerLinha("Digite o seu rg");
        Double totalHorasDeVoo = Prompt.lerDecimal("Digite quantas horas têm de voo:");

        String matriculaFuncionario = Prompt.lerLinha("Digite a mátricula de Funcionário:");
        String idAeronautica = Prompt.lerLinha("Digite a sua identificação de aernoáutica:");

        return new Comandante(nome, rg, matriculaFuncionario, idAeronautica, totalHorasDeVoo);
    }

    public Comandante alterar(Comandante comandanteAlterar){
        Prompt.clearConsole();
        Prompt.separador();
        Prompt.imprimir("ALTERAR COMANDANTE");
        Prompt.separador();
        
        String nomeAlterar = Prompt.lerLinha("Digite o novo nome do comandante:");
        String rgAlterar = Prompt.lerLinha("Digite o novo rg");
        Double totalHorasDeVooAlterar = Prompt.lerDecimal("Digite a nova quantidade de horas de voo:");
        String matriculaFuncionarioAlterar = Prompt.lerLinha("Digite a nova mátricula de Funcionário:");
        String idAeronauticaAlterar = Prompt.lerLinha("Digite a nova identificação de aernoáutica:");

        comandanteAlterar.setNome(nomeAlterar);
        comandanteAlterar.setRg(rgAlterar);
        comandanteAlterar.setTotalHorasDeVoo(totalHorasDeVooAlterar);
        comandanteAlterar.setMatriculaFuncionario(matriculaFuncionarioAlterar);
        comandanteAlterar.setIdAeronautica(idAeronauticaAlterar);

        return comandanteAlterar;
    }
}
