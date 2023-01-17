
package principal;

import java.io.*;
import java.util.Random;

public class CriaArvoreB {
  public static void main (String[] args) throws Exception {
    ArvoreB dicionario = new ArvoreB (6);
    Random rand = new Random();
    /*BufferedReader in = new BufferedReader (
                        new InputStreamReader (System.in));*/
    System.out.println ("Criacao da arvore"); 
    for(int i=0;i<100000;i++){
      MeuItem item = new MeuItem (i);
      dicionario.insere (item);
      //dicionario.imprime ();
    }

    System.out.println ("\nPesquisando chaves");
      MeuItem item = new MeuItem (100001);
      item = (MeuItem)dicionario.pesquisa (item);
      if (item == null) System.out.println ("Item nao encontrado");
      else System.out.println ("Item encontrado");
      System.out.println(ArvoreB.miss);
      //chave = rand.nextInt(5000);

    /*System.out.println ("\nRemovendo algumas chaves");
    chave = Integer.parseInt (in.readLine());
    while (chave > 0) {
      MeuItem item = new MeuItem (chave);
      dicionario.retira (item);
      dicionario.imprime ();
      chave = Integer.parseInt (in.readLine());
    }*/
  }
}
