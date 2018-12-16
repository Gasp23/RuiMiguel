package projetos;

import java.io.Serializable;

public class Bar extends PontoDeInteresse implements Serializable{
    
    private float classificaçao;

    public Bar() {
    }

    public Bar(String nome,Horário horario,int popularidade, float custoEntrada,float classificaçao) {
        super(nome, popularidade, horario, custoEntrada);
        this.classificaçao = classificaçao;
    }

    public Bar(float classificaçao) {
        this.classificaçao = classificaçao;
    }
    
    public float getClassificaçao() {
        return classificaçao;
    }

    public void setClassificaçao(float classificaçao) {
        this.classificaçao = classificaçao;
    }  
    
    @Override
    public float custo() {
        return 2;
    }

    @Override
    public String getTipo() {
        return "Bar";
    }

    @Override
    public String toString() {
        return "Bar{" + "classifica\u00e7ao=" + classificaçao + '}';
    }
    
}
