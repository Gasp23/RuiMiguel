/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_gui_tp3;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import projetos.Aluno;
import projetos.Licenciatura;
import projetos.Projeto;

/**
 *
 * @author Diogo Apóstolo
 */
public class GUIRegister extends JFrame{
    private Projeto p;
    private GUI gui;
    private JButton ok;
    private JButton exit;
    private JTextField nomeText;
    private JTextField passwordText;
    private JTextField passwordConfirmedText;
    private JLabel nome;
    private JLabel password;
    private JLabel passwordConfirmed;
    private JCheckBox lei;
    private JCheckBox mei;
    
    public GUIRegister(Projeto p,GUI gui){
        super();
        this.p = p;
        this.gui = gui;
        setTitle("Register");
        setSize(450,220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false); 
        
        ok = new JButton("REGISTER");
        ok.setBounds(0,130,450,50);
        ok.addActionListener(new ButtonActionListener());
        exit = new JButton("EXIT");
        exit.setBounds(340,20,100,100);
        exit.addActionListener(new ButtonActionListener());
        lei = new JCheckBox("LEI");
        lei.setBounds(280,40,50,20);
        mei = new JCheckBox("MEI");
        mei.setBounds(280,70,50,20);
        
        nome = new JLabel("Nome:");
        nome.setBounds(10,10+10,150,25);
        nomeText = new JTextField(20);
        nomeText.setBounds(125,10+10,150,25);
        
        password = new JLabel("Password:");
        password.setBounds(10,40+10,150,25);
        passwordText = new JTextField(20);
        passwordText.setBounds(125,40+10,150,25);
        
        
        
        passwordConfirmed = new JLabel("Confirm password:");
        passwordConfirmed.setBounds(10,70+10,150,25);
        passwordConfirmedText = new JTextField(20);
        passwordConfirmedText.setBounds(125,70+10,150,25);
        
        
        /*addP = new JButton("Add POI to hot");
        addP.setBounds(220 + 200, 10, 150, 50);
        addP.addActionListener(new GUIPointsOfInterest.ButtonActionListener());*/
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(ok);
        panel.add(exit);
        panel.add(password);
        panel.add(passwordText);
        panel.add(passwordConfirmed);
        panel.add(passwordConfirmedText);
        panel.add(nome);
        panel.add(nomeText);
        panel.add(lei);
        panel.add(mei);
        
        add(panel);
        
        
    }
    
    private class ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==ok){
                int x = 0;
                if(nomeText.getText().length() == 0){
                    JOptionPane.showMessageDialog(null, "Nome invalido","Mensagem", JOptionPane.PLAIN_MESSAGE);
                    return;
                }
                
                if(passwordText.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Password invalida","Mensagem", JOptionPane.PLAIN_MESSAGE);
                    return;
                }
                
                
                for(Aluno a: p.getAlunos()){
                    
                    if(a.getNome().equals(nomeText.getText())){
                        x = 1;
                        break;
                    }
                }
                
                if(x==1){
                    JOptionPane.showMessageDialog(null, "Nome já em uso","Mensagem", JOptionPane.PLAIN_MESSAGE);
                    return;
                }
                
                if(passwordText.getText().equals(passwordConfirmedText.getText())){
                    p.getAlunos().add(new Licenciatura(nomeText.getText(),passwordText.getText()));
                    GUIRegister.this.setVisible(false);
                    gui.setVisible(true);
                    return;
                }
                else{
                    JOptionPane.showMessageDialog(null, "passwords não são iguais","Mensagem", JOptionPane.PLAIN_MESSAGE);
                    return;  
                }
                
                
            }
            
            if(e.getSource()==exit){
                GUIRegister.this.setVisible(false);
                gui.setVisible(true);
            }
            
        }
    
    
    
    }


}
