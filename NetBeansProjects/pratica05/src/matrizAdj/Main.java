
package matrizAdj;

public class Main {
    public static void main(String[] args) {
        XGrafo grafo = new XGrafo(8);
        System.out.println("Grafo 1:");
        XGrafo grafo2 = new XGrafo(10);
        exemplo1(grafo);
        System.out.println("Grafo 2:");
        exemplo2(grafo2);
    }
    private static void exemplo2(XGrafo grafo){
        grafo.insereAresta(9, 6);
        grafo.insereAresta(0, 2);
        grafo.insereAresta(0, 1);
        grafo.insereAresta(0, 3);
        grafo.insereAresta(0, 5);
        grafo.insereAresta(5, 4);
        grafo.insereAresta(5, 6);
        grafo.insereAresta(1, 2);
        grafo.insereAresta(2, 4);
        grafo.insereAresta(2, 3);
        grafo.insereAresta(4, 6);
        grafo.insereAresta(6, 8);
        grafo.insereAresta(6, 7);
        grafo.insereAresta(7, 8);
        XCiclo b = new XCiclo(grafo,true);
        b.buscaEmProfundidade();
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
        XCiclo b = new XCiclo(grafo,false);
        b.buscaEmProfundidade();
        //grafo.imprime();
    }
}

