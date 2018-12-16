/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetos.teste;

import java.util.HashMap;


/**
 *
 * @author Asus
 */
public class Prog {

    HashMap<String, Origem> list;

    public Prog() {
        list = new HashMap();

        Ponto p = new Ponto("Coimbra", "Madrid", 500, 200);
        Origem pt = new Origem();
        pt.addPoint(p.getDestino(), p);

        list.put("Coimbra", pt);

        Origem tmp = list.get("Coimbra");
        Ponto tmpp = tmp.dest.get("Madrid");
        System.out.println("Custo: " + tmpp.getCusto());

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Prog a = new Prog();
// TODO code application logic here
    }

}
