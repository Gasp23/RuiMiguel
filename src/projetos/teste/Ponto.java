/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetos.teste;

import java.io.Serializable;

/**
 *
 * @author Asus
 */
public class Ponto implements Serializable{
    String origem;
    String destino;
    double custo;
    double distancia;

    public Ponto(String origem, String destino, double custo, double distancia) {
        this.origem = origem;
        this.destino = destino;
        this.custo = custo;
        this.distancia = distancia;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    
        
}
