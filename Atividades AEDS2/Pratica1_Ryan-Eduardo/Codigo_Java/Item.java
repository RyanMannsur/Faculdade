
package arvoreBinaria;

public class Item {

    private int chave;

    public Item(int chave) {
        this.chave = chave;
    }

    public Item(){
    }
    
    public int compara(Item it) {
        Item item = it;
        if (this.chave < it.chave)
            return -1;
        else 
            if (this.chave > it.chave) 
                return 1;
        return 0;
    }

    public int getChave() {
        return chave;
    }
}
