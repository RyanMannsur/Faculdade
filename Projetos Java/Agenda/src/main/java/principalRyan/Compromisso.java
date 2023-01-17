
package principalRyan;


public class Compromisso {
    private String descricao;
    private int duracao;

    public Compromisso() {
    }

    public Compromisso(String descricao, int duracao) {
        this.descricao = descricao;
        this.duracao = duracao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    
    
}
