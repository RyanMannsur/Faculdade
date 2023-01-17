
package principalRyan;


public abstract class FormaBidimensonal extends Forma{
    protected double area;

    public FormaBidimensonal(double area) {
        this.area = area;
    }
    
    public FormaBidimensonal() {
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
