
package extrai;


public class Palavra {
    private int linha;
    private int coluna;
    private String palavra;

    public Palavra(int linha, int coluna, String palavra) {
        this.linha = linha;
        this.coluna = coluna;
        this.palavra = palavra;
    }

    public Palavra() {
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }
    
    
}
