
package arvoreGeradoraMin;


public class ArvoreMin {
    public static void main(String[] args) {
        XGrafo grafo1 = new XGrafo(9);
        XGrafo grafo2 = new XGrafo(8);
        exemplo1(grafo1);
        System.out.println("");
        exemplo2(grafo2);
        
    }
    private static void exemplo2(XGrafo grafo){
        grafo.insereAresta(1, 0, 8);
        grafo.insereAresta(1, 2, 3);
        grafo.insereAresta(1, 3, 2);
        grafo.insereAresta(1, 4, 7);
        grafo.insereAresta(1, 5, 5);
        grafo.insereAresta(1, 7, 6);
        grafo.insereAresta(0, 2, 2);
        grafo.insereAresta(2, 3, 9);
        grafo.insereAresta(3, 4, 6);
        grafo.insereAresta(4, 5, 5);
        grafo.insereAresta(5, 7, 4);
        grafo.insereAresta(0, 6, 9);
        grafo.insereAresta(2, 6, 6);
        grafo.insereAresta(3, 6, 2);
        grafo.insereAresta(4, 6, 4);
        grafo.insereAresta(5, 6, 6);
        grafo.insereAresta(7, 6, 3);
        XAGM a = new XAGM(grafo);
        XGrafo g;
        g = a.arvore();
        g.imprime();
        int mat[][] = g.getMat();
        int sum = 0;
        for(int i=0; i<g.numVertices(); i++){
            for(int j=0;j<g.numVertices();j++){
                sum = sum + mat[i][j];
            }
        }
        System.out.println("O peso da AGM foi de: "+sum);
    }
    
    
    private static void exemplo1(XGrafo grafo){
        grafo.insereAresta(0, 1, 5); //a-->b
        grafo.insereAresta(0, 3, 10);//a-->d
        grafo.insereAresta(0, 4, 5);//a-->e
        grafo.insereAresta(0, 6, 10);//a-->g
        grafo.insereAresta(0, 7, 10);//a-->h
        grafo.insereAresta(1, 7, 5);//b-->h
        grafo.insereAresta(1, 8, 10);//b-->k
        grafo.insereAresta(1, 5, 5);//b-->f
        grafo.insereAresta(2, 4, 10);//c-->e
        grafo.insereAresta(2, 3, 5);//c-->d
        grafo.insereAresta(2, 6, 5);//c-->g
        grafo.insereAresta(3, 6, 10);//d-->g
        grafo.insereAresta(3, 4, 5);//d-->e
        grafo.insereAresta(4, 8, 10);//e-->k
        grafo.insereAresta(5, 6, 15);//f-->g
        grafo.insereAresta(7, 8, 20);//h-->k
        grafo.insereAresta(4, 8, 10);//e-->k
        XAGM a = new XAGM(grafo);
        XGrafo g;
        g = a.arvore();
        g.imprime();
        int mat[][] = g.getMat();
        int sum = 0;
        for(int i=0; i<g.numVertices(); i++){
            for(int j=0;j<g.numVertices();j++){
                sum = sum + mat[i][j];
            }
        }
        System.out.println("O peso da AGM foi de: "+sum);
    }
}
