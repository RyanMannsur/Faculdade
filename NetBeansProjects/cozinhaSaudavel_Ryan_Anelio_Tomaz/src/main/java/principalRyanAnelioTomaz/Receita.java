
package principalRyanAnelioTomaz;

import java.util.ArrayList;


public class Receita {
    private String nome;
    private ArrayList<Ingrediente> ingredientes;

    public Receita(String nome) {
        this.ingredientes = new ArrayList<>();
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
    public void adicionarIngrediente(Ingrediente ingrediente){
        ingredientes.add(ingrediente);
    }
    public void imprimirReceita(){
        System.out.println(nome);
        System.out.println("Ingrediente     | Substituição");
        for(int i=0; i<ingredientes.size();i++){
             System.out.println(ingredientes.get(i).getQuantidade()+" de "+ingredientes.get(i).getNome()+"      "+ingredientes.get(i).getOpcaoSaudavel());
        }
        System.out.println("");
    }
}
