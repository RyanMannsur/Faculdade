
package pratica13a;


public class TesteMemento {
    public static void main(String[] args) {
        Originator originator = new Originator(400.00);
        originator.setValor(300.00);
        originator.setValor(200.00);
        originator.setValor(100.00);
        originator.setValor(0);
        originator.getValorFromMemento(originator);
        originator.getValorFromMemento(originator);
        originator.getValorFromMemento(originator);
        originator.getValorFromMemento(originator);
    }
}
