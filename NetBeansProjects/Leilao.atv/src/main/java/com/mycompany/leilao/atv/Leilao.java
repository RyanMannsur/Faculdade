
package com.mycompany.leilao.atv;


public class Leilao {
    private Lote[] leilao;
    private int qntdLotes = 0;
    
    public Leilao(int lotesTotal){
        this.leilao = new Lote[lotesTotal];
    }

    public Lote[] getLeilao() {
        return leilao;
    }

    public void setLeilao(Lote leilao) {
        this.leilao[qntdLotes] = leilao;
        qntdLotes++;
    }
    
    public boolean adicionaLote(Lote lote){
       setLeilao(lote);
       return true;
    } 
    
    public boolean recebeLance(Lance lance, String descricao){
        for(int i=0;i<leilao.length;i++){
            if(leilao[i].getDescricao().equals(descricao)){
                if(leilao[i].getMaiorLance().getValor()<lance.getValor()){
                    leilao[i].setMaiorLance(lance);
                    return true;
                }
                else
                    return false;
            }    
        }
        return false;
    }
    
    public void imprimiLotes(){
        for(int i=0;i<leilao.length;i++){
            if(leilao[i].getMaiorLance().getValor()>0)
                System.out.println("O lote \""+leilao[i].getDescricao()+"\" ja tem lance de R$ "
                +leilao[i].getMaiorLance().getValor());
            else
                System.out.println("O lote \""+leilao[i].getDescricao()+"\" ainda nao tem lance");
        }
    }
    
    public void encerrarLeilao(){
        for(int i=0;i<leilao.length;i++){
            if(leilao[i].getMaiorLance().getValor()>0)
                System.out.println("O lote \""+leilao[i].getDescricao()+
                "\" foi vendido para o(a) Sr(a) "+leilao[i].getMaiorLance().getComprador().getNome()+
                " por R$ "+leilao[i].getMaiorLance().getValor());
            else
                System.out.println("O lote \""+leilao[i].getDescricao()+"\" nao teve lance");
        }
    }
    
}
