package jogadores;

import java.io.Serializable;


public class JogadorBase implements Serializable{

    protected String nome;
    protected int idade;
    protected double peso;
    protected double tamanho;
    protected int camisa;
    protected int nGols;
    protected int assistencias;
    protected int cartaoAmarelo;
    protected int cartaoVermelho;
    protected String time;

    public JogadorBase(String nome, int idade, double peso, double tamanho, int camisa) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.tamanho = tamanho;
        this.camisa = camisa;
        nGols = 0;
        assistencias = 0;
        cartaoAmarelo = 0;
        cartaoVermelho = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public int getCamisa() {
        return camisa;
    }

    public void setCamisa(int camisa) {
        this.camisa = camisa;
    }

    public int getnGols() {
        return nGols;
    }

    public void setnGols(int nGols) {
        this.nGols = nGols;
    }

    public int getAssistencias() {
        return assistencias;
    }

    public void setAssistencias(int assistencias) {
        this.assistencias = assistencias;
    }

    public void fezGol() {
        nGols++;
    }
    
    public void cartaoVermelho(){
        cartaoVermelho++;
    }
    
    public void cartaoAmarelo(){
        cartaoAmarelo++;
    }
    
    public void deuAssistencia(){
        assistencias++;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    

}
