package br.edu.up.controles;

import java.time.LocalDate;

import br.edu.up.modelos.Ano;
import br.edu.up.modelos.Compromisso;
import br.edu.up.modelos.Dia;
import br.edu.up.modelos.Mes;

public class CadastroCompromissos {
    
    public boolean adicionarCompromisso(String pessoa, String local, String assunto, int hora, String data) {

        int anoDigitado = Integer.parseInt(data.substring(6,10));
        int mesDigitado = Integer.parseInt(data.substring(3,5));
        int diaDigitado = Integer.parseInt(data.substring(0,2));
        LocalDate dataDate = LocalDate.of( anoDigitado , mesDigitado , diaDigitado );

        Compromisso compromisso = new Compromisso(pessoa, local, assunto, hora);

        Dia dia = new Dia(diaDigitado);
        dia.adicionarCompromisso(compromisso);

        boolean isBissexto = (anoDigitado % 4 == 0) && ((anoDigitado % 100 != 0 ) || (anoDigitado % 400 == 0));
        Mes mes = new Mes(dataDate.lengthOfMonth() ,mesDigitado);
        mes.adicionarCompromisso(compromisso, diaDigitado);

        Ano ano = new Ano(anoDigitado, isBissexto);
        ano.adicionarMes(mes);  
        
        return true;
    }
    
}