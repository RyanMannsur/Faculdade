package linhasDeMontagem;

class XAEDsMaps {
 
    private int menor_peso;
    private int[] distanciasMenores;
    private int[] antecessores; 

    public XAEDsMaps(int[][] mat, int inicio, int fim) {
        int numVertices = mat[0].length;
        int[] distanciasMenores = new int[numVertices]; //vetor para registrar os menores pesos
        boolean[] adicionados = new boolean[numVertices]; //vetor para marcar os vertices já marcados
        for (int vertIndice = 0; vertIndice < numVertices; vertIndice++){
            distanciasMenores[vertIndice] = Integer.MAX_VALUE;
            adicionados[vertIndice] = false;
        }
        distanciasMenores[inicio] = 0;
        int[] antecessores = new int[numVertices];
        antecessores[inicio] = -1;
        for (int i = 1; i < numVertices; i++){
            int vertice_proximo = -1;
            int menor_peso = Integer.MAX_VALUE; //inicializa o menor peso como infinito
            for (int vertIndice = 0; vertIndice < numVertices; vertIndice++) {
                //checa se vertice já foi adicionado, se nao, entao compara com o menor peso registrado
                if (!adicionados[vertIndice] && distanciasMenores[vertIndice] < menor_peso) {
                    vertice_proximo = vertIndice;
                    menor_peso = distanciasMenores[vertIndice];
                }
            }
            if(vertice_proximo != -1){
                adicionados[vertice_proximo] = true;

                for (int vertIndice = 0; vertIndice < numVertices; vertIndice++) {
                    int peso = mat[vertice_proximo][vertIndice];
                    
                    if (peso > 0 && ((menor_peso + peso) < distanciasMenores[vertIndice])) {
                        //atualiza os vetores de antecessor e distancia com os novos valores corretos
                        antecessores[vertIndice] = vertice_proximo;
                        distanciasMenores[vertIndice] = menor_peso + peso;
                    }
                }
            }
        }
 
        this.menor_peso = distanciasMenores[fim];
        this.distanciasMenores = distanciasMenores;
        this.antecessores = antecessores;
        // imprimeMenorCaminho(inicio, distanciasMenores, antecessores, fim);
    }
 
    public void imprimeMenorCaminho(int inicio, int fim) {
        int numVertices = this.distanciasMenores.length;
        
        System.out.print("Caminho: ");
        imprimeCaminho(fim, this.antecessores);
    }
 
    private static void imprimeCaminho(int currentVertex, int[] antecessores){    
        if (currentVertex != -1){
            imprimeCaminho(antecessores[currentVertex], antecessores);
            System.out.print(" -> ");
            System.out.print(currentVertex);
        }
    }

    public int getMenorPeso(){
        return this.menor_peso;
    } 
}