package br.edu.up.models;
import br.edu.up.*;

public class Livro {
    private String codigo;
    private String titulo;
    private String[] autores;
    private String isbn;
    private int ano;

    public Livro(){}

    public Livro(String codigo, String titulo, String[] autores, String isbn, int ano){
        this.codigo = codigo;
        this.titulo = titulo;
        this.autores = autores;
        this.isbn = isbn;
        this.ano = ano;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String[] getAutores() {
        return autores;
    }

    public void setAutores(String[] autores) {
        this.autores = autores;
    }

    public int getAno() {
        return ano;
    }
    
    public void setAno(int ano) {
        this.ano = ano;
    }

    public void mostrarLivro(){
        
        Prompt.separador();
        Prompt.imprimir("Código: " + codigo);
        Prompt.imprimir("Titulo: " + titulo);
        Prompt.imprimir("Autores: " + String.join(" e ", autores));
        Prompt.imprimir("Isbn: " + isbn);
        Prompt.imprimir("Ano: " + ano);
        Prompt.separador();
    }
}