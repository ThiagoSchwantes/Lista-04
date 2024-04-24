package br.edu.up.modelos;

import br.edu.up.Prompt;

public class Ponto {
    private Double x;
    private Double y;

    public Ponto() {
        this.x = 0.0;
        this.y = 0.0;
    }

    public Ponto(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }
    
    public void setY(Double y) {
        this.y = y;
    }
    
    public Double calcularDistancia(Ponto ponto2){
        return Math.sqrt( Math.pow(this.x - ponto2.getX(), 2) + Math.pow(this.y - ponto2.getY(), 2) );
    }

    public Double calcularDistancia(Double x, Double y){
        return Math.sqrt( Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2) );
    }

}
