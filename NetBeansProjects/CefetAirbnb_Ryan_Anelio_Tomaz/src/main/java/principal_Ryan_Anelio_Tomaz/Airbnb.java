
package principal_Ryan_Anelio_Tomaz;
import java.lang.NullPointerException;

public class Airbnb {
    public static void main(String[] args) {
        int saldo = 300;
        int valor = 200;
        int saldoA = saldo;
        try{
            saldo -= valor;
            if(saldo<0)
                throw new NullPointerException();
        }catch(NullPointerException exception){
            System.out.println("Saldo insuficiente");
            saldo = saldoA;
        }finally{
            System.out.println("Saldo: "+saldo);
        }
    }
}
