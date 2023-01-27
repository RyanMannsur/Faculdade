
package principal;

import java.util.ArrayList;

public class Comodo {
    private double largura; 
    private double comprimento;
    private ArrayList<Mobilia> mobilia;
    
    // Composicao: o objeto comodo é composto por uma largura, tamanho, e um array de mobilia.

    public Comodo(double largura, double comprimento) {
        this.largura = largura;
        this.comprimento = comprimento;
        this.mobilia = new ArrayList<>();
    }
    
    /*Polimorfismo: Abaixo tem uma sobrecarga de metodos, posso chamar o construtor enviando o array de mobilia,
      os sem ele, o proprio copilador percebe qual construtor chamei.*/
    
    public Comodo(double largura, double comprimento, ArrayList<Mobilia> mobilia) {
        this.largura = largura;
        this.comprimento = comprimento;
        this.mobilia = mobilia;
    }
    
    public void tirarMobilia(Mobilia m){
        for(int i=0;i<mobilia.size();i++){
            if(mobilia.get(i).equals(m)){
                mobilia.remove(i);
            }
        }
    }
    
    /* Encapsulamento: Apesar do metodo publico para adicionar ou remover a mobilia, o metodo usa elementos privados da classe comodo,
       sendo outro exemplo de encapsulamento. Ao fazer uma das coisas, so irá ter efeito no comodo, para quem chama o metodo,
       não interessa como ele foi implemento, apenas que ele funcione. */
    
    public void addMobilia(Mobilia m){
        mobilia.add(m);
    }
}
