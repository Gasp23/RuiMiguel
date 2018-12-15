/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetos;

/**
 *
 * @author Diogo Apóstolo
 */
import ex_gui_tp3.GUI;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.lang.NumberFormatException;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.InputMismatchException;
import java.util.Random;
import javax.swing.JFrame;
import projetos.teste.Origem;
import projetos.teste.Ponto;

public class Projeto implements Serializable {

    private String fileObject;
   
    private ArrayList<Local> locais;
    private ArrayList<Aluno> alunos;
    private ArrayList<PontoDeInteresse> pontosDeInteresse;
    private ArrayList<Viagem> percursos;
    private HashMap<String, Origem> distanciaCusto;
    private Aluno user;
    private int id;

    public Projeto() {

        fileObject = "fileObject.txt";
     
        alunos = new ArrayList<>();
        locais = new ArrayList<>();

        percursos = new ArrayList<>();
        distanciaCusto = new HashMap<>();
        pontosDeInteresse = new ArrayList<>();
        //ler os pontos de interesse do ficheiro
        File f1 = new File(fileObject);
       
        if (f1.exists()) {

            try {
                FileInputStream fis = new FileInputStream(f1);
                ObjectInputStream ois = new ObjectInputStream(fis);
                PontoDeInteresse bar = new Bar();

                this.locais = (ArrayList<Local>) ois.readObject();
                this.alunos = (ArrayList<Aluno>) ois.readObject();
                this.distanciaCusto = (HashMap<String, Origem>) ois.readObject();
                this.pontosDeInteresse = (ArrayList<PontoDeInteresse>) ois.readObject();
                ois.close();

            } catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir ficheiro.");
            } catch (IOException ex) {
                System.out.println(ex);
            } catch (ClassNotFoundException ex) {
                System.out.println("Erro a converter objeto.");
            }

            

        } else {
            pontosDeInteresse = loadTextFilePI("PontosDeInteresse.txt");
            alunos = loadTextFileAlunos("Alunos.txt");

            distanciaCusto = loadTextFileHashMap("HashMap.txt");

            for (Aluno a : alunos) {
                System.out.println(a);
            }

            for (PontoDeInteresse p : pontosDeInteresse) {
                System.out.println(p);
            }

            for (Local e : this.locais) {

                System.out.println(e);
            }

            SaveToObjectFile();
            

        }

