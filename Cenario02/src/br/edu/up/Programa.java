package br.edu.up;

import java.text.DecimalFormat;

import br.edu.up.modelos.Ponto;

public class Programa {
    public static void main(String[] args) throws Exception {
        DecimalFormat df = new DecimalFormat("0.00");

        Ponto ponto1 = new Ponto();
        Ponto ponto2 = new Ponto(2.0, 5.0);

        Prompt.separador();
        Prompt.imprimir("A distancia do ponto 1 para o ponto 2 é: " + df.format(ponto1.calcularDistancia(ponto2)) + "\n");
        Prompt.separador();

        Prompt.imprimir("A distancia do ponto 2 para o ponto (7, 2) é: " + df.format(ponto1.calcularDistancia(7.0 , 2.0)) + "\n");
        Prompt.separador();

        ponto1.setX(10.0);
        ponto1.setY(3.0);

        Prompt.imprimir("O ponto 1 foi alterado para (" + ponto1.getX() + ", " + ponto1.getY() + ").\n");
        Prompt.separador();

        
    }
}
