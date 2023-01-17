
package principal;

import java.util.Scanner;

/*
* Anelio Gonçalves Caldas e Ryan Eduardo Mansur Vasconcelos
*/
public class Teste {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = 0;
        int y = 0;
        System.out.println("Digite os pontos: ");
        System.out.println("X1: ");
        x = sc.nextInt();
        System.out.println("Y1: ");
        y = sc.nextInt();
        Ponto2D a = new Ponto2D(x, y);
        
        System.out.println("X2: ");
        x = sc.nextInt();
        System.out.println("Y2: ");
        y = sc.nextInt();
        Ponto2D b = new Ponto2D(x,y);
        
        System.out.println("X3: ");
        x = sc.nextInt();
        System.out.println("Y3: ");
        y = sc.nextInt();
        Ponto2D c = new Ponto2D(x,y);
        
        Triangulo abc = new Triangulo(a, b, c);
        
        if(abc.equilatero()){
            System.out.println("Tringulo Equilatero");
        }
        if(abc.escaleno()){
            System.out.println("Tringulo Escaleno");
        }
        if(abc.isósceles()){
            System.out.println("Tringulo Isoceles");
        }
        if(abc.formaTriangulo(abc.getA(), abc.getB(), abc.getC())){
            System.out.println("A area do triangulo e: "+abc.area());
        System.out.println("O perimetro do triangulo e: "+abc.perimetro());
        }
        else
            System.out.println("Nao e um triangulo");
    }
}
