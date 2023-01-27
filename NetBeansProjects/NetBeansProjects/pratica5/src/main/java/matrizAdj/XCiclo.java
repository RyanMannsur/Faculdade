
package matrizAdj;

public class XCiclo {
    public static void main(String[] args) {
        XGrafo grafo = new XGrafo(6);
        exemplo1(grafo);
    }
    
    private static void exemplo1(XGrafo grafo){
        grafo.insereAresta(0, 1); grafo.insereAresta(1, 0);
        grafo.insereAresta(1, 2); grafo.insereAresta(2, 1);
        grafo.insereAresta(2, 3); grafo.insereAresta(3, 2);
        grafo.insereAresta(3, 0); grafo.insereAresta(0, 3);
        grafo.insereAresta(0, 4); grafo.insereAresta(4, 0);
        grafo.insereAresta(5, 4); grafo.insereAresta(4, 5);
        grafo.insereAresta(1, 5); grafo.insereAresta(5, 1);
        grafo.insereAresta(6, 5); grafo.insereAresta(5, 6);
        grafo.insereAresta(6, 2); grafo.insereAresta(2, 6);
        grafo.insereAresta(7, 6); grafo.insereAresta(6, 7);
        grafo.insereAresta(7, 3); grafo.insereAresta(3, 7);
        grafo.insereAresta(4, 7); grafo.insereAresta(7, 4);
        grafo.imprime();
    }
}
