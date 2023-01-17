
package principalRyan;


public class Bilhete {
    private double valor;
    private Filme filme;

    public Bilhete(double valor, Filme filme) {
        this.valor = valor;
        this.filme = filme;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }   
    
    public boolean imprimirBilhete(int sala){ //Retorna o bilhete que vai ser vendido
        if(sala == filme.getSala().getNumero()){
            return true;
        }
        return false;
    }
    
}
