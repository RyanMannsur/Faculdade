//Ryan Eduardo
package com.mycompany.enquete;

import java.util.Scanner;
import java.util.Random;

public class Teste {
    public static void main(String[] args){
        int qtdMax;
        Random gerador = new Random();
        Scanner input = new Scanner(System.in);
        System.out.println("Digite a quantidade de notas:");
        qtdMax = input.nextInt();
        Enquete pesquisa = new Enquete(qtdMax);
        int[] n = new int[qtdMax];
        for(int i=0;i<qtdMax;i++){
            n[i] = 1+gerador.nextInt(10);
            pesquisa.setNotas(n);
        }
        pesquisa.frequenciaDeNotas();
        pesquisa.notaMedia();
        pesquisa.clientesEntrevistados();
    }
}
