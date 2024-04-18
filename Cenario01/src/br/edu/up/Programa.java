package br.edu.up;
import br.edu.up.models.Livro;

public class Programa {
    public static void main(String[] args) throws Exception {
        
        Livro livro01 = new Livro("1598FHK","Core Java 2", new String[]{"Cay S. Horstmann","Gary Cornell"},"0130819336",2005);
        Livro livro02 = new Livro("9865PLO","Java, Como programar",new String[]{"Harvey Deitel"},"0130341517",2015);

        livro01.mostrarLivro();
        livro02.mostrarLivro();
    }
}
