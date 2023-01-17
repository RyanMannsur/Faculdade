
package principalRyan;


public abstract class Empregado implements Pagavel {
    protected String nome;
    protected String sobrenome;
    protected String numIndent;

    public Empregado(String nome, String sobrenome, String numIndent) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numIndent = numIndent;
    }

    public Empregado() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNumIndent() {
        return numIndent;
    }

    public void setNumIndent(String numIndent) {
        this.numIndent = numIndent;
    }
    
    
}
