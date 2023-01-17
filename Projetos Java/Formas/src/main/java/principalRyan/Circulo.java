
package principalRyan;


public class Circulo extends FormaBidimensonal{
    private double raio;

    public Circulo(double raio) {
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
        return Math.PI*Math.pow(raio, 2);
    }
    
    @Override
    public double calcularVolume() throws NaoExisteVolumeException {
        throw new NaoExisteVolumeException("Impossivel Calcular Volume");
    }
    
}
