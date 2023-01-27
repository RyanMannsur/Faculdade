
package principal;

import java.util.Random;
import java.lang.*;

public class Teste {
    public static void main(String[] args) {
        long tempo = System.nanoTime();
        ArvoreSBB a = new ArvoreSBB();
        Random rand = new Random();
        for(Integer i=1;i<=20000;i++){
            Item reg = new Item(i);
            a.insere(reg);
        }
        a.pesquisa(new Item(52));
        System.out.println("Comparações = "+ArvoreSBB.comp);
        tempo = System.nanoTime()-tempo;
        System.out.println("Tempo gasto: "+tempo);
    }
}
