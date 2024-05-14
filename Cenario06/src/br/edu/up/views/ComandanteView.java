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
