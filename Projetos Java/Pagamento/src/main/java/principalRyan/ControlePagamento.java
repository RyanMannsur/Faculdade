
package principalRyan;

import java.util.ArrayList;
import java.util.Iterator;


public class ControlePagamento {
    public static double salario = 954.00;
    public static double hora = 8.00;
    private ArrayList<Pagavel> pagaveis;

    public ControlePagamento() {
        pagaveis = new ArrayList<>(); 
    }

    public ArrayList<Pagavel> getPagaveis() {
        return pagaveis;
    }

    public void setPagaveis(ArrayList<Pagavel> pagaveis) {
        this.pagaveis = pagaveis;
    }
    
    public double folhaPagamento(){
        double valor = 0.0;
        Pagavel aux;
        Iterator it = pagaveis.iterator();
        while(it.hasNext()){
            aux = (Pagavel)it.next();
            valor = valor + aux.getValorPagar();
        }
        return valor;
    }
    
    public void despesaAdd(Pagavel p){
        pagaveis.add(p);
    }
}
