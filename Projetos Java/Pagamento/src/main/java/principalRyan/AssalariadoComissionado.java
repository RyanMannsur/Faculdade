
package principalRyan;


public class AssalariadoComissionado extends Comissionado{

    public AssalariadoComissionado(double vendas, String nome, String sobrenome, String numIndent) {
        super(vendas, nome, sobrenome, numIndent);
    }

    public AssalariadoComissionado() {
    }
    
    @Override
    public double getValorPagar() {
        double pagamento = ControlePagamento.salario;
        return pagamento + (vendas*0.06) + (pagamento*0.1);
    }
}
