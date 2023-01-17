
package com.mycompany.leilao.atv;


public class Lote {
    private String descricao;
    private Lance maiorLance;
    
    public Lote(String descricao){
        this.descricao = descricao;
        this.maiorLance = new Lance();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Lance getMaiorLance() {
        return maiorLance;
    }

    public void setMaiorLance(Lance maiorLance) {
        this.maiorLance = maiorLance;
    }
    
    public void verificarLance(Lance lance){
        if(lance.getValor()>maiorLance.getValor()){
            maiorLance.setValor(lance.getValor());
            maiorLance.setComprador(lance.getComprador());
        }
    }
}
