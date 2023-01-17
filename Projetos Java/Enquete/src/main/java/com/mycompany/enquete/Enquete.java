
package com.mycompany.enquete;


public class Enquete {
    private int[] notas;
    private int qtdMax = 0;
    
    public Enquete(int qtdMax){
        this.notas = new int[qtdMax];
        this.qtdMax = qtdMax;
    }
    
    public int[] getNotas(){
        return notas;
    }
    public void setNotas(int[] notas){
        this.notas = notas;
    }
    
    public void frequenciaDeNotas(){
        System.out.println("As notas dadas foram:");
        int[] contador = new int[11];
        int posicao = 0;
        for(int i=0;i<qtdMax;i++){
            if(notas[i]>0){
                posicao = notas[i];
                contador[posicao]++;
            }
        }
        for(int i=1;i<contador.length;i++){
            if(contador[i]!=0)
                System.out.printf("A nota %d se repetiu %d vezes.\n",i,contador[i]);
        }
    }
    
    public void notaMedia(){
        double notaMedia = 0.0;
        double quantidadeNotas = 0.0;
        for(int i=0;i<notas.length;i++){
            if(notas[i]>0){
                notaMedia = notaMedia+notas[i];
                quantidadeNotas++;
            }
        }    
        notaMedia = notaMedia/quantidadeNotas;
        System.out.println("A media das notas foi de: "+notaMedia);       
    }
    
    public void clientesEntrevistados(){
        int clientesEntrevistados = 0;
        for(int i=0;i<notas.length;i++){
            if(notas[i]>0){
                clientesEntrevistados++;
            }
        }
        System.out.println("O total de clientes entrevistado foi de: "+clientesEntrevistados);
    }
}
