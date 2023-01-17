
package principalRyan;


public class Concessionaria extends Conta {
     private String descicao;

    public Concessionaria(String descicao, int dia, int mes, double valor) {
        super(dia, mes, valor);
        this.descicao = descicao;
    }

    public Concessionaria(int dia, int mes, double valor) {
        super(dia, mes, valor);
    }

    public String getDescicao() {
        return descicao;
    }

    public void setDescicao(String descicao) {
        this.descicao = descicao;
    }

    
    @Override
    public double getValorPagar() {
        return valor;
    }
    
}
