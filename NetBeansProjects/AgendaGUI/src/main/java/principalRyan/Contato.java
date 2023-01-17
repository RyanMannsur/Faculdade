
package principalRyan;


public class Contato {
    private String nome;
    private String endereco;
    private String telefone;
    private String email;

    public Contato(String nome, String endereço, String telefone, String email) {
        this.nome = nome;
        this.endereco = endereço;
        this.telefone = telefone;
        this.email = email;
    }

    public Contato() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
