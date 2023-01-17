
package principalRyan;


public class Terceirizado extends Empregado{
    private int horasTrabalhadas;
    public Terceirizado(String nome, String sobrenome, String numIndent, int horasTrabalhadas) {
        super(nome, sobrenome, numIndent);
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public Terceirizado() {
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }
    
    
    @Override
    public double getValorPagar() {
        double pagamento = 0.0;
        for(int i=0; i!=horasTrabalhadas;i++){
            pagamento = pagamento + 30.0; //Tercerizado recebe 30 por hora.
        }
        return pagamento;
    }
}
