
package principal;

import java.util.ArrayList;

public class Heap {
    private ArrayList<Item> vetor;
    public Heap(ArrayList<Item>vetor) {
        this.vetor = vetor;
        
        criaHeap();
    }
    
    private void criaHeap(){
        for(int posicao = (vetor.size()-1)/2;posicao>=0;posicao--){
            ordenarArvore(vetor.size(),posicao);
        }
    }
    public void ordenarArvore(int tam, int posicao){
        HeapSort.miss++;
        int raiz = posicao;
        int filhoUm = 2 * posicao + 1;
        int filhoDois = 2*posicao + 2;
        if (filhoUm < tam && vetor.get(filhoUm).compara(vetor.get(raiz)) > 0) {
            raiz = filhoUm;
        }
        if (filhoDois < tam && vetor.get(filhoDois).compara(vetor.get(raiz)) > 0) {
            raiz = filhoDois;
        }
        if(raiz != posicao){
            Item aux = vetor.get(posicao);
            vetor.set(posicao, vetor.get(raiz));
            vetor.set(raiz, aux);
            ordenarArvore(tam,raiz);
        }
    }

    public ArrayList<Item> getVetor() {
        return vetor;
    }
}
