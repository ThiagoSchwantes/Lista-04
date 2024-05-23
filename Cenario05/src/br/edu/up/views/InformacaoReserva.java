

import java.time.LocalDate;
import br.edu.up.utils.Prompt;

public class InformacaoReserva {

    public String registrarNome(){
       
        return nomeResponsavel;
    }

    public int registrarQuantPessoas(){
        
        return quantPessoas;
    }

    public LocalDate registrarData(){
        return LocalDate.now();
    }

    public String registrarNovoNome(){
        String nomeResponsavel = Prompt.lerLinha("Informe o nome do responsável pela reserva: ");
        return nomeResponsavel;
    }

    public int registrarNovaQuantPessoas(){
        int quantPessoas = Prompt.lerInteiro("Informe para quantas pessoas é a reserva: ");
        return quantPessoas;
    }

    public LocalDate registrarNovaData(){
        return 
    }

}
