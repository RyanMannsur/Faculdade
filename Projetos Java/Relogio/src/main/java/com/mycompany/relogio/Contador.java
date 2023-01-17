
package com.mycompany.relogio;


public class Contador {
    private int valor;
    private int limite;
    
    public Contador(int limite, int valorInicial){
        this.limite = limite;
        this.valor = valorInicial;
    }
    
    public void setValor(int valor){
        this.valor = valor;
    }
    
    public int getValor(){
        return valor;
    }
    
    public void setLimite(int limite){
        this.limite = limite;
    }
    
    public int getLimite(){
        return limite;
    }
    
    public void contar(){
        valor++;
        if(valor == limite){
            valor = 0;
        }
    }
}
