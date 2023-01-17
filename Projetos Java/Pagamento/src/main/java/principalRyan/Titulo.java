
package principalRyan;

public class Titulo extends Conta {
    private boolean atraso;
    String descricao;

    public Titulo(boolean atraso, int dia, int mes, double valor,String descricao) {
        super(dia, mes, valor);
        this.atraso = atraso;
        this.descricao = descricao;
    }

    public Titulo() {
    }

    public boolean isAtraso() {
        return atraso;
    }

    public void setAtraso(boolean atraso) {
        this.atraso = atraso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
   
    
    @Override
    public double getValorPagar(){
        double pagamento = valor;
        if(atraso){
            pagamento = pagamento + (valor*0.1);
        }
        return pagamento;
    }
}
