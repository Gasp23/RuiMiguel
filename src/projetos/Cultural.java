package projetos;

import java.io.Serializable;

public class Cultural extends Parque implements Serializable{
    private String temática;
    public Cultural() {
    }

    public Cultural(String temática, String nome, int popularidade, Horário horario, float custoEntrada) {
        super(nome, popularidade, horario, custoEntrada);
        this.temática = temática;
    }

    public String getTemática() {
        return temática;
    }

    public Cultural(String temática) {
        this.temática = temática;
    }
    
    public void setTemática(String temática) {
        this.temática = temática;
    }
    
    @Override
    public float custo() {
        return 3;
    }

    @Override
    public String getTipo() {
        return "Cultural";
    }

    @Override
    public String toString() {
        return "Cultural{" +temática+ '}';
    }
    
}
