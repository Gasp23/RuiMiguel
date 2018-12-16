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
public class Mestrado extends Aluno implements Serializable{

    public Mestrado() {
        super();
    }

    public Mestrado(String nome, String password, ArrayList<Local> locais, ArrayList<Local> notLocais, ArrayList<PontoDeInteresse> interesses, ArrayList<PontoDeInteresse> notInteresses, float custoTotal) {
        super(nome, password, locais, notLocais, interesses, notInteresses, custoTotal);
    }

    

    
    
    public Mestrado(String nome,String password){
        super(nome,password);
    }
    
    @Override
    public String getTipo() {
        return "Mestrado";
    }

    @Override
    public void escolha(ArrayList<Local> locais) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Mestrado{" + getNome() + " " + getPassword() + '}';
    }
    
    
}
