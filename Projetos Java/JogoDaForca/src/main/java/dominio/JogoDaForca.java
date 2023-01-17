
package dominio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import servicos.TestFileApps;


public class JogoDaForca {
    private String palavra;
    private ArrayList palavras;
    private boolean venceu;
    private int tentativas;

    public JogoDaForca(){
        this.palavras = new ArrayList<>();
        venceu = false;
        this.tentativas = 15;
        TestFileApps.readRecords(this);
        sorteiarPalavra();
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public ArrayList getPalavras() {
        return palavras;
    }

    public void setPalavras(ArrayList palavras) {
        this.palavras = palavras;
    }

    public boolean isVenceu() {
        return venceu;
    }

    public void setVenceu(boolean venceu) {
        this.venceu = venceu;
    }

    public int getTentativas() {
        return tentativas;
    }

    public void setTentativas(int tentativas) {
        this.tentativas = tentativas;
    }
    
    public boolean verificarFimDeJogo(){
        return false;
    }

    public void realizarJogada(){
        tentativas--;
    }
    
    public ArrayList<Integer> verificarLetra(String letra){
        realizarJogada();
        ArrayList<Integer> posicao = new ArrayList<>();
        if(palavra.contains(letra)){
            for(int i=0;i<palavra.length();i++){
                if(letra.charAt(0) == palavra.charAt(i))
                  posicao.add(i);
            }
        }
        return posicao;
    }
    
    public void sorteiarPalavra(){
        Random aleatorio = new Random();
        int i = aleatorio.nextInt(palavras.size());
        int contador = 0;
        String aux = null;
        Iterator it = palavras.iterator();
        while(it.hasNext()){
            aux = (String)it.next();
            contador++;
            if(contador-1 == i)
                break;
        }
        palavra = aux;
        System.out.println("Palavra escolhida:"+palavra);
    }
    
    public boolean vericarFimDeJogo(ArrayList<String> letras){
        Iterator it = letras.iterator();
        int i = 0;
        while(it.hasNext() && i<7){
            if(!((String)it.next()).equalsIgnoreCase(""+palavra.charAt(i))){
                return false;
            }
            i++;
        }
        return true;
    }
}
