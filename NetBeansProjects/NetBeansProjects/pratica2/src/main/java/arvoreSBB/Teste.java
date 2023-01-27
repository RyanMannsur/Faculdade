
package arvoreSBB;

import java.util.Random;


public class Teste {
    public static void main(String[] args) {
        ArvoreSBB a = new ArvoreSBB();
        //ArvoreSBB a2 = new ArvoreSBB();
        //ArvoreSBB a3 = new ArvoreSBB();
       // Random rand = new Random();
        for(int i=0;i<2000;i++){ // nesse for fiz os teste com arvores de numeros ordenados
            Item reg = new Item(i);
            a.insere(reg);
        }
        /*for (int i = 0; i < 9; i++) { // nesse for fiz os teste com arvores de numeros aleatorios
            Item reg = new Item(1000 + rand.nextInt(9000));
            a2.insere(reg);
        }
        for (int i = 0; i < 9; i++) { // nesse for fiz os teste com arvores de numeros aleatorios
            Item reg = new Item(1000 + rand.nextInt(9000));
            a3.insere(reg);
        }*/
        Item reg = new Item(100001); //item 9001 não esta na arvore
        a.pesquisa(reg);
        System.out.println(ArvoreSBB.comp);
        //System.out.println(""); //pulo linha pra contar aa comparações
        //a2.pesquisa(reg);
        //System.out.println("");
        //a3.pesquisa(reg);
        //System.out.println("");
    }
    /* Considerações: Para numeros ordenados ele sempre faz n/2 comparações
    Ja para aleatorios depende dos numeros gerados, mas em geral é algo bem proximo de n/2 comparações.
    */
}
