
package Principal;


public class Fatura {
    private Item itens[];

    public Fatura(int tamanho) {
        this.itens = new Item[tamanho];
    }

    public Item[] getItens() {
        return itens;
    }

    public void setItens(Item[] itens) {
        this.itens = itens;
    }
    
    public void adicionarItem(Item item){
        if(itens[0] == null)
            itens[0] = item;
        else
            for(int i=1; itens[i-1]!= null; i++){
                if(itens[i]==null){
                    itens[i] = item;
                    break;
                }
            }
    }
    
    public int tamanho(){
        int i;
        for(i=0; i<itens.length && itens[i]!=null;i++){
        }
        return i;
    }
    
    public double valorFatura(){
        double total = 0;
        for(int i=0;i<itens.length && itens[i]!=null ;i++){
            total = itens[i].getProduto().getValor()*itens[i].getQuantidade() + total;
        }
        return total;
    }
    
}
