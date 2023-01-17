package linhasDeMontagem;

public class Estacao {
    private int posicao;
    private int linha;
    private int valor;
    private int transporte;

    public Estacao(int posicao, int linha, int valor, int transporte) {
        this.posicao = posicao;
        this.linha = linha;
        this.valor = valor;
        this.transporte = transporte;
    }

    public int getPosicao() {
        return posicao;
    }

    public int getLinha() {
        return linha;
    }

    public int getValor() {
        return valor;
    }

    public int getTransporte() {
        return transporte;
    }   
}