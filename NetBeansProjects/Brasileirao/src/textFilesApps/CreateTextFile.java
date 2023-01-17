package textFilesApps;

import java.io.*;
import java.util.ArrayList;

public class CreateTextFile {

    File file = new File("times.txt");
    File timesCriados = new File("times_criados.txt");
    File jogadoresCriados = new File("jogadores_criados.txt");

    public void gravar(ArrayList times) throws FileNotFoundException, IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        for (int i = 0; i < times.size(); i++) {
            out.writeObject(times.get(i));
        }

        out.close();
    }
    
    public void gravarTimesCriados(ArrayList times) throws FileNotFoundException, IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(timesCriados));
        for (int i = 0; i < times.size(); i++) {
            out.writeObject(times.get(i));
        }

        out.close();
    }
    
    public void jogadoresCriados(ArrayList jogadores) throws FileNotFoundException, IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(jogadoresCriados));
        for (int i = 0; i < jogadores.size(); i++) {
            out.writeObject(jogadores.get(i));
        }
        out.close();
    }
    
    
}
