/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_gui_tp3;


import javax.swing.JFrame;
import projetos.Projeto;

/**
 *
 * @author Diogo Apóstolo
 */
public class GUIRegister extends JFrame{
    private Projeto p;
    private GUI gui;
    
    public GUIRegister(Projeto p,GUI gui){
        super();
        this.p = p;
        this.gui = gui;
        setTitle("Register");
        setSize(450,220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false); 
        
        
    }
}
