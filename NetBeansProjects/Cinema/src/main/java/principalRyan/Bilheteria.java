
package principalRyan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class Bilheteria {
    private ArrayList<Filme> filmes;
    private HashMap<String,Bilhete> ingresso;

    public Bilheteria() {
        this.filmes = new ArrayList<>();
        this.ingresso = new HashMap<>();
    }

    public ArrayList<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(ArrayList<Filme> filmes) {
        this.filmes = filmes;
    }

    public HashMap<String, Bilhete> getIngresso() {
        return ingresso;
    }

    public void setIgresso(HashMap<String, Bilhete> ingresso) {
        this.ingresso = ingresso;
    }
    
    public void addFilme(Filme filme){
        filmes.add(filme);
    }
    
    public boolean verificarAssento(String cadeira, Filme filme){ //Verifica se assento esta disponivel.
        Iterator it = ingresso.keySet().iterator();
        switch (filme.getSala().getNumero()){
                case 1: cadeira = "1"+cadeira; break;
                case 2: cadeira = "2"+cadeira; break;
                case 3: cadeira = "3"+cadeira; break;
        }
        while(it.hasNext()){
            String chave = (String)it.next();
            if(chave.equals(cadeira)){
                return false; // false se ja ocupado
            }
        }
        return true;
    }
    
    public double devolverValorFinal(){
        double soma = 0.0;
        Iterator it = ingresso.keySet().iterator();
        while(it.hasNext()){
            String chave = (String)it.next();
            soma = soma + ingresso.get(chave).getValor();
        }
        return soma;
    }
    
    public void venderBilhete(String cadeira, Bilhete bilhete){
        switch (bilhete.getFilme().getSala().getNumero()){
                case 1: cadeira = "1"+cadeira; break;
                case 2: cadeira = "2"+cadeira; break;
                case 3: cadeira = "3"+cadeira; break;
            }
        ingresso.put(cadeira, bilhete);
        bilhete.getFilme().getSala().aumentarQuantidade();
    }
    
}
