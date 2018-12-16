/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Diogo Apóstolo
 */
public abstract class Aluno implements Serializable{
    private String nome;
    private String password;
    private ArrayList<Local> locais;
    private ArrayList<Local> notLocais;
    private ArrayList<PontoDeInteresse> interesses;
    private ArrayList<PontoDeInteresse> notInteresses;
    private float custoTotal;
    
    Aluno(){
        locais = new ArrayList();
        notLocais = new ArrayList();
        interesses = new ArrayList();
        notInteresses = new ArrayList();
    }

   
   
    public Aluno(String nome, String password, ArrayList<Local> locais, ArrayList<Local> notLocais, ArrayList<PontoDeInteresse> interesses, ArrayList<PontoDeInteresse> notInteresses, float custoTotal) {
        
        this.nome = nome;
        this.password = password;
        this.locais = locais;
        this.notLocais = notLocais;
        this.interesses = interesses;
        this.notInteresses = notInteresses;
        this.custoTotal = custoTotal;
    }
    
    public Aluno(String nome,String password){
        this.nome = nome;
        this.password = password;
        
        locais = new ArrayList();
        notLocais = new ArrayList();
        interesses = new ArrayList();
        notInteresses = new ArrayList();
        
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<PontoDeInteresse> getInteresses() {
        return interesses;
    }

    public void setInteresses(ArrayList<PontoDeInteresse> interesses) {
        this.interesses = interesses;
    }

    public float getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(float custoTotal) {
        this.custoTotal = custoTotal;
    }

    public void setNotLocais(ArrayList<Local> notLocais) {
        this.notLocais = notLocais;
    }

    public void setNotInteresses(ArrayList<PontoDeInteresse> notInteresses) {
        this.notInteresses = notInteresses;
    }

    public ArrayList<Local> getNotLocais() {
        return notLocais;
    }

    public ArrayList<PontoDeInteresse> getNotInteresses() {
        return notInteresses;
    }

    public ArrayList<Local> getLocais() {
        return locais;
    }

    public void setLocais(ArrayList<Local> locais) {
        this.locais = locais;
    }

    @Override
    public String toString() {
        return "Aluno{" + "nome=" + nome + ", password=" + password + ", locais=" + locais + ", interesses=" + interesses + ", custoTotal=" + custoTotal + '}';
    }

   
    public abstract String getTipo();
    public abstract void escolha(ArrayList<Local> locais);
    
}
