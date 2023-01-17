
package principalRyan;


public class Assalariado extends Empregado {
    private int horasTrabalhadas;
    public Assalariado(String nome, String sobrenome, String numIndent, int horasTrabalhadas) {
        super(nome, sobrenome, numIndent);
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public Assalariado() {
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }
    
    
    @Override
    public double getValorPagar() {
        int aux = horasTrabalhadas;
        double pagamento = ControlePagamento.salario;
        while(aux!=(ControlePagamento.hora*5)){
            pagamento = pagamento + 8.0; 
        } 
        return pagamento;
    }
    
}
