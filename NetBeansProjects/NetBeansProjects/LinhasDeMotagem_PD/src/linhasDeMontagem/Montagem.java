
package linhasDeMontagem;

import java.util.ArrayList;


public class Montagem {
    private ArrayList<Estacao> linha1;
    private ArrayList<Estacao> linha2;
    private int[] l1;
    private int[] l2;
    private int l;
    private int f;
    private int[] f1;
    private int[] f2;

    public Montagem(int a1[], int a2[], int[] t1, int[] t2, int tam) { //tam é o tamanho da linha de montagem, com valor de entrada e saida
        linha1 = new ArrayList<>();
        linha2 = new ArrayList<>();
        construirLinha1(a1,t1,tam);
        construirLinha2(a2,t2,tam);
        l1 = new int[tam-1]; //de 0 a 6, mas so uso de 2 a 6
        l2 = new int[tam-1]; //de 0 a 6, mas so uso de 2 a 6
        f1 = new int[tam-1]; //de 0 a 6, mas so uso de 1 a 6
        f2 = new int[tam-1]; //de 0 a 6, mas so uso de 1 a 6
        melhorCaminho(tam-2);
    }
    
    private void construirLinha1(int a1[], int t1[], int tam){
        Estacao e;
        for(int i=0; i<tam; i++){
            if(i!=0){ //quando não for o valor de entrada
                if(i<tam-2){  //quando nao for o valor de saida. de 1 a 6
                    e = new Estacao(i,1,a1[i],t1[i-1]); //posicao,linha,valor,valor de transporte
                    linha1.add(e);
                }
                else{ //quando for valor de saida
                    e = new Estacao(i,1,a1[i],0);
                    linha1.add(e);
                }
            }
            else{
                e = new Estacao(i,1,a1[i],0);
                linha1.add(e);
            }
        }
    }
    
    private void construirLinha2(int a2[], int t2[], int tam){
        Estacao e;
        for(int i=0; i<tam; i++){
            if(i!=0){ //quando não for o valor de entrada
                if(i<tam-2){ //quando nao for o valor de saida. de 1 a 6
                    e = new Estacao(i,2,a2[i],t2[i-1]); //posicao,linha,valor,valor de transporte
                    linha2.add(e);
                }
                else{
                    e = new Estacao(i,2,a2[i],0);
                    linha2.add(e);
                }
            }
            else{
                e = new Estacao(i,2,a2[i],0);
                linha2.add(e);
            }
        }
    }
    
    private void melhorCaminho(int tam){
        int x1, e1;
        int x2, e2;
        e1 = linha1.get(0).getValor(); //valor de entrada linha 1
        e2 = linha2.get(0).getValor(); //valor de entrada linha 2
        x1 = linha1.get(tam+1).getValor(); //valor de saida linha 1
        x2 = linha2.get(tam+1).getValor(); //valor de saida linha 2
        //algoritmo mostrado na aula
        f1[1] = e1 + linha1.get(1).getValor();
        f2[1] = e2 + linha2.get(1).getValor();
        for(int j=2;j<=tam; j++){
            if(f1[j-1] + linha1.get(j).getValor() <= f2[j-1] + linha2.get(j-1).getTransporte() + linha1.get(j).getValor()){
                f1[j] = f1[j-1] + linha1.get(j).getValor();
                l1[j] = 1;
            }
            else{
                f1[j] = f2[j-1] + linha2.get(j-1).getTransporte() + linha1.get(j).getValor();
                l1[j] = 2;
            }
            if(f2[j-1] + linha2.get(j).getValor() <= f1[j-1] + linha1.get(j-1).getTransporte() + linha2.get(j).getValor()){
                f2[j] = f2[j-1] + linha2.get(j).getValor();
                l2[j] = 2;
            }
            else{
                f2[j] = f1[j-1] + linha1.get(j-1).getTransporte() + linha2.get(j).getValor();
                l2[j] = 1;
            }
        }
        if(f1[tam] + x1 <= f2[tam] + x2){
            f = f1[tam] + x1;
            l = 1;
        }
        else{
            f = f2[tam] + x2;
            l = 2;
        }
    }
    
    public void imprime(int tam){
        System.out.println("    j  1 2 3 4 5 6");
        System.out.printf("f1[j]: ");
        for(int i = 1; i<tam-1; i++){
            System.out.printf("%d ", f1[i]);
        }
        System.out.println("");
        System.out.printf("f2[j]: ");
        for(int i = 1; i<tam-1; i++){
            System.out.printf("%d ", f2[i]);
        }
        System.out.println("\nO valor do caminho minimo e:\nf* = "+f);
        System.out.println("    j  1 2 3 4 5 6");
        System.out.printf("l1[j]: ");
        for(int i = 2; i<tam-1; i++){
            System.out.printf("%d ", l1[i]);
        }
        System.out.println("");
        System.out.printf("l2[j]: ");
        for(int i = 2; i<tam-1; i++){
            System.out.printf("%d ", l2[i]);
        }
        System.out.println("\nA linha inicial e:\nl* = "+l);
    }
}