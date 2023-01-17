
package arvoreSBB;

import java.util.Random;
import java.lang.*;

public class Teste {
    public static void main(String[] args) {
        long tempo = System.nanoTime();
        ArvoreSBB a = new ArvoreSBB();
        Random rand = new Random();
        for(Integer i=1;i<=20000;i++){ // nesse for fiz os teste com arvores de numeros ordenados
            Item reg = new Item(i);
            a.insere(reg);
        }
        /*for(int i=0;i<9000;i++){ // nesse for fiz os teste com arvores de numeros aleatorios
            Item reg = new Item(rand.nextInt(200000000));
            a.insere(reg);
        }*/
        a.pesquisa(new Item(2000000001));
        System.out.println("Comparações = "+ArvoreSBB.comp);
        tempo = System.nanoTime()-tempo;
        System.out.printf("Tempo gasto: "+tempo);
    }
    /* Considerações: Para numeros ordenados ele sempre faz n/2 comparações
    Ja para aleatorios depende dos numeros gerados, mas em geral é sempre o numero parecido de comparação
    não importa o valor de n.
    */
}
