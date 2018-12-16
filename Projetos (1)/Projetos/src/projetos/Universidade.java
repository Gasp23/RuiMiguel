package projetos;

import java.io.Serializable;
import java.util.ArrayList;

public class Universidade extends PontoDeInteresse implements Serializable{
    private ArrayList<String> cursos;

    public Universidade() {
    }

    public Universidade(ArrayList<String> cursos, String nome, int popularidade, Horário horario, float custoEntrada) {
        super(nome, popularidade, horario, custoEntrada);
        this.cursos = cursos;
    }

    public Universidade(ArrayList<String> cursos) {
        this.cursos = cursos;
    }

    

    @Override
    public float custo() {
        return 0;
    }

    @Override
    public String getTipo() {
        return "Universidade";
    }
    
}
