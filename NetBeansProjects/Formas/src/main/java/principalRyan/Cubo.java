
package principalRyan;


public class Cubo extends FormaTridimensonal{
    private double aresta;

    public Cubo(double aresta) {
        this.aresta = aresta;
    }

    public double getAresta() {
        return aresta;
    }

    public void setAresta(double aresta) {
        this.aresta = aresta;
    }
   
    @Override
    public double calcularArea() {
        area = 6*Math.pow(aresta, 2);
        return area;
    }
 
    @Override
    public double calcularVolume() throws NaoExisteVolumeException {
        volume = Math.pow(aresta, 3);
        return volume;
    }
}
