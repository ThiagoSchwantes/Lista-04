package br.edu.up;

public class teste {
    package br.edu.up.main;

import br.edu.up.modelos.*;

public class Main {
    public static void main(String[] args) {
        // Criar um compromisso
        Compromisso compromisso1 = new Compromisso("João", "Café Central", "Reunião", 10);

        // Criar um dia
        Dia dia = new Dia(10); // Supondo que seja o dia 10 do mês

        // Adicionar o compromisso ao dia
        dia.adicionarCompromisso(compromisso1);

        // Listar os compromissos do dia
        System.out.println("Compromissos do dia " + dia.getDiaMes() + ":");
        System.out.println(dia.listarCompromissos());

        // Criar um mês
        Mes mes = new Mes(31, 1); // Supondo que seja janeiro com 31 dias

        // Adicionar o dia ao mês
        mes.adicionarDia(dia);

        // Listar os compromissos do mês
        System.out.println("Compromissos do mês de " + mes.getNome() + ":");
        System.out.println(mes.listarCompromissos(10)); // Listar compromissos do dia 10

        // Criar um ano
        Ano ano = new Ano(2024, true); // Supondo que seja o ano de 2024 e seja bissexto

        // Adicionar o mês ao ano
        ano.adicionarMes(mes);

        // Listar os compromissos do ano
        System.out.println("Compromissos do ano de " + ano.getAno() + ":");
        System.out.println(ano.listarCompromissos("Janeiro")); // Listar compromissos do mês de janeiro
    }
}

}
