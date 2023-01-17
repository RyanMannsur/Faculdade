
package principalRyan;


public abstract class FormaTridimensonal extends Forma{
    protected double area;
    protected double volume;

    public FormaTridimensonal(double area, double volume) {
        this.area = area;
        this.volume = volume;
    }

    public FormaTridimensonal() {
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
    
    
}
