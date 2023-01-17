
package com.mycompany.leilao.atv;


public class Lance {
    private Pessoa comprador;
    private double valor;
    
    public Lance(String nome, double valor){
        this.comprador = new Pessoa(nome);
        this.valor = valor;
    }
    
    public Lance(){
        comprador = new Pessoa();
    }

    public Pessoa getComprador() {
        return comprador;
    }

    public void setComprador(Pessoa comprador) {
        this.comprador = comprador;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
