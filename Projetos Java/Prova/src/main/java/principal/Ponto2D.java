package principal;
/*
* Anelio Gonçalves Caldas e Ryan Eduardo Mansur Vasconcelos
*/
public class Ponto2D {

    private int x;
    private int y;

    public Ponto2D() {
    }

    public Ponto2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Ponto2D(Ponto2D p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double calcularDistancia(Ponto2D ponto) {
        return (Math.sqrt(Math.pow((x - ponto.getX()), 2) + Math.pow((y - ponto.getY()), 2)));
    }

}
