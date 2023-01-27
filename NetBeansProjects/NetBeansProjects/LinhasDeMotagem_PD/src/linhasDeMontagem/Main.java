
package linhasDeMontagem;


public class Main {
    public static void main(String[] args) {
        int tam = 8;
        int[] a1 = {2, 7, 9, 3, 4, 8, 4, 3};
        int[] a2 = {4, 8, 5, 6, 4, 5, 7, 2};
        int[] t1 = {2, 3, 1, 3, 4};
        int[] t2 = {2, 1, 2, 2, 1};
        
        Montagem m = new Montagem(a1,a2,t1,t2,tam);
        m.imprime(tam);
    }
}
