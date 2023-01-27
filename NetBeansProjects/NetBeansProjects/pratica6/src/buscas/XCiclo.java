
package buscas;

import arvoreGeradoraMin.XGrafo;

public class XCiclo {

    public static final byte branco = 0;
    public static byte cinza = 1;
    public static byte preto = 2;
    private int d[]/*tempo de descoberta*/, t[]/*tempo de término do exame da lista de adjacentes de v*/, 
                antecessor[];
    private XGrafo grafo;
    private boolean orientado;

    public XCiclo(XGrafo grafo, boolean orientado) {
        this.grafo = grafo;
        int n = this.grafo.numVertices();
        d = new int[n];
        t = new int[n];
        antecessor = new int[n];
        this.orientado = orientado;
    }

    private boolean visitaDfs(int u, int cor[]) {
        cor[u] = cinza; //grafo visitado fica cinza
        boolean ciclo = true;
        if (!this.grafo.listaAdjVazia(u)) { //se ele não for isolado
            XGrafo.Aresta a = this.grafo.primeiroListaAdj(u); //pega a primeira aresta que u participa
            while (a != null) {
                int v = a.v2(); //pego a outra ponta da aresta a
                if (cor[v] == branco) { // se o vertice encontrado não foi visitado
                    this.antecessor[v] = u; //coloco o vertice atual como atecessor de v.
                    ciclo = this.visitaDfs(v, cor); // e vejo se v tem vertices ainda não visitados
                    if(ciclo)
                        return true;
                }else{
                    if(orientado){
                        if(cor[v] == cinza){ // se for encontrado um vertice cinza
                            return true;
                        }
                    }else{
                        if(cor[v] == cinza && !(this.antecessor[u] == v)){
                            return true;
                        }
                    }
                }
                a = this.grafo.proxAdj(u); // prox aresta que o vertice u participa
                //refaz o while até não houver arestas.
            }
        }
        cor[u] = preto; // o vertice recebe preto
        return false;
    }

    public boolean buscaEmProfundidade() {
        boolean ciclo = false;
        int cor[] = new int[this.grafo.numVertices()];
        for (int u = 0; u < grafo.numVertices(); u++) {
            cor[u] = branco;
            this.antecessor[u] = -1;
        }
        for (int u = 0; u < grafo.numVertices(); u++) {
            if (cor[u] == branco) {
                ciclo = this.visitaDfs(u, cor);
            }
        }
        return ciclo;
    }

    public int d(int v) {
        return this.d[v];
    }

    public int t(int v) {
        return this.t[v];
    }

    public int antecessor(int v) {
        return this.antecessor[v];
    }
}
