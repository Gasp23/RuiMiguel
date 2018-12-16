package projetos;

import java.io.Serializable;
import java.util.ArrayList;

public class Viagem implements Serializable{
    private ArrayList<Local> locais;
    private int custoTotal;
    public Viagem() {
    }

    public Viagem(ArrayList<Local> locais, int custoTotal) {
        this.locais = locais;
        this.custoTotal = custoTotal;
    }
    
    public ArrayList<Local> getLocais() {
        return locais;
    }

    public void setLocais(ArrayList<Local> locais) {
        this.locais = locais;
    }

    public int getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(int custoTotal) {
        this.custoTotal = custoTotal;
    }
    
    @Override
    public String toString(){
        return "";
    }
}
