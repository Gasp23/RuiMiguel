package projetos;

import java.io.Serializable;
import java.util.ArrayList;

public class Viagem implements Serializable{
    private ArrayList<Local> locais;
    private ArrayList<PontoDeInteresse> interesses;
    private int custoTotal;
    public Viagem() {
        locais=new ArrayList<>();
        interesses=new ArrayList<>();
    }

    public Viagem(ArrayList<Local> locais, ArrayList<PontoDeInteresse> interesses) {
        this.locais = locais;
        this.interesses = interesses;
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

    public ArrayList<PontoDeInteresse> getInteresses() {
        return interesses;
    }

    public void setInteresses(ArrayList<PontoDeInteresse> interesses) {
        this.interesses = interesses;
    }
    
    public void calcCusto(){
        int custo=0;
        for (PontoDeInteresse interesse : interesses) {
            custo+=interesse.custo();
        }
        
    }
    
    @Override
    public String toString(){
        return ""+locais+" "+this.interesses;
    }
}
