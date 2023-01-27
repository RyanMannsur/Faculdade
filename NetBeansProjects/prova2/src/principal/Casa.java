
package principal;

import java.util.ArrayList;

public class Casa extends Imovel{ // Exemplo de herança
    private boolean moradores;

    public Casa(boolean moradores, ArrayList<Comodo> comodos) {
        super(comodos);
        this.moradores = moradores;
    }
    
    /* Herança: Casa é um tipo de Imovel, portanto obtem todas as caracteristicas do Imovel,
       mas também tem sua caracteristica propria, que são os moradores.
       A classe ainda poderia herdar alguns comportamentos de Imovel, e também ter algum
       comportamento proprio.
    */
}
