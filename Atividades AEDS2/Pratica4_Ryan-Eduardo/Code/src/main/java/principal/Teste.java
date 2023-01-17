
package principal;
import java.util.ArrayList;
import java.util.Random;

public class Teste {
    public static void main(String[] args) {
         Random rand = new Random();
         ArrayList<Item> it = new ArrayList();
         /*for(int i=100000;i>=0;i--)
             it.add(new Item(i));*/
         for(int i=0;i<100000;i++)
             it.add(new Item(rand.nextInt(50000000)));
         Heap heap = new Heap(it);
         HeapSort sort = new HeapSort(heap);
         System.out.println("\nComparações: "+HeapSort.miss);
    }
}
