
package principalRyanAnelioTomaz;

import java.util.Random;


public class Vegetal extends Ingrediente{

    public Vegetal(String quantidade, String nome) {
        super(quantidade, nome);
    }
    @Override
    public String getOpcaoSaudavel() {
        Random r = new Random();
        int aux = r.nextInt(substituto.size());
        String ingrediente = substituto.get(aux).quantidade+" de "+substituto.get(aux).nome;
        return ingrediente;
    }
}
