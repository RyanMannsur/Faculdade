
package principalRyan;


public class Esfera extends FormaTridimensonal{
    private double raio;

    public Esfera(double raio) {
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }
    
    @Override
    public double calcularArea() {
        area = 4*Math.PI*Math.pow(raio, 2);
        return area;
    }
    
    @Override
    public double calcularVolume() throws NaoExisteVolumeException {
        volume = ( 4*Math.PI*Math.pow(raio, 3) ) / 3;
        return volume;
    }
}
