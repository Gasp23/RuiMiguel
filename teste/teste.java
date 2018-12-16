/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetos.teste;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import projetos.Bar;
import projetos.Local;
import projetos.PontoDeInteresse;


public class teste {
    
    ArrayList<Local> locais;
    public teste(){
        locais = new ArrayList();
        Local l = brrr();
        l.setNome("brrrr");
        locais.get(1).setNome("ikdfidi");
        for(Local e : locais){
            System.out.println(e);
        }
        
    }
    
    
    public static void main(String[] args) {
        
        teste t = new teste();
        
        
        
        
        
        
        
        
        
        
        /*ArrayList<PontoDeInteresse> pontos = new ArrayList();
        Bar bar = new Bar();
        File f2 = new File("teste.txt");
        
        
        
        try {
                FileOutputStream fos = new FileOutputStream(f2);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(bar);
                oos.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Erro a criar ficheiro.");
            } catch (IOException ex) {
                System.out.println("Erro a escrever para o ficheiro.");
        }
        
        
        
        
        try {
                FileInputStream fis = new FileInputStream(f2);
                ObjectInputStream ois = new ObjectInputStream(fis);
               
                
                bar = (Bar)ois.readObject();
                System.out.println("djiidieiej");
               
                 
                ois.close();
                
            } catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir ficheiro.");
            } catch (IOException ex) {
                System.out.println(ex);
            } catch (ClassNotFoundException ex) {
                System.out.println("Erro a converter objeto.");
            }
            
        System.out.println(bar);*/
    }
    
    public Local brrr(){
        
        Local l = new Local();
        locais.add(l);
        locais.add(l);
        Local q = new Local();
        locais.add(q);
        return l;
    }
    
}
