
package extrai;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class LerArquivo {
    private HashMap<Integer,String> textoMap;

    public LerArquivo() {
        textoMap = ler("Exemplo.txt");
    }

    public HashMap<Integer, String> getTextoMap() {
        return textoMap;
    }
    
    public HashMap<Integer, String> ler(String nome) {
        String arquivo = null;
        HashMap<Integer,String> texto = null;
        int linha = 0;
        try {
            FileReader arq = new FileReader(nome);
            BufferedReader lerArq = new BufferedReader(arq);

            arquivo = lerArq.readLine();
            texto.put(linha, arquivo);
            linha++;
            while (arquivo != null) {
                arquivo = lerArq.readLine(); // lê da segunda até a última linha
                texto.put(linha, arquivo);
                linha++;
            }

           arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        return texto;
    }
}
