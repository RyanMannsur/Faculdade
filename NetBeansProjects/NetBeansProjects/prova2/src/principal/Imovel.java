
package principal;

import java.util.ArrayList;


public class Imovel {
    private ArrayList<Comodo> comodos;
    
    //Composição, o objeto Imovel pode ter varios comodos, mesmo comodos sendo um outro objeto.

    public Imovel(ArrayList<Comodo> comodos) {
        this.comodos = comodos;
    }
    
}
