package projetos;

import java.io.Serializable;
import java.util.ArrayList;

public class Local implements Serializable, Comparable<Local>{
    private String nome;
    private int popularidade;
    private ArrayList<PontoDeInteresse> pontosDeInteresse;
    
    public Local(String nome, ArrayList<PontoDeInteresse> pontosDeInteresse, int popularidade) {
        this.nome = nome;
        this.pontosDeInteresse = pontosDeInteresse;
        this.popularidade = popularidade;
    }

    public Local() {
        pontosDeInteresse = new ArrayList();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPopularidade() {
        return popularidade;
    }

    public void setPopularidade(int popularidade) {
        this.popularidade = popularidade;
    }

    public ArrayList<PontoDeInteresse> getPontosDeInteresse() {
        return pontosDeInteresse;
    }

    public void setPontosDeInteresse(ArrayList<PontoDeInteresse> pontosDeInteresse) {
        this.pontosDeInteresse = pontosDeInteresse;
    }     
    
    @Override
    public String toString() {
        String temp = "";
        for(PontoDeInteresse e: pontosDeInteresse){
            
            temp.concat(e.getNome());
            temp.concat(" ");
            
        }
        return "Local{" + "nome=" + nome + ", popularidade=" + popularidade + ", pontosDeInteresse=" + pontosDeInteresse + '}';
    }

    void addPoI(PontoDeInteresse p) {
    
       pontosDeInteresse.add(p);
    }

    @Override
    public int compareTo(Local o) {
        return  o.popularidade-this.popularidade;
    }
    
    
}
