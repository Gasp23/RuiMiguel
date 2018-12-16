package ex_gui_tp3;

import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import projetos.PontoDeInteresse;
import projetos.Projeto;

/**
 *
 * @author Rui Miguel
 */
class GUIVoyages extends JFrame{
    private Projeto p;
    private GUI gui;
    private GUIMenu menu;
    private JButton next;
    private JButton prev;
    private JTextField pontosDeInteresse;
    private JList locais;

    public GUIVoyages(Projeto p, GUI gui, GUIMenu menu) {
        super();
        this.p = p;
        this.gui = gui;
        this.menu = menu;
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        setTitle("Voyages");
        setSize(390+200,250+25);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        locais = new JList();
        locais.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        locais.setBounds(10,70+25,190,130);
        locais.setBackground(new Color(178,178,178));
        locais.addListSelectionListener(new showListener());
        panel.add(locais);
        
        next=new JButton("Next voyage");
        
        prev=new JButton("Prev voyage");
        add(panel);
        
    }
    
    private class showListener implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
//            System.out.println("Escolhido: "+p.getLocais().);
        }    
    }
    
    private void updateList(){
        DefaultListModel<PontoDeInteresse> model=new DefaultListModel<>();
//        for(p.getPercursos()){
//            
//        }
    }
    
    
}