        GUI g = new GUI(this);
        g.setVisible(true);

    }

    public static void main(String[] args) {
        Projeto projeto = new Projeto();
        projeto.setUser(new Mestrado());
        System.out.println("Size");
        System.out.println(projeto.getPontosDeInteresse().size());
        projeto.algoritmo(projeto.user);
        //JFrame frame = new JFrame();
        //projeto.registo();
        //projeto.login();
        //para testar escolher preferencias
        //projeto.alunos.get(0).escolha(projeto.locais);
        /*System.out.println(projeto.alunos.get(0).getNotInteresses());
        projeto.alunos.get(0).getNotInteresses().add(new Bar());
        System.out.println(projeto.alunos.get(0).getNotInteresses());*/
 /*testar organiza
        projeto.locais.get(1).setPopularidade(1);
        System.out.println(projeto.locais);
        projeto.OrderLocais();
        System.out.println(projeto.locais);*/
    }

    //----------------------------------------------------------------------

    public String getFileObject() {
        return fileObject;
    }

    public void setFileObject(String fileObject) {
        this.fileObject = fileObject;
    }
  
    

    public void setLocais(ArrayList<Local> locais) {
        this.locais = locais;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void setPontosDeInteresse(ArrayList<PontoDeInteresse> pontosDeInteresse) {
        this.pontosDeInteresse = pontosDeInteresse;
    }

    public void setPercursos(ArrayList<Viagem> percursos) {
        this.percursos = percursos;
    }

    public void setDistanciaCusto(HashMap<String, Origem> distanciaCusto) {
        this.distanciaCusto = distanciaCusto;
    }

    public void setUser(Aluno user) {
        this.user = user;
    }

    public void setId(int id) {
        this.id = id;
    }

   

    public ArrayList<Local> getLocais() {
        return locais;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public ArrayList<PontoDeInteresse> getPontosDeInteresse() {
        return pontosDeInteresse;
    }

    public ArrayList<Viagem> getPercursos() {
        return percursos;
    }

    public HashMap<String, Origem> getDistanciaCusto() {
        return distanciaCusto;
    }

    public Aluno getUser() {
        return user;
    }

    public int getId() {
        return id;
    }

    //-------------------------------------------------------------
    public void OrderLocais() {
        Collections.sort(locais);
    }

    public void OrderPOI() {
        Collections.sort(pontosDeInteresse);
    }

    public void custoMax() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Intruduza um custo maximo que pretende gastar:");
        user.setCustoTotal(sc.nextFloat());
    }

    public void registo() {
        Aluno user;
        String nome;
        String password;
        String password2;
        Scanner sc = new Scanner(System.in);
        Iterator<Aluno> it;
        Aluno temp;
        int x;

        do {
            it = alunos.iterator();
            System.out.println("Introduza um nome:");
            nome = sc.nextLine();
            x = 0;
            while (it.hasNext()) {
                temp = it.next();

                if (nome.equals(temp.getNome()) == true) {
                    System.out.println("Nome ja esta em uso\n");
                    x = 1;
                    break;
                }
            }

        } while (x == 1);

        do {
            System.out.println("Introduza uma password");
            password = sc.nextLine();
            System.out.println("Confirme a password");
            password2 = sc.nextLine();
            if (password.equals(password2) == false) {
                System.out.println("As passwords não são iguais\n");
            }
        } while (password.equals(password2) == false);

        System.out.println("É aluno de mestrado ou licenciatura? (0-licenciatura) (1-mestrado)");

        while (true) {

            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                if (choice == 0) {
                    user = new Licenciatura(nome, password);
                    break;
                } else if (choice == 1) {
                    user = new Mestrado(nome, password);
                    break;
                } else {
                    System.out.println("Introduza um valor válido.");
                }
            } else {
                sc.next();
                System.out.println("Introduza um valor válido.");
            }
        }
        System.out.println("ijdjdj\n");
        alunos.add(user);

    }

    private HashMap loadTextFileHashMap(String filename) {
        File f = new File(filename);
        HashMap<String, Origem> list = new HashMap();
        if (f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);

                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    int distancia = 0;
                    int custo = 0;
                    int x = 0;
                    String[] s = line.split(",");
                    if (s.length == 4) {
                        if (s[0].length() == 0) {

                            continue;
                        }

                        //verifica se o local de origem existe na ArrayList de locais
                        for (Local l : locais) {
                            if (s[0].equals(l.getNome())) {
                                x = 1;
                                break;
                            }

                        }

                        //se nao existir sai
                        if (x == 0) {
                            continue;
                        }

                        x = 0;

                        if (s[1].length() == 0) {
                            continue;
                        }

                        //verifica se o local de destino existe na ArrayList de locais
                        for (Local l : locais) {
                            if (s[1].equals(l.getNome())) {
                                x = 1;
                                break;
                            }

                        }

                        //se não existir sai
                        if (x == 0) {
                            continue;
                        }

                        try {
                            distancia = Integer.parseInt(s[2]);
                            custo = Integer.parseInt(s[3]);

                        } catch (NumberFormatException e) {

                            System.out.println("erro ao ler o custo ou a distancia");
                            continue;
                        }

                        //criar hashmap de hashmap;
                        //verifica a chave ja existe
                        if (list.containsKey(s[0])) {
                            //verifica se o valor da chave ja existe
                            if (!(list.get(s[0]).dest.containsKey(s[1]))) {
                                //adicionar à hashmap
                                Ponto p = new Ponto(s[0], s[1], custo, distancia);
                                list.get(s[0]).addPoint(p.getDestino(), p);

                            }

                        } else {
                            //adicionar à hashmap

                            Ponto p = new Ponto(s[0], s[1], custo, distancia);
                            Origem pt = new Origem();
                            pt.addPoint(p.getDestino(), p);
                            list.put(s[0], pt);

                        }

                    }

                }
                System.out.println("        " + list.get("Coimbra").dest.get("Aguiar").getCusto());
                //verificar se a hashmap esta completa!!!!!!

                br.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir ficheiro de texto.");
            } catch (IOException ex) {
                System.out.println("Erro a ler ficheiro de texto.");
            } catch (Exception e) {
                System.out.println("ERRO! Qual?");
                e.printStackTrace();
            }
        } else {
            System.out.println("Ficheiro não existe.");
        }

        return list;

    }

    private ArrayList<Aluno> loadTextFileAlunos(String filename) {

        ArrayList<Aluno> alunos = new ArrayList();
        File f = new File(filename);

        if (f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);

                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    String[] s = line.split(",");

                    if (s[0].equals("Licenciatura") && s.length == 3) {
                        if (s[1].length() != 0 && s[2].length() != 0) {
                            alunos.add(new Licenciatura(s[1], s[2]));
                        }

                    }

                    if (s[0].equals("Mestrado") && s.length == 3) {
                        if (s[1].length() != 0 && s[2].length() != 0) {
                            alunos.add(new Mestrado(s[1], s[2]));
                        }
                    }

                }

                br.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir ficheiro de texto.");
            } catch (IOException ex) {
                System.out.println("Erro a ler ficheiro de texto.");
            } catch (Exception e) {
                System.out.println("ERRO! Qual?");
                e.printStackTrace();
            }
        } else {
            System.out.println("Ficheiro não existe.");
        }

        return alunos;
    }

    private ArrayList<PontoDeInteresse> loadTextFilePI(String filename) {
        ArrayList<PontoDeInteresse> pontosInteresses = new ArrayList();

        File f = new File(filename);
        int i = 0;
        int good = 0;
        if (f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                PontoDeInteresse p = null;
                String line;
                while ((line = br.readLine()) != null) {
                    good = 0;
                    System.out.println(line);

                    String[] s = line.split(",");
                    if (s[0].equals("Aquatico") && s.length == 8) {

                        int piscinas = 0;
                        boolean espetaculo;
                        int escorregas = 0;
                        try {
                            piscinas = Integer.parseInt(s[5]);
                        } catch (NumberFormatException e) {
                            System.out.println("Não há piscinas neste parque aquatico. Ironic");
                        }

                        espetaculo = Boolean.parseBoolean(s[6]);

                        try {
                            escorregas = Integer.parseInt(s[7]);
                        } catch (NumberFormatException e) {
                            System.out.println("Não há escorregas neste parque aquatico. Sad");
                        }

                        p = new Aquatico(piscinas, espetaculo, escorregas);

                        good = 1;
                        /*ClienteNormal cn = new ClienteNormal(s[1], idade);
                        cn.setPref(getPref(s[3]));
                        clientes.add(cn);*/
                    } else if (s[0].equals("Bar") && s.length == 6) {
                        /*ClienteGold cg = new ClienteGold(s[1], Integer.parseInt(s[2]), s[3], s[4]);
                        cg.setPref(getPref(s[3]));
                        clientes.add(cg);*/
                        float classificaçao = 0;
                        try {
                            classificaçao = Float.parseFloat(s[5]);
                        } catch (NumberFormatException e) {
                            System.out.println("Classificaçao ainda nao realizada");
                            classificaçao = 0;
                        }
                        p = new Bar(classificaçao);

                        good = 1;
                    } else if (s[0].equals("Cultural") && s.length == 6) {
                        String tematica = s[5];
                        if (tematica.length() == 0) {
                            System.out.println("Abreu woudn't be proud");
                            continue;
                        }
                        p = new Cultural(tematica);
                        good = 1;
                        /*ClienteEmpresa ce = new ClienteEmpresa(s[1], Integer.parseInt(s[2]), Integer.parseInt(s[3]), s[4]);
                        ce.setPref(getPref(s[3]));
                        clientes.add(ce);*/
                    } else if (s[0].equals("Museu") && s.length == 6) {
                        String tematica = s[5];
                        if (tematica.length() == 0) {
                            System.out.println("Abreu woudn't be proud");
                            continue;
                        }
                        p = new Museu(tematica);
                        good = 1;
                    } else if (s[0].equals("Tematico") && s.length == 9) {
                        String tematica = s[5];
                        boolean unico;
                        int rodaGigante = 0;
                        int montanhaRussa = 0;

                        if (tematica.length() == 0) {
                            System.out.println("Abreu woudn't be proud");
                            continue;
                        }

                        unico = Boolean.parseBoolean(s[6]);

                        try {
                            rodaGigante = Integer.parseInt(s[7]);
                        } catch (NumberFormatException e) {
                            System.out.println("Nao ha roda gigante");
                        }

                        try {
                            montanhaRussa = Integer.parseInt(s[8]);
                        } catch (NumberFormatException e) {
                            System.out.println("Nao ha montanhas russas");
                        }
                        p = new Tematico(tematica, unico, rodaGigante, montanhaRussa);
                        good = 1;
                    } else if (s[0].equals("Universidade") && s.length == 6) {
                        /*Univerdidade ce = new ClienteEmpresa(s[1], Integer.parseInt(s[2]), Integer.parseInt(s[3]), s[4]);
                        ce.setPref(getPref(s[5]));
                        clientes.add(ce);*/
                        ArrayList<String> cursos = getCursos(s[5]);
                        p = new Universidade(cursos);
                        good = 1;
                    }

                    if (good == 1) {

                        String n = s[1];
                        if (n.length() == 0) {
                            System.out.println("Abreu woudn't be proud");
                            pontosInteresses.remove(pontosInteresses.size() - 1);
                            continue;
                        }
                        Horário horario;

                        try {
                            horario = getHorario(s[2]);
                        } catch (NumberFormatException e) {
                            continue;
                        }

                        float custoTotal = 0;

                        try {
                            custoTotal = Float.parseFloat(s[4]);
                        } catch (NumberFormatException e) {
                            System.out.println("Its free, BABY");
                        }

                        p.setCustoEntrada(custoTotal);
                        p.setHorario(horario);
                        p.setNome(n);
                        p.setPopularidade(0);
                        String local = s[3];

                        if (local.length() == 0) {
                            System.out.println("Abreu woudn't be proud");
                            continue;
                        }
                        
                        Local l = processLocal(s[3]);
                        System.out.println("Ponto De Interesse: ");
                        System.out.println(p);
                        this.pontosDeInteresse.add(p);
                        System.out.println("Size");
                        System.out.println(this.pontosDeInteresse.size());
                        l.addPoI(p);

                        i++;
                    }
                }

                br.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir ficheiro de texto.");
            } catch (IOException ex) {
                System.out.println("Erro a ler ficheiro de texto.");
            } catch (Exception e) {
                System.out.println("ERRO! Qual?");
                e.printStackTrace();
            }
        } else {
            System.out.println("Ficheiro não existe.");
        }

        return this.pontosDeInteresse;
    }

   
    private ArrayList<String> getCursos(String string) {
        // STRING: pref1;pref2;pref3
        ArrayList<String> cursos = new ArrayList();

        String[] s = string.split(";");

        for (String p : s) {
            if (p.length() == 0) {
                continue;
            }
            cursos.add(p);
        }

        return cursos;
    }

    private Horário getHorario(String string) {
        // STRING: pref1;pref2;pref3

        int[] tempo = new int[4];
        String[] s = string.split(";");
        if (s.length == 4) {
            try {
                for (int i = 0; i < 4; i++) {
                    tempo[i] = Integer.parseInt(s[i]);
                }
            } catch (NumberFormatException e) {
                throw e;
            }

            System.out.println(tempo[0]);
            if ((0 > tempo[0]) || (24 < tempo[0]) || (0 > tempo[2]) || (24 < tempo[2]) || (0 > tempo[1]) || (60 < tempo[1]) || (0 > tempo[3]) || (60 < tempo[3])) {
                throw new NumberFormatException();

            }

            Horário horario = new Horário(tempo[0], tempo[1], tempo[2], tempo[3]);
            return horario;
        } else {
            throw new NumberFormatException();
        }

    }
    
    
    public void SaveToObjectFile() {
        File f1 = new File(fileObject);
        try {
                FileOutputStream fos = new FileOutputStream(f1);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(locais);
                oos.writeObject(alunos);
                oos.writeObject(distanciaCusto);
                oos.writeObject(pontosDeInteresse);
                oos.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Erro a criar ficheiro.");
            } catch (IOException ex) {
                System.out.println("Erro a escrever para o ficheiro.");
        }

    }
    
    public int Contains(Local local){
        for(int i=0;i<user.getLocais().size();i++){
            if(user.getLocais().get(i).getNome().equals(local.getNome())){
                return 1;
            }
            
        }
        
        for(int i=0;i<user.getNotLocais().size();i++){
            if(user.getNotLocais().get(i).getNome().equals(local.getNome())){
                return 1;
            }
        }
        
        
        return 0;  
        
    }
    
    
    public int Contains2(PontoDeInteresse pontoDeInteresse){
       
        for(int i=0;i<user.getInteresses().size();i++){
            if(user.getInteresses().get(i).getNome().equals(pontoDeInteresse.getNome())){
                return 1;
            }
            
        }
        
        for(int i=0;i<user.getNotInteresses().size();i++){
            if(user.getNotInteresses().get(i).getNome().equals(pontoDeInteresse.getNome())){
                return 1;
            }
        }
        
        
        return 0;  
        
    }
    
    private void algoritmo(Aluno user){
        ArrayList<Local> pref = user.getLocais();
        ArrayList<PontoDeInteresse> prefInteresses = user.getInteresses();
        Random rand=new Random();
        ArrayList<Local> locais = new ArrayList<Local>();
        for(int j=0;j<10;j++){
            if(0<=pref.size()&&pref.size()<=3){
                locais.addAll(pref);
                for (int i = 0; i < 3-pref.size(); i++) {
                    int randomInt =rand.nextInt(this.locais.size());
                    while(locais.contains(this.locais.get(randomInt))){
                        randomInt =rand.nextInt(this.locais.size());
                    }
                    locais.add(this.locais.get(randomInt));
                }
            }
            else{
                for (int i = 0; i <3; i++) {
                    int randomInt =rand.nextInt(pref.size());
                    while(locais.contains(pref.get(randomInt))){
                        randomInt =rand.nextInt(pref.size());
                    }
                    locais.add(pref.get(randomInt));
                }
            }
            ArrayList<PontoDeInteresse> poiFinal =new ArrayList<>();
            for (Local local : locais) {
                for (PontoDeInteresse poi : prefInteresses) {
                    if(local.getPontosDeInteresse().contains(poi)){
                        poiFinal.add(poi);
                    }
                }
                int randomInt =rand.nextInt(this.pontosDeInteresse.size());
                System.out.println("RandomInt:");
                System.out.println(randomInt);
                while(poiFinal.contains(this.pontosDeInteresse.get(randomInt))){
                    randomInt =rand.nextInt(local.getPontosDeInteresse().size());
                }
                System.out.println("Reaches");
                poiFinal.add(this.pontosDeInteresse.get(randomInt));
            }
            this.percursos.add(new Viagem(locais, poiFinal));
        }
    }
    
    private void filtro(Aluno user){
        ArrayList<Viagem> remover = new ArrayList<>();
        ArrayList<Local> notLocais= user.getNotLocais();
        ArrayList<PontoDeInteresse> notInteresses=user.getNotInteresses();
        boolean remove;
        for (Viagem v : this.percursos) {
            remove=true;
            if(v.getCustoTotal()>user.getCustoTotal()){
                remover.add(v);
            }
            for(PontoDeInteresse interesse: v.getInteresses()){
                if(interesse.getTipo().equals("Museu")){
                    remove=false;
                    break;
                }
            }
            if(remove){
                remover.add(v);
            }
        }
        percursos.removeAll(remover);
        if(percursos.size()==0){
            return;
        }
        for(Viagem v : this.percursos){
            remove=false;
            for (Local notLocal : notLocais) {
                if(v.getLocais().contains(v)){
                    remover.add(v);
                    remove=true;
                    break;
                }
            }
            if(remove){
                break;
            }
            for(PontoDeInteresse notInteresse: notInteresses){
                if(v.getInteresses().contains(notInteresse)){
                    remover.add(v);
                    remove=true;
                    break;
                }
            }
        }
        percursos.removeAll(remover);
    }
    
    private Local processLocal(String name) {
        // Search name

        for (Local l : locais) {
            if (l.getNome().equals(name)) {

                return l;
            }
        }

        // Create
        Local temp = new Local();
        temp.setNome(name);
        locais.add(temp);
        return temp;
    }

}
