/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetos.teste;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Asus
 */
public class Origem implements Serializable{
    public HashMap <String, Ponto> dest;
    
    public Origem(){
        dest = new HashMap<>();
    }
    public void addPoint(String local, Ponto p){
        dest.put(local,p);
    }
}
