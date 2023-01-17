
package principalRyan;


public class Tetraedo extends FormaTridimensonal{
    private double aresta;

    public Tetraedo(double aresta) {
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
        area = Math.pow(aresta, 2) * Math.sqrt(3);
        return area;
    }
    @Override
    public double calcularVolume() throws NaoExisteVolumeException {
        volume = (Math.pow(aresta, 3)*Math.sqrt(2))/12;
        return volume;
    }
}
