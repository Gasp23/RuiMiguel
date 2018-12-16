package projetos;

import java.io.Serializable;

public class Aquatico extends Diversão implements Serializable {
    private int piscinas;
    private boolean espetaculo;
    private int escorregas;

    public Aquatico() {
    }

    public Aquatico(int piscinas, boolean espetaculo, int escorregas, String nome, int popularidade, Horário horario, float custoEntrada) {
        super(nome, popularidade, horario, custoEntrada);
        this.piscinas = piscinas;
        this.espetaculo = espetaculo;
        this.escorregas = escorregas;
    }

    public Aquatico(int piscinas, boolean espetaculo, int escorregas) {
        this.piscinas = piscinas;
        this.espetaculo = espetaculo;
        this.escorregas = escorregas;
    }
    
    
    
    
    public int getPiscinas() {
        return piscinas;
    }

    public void setPiscinas(int piscinas) {
        this.piscinas = piscinas;
    }

    public boolean isEspetaculo() {
        return espetaculo;
    }

    public void setEspetaculo(boolean espetaculo) {
        this.espetaculo = espetaculo;
    }

    public int getEscorregas() {
        return escorregas;
    }

    public void setEscorregas(int escorregas) {
        this.escorregas = escorregas;
    }
    
    @Override
    public float custo() {
        return 4;
    }

    @Override
    public String getTipo() {
        return "Tematico";
    }

    @Override
    public String toString() {
        return "Aquatico{" + "piscinas=" + piscinas + ", espetaculo=" + espetaculo + ", escorregas=" + escorregas + '}';
    }
    
    
}
