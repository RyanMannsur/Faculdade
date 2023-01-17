package principal;
/*
* Anelio Gonçalves Caldas e Ryan Eduardo Mansur Vasconcelos
*/
public class Triangulo {

    private Ponto2D A;
    private Ponto2D B;
    private Ponto2D C;

    public Triangulo(Ponto2D A, Ponto2D B, Ponto2D C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public Ponto2D getA() {
        return A;
    }

    public void setA(Ponto2D A) {
        this.A = A;
    }

    public Ponto2D getB() {
        return B;
    }

    public void setB(Ponto2D B) {
        this.B = B;
    }

    public Ponto2D getC() {
        return C;
    }

    public void setC(Ponto2D C) {
        this.C = C;
    }

    public static boolean formaTriangulo(Ponto2D p1, Ponto2D p2, Ponto2D p3) {
        return (p1.calcularDistancia(p2) + p1.calcularDistancia(p3)) > p2.calcularDistancia(p3);
    }

    public boolean equilatero() {
        if (!formaTriangulo(getA(), getB(), getC())) {
            return false;
        } else {
            return (getA().calcularDistancia(getB()) == getA().calcularDistancia(getC()))
                    && getA().calcularDistancia(getB()) == getB().calcularDistancia(getC());
        }
    }

    public boolean isósceles() {
        if (!formaTriangulo(getA(), getB(), getC())) {
            return false;
        }
        else {
            return !equilatero() && (getA().calcularDistancia(getB()) == getA().calcularDistancia(getC()))
                    || getA().calcularDistancia(getB()) == getB().calcularDistancia(getC());
        }
    }

    public boolean escaleno() {
        if (!formaTriangulo(getA(), getB(), getC())) {
            return false;
        } else {
            return !equilatero() && (getA().calcularDistancia(getB()) != getA().calcularDistancia(getC()))
                    && getA().calcularDistancia(getB()) != getB().calcularDistancia(getC());
        }
    }

    public double perimetro(){
        double lado1 = A.calcularDistancia(B);
        double lado2 = A.calcularDistancia(C);
        double lado3 = B.calcularDistancia(C);
        return lado1 + lado2 + lado3;
    }

    public double area() {
        double lado1 = A.calcularDistancia(B);
        double lado2 = A.calcularDistancia(C);
        double lado3 = B.calcularDistancia(C);
        double sp = (lado1 + lado2 + lado3) / 2;
        return (Math.sqrt(sp * (sp - lado1) * (sp - lado2) * (sp - lado3)));
    }
}
