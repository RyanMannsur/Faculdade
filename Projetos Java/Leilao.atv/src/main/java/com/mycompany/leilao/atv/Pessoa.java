
package com.mycompany.leilao.atv;


public class Pessoa {
    private String nome;
    private String contato;
    
    public Pessoa(String nome){
        this.nome = nome;
    }
    
    public Pessoa(){
        
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
    
}
