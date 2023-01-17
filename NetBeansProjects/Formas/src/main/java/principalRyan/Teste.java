
package principalRyan;

public class Teste {
    public static void main(String[] args) {
        TrataFormas formas = new TrataFormas();
        Forma quadrado = new Quadrado(5.0,10.0);
        Forma triangulo = new Triangulo(2.0, 5.0);
        Forma circulo = new Circulo(2.0);
        Forma cubo = new Cubo(4.0);
        Forma esfera = new Esfera(2.0);
        Forma tetraedo = new Tetraedo(5.0);
        formas.addFormas(quadrado);
        formas.addFormas(triangulo);
        formas.addFormas(circulo);
        formas.addFormas(cubo);
        formas.addFormas(esfera);
        formas.addFormas(tetraedo);
        formas.printAreaDasFormas();
        
        formas.printVolumeDasFormas(); //Vai chamar a execeção e continuar executando
        
        /*try {
            formas.volume(quadrado);
        } catch (NaoExisteVolumeException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
            System.exit(1); // Vai chamar a exceção e para de executar;
        }*/
    }
}
