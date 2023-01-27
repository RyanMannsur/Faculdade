
package pratica13a;


public class Originator extends Memento{
    private CareTaker careTaker;

    public Originator(double valor) {
        super(valor);
        careTaker = new CareTaker();
        setValor(valor);
    }
    
    void setValor(double valor){
        this.valor = valor;
        System.out.println("Valor salvo: " + String.format("%.1f", valor));
        careTaker.add(saveValorToMemento());
    }
    
    Memento saveValorToMemento(){
        return new Memento(this.valor);
    }
    
    void getValorFromMemento(Memento memento){
        for(int i=0; i<careTaker.mementoList.size(); i++){
            if(careTaker.mementoList.get(i).getValor() == memento.getValor()){
                System.out.println("Valor Restaurado: " + String.format("%.1f", careTaker.mementoList.get(i-1).getValor()));
                valor = careTaker.mementoList.get(i-1).getValor();
            }
        }
    }
}
