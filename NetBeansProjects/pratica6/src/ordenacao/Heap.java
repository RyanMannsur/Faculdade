
package ordenacao;

import arvoreGeradoraMin.XGrafo.Aresta;
import java.util.ArrayList;

public class Heap {
    private ArrayList<Aresta> vetor;
    public Heap(ArrayList<Aresta> vetor) {
        this.vetor = vetor;
        
        criaHeap();
    }
    
    private void criaHeap(){
        for(int posicao = (vetor.size()-1)/2;posicao>=0;posicao--){
            ordenarArvore(vetor.size(),posicao);
        }
    }
    public void ordenarArvore(int tam, int posicao){
        int raiz = posicao;
        int filhoUm = 2 * posicao + 1;
        int filhoDois = 2*posicao + 2;
        if (filhoUm < tam && vetor.get(filhoUm).peso() > vetor.get(raiz).peso()) {
            raiz = filhoUm;
        }
        if (filhoDois < tam && vetor.get(filhoDois).peso() > vetor.get(raiz).peso()) {
            raiz = filhoDois;
        }
        if(raiz != posicao){
            Aresta aux = vetor.get(posicao);
            vetor.set(posicao, vetor.get(raiz));
            vetor.set(raiz, aux);
            ordenarArvore(tam,raiz);
        }
    }

    public ArrayList<Aresta> getVetor() {
        return vetor;
    }
}
