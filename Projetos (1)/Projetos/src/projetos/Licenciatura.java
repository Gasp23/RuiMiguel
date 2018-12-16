/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Diogo Apóstolo
 */
public class Licenciatura extends Aluno implements Serializable {

    public Licenciatura() {
        super();
    }

    public Licenciatura(String nome, String password, ArrayList<Local> locais, ArrayList<Local> notLocais, ArrayList<PontoDeInteresse> interesses, ArrayList<PontoDeInteresse> notInteresses, float custoTotal) {
        super(nome, password, locais, notLocais, interesses, notInteresses, custoTotal);
    }

    public Licenciatura(String nome, String password) {
        super(nome, password);
    }

    

    @Override
    public String getTipo() {
        return "Licenciatura";
    }

    @Override
    public void escolha(ArrayList<Local> locais) {
        
        Scanner sc = new Scanner(System.in);
        int num;
        
        for (Local l : locais) {
           
          
           
            if (this.getLocais().isEmpty() || !(this.getLocais().contains(l)) && !(this.getNotLocais().contains(l))) {
                System.out.println("\n\n" + l.getNome());
                System.out.println("\nPretende adicionar este local às suas preferencias(1)\nAdicionar aos locais a evitar(2)\nNão fazer nada(2)");
                num = sc.nextInt();
                if (num == 1) {
                    getLocais().add(l);
                    System.out.println("Pretende selecionar pontos de interesse dentro deste local (1-0)");
                    if (sc.nextInt() == 1) {
                        for (PontoDeInteresse p : l.getPontosDeInteresse()) {

                            if (!(this.getInteresses().contains(p)) && !(this.getNotInteresses().contains(p))) {
                                System.out.println(p.getNome());
                                System.out.println("Pretende adicionar este ponto de interesse às suas preferencias(1)\nAdicionar aos pontos de interesse a evitar(2)\nNão fazer nada(2)");
                                num = sc.nextInt();
                                if (num == 1) {
                                    getInteresses().add(p);
                                }

                                if (num == 2) {
                                    getNotInteresses().add(p);
                                }

                            }

                        }
                    }

                }
                
                if (num == 2) {
                    getNotLocais().add(l);
                    System.out.println("Pretende selecionar pontos de interesse dentro deste local (1-0)");
                    
                }

            }

        }
    }

}
