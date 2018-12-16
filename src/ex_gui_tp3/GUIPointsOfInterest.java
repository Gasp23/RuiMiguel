/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_gui_tp3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import projetos.PontoDeInteresse;
import projetos.Projeto;

/**
 *
 * @author Diogo Apóstolo
 */
public class GUIPointsOfInterest extends JFrame {

    private Projeto p;
    private GUIPreferences guiPreferences;
    private JButton addP;
    private JButton addN;
    private JButton Next;
    private JButton Prev;
    private JButton Exit;
    private JTextField nomeText;
    private JTextField popularidadeText;
    private JLabel nome;
    private JLabel popularidade;
    private int j;
    private int i;
    private ArrayList<PontoDeInteresse> pontosDeInteresse;

    public GUIPointsOfInterest(Projeto p, GUIPreferences guiPreferences,int i) {
        super();
        
        this.i = i;
        pontosDeInteresse = p.getLocais().get(this.i).getPontosDeInteresse();
        this.p = p;
        
        this.guiPreferences = guiPreferences;
        setTitle("Preferences");
        setSize(390 + 200, 250 + 25);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        InitialI();
        
        nome = new JLabel("Nome:");
        nome.setBounds(10, 10, 50, 25);

        nomeText = new JTextField(30);
        nomeText.setBounds(100, 10, 100, 25);
        
        nomeText.setEditable(false);

        popularidade = new JLabel("Popularidade:");
        popularidade.setBounds(10, 35, 100, 25);

        popularidadeText = new JTextField(30);
        popularidadeText.setEditable(false);
        popularidadeText.setBounds(100, 35, 100, 25);
        
        changeLocal();
        addP = new JButton("Add POI to hot");
        addP.setBounds(220 + 200, 10, 150, 50);
        addP.addActionListener(new GUIPointsOfInterest.ButtonActionListener());
        addN = new JButton("Add POI to not");
        addN.setBounds(220 + 200, 70, 150, 50);
        addN.addActionListener(new GUIPointsOfInterest.ButtonActionListener());
        Prev = new JButton("Prev");
        Prev.setBounds(220 + 200, 130 + 25, 75, 70);
        Prev.addActionListener(new GUIPointsOfInterest.ButtonActionListener());
        Next = new JButton("Next");
        Next.setBounds(295 + 200, 130 + 25, 75, 70);
        Next.addActionListener(new GUIPointsOfInterest.ButtonActionListener());
        Exit = new JButton("Exit");
        addP.setBounds(220 + 200, 10, 150, 50);
        
        
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
        add(panel);

    }

    private void changeLocal() {
        if (j == -1) {
            nomeText.setText("");
            popularidadeText.setText("");

        } else {

            nomeText.setText(pontosDeInteresse.get(j).getNome());
            popularidadeText.setText(Integer.toString(pontosDeInteresse.get(j).getPopularidade()));
            //updateList();
        }

    }

    private void InitialI() {

        int x = 0;
        for (j = 0; j < pontosDeInteresse.size(); j++) {
            System.out.println(pontosDeInteresse.get(j) + " " + j);
            if (p.Contains2(pontosDeInteresse.get(j)) == 0 && p.Contains2(pontosDeInteresse.get(j)) == 0) {
                x = 1;

                break;
            }
        }

        if (x == 0) {
            j = -1;
        }

        System.out.println(j);
    }

    private class ButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == addP) {
                if (j != -1) {
                    p.getUser().getInteresses().add(pontosDeInteresse.get(j));
                    p.SaveToObjectFile();

                    if ((p.getUser().getInteresses().size() + p.getUser().getNotLocais().size()) == pontosDeInteresse.size()) {
                        j = -1;
                    }

                    InitialI();
                    changeLocal();

                }
            } else if (e.getSource() == addN) {
                if (j != -1) {
                    p.getUser().getNotInteresses().add(p.getPontosDeInteresse().get(j));
                    p.SaveToObjectFile();
                    if ((p.getUser().getInteresses().size() + p.getUser().getNotInteresses().size()) == pontosDeInteresse.size()) {
                        j = -1;
                    }
                    InitialI();
                    changeLocal();

                }
            } else if (e.getSource() == Next) {

                if (j != -1) {

                    do {

                        j++;
                        j = j % (pontosDeInteresse.size());

                    } while (p.Contains2(pontosDeInteresse.get(j)) == 1 || p.Contains2(pontosDeInteresse.get(j)) == 1);

                    changeLocal();

                }

            } else if (e.getSource() == Prev) {
                if (j != -1) {
                    do {
                        j--;
                        j = (j) % (pontosDeInteresse.size());
                        if (j == -1) {
                            j = pontosDeInteresse.size() - 1;
                        }
                    } while (p.Contains2(pontosDeInteresse.get(j)) == 1 || p.Contains2(pontosDeInteresse.get(j)) == 1);
                    changeLocal();
                }
            }

        }

    }
}
