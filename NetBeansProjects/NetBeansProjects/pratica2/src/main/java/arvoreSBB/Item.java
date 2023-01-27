
package arvoreSBB;


public class Item {
    private long chave;

    public Item(long chave) {
        this.chave = chave;
    }

    public int compara(Item it) {
        Item item = it;
        if (this.chave < item.chave) {
            return -1;
        } else if (this.chave > item.chave) {
            return 1;
        }
        return 0;
    }

    public long getChave() {
        return chave;
    }
}
