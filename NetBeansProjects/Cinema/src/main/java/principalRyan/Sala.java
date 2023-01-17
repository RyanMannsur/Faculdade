
package principalRyan;


public class Sala {
    private int numero;
    private int capacidade;
    private int quantidade;


    public Sala(int numero, int capacidade) {
        this.numero = numero;
        this.capacidade = capacidade;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public boolean vericarSeLotou(){
        return quantidade == capacidade;
    }
    public void aumentarQuantidade(){
      this.quantidade = this.quantidade + 1;
    }
}
