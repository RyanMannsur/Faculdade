package linhasDeMontagem;

public class Main {


    static XAEDsMaps montaLinhaGrafo(int inicio, int fim, int[] a1, int[] a2, int[] t1, int[] t2, int tam){
        XGrafo grafo = new XGrafo(tam); //grafo inicio

        /*
            0-1 == e1
                1-2 == S1,1; 2-3 == S1,2 ...
                2-12 == t1,1; 3-13 == t1,2 ...
            7-8 == x1

            9-10 == e2
                9-10 == S2,1; 10-11 == S2,2;
                11-3 == t2,1; 12-4 == t2,2 ...
            16-17 == x2
            
        */
        for(int i=0; i < a1.length; i++)
            grafo.insereAresta(i, i+1, a1[i]);
        
        for(int i=0; i < t1.length; i++)
            grafo.insereAresta(i+2, i+a1.length+4, t1[i]+a2[i+2]);

        for(int i=0; i < a2.length; i++)
            grafo.insereAresta(i+a2.length+1, i+a2.length+2, a2[i]);

        for(int i=0; i < t2.length; i++)
            grafo.insereAresta(i+a1.length+3, i+3, t2[i]+a1[i+2]);
        // grafo.imprime();
        XAEDsMaps dijkstra = new XAEDsMaps(grafo.getMat(), inicio, fim);
        return dijkstra;
    }

    public static void main(String[] args) {
        int tam = 8;
        int[] a1 = {2, 7, 9, 3, 4, 8, 4, 3};
        int[] a2 = {4, 8, 5, 6, 4, 5, 7, 2};
        int[] t1 = {2, 3, 1, 3, 4};
        int[] t2 = {2, 1, 2, 2, 1};
        
        Montagem m = new Montagem(a1,a2,t1,t2,tam);
        System.out.println("\n\nPrimeiro caso - PD>>>\n");
        m.imprime(tam);
        
        XAEDsMaps e1_x1 = montaLinhaGrafo(0,8,a1,a2,t1,t2,18);
        XAEDsMaps e1_x2 = montaLinhaGrafo(0,17,a1,a2,t1,t2,18);
        XAEDsMaps e2_x1 = montaLinhaGrafo(9,8,a1,a2,t1,t2,18);
        XAEDsMaps e2_x2 = montaLinhaGrafo(9,17,a1,a2,t1,t2,18);

        System.out.println("\n\nDijkstra>>>\nMenor peso e1 -> x1: " + e1_x1.getMenorPeso());
        e1_x1.imprimeMenorCaminho(0,8);
        System.out.println("");

        System.out.println("Menor peso e1 -> x2: " + e1_x2.getMenorPeso());
        e1_x2.imprimeMenorCaminho(0,17);
        System.out.println("");

        System.out.println("Menor peso e2 -> x1: " + e2_x1.getMenorPeso());
        e2_x1.imprimeMenorCaminho(9,8);
        System.out.println("");

        System.out.println("Menor peso e2 -> x2: " + e2_x2.getMenorPeso());
        e2_x2.imprimeMenorCaminho(9,17);
        System.out.println("");


        tam = 11;
        int[] a1_1 = {3, 5, 7, 10, 5, 9, 11, 9, 5, 2, 6};
        int[] a2_1 = {2, 6, 3, 9, 11, 4, 9, 3, 12, 4, 5};
        int[] t1_1 = {3, 5, 4, 2, 7, 5, 8, 1};
        int[] t2_1 = {5, 3, 7, 5, 6, 2, 5, 2};
        
        Montagem m1 = new Montagem(a1_1,a2_1,t1_1,t2_1,tam);
        
        System.out.println("\n\nSegundo caso - PD>>>\n");
        m1.imprime(tam);
        
        e1_x1 = montaLinhaGrafo(0,11,a1_1,a2_1,t1_1,t2_1,24);
        e1_x2 = montaLinhaGrafo(0,23,a1_1,a2_1,t1_1,t2_1,24);
        e2_x1 = montaLinhaGrafo(12,11,a1_1,a2_1,t1_1,t2_1,24);
        e2_x2 = montaLinhaGrafo(12,23,a1_1,a2_1,t1_1,t2_1,24);
        
        System.out.println("\n\nDijkstra>>>\nMenor peso e1 -> x1: " + e1_x1.getMenorPeso());
        e1_x1.imprimeMenorCaminho(0,11);
        System.out.println("");

        System.out.println("Menor peso e1 -> x2: " + e1_x2.getMenorPeso());
        e1_x2.imprimeMenorCaminho(0,23);
        System.out.println("");

        System.out.println("Menor peso e2 -> x1: " + e2_x1.getMenorPeso());
        e2_x1.imprimeMenorCaminho(12,11);
        System.out.println("");

        System.out.println("Menor peso e2 -> x2: " + e2_x2.getMenorPeso());
        e2_x2.imprimeMenorCaminho(12,23);
        System.out.println("");


        tam = 10;
        int[] a1_2 = {5, 10, 6, 3, 8, 5, 3, 7, 12, 8};
        int[] a2_2 = {7, 3, 5, 3, 7, 6, 4, 9, 10, 9};
        int[] t1_2 = {4, 2, 7, 2, 5, 8, 2};
        int[] t2_2 = {6, 1, 7, 3, 6, 4, 5};
        
        Montagem m2 = new Montagem(a1_2,a2_2,t1_2,t2_2,tam);
        System.out.println("\n\nTerceiro caso - PD>>>\n");
        m2.imprime(tam);
        
        e1_x1 = montaLinhaGrafo(0,10,a1_2,a2_2,t1_2,t2_2,22);
        e1_x2 = montaLinhaGrafo(0,21,a1_2,a2_2,t1_2,t2_2,22);
        e2_x1 = montaLinhaGrafo(11,10,a1_2,a2_2,t1_2,t2_2,22);
        e2_x2 = montaLinhaGrafo(11,21,a1_2,a2_2,t1_2,t2_2,22);
        
        System.out.println("\n\nDijkstra>>>\nMenor peso e1 -> x1: " + e1_x1.getMenorPeso());
        e1_x1.imprimeMenorCaminho(0,10);
        System.out.println("");

        System.out.println("Menor peso e1 -> x2: " + e1_x2.getMenorPeso());
        e1_x2.imprimeMenorCaminho(0,21);
        System.out.println("");

        System.out.println("Menor peso e2 -> x1: " + e2_x1.getMenorPeso());
        e2_x1.imprimeMenorCaminho(11,10);
        System.out.println("");

        System.out.println("Menor peso e2 -> x2: " + e2_x2.getMenorPeso());
        e2_x2.imprimeMenorCaminho(11,21);
        System.out.println("");

    }
}
