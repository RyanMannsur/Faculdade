
package principalRyan;

import java.util.ArrayList;
import java.util.Iterator;


public class TrataFormas {
    private ArrayList<Forma> formas;

    public TrataFormas() {
        this.formas = new ArrayList<>();
    }

    public ArrayList<Forma> getFormas() {
        return formas;
    }

    public void setFormas(ArrayList<Forma> formas) {
        this.formas = formas;
    }
    
    public void addFormas(Forma forma){
        formas.add(forma);
    }
  
    public void printAreaDasFormas(){
        Iterator it = formas.iterator();
        Forma aux;
        while(it.hasNext()){
            aux = (Forma) it.next();
            System.out.printf("%.2f\n" , aux.calcularArea());
        }
    }
    
    public double area(Forma forma){
        return forma.calcularArea();
    }
        
    
    public void printVolumeDasFormas(){
        Iterator it = formas.iterator();
        Forma aux;
        while(it.hasNext()){
            aux = (Forma) it.next();
            try {
                System.out.printf("%.2f\n" , aux.calcularVolume());
            } catch (NaoExisteVolumeException ex) {
                System.err.printf("%s\n",ex.getMessage()); //Imprime que nao pode calcular
            }
        }
    }
    public double volume(Forma forma) throws NaoExisteVolumeException{
        return forma.calcularVolume();
    }
}
