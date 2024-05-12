package br.edu.up.views;

import br.edu.up.utils.Prompt;

public class InformacaoProfessor {
    public int registrarLattesId(){
        int lattesId = Prompt.lerInteiro("Informe o id do seu currículo Lattes: ");
        return lattesId;
    }

    
}
