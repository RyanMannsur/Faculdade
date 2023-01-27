
package ordenacao;

import arvoreGeradoraMin.XGrafo.Aresta;


public class HeapSort {
    private Heap heap;
    
    public static int miss = 0;

    public HeapSort(Heap heap) {
        this.heap = heap;
        ordenar();
    }
    private void ordenar(){
        int n = heap.getVetor().size();
        for(int i = heap.getVetor().size()-1;i>0;i--){
            Aresta aux = heap.getVetor().get(0);
            heap.getVetor().set(0, heap.getVetor().get(i));
            heap.getVetor().set(i, aux);
            heap.ordenarArvore(i,0);
        }
    }

    public Heap getHeap() {
        return heap;
    }  
}
