
package principal;


public class Mobilia {
    private String nome;
    private double tamanho;
    
    /*Encapsulamento: Temos um exemlo de encapsulamento, o nome e o tamanho do movél são privados,
      assim, apenas a propria classe poderá muda-lá. */

    public Mobilia(String nome, double tam) {
        this.nome = nome;
        this.tamanho = tam;
    }
}
