
package arvoreGeradoraMin;

import arvoreGeradoraMin.XGrafo.Aresta;
import buscas.XCiclo;
import java.util.ArrayList;
import ordenacao.Heap;
import ordenacao.HeapSort;


public class XAGM {
    private XGrafo grafo1;
    private XGrafo grafo2;
    private ArrayList<Aresta> aresta;

    public XAGM(XGrafo grafo) {
        this.grafo1 = grafo;
        aresta = new ArrayList<>();
        criaArvore(); //cria a arvore sem arestas
    }
    
    public XGrafo arvore(){
        for(int i=0; i<this.aresta.size();i++){
            int v1 = aresta.get(i).v1();
            int v2 = aresta.get(i).v2();
            int peso = aresta.get(i).peso();
            if(grafo1.existeAresta(v1, v2)){ // se existe a ligação no grafo original
                if(!grafo2.existeAresta(v1, v2)){ // mas não existe no grafo 1
                    grafo2.insereAresta(v1, v2, peso); //insiro aresta
                    XCiclo b = new XCiclo(grafo2,false);
                    if(b.buscaEmProfundidade()){ //se a aresta forma um ciclo
                        if(b.buscaEmProfundidade())
                            grafo2.retiraAresta(v1, v2); //retiro a aresta
                    }
                }
            }
        }
        return grafo2;
    }
    
    private void criaArvore(){
        int vertices = grafo1.numVertices(); 
        for(int i=0;i<vertices;i++){ //vou pegando todas as arestas
            XGrafo.Aresta a = this.grafo1.primeiroListaAdj(i);
            while (a != null) {
                 this.aresta.add(a);
                 a = this.grafo1.proxAdj(i);
            }
        }
        Heap h = new Heap(this.aresta); //ordeno de acordo com as arestas
        HeapSort h2 = new HeapSort(h);
        this.aresta = h2.getHeap().getVetor();
        grafo2 = new XGrafo(vertices);
    }
}
