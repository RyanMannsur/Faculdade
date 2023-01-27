
package estatistica;

import java.util.ArrayList;
import java.util.Collections;


public class Numeros {
    ArrayList<Integer> numeros = new ArrayList<>();

    public Numeros(ArrayList<Integer> numeros) {
        this.numeros = numeros;
    }
    
    public double media(){
        return mediaAri();
    }
    
    public int mediana(){
        return medianaP();
    }
    
    public double variancia(){
        return varianciaP();
    }
    
    public double desvioPadrao(){
        return desvioPadraoP();
    }
    
    public int amplitude(){
        return amplitudeP();
    }
    
    private double mediaAri(){
        int soma = 0;
        for(int i=0;i<numeros.size();i++)
            soma = soma+numeros.get(i);
        return (soma/numeros.size());
    }
    
    private int medianaP(){
        Collections.sort(numeros);
        
        return 0;   
    }
    
    private double varianciaP(){
        return 0.0;
    }
    
    private double desvioPadraoP(){
        return 0.0;
    }
    
    private int amplitudeP(){
        return 0;
    }
    
    private ArrayList<Integer> ordena(){
        return null;
    }
    
}
