package br.edu.up.views;

import br.edu.up.utils.Prompt;

public class InformacaoDisciplina {
    public String registrarNomeDisciplina(){
        String nomeDisciplina = Prompt.lerLinha("Informe o nome da disciplina: ");
        return nomeDisciplina;
    }

    public int registrarIdDisciplina(){
        int idDisciplina = Prompt.lerInteiro("Informe o id da disciplina: ");
        return idDisciplina;
    }
    
    public String registrarCompetenciaNecessaria(){
        String competenciaNecessaria = Prompt.lerLinha("Informe uma competencia necessaria: ");
        return competenciaNecessaria;
    }

    public String registrarCompetenciaComplementar(){
        String competenciaComplementar = Prompt.lerLinha("Informe uma competencia complementar: ");
        return competenciaComplementar;
    }
}
