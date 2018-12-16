package ex_gui_tp3;

//import ex_files_tp3.Cliente;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
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
import projetos.Aluno;
import projetos.Licenciatura;
import projetos.Projeto;

public class GUI extends JFrame {
    private JList clients;
    
    private Projeto p;
    
   
    private JLabel labelName;
    private JLabel nome;
    private JLabel password;
    private JTextField nameField;
    private JTextField passwordField;
    private JLabel mensagem;
    private JButton btnLogin;
    private JButton btnRegister;
    
    public GUI(Projeto p) {
        super();
        
        this.p = p;
        
        setTitle("Login");
        setSize(450,220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        mensagem = new JLabel("Introduza as suas credênciais:");
        mensagem.setFont(new Font("Serif",Font.BOLD,14));
        mensagem.setBounds(50,10,300 ,50);
        
        nome = new JLabel("Nome:");
        nome.setBounds(50,60,150,25);
        nameField = new JTextField(20);
        nameField.setBounds(125,60,150,25);
        
        password = new JLabel("Password:");
        password.setBounds(50,110,150,25);
        passwordField = new JTextField(20);
        passwordField.setBounds(125,110,150,25);
        
        
        btnLogin = new JButton("Login");
        btnLogin.setBounds(300,110,100,25);
        
        btnRegister = new JButton("Register");
        btnRegister.setBounds(300,60,100,25);
            
        btnLogin.addActionListener(new ButtonLoginListener());
        btnRegister.addActionListener(new ButtonRegisterListener());
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(nome);
        panel.add(nameField);
        panel.add(password);
        panel.add(passwordField);
        panel.add(mensagem);
        panel.add(btnLogin);
        panel.add(btnRegister);
        add(panel);
    }
    

    private int login(String nome,String password) {
        
        Aluno temp;
        Scanner sc = new Scanner(System.in);
        Iterator<Aluno> it;
        int x=0;
        
        
        it = p.getAlunos().iterator();

        while (it.hasNext()) {
            temp = it.next();
            if ((nome.equals(temp.getNome())) && (password.equals(temp.getPassword()))) {
                
                p.setUser(temp);
                return 1;
            }
        }

       return 0; 
       
    }

    private void createMenu() {
        GUIMenu menu = new GUIMenu(p, this);
        menu.setVisible(true);
        this.setVisible(false);
    }
    
    private void CreateRegister(){
        GUIRegister register = new GUIRegister(p,this);
        register.setVisible(true);
        this.setVisible(false);
    }
    
    private class ButtonRegisterListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            CreateRegister();
        }
        
    }
    
    private class ButtonLoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nome = nameField.getText();
            String password = passwordField.getText();
            
            if(nome.length()==0){
                JOptionPane.showMessageDialog(null, "Introduza um nome!","Failed", JOptionPane.PLAIN_MESSAGE);
                createMenu(); //CHANGE THIS
            }
            
            else if(password.length()==0){
                JOptionPane.showMessageDialog(null, "Introduza uma password!","Failed", JOptionPane.PLAIN_MESSAGE);
            }
            
            else{
                if(login(nome,password)==1){
                    JOptionPane.showMessageDialog(null, "Bem vindo de volta","Mensagem de sucesso", JOptionPane.PLAIN_MESSAGE);
                    createMenu();
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Nome ou password incorretos!","Failed", JOptionPane.PLAIN_MESSAGE);
                }
            }
            
        }
    }
    
    
    
    
    
        /*clients = new JList();
        clients.setBackground(new Color(178,178,178));
        clients.setBounds(10, 10, 200, 150);
        clients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //clients.addListSelectionListener(new ListListener());
        panel.add(clients);
        
        btnAdd = new JButton("Add");
        btnAdd.setBounds(10,175,200,25);
        //btnAdd.addActionListener(new ButtonListener());
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
        
       // updateList();
       */
        
        
        
    


    
    
}    
    
    /*
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
        GUIInput input = new GUIInput(p, this);
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
    }*/

    
//    public static void main(String[] args) {
//        GUI gui = new GUI();
//        gui.setTitle("Clientes");
//        gui.setSize(500, 300);
//        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        gui.setResizable(false);
//        gui.setVisible(true);
//    }

