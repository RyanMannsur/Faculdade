package jogadores;

import java.util.ArrayList;


public class JogadorDeLinha extends JogadorBase{
    
    private ArrayList<String> posicoes;

    public JogadorDeLinha(String nome, int idade, double peso, double tamanho, int camisa) {
        super(nome, idade, peso, tamanho, camisa);
        posicoes = new ArrayList<>();
    }

    public ArrayList<String> getPosicoes() {
        return posicoes;
    }

    public void setPosicoes(ArrayList<String> posicoes) {
        this.posicoes = posicoes;
    }
    
    

}
