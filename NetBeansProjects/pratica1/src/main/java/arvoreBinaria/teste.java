
package arvoreBinaria;

import java.util.Random;


public class teste {
    public static void main(String[] args) {
        ArvoreBinaria a = new ArvoreBinaria();
        Random rand = new Random();
        for(int i=1;i<=1000;i=i++){ // nesse for fiz os teste com arvores de numeros ordenados
            Item reg = new Item(i);
            a.insere(reg);
        }
        /*for(int i=0;i<1000;i++){ // nesse for fiz os teste com arvores de numeros aleatorios
            Item reg = new Item(1+rand.nextInt(20000));
            a.insere(reg);
        }*/
        a.pesquisa(new Item(20001));
        System.out.println("Comparações = "+ArvoreBinaria.comp);
    }
}/* Considerações: Ao pesquisa numeros ordenados, sempre terei n comparações.
    Ja no caso dos aleatorios irá depender da arvore gerada, mas em geral faz menos comparações,
    uma vez que a arvore será mais balanceada.*/
