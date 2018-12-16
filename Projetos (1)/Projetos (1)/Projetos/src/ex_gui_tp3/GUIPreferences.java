/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_gui_tp3;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import projetos.PontoDeInteresse;
import projetos.Projeto;

/**
 *
 * @author Diogo Apóstolo
 */
public class GUIPreferences  extends JFrame{
        private Projeto p;
        private GUI gui;
        private GUIMenu menu;
        private JButton addP;
        private JButton addN;
      
        private JButton Next;
        private JButton Prev;
        private JList pontosDeInteresse;
        private JTextField nomeText;
        private JTextField popularidadeText;
        private JLabel nome;
        private JLabel popularidade;
        private JLabel pontosDeInteresseText;
        private int i;
        
        public GUIPreferences(Projeto p,GUI gui,GUIMenu menu){
            super();
            this.p = p;
            this.gui = gui;
            this.menu = menu;
           
            InitialI();
            
            
            
            setTitle("Preferences");
            setSize(390+200,250+25);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setResizable(false);
            
            nome = new JLabel("Nome:");
            nome.setBounds(10,10,50,25);
            
            
            nomeText = new JTextField(30);
            nomeText.setBounds(100,10,100,25);
           
            nomeText.setEditable(false);
            
            popularidade = new JLabel("Popularidade:");
            popularidade.setBounds(10,35,100,25);
            
            
            popularidadeText = new JTextField(30);
            popularidadeText.setEditable(false);
            popularidadeText.setBounds(100,35,100,25);
            
            
           
            
            
            
            pontosDeInteresse = new JList();
            pontosDeInteresse.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            pontosDeInteresse.setBounds(10,70+25,190,130);
            pontosDeInteresse.setBackground(new Color(178,178,178));
            pontosDeInteresseText = new JLabel("Pontos de interesse:");
            pontosDeInteresseText.setBounds(10,70 ,200 ,25 );
            changeLocal();
            addP = new JButton("Add local to hot");
            addP.setBounds(220+200,10,150,50);
            addP.addActionListener(new ButtonActionListener());
            addN = new JButton("Add local to not");
            addN.setBounds(220+200,70,150,50);
            addN.addActionListener(new ButtonActionListener());
            Prev = new JButton("Prev");
            Prev.setBounds(220+200,130+25,75,70);
            Prev.addActionListener(new ButtonActionListener());
            Next = new JButton("Next");
            Next.setBounds(295+200,130+25,75,70);
            Next.addActionListener(new ButtonActionListener());
            
            
            JPanel panel = new JPanel();
            panel.setLayout(null);
            panel.add(addP);
            panel.add(addN);
           
            panel.add(Next);
            panel.add(Prev);
            panel.add(nome);
            panel.add(nomeText);
            panel.add(popularidade);
            panel.add(popularidadeText);
            panel.add(pontosDeInteresse);
            panel.add(pontosDeInteresseText);
            add(panel);
            
            
            
    }
    
    private void updateList(){
        DefaultListModel<String> model = new DefaultListModel<>();
        
        if(i!=-1){
            for (PontoDeInteresse poi: p.getLocais().get(i).getPontosDeInteresse()) {
                    model.addElement(poi.getNome());
            }
        }
        System.out.println(i);
        pontosDeInteresse.setModel(model);
        
    }    
        
    
    private void changeLocal(){
       if(i==-1){
         nomeText.setText("");
         popularidadeText.setText("");
         
       }
       else{
         
           nomeText.setText(p.getLocais().get(i).getNome());
           popularidadeText.setText(Integer.toString(p.getLocais().get(i).getPopularidade()));
           updateList();
       }
        
        
        
        
    }
    
    private void InitialI(){
           
            int x = 0;
            for(i=0;i<p.getLocais().size();i++){
                System.out.println(p.getLocais().get(i));
                System.out.println(p.getUser().getLocais());
                System.out.println(p.getUser().getLocais().contains(p.getLocais().get(i)));
                if(p.Contains(p.getLocais().get(i))==0 && p.Contains(p.getLocais().get(i))==0){
                    x = 1;
                    
                    break;
                }
            }
            
            if(x == 0){
                i = -1;
            }
            
            System.out.println(i);
    }
    
    private class ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(e.getSource()==addP){
                if(i!=-1){
                    p.getUser().getLocais().add(p.getLocais().get(i));
                    p.SaveUsersToObjectFile();
                    
                    if((p.getUser().getLocais().size() + p.getUser().getNotLocais().size()) == p.getLocais().size()){
                        i = -1;
                    }
                    
                    JOptionPane.showMessageDialog(null, "Bem vindo de volta","Mensagem de sucesso", JOptionPane.PLAIN_MESSAGE);
                    InitialI();
                    changeLocal();
                }
            }
            
            else if(e.getSource()==addN){
                if(i!=-1){
                    p.getUser().getNotLocais().add(p.getLocais().get(i));
                    p.SaveUsersToObjectFile();
                    if((p.getUser().getLocais().size() + p.getUser().getNotLocais().size()) == p.getLocais().size()){
                        i = -1;
                    }
                    InitialI();
                    changeLocal();
                }
            }
            
            else if(e.getSource()==Next){
              
                if(i!=-1){
                    
                    do{
                        
                        
                        i++;
                        i = i%(p.getLocais().size());
                      
                        
                    }while(p.Contains(p.getLocais().get(i))==1 || p.Contains(p.getLocais().get(i))==1);
                    
                    changeLocal();
                   
                }
                
                
            }
            
            else if(e.getSource()==Prev){
                if(i!=-1){
                    do{
                        i--;
                        i = (i)%(p.getLocais().size());
                        if(i==-1){
                            i = p.getLocais().size()-1;
                        }
                    }while(p.Contains(p.getLocais().get(i))==1 || p.Contains(p.getLocais().get(i))==1 );
                    changeLocal();
                }
            }
        
        }
        
        
    }
    
    
    
    
}
