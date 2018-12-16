package projetos;

import java.io.Serializable;

public class Tematico extends Diversão implements Serializable{
    private String temática;
    private boolean unico;
    private int rodaGigante;
    private int montanhaRussa;

    public Tematico() {
    }

    public Tematico(String temática, boolean unico, int rodaGigante, int montanhaRussa, String nome, int popularidade, Horário horario, float custoEntrada) {
        super(nome, popularidade, horario, custoEntrada);
        this.temática = temática;
        this.unico = unico;
        this.rodaGigante = rodaGigante;
        this.montanhaRussa = montanhaRussa;
    }

    public Tematico(String temática, boolean unico, int rodaGigante, int montanhaRussa) {
        this.temática = temática;
        this.unico = unico;
        this.rodaGigante = rodaGigante;
        this.montanhaRussa = montanhaRussa;
    }
    
    public String getTemática() {
        return temática;
    }

    public void setTemática(String temática) {
        this.temática = temática;
    }

    public boolean isUnico() {
        return unico;
    }

    public void setUnico(boolean unico) {
        this.unico = unico;
    }

    public int getRodaGigante() {
        return rodaGigante;
    }

    public void setRodaGigante(int rodaGigante) {
        this.rodaGigante = rodaGigante;
    }

    public int getMontanhaRussa() {
        return montanhaRussa;
    }

    public void setMontanhaRussa(int montanhaRussa) {
        this.montanhaRussa = montanhaRussa;
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
        return "Tematico{" + "tem\u00e1tica=" + temática + ", unico=" + unico + ", rodaGigante=" + rodaGigante + ", montanhaRussa=" + montanhaRussa + '}';
    }
}
