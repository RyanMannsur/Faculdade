
package principalRyan;


public class Triangulo extends FormaBidimensonal{
    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    @Override
    public double calcularArea() {
        area = (base*altura)/2;
        return area;
    }
    
    @Override
    public double calcularVolume() throws NaoExisteVolumeException {
        throw new NaoExisteVolumeException("Impossivel Calcular Volume");
    }
}
