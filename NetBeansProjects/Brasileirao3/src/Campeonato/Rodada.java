package Campeonato;

import java.util.ArrayList;
import time.Time;


public class Rodada {
    
    private Partida partidas[];

    public Partida[] getPartidas() {
        return partidas;
    }

    public void setPartidas(Partida[] partidas) {
        this.partidas = partidas;
    }
    
    public void nPartidas(int x){
        partidas = new Partida[x];
        for (int i = 0; i < partidas.length; i++) {
            partidas[i] = new Partida();
        }
    }
    
    public void resultados(){
        for (int i = 0; i < partidas.length; i++) {
            partidas[i].gerarEstatisticas();
        }
    }
    
    private void classificacaoDoTimeNaRodada(){
        ArrayList<Time> times = new ArrayList<>();
        
        
    }
    
    

}
