
package extrai;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ExtraiPalavra {
    private ArrayList<Palavra> palavras;

    public ExtraiPalavra() throws IOException {
        lerArquivo("Exemplo.txt");
    }
    
    public void lerArquivo(String nome) throws IOException {
        int aux = 0;
        String arquivo;
        int linha = 0;
        try {
            FileReader arq = new FileReader(nome);
            BufferedReader lerArq = new BufferedReader(arq);

            arquivo = lerArq.readLine();
            for (int i = 0; i < arquivo.length(); i++) {
                if (arquivo.charAt(i) == ' ') {
                    String palavra = arquivo.substring(aux, i - 1);
                    Palavra p = new Palavra(linha,i,palavra);
                    aux = i;
                    palavras.add(p);
                }
            }
            linha++;
            while (arquivo != null) {
                arquivo = lerArq.readLine(); // lê da segunda até a última linha
                linha++;
                for (int i = 0; i < arquivo.length(); i++) {
                    if (arquivo.charAt(i) == ' ') {
                        String palavra = arquivo.substring(aux, i - 1);
                        Palavra p = new Palavra(linha, i, palavra);
                        aux = i;
                        palavras.add(p);
                    }
                }
            }

           arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
    }
}
