
package arvoreBinaria;

import java.util.Random;
import java.lang.*;

public class teste {
    public static void main(String[] args) {
        ArvoreBinaria a = new ArvoreBinaria();
        Random rand = new Random();
        long tempo = System.nanoTime();
        /*for(int i=1;i<=9000;i++){ // nesse for fiz os teste com arvores de numeros ordenados
            Item reg = new Item(i);
            a.insere(reg);
        }*/
        for(int i=0;i<9000;i++){ // nesse for fiz os teste com arvores de numeros aleatorios
            Item reg = new Item(rand.nextInt(20000000));
            a.insere(reg);
        } 
        a.pesquisa(new Item(20000001));
        tempo = System.nanoTime() - tempo;
        System.out.println("Comparações = "+ArvoreBinaria.comp);
        System.out.println("Tempo = "+tempo);
    }
}/* Considerações: Ao pesquisa numeros ordenados, sempre terei n comparações sempre.
    Ja no caso dos aleatorios irá depender da arvore gerada, mas em geral 
    faz log(n) comparações(log na base 2), uma vez que a arvore será mais balanceada.*/
