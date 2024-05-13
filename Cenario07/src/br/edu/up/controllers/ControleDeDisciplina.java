package br.edu.up.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.models.Competencia;
import br.edu.up.models.Disciplina;
import br.edu.up.utils.Prompt;
import br.edu.up.views.InformacaoDisciplina;

public class ControleDeDisciplina {
    Scanner scanner = new Scanner(System.in);
    public Disciplina incluirDisciplina(){
        InformacaoDisciplina iDisciplina = new InformacaoDisciplina();

        String nomeDisciplina = iDisciplina.registrarNomeDisciplina();
        int idDisciplina = iDisciplina.registrarIdDisciplina();

        List<Competencia> competenciasNecessarias = new ArrayList<>();

        boolean adicionarMaisCompetencias = true;
        while (adicionarMaisCompetencias) {
            String competencia = iDisciplina.registrarCompetenciaNecessaria();
            competenciasNecessarias.add(Competencia.nome);

            System.out.print("Deseja adicionar outra competência necessária? (true/false): ");
            String input = scanner.nextLine();
            adicionarMaisCompetencias = Boolean.parseBoolean(input);
        }


        
    }
}
