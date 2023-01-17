package jogadores;


public class Goleiro extends JogadorBase{
    
    private String posicao;
    private int nDefesas;
    private int jogosSemGols;

    public Goleiro(String nome, int idade, double peso, double tamanho, int camisa) {
        super(nome, idade, peso, tamanho, camisa);
        posicao = "GL";
        nDefesas = 0;
        jogosSemGols = 0;
    }

    public int getnDefesas() {
        return nDefesas;
    }

    public void setnDefesas(int nDefesas) {
        this.nDefesas = nDefesas;
    }

    public int getJogosSemGols() {
        return jogosSemGols;
    }

    public void setJogosSemGols(int jogosSemGols) {
        this.jogosSemGols = jogosSemGols;
    }
    
    public void defendeu(){
        nDefesas++;
    }

   

}
