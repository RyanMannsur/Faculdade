
package principalRyanAnelioTomaz;

import java.util.ArrayList;

public abstract class Ingrediente {
    protected String quantidade;
    protected String nome;
    protected ArrayList<Ingrediente> substituto;
    
    public Ingrediente(String quantidade, String nome) {
        this.quantidade = quantidade;
        this.nome = nome;
        this.substituto = new ArrayList<>();
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Ingrediente> getSubstituto() {
        return substituto;
    }

    public void setSubstituto(ArrayList<Ingrediente> substituto) {
        this.substituto = substituto;
    }
    
    public abstract String getOpcaoSaudavel();
    
}
