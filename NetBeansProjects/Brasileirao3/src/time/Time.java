package time;

import java.io.Serializable;
import java.util.ArrayList;
import jogadores.Goleiro;
import jogadores.JogadorDeLinha;


public class Time implements Serializable{
    
    private String nome;
    private String sigla;
    private String estagio;
    private int vitorias;
    private int derrotas;
    private int empates;
    private int pontos;
    private int gFeitos;
    private int gSofridos;
    private int saldoDeGols;
    private ArrayList<JogadorDeLinha> jogadores;
    private ArrayList<Goleiro> goleiros;
    private double ranking;
    private String logo;

    public Time(String nome, String sigla, String estagio, int ranking) {
        this.nome = nome;
        this.sigla = sigla;
        this.estagio = estagio;
        this.ranking = ranking;
        vitorias = 0;
        derrotas = 0;
        empates = 0;
        pontos = 0;
        gFeitos = 0;
        gSofridos = 0;
        saldoDeGols = 0;
        jogadores = new ArrayList<>();
        goleiros = new ArrayList<>();
        logo = nome;
        
    }
    
    public Time(Time time) {
        this.nome = time.getNome();
        this.sigla = time.getSigla();
        this.estagio = time.getEstagio();
        this.ranking = time.getRanking();
        vitorias = time.getVitorias();
        derrotas = time.getDerrotas();
        empates = time.getEmpates();
        pontos = time.getPontos();
        gFeitos = time.getgFeitos();
        gSofridos = time.getgSofridos();
        saldoDeGols = time.getSaldoDeGols();
        jogadores = time.getJogadores();
        goleiros = time.getGoleiros();
        logo = time.getLogo();       
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getEstagio() {
        return estagio;
    }

    public void setEstagio(String estagio) {
        this.estagio = estagio;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getgFeitos() {
        return gFeitos;
    }

    public void setgFeitos(int gFeitos) {
        this.gFeitos = gFeitos;
    }

    public int getgSofridos() {
        return gSofridos;
    }

    public void setgSofridos(int gSofridos) {
        this.gSofridos = gSofridos;
    }

    public int getSaldoDeGols() {
        return saldoDeGols;
    }

    public void setSaldoDeGols(int saldoDeGols) {
        this.saldoDeGols = saldoDeGols;
    }

    public ArrayList<JogadorDeLinha> getJogadores() {
        return jogadores;
    }

    public void setJogadores(ArrayList<JogadorDeLinha> jogadores) {
        this.jogadores = jogadores;
    }

    public ArrayList<Goleiro> getGoleiros() {
        return goleiros;
    }

    public void setGoleiros(ArrayList<Goleiro> goleiros) {
        this.goleiros = goleiros;
    }

    public double getRanking() {
        return ranking;
    }

    public void setRanking(double ranking) {
        this.ranking = ranking;
    }
    
    
    
    

}
