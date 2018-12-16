package projetos;

import java.io.Serializable;

public abstract class PontoDeInteresse implements Serializable, Comparable<PontoDeInteresse>{
    private String nome;
    private int popularidade;
    private Horário horario;
    private float custoEntrada;

    public PontoDeInteresse(String nome, int popularidade, Horário horario, float custoEntrada) {
        this.nome = nome;
        this.popularidade = popularidade;
        this.horario = horario;
        this.custoEntrada = custoEntrada;
    }

    public PontoDeInteresse() {
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPopularidade() {
        return popularidade;
    }

    public void setPopularidade(int popularidade) {
        this.popularidade = popularidade;
    }

    public Horário getHorario() {
        return horario;
    }

    public void setHorario(Horário horario) {
        this.horario = horario;
    }

    public float getCustoEntrada() {
        return custoEntrada;
    }

    public void setCustoEntrada(float custoEntrada) {
        this.custoEntrada = custoEntrada;
    }
    
    @Override
    public int compareTo(PontoDeInteresse o) {
        return o.popularidade-this.popularidade;
    }
    
    public abstract float custo();
    public abstract String getTipo();
    
    @Override
    public String toString() {
        return "PontoDeInteresse{" + "nome=" + nome + ", popularidade=" + popularidade + ", horario=" + horario + ", custoEntrada=" + custoEntrada + '}';
    }
}
