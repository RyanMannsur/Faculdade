
package principalRyan;


public class Comissionado extends Empregado{
    protected double vendas;

    public Comissionado(double vendas, String nome, String sobrenome, String numIndent) {
        super(nome, sobrenome, numIndent);
        this.vendas = vendas;
    }

    public Comissionado() {
    }

    public double getVendas() {
        return vendas;
    }

    public void setVendas(double vendas) {
        this.vendas = vendas;
    }

    @Override
    public double getValorPagar() {
        double pagamento = 0.0;
        return pagamento = vendas*0.06;
    }
}
