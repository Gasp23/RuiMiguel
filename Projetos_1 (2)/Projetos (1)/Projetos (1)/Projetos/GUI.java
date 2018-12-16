package ex_gui_tp3;

import ex_files_tp3.Cliente;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GUI extends JFrame {
    private JList clients;
    private JButton btnAdd;
    private ArrayList<Cliente> names;
    private JTextField tfName;
    private JLabel labelName;
    private final JLabel labelAge;
    private final JTextField tfAge;
    
    public GUI(ArrayList<Cliente> names) {
        this.names = names;
        
        setTitle("Clientes");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        
//        names = new ArrayList<>();
//        names.add(new Cliente("Joao", 10));
//        names.add(new Cliente("Maria", 11));
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        clients = new JList();
        clients.setBackground(new Color(178,178,178));
        clients.setBounds(10, 10, 200, 150);
        clients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        clients.addListSelectionListener(new ListListener());
        panel.add(clients);
        
        btnAdd = new JButton("Add");
        btnAdd.setBounds(10,175,200,25);
        btnAdd.addActionListener(new ButtonListener());
        panel.add(btnAdd);
        
        labelName = new JLabel("Name");
        labelName.setBounds(220,10,50,25);
        panel.add(labelName);
        
        tfName = new JTextField();
        tfName.setBounds(280,10,200,25);
        panel.add(tfName);
        
        labelAge = new JLabel("Age");
        labelAge.setBounds(220,35,50,25);
        panel.add(labelAge);
        
        tfAge = new JTextField();
        tfAge.setBounds(280,35,200,25);
        panel.add(tfAge);
        
        updateList();
        
        
        
        add(panel);
    }

    void addCliente(String name, String age) {
        names.add(new Cliente(name, Integer.parseInt(age)));
        updateList();
    }
    
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
//            String value = JOptionPane.showInputDialog(null, "Introduza o nome do cliente", "Nome", JOptionPane.QUESTION_MESSAGE);
//            names.add(new Cliente(value,0));
//            updateList();
            createInput();
        }
    }
    
    private void createInput() {
        GUIInput input = new GUIInput(this);
        input.setVisible(true);
        this.setVisible(false);
    }
    
    private class ListListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            System.out.println("Escolhido: "+clients.getSelectedValue());
            
            String tf = clients.getSelectedValue()+"";
            
            for(Cliente c: names) {
                if(c.getNome().equals(tf)) {
                    tfName.setText(c.getNome());
                    tfAge.setText(""+c.getIdade());
                }
            }
            
        }
    }
    
    private void updateList() {
        DefaultListModel<String> model = new DefaultListModel<>();
        
        for(Cliente name: names) {
            model.addElement(name.getNome());
        }
        
        clients.setModel(model);
    }
    
//    public static void main(String[] args) {
//        GUI gui = new GUI();
//        gui.setTitle("Clientes");
//        gui.setSize(500, 300);
//        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        gui.setResizable(false);
//        gui.setVisible(true);
//    }
}
