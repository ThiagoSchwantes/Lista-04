package br.edu.up;

import br.edu.up.modelos.*;

public class Programa {
    public static void main(String[] args) throws Exception {

        /*A agenda deve permitir a criação de um compromisso com uma pessoa, em um determinado local e 
        horário, para tratar um assunto específico. Para cada dia considerar que será possível agendar o 
        compromisso para qualquer uma das 24 horas de um dia, qualquer dia do mês de 28 a 31 dias e em 
        qualquer um dos 12 meses do ano.  */
        
        Mes[] mes = new Mes[12];
        Dia[] dia = new Dia[28];
        Compromisso[] arrayDeCompromissos = new Compromisso[24];

        Prompt.separador();
        Prompt.imprimir("BEM-VINDO ao programa de criação de compromisso,siga o passo-a-passo para criar um novo compromisso:");

        int indiceVazio = -1;
        for (int i = 0; i < arrayDeCompromissos.length; i++) {
            if (arrayDeCompromissos[i] == null) {
                indiceVazio = i;
                break;
            }
        }

        if (indiceVazio == -1) {
            System.out.println("Não há mais espaço para novos compromissos. Encerrando o programa.");
            return;
        }

        
        arrayDeCompromissos[indiceVazio] = new Compromisso(
            Prompt.lerLinha("Informe o nome da pessoa que estará no compromisso: "),
            Prompt.lerLinha("Informe o local do compromisso: "),
            Prompt.lerLinha("Informe o assunto do compromisso: "),
            Prompt.lerInteiro("Informe a hora do compromisso:")
        );
        Prompt.separador();

        //se no mes tiver espaço(null) considerando que tem 12 espaços retorne true;
        //se no dia tiver espaço(null) considerando que tera de 28 a 31 espaços dependendo do mes retone true;
        //se no horario tiver espaço(null) considerando que os espaços são de 24 espaços de 1 em 1 hora retorne true;
        //se todas as condições forem atendidas adicionar compromisso
    }
}
