package projetos;

import java.io.Serializable;

public class Horário implements Serializable{
    private int horasIniciais;
    private int horasFinais;
    private int minutosIniciais;
    private int minutosFinais;

    public Horário() {
    }

    public Horário(int horasIniciais,int minutosIniciais, int horasFinais, int minutosFinais) {
        this.horasIniciais = horasIniciais;
        this.horasFinais = horasFinais;
        this.minutosIniciais = minutosIniciais;
        this.minutosFinais = minutosFinais;
    }

    public int getHorasIniciais() {
        return horasIniciais;
    }

    public void setHorasIniciais(int horasIniciais) {
        this.horasIniciais = horasIniciais;
    }

    public int getHorasFinais() {
        return horasFinais;
    }

    public void setHorasFinais(int horasFinais) {
        this.horasFinais = horasFinais;
    }

    public int getMinutosIniciais() {
        return minutosIniciais;
    }

    public void setMinutosIniciais(int minutosIniciais) {
        this.minutosIniciais = minutosIniciais;
    }

    public int getMinutosFinais() {
        return minutosFinais;
    }

    public void setMinutosFinais(int minutosFinais) {
        this.minutosFinais = minutosFinais;
    }

    @Override
    public String toString() {
        return "Hor\u00e1rio{" + "horasIniciais=" + horasIniciais + ", horasFinais=" + horasFinais + ", minutosIniciais=" + minutosIniciais + ", minutosFinais=" + minutosFinais + '}';
    }
    
}
