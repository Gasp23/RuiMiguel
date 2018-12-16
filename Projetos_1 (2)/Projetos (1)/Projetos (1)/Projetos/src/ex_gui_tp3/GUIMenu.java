/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_gui_tp3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import projetos.Projeto;

/**
 *
 * @author Diogo Apóstolo
 */
public class GUIMenu extends JFrame{
    private Projeto p;
    private GUI gui;
    private JButton btnPreferences;
    
    public GUIMenu(Projeto p,GUI gui){
        super();
        this.p = p;
        this.gui = gui;
        
        setTitle("Menu");
        setSize(450,220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        btnPreferences = new JButton("Set Preferences");
        btnPreferences.addActionListener(new ButtonPreferencesListener());
        
        JPanel panel = new JPanel();
        panel.add(btnPreferences);
        
        
        add(panel);
        
        
        
        
        
        
        
        
        
        
    }
    
    private void CreatePreferences(){
        GUIPreferences preferences = new GUIPreferences(p, gui, this);
        preferences.setVisible(true);
        this.setVisible(false);
    }
    
    
    
    private class ButtonPreferencesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            CreatePreferences();
        }
    }
    
    
    
}
