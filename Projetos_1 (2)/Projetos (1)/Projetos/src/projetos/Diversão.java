package projetos;

import java.io.Serializable;

public abstract class Diversão extends Parque implements Serializable{

    public Diversão() {
    }

    public Diversão(String nome, int popularidade, Horário horario, float custoEntrada) {
        super(nome, popularidade, horario, custoEntrada);
    }
    
    @Override
    public abstract float custo();

    @Override
    public abstract String getTipo();

    @Override
    public String toString() {
        return "Divers\u00e3o{" + '}';
    }
    
}
