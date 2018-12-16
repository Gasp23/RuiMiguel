package projetos;

import java.io.Serializable;

public abstract class Parque extends PontoDeInteresse implements Serializable {

    public Parque() {
    }

    
    public Parque(String nome, int popularidade, Horário horario, float custoEntrada) {
        super(nome, popularidade, horario, custoEntrada);
    }
    
    @Override
    public abstract float custo();

    @Override
    public abstract String getTipo();

    @Override
    public String toString() {
        return "Parque{" + '}';
    }
    
    
}
