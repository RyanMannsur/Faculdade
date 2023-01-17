
package principalRyan;


public abstract class Forma{

    public Forma() {
    }
    
    public abstract double calcularArea();
    public abstract double calcularVolume() throws NaoExisteVolumeException;

}
