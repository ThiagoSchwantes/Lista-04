package br.edu.up.models.Pessoa;
import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa{
    private int lattesId;
    private Titulacao titulacao;
    private static List<Professor> listaProfessores = new ArrayList<>();

    public Professor(String nome,String rg,String matricula,int lattesId, Titulacao titulacao) {
        super(nome, rg, matricula);
        this.lattesId = lattesId;
        this.titulacao = titulacao;
    }
    public int getLattesId() {
        return lattesId;
    }
    public void setLattesId(int lattesId) {
        this.lattesId = lattesId;
    }
    public Titulacao getTitulacao() {
        return titulacao;
    }
    public void setTitulacao(Titulacao titulacao) {
        this.titulacao = titulacao;
    }
    public static List<Professor> getListaProfessores() {
        return listaProfessores;
    }
    @Override
    public String toString() {
        return "Professor{" +
            "nome='" + getNome() + '\'' +
            ", rg='" + getRg() + '\'' +
            ", matricula='" + getMatricula() + '\'' +
            ", lattesId=" + lattesId +
            ", titulacao=" + titulacao +
            '}';
    }
    
    
    
}
