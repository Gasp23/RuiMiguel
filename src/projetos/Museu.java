package projetos;

import java.io.Serializable;

public class Museu extends PontoDeInteresse implements Serializable{
    private String tematica;

    public Museu() {
    }

    public Museu(String tematica, String nome, int popularidade, Horário horario, float custoEntrada) {
        super(nome, popularidade, horario, custoEntrada);
        this.tematica = tematica;
    }

    public Museu(String tematica) {
        this.tematica = tematica;
    }
    
    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }
    
    @Override
    public float custo() {
        return 1;
    }

    @Override
    public String getTipo() {
        return "Museu";
    }

    @Override
    public String toString() {
        return "Museu{" + "tematica=" + tematica + '}';
    }
    
}
