package textFilesApps;

import java.io.*;
import java.util.ArrayList;
import jogadores.JogadorBase;
import time.Time;

public class ReadTextFile {

    File file = new File("times.txt");
    File timesCriados = new File("times_criados.txt");
    File jogadoresCriados = new File("jogadores_criados.txt");
    
    public ArrayList buscarTime() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream in = new FileInputStream(file);
        ObjectInputStream read = new ObjectInputStream(in);
        ArrayList<Time> times = new ArrayList<>();
        Time time = null;
        int x = 20;
        while (true) {
            try {
                time = (Time) read.readObject();
                times.add(time);
            } catch (Exception e) {
                break;
            }
        }

        read.close();
        in.close();
        return times;
    }
    
    public ArrayList buscarJogares() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream in = new FileInputStream(jogadoresCriados);
        ObjectInputStream read = new ObjectInputStream(in);
        ArrayList<JogadorBase> jogadores = new ArrayList<>();
        JogadorBase jogador = null;
        while (true) {
            try {
                jogador = (JogadorBase) read.readObject();
                jogadores.add(jogador);
            } catch (Exception e) {
                break;
            }
        }

        read.close();
        in.close();
        return jogadores;
    }
    
    public ArrayList buscarTimesCriados() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream in = new FileInputStream(timesCriados);
        ObjectInputStream read = new ObjectInputStream(in);
        ArrayList<Time> times = new ArrayList<>();
        Time time = null;
        int x = 20;
        while (true) {
            try {
                time = (Time) read.readObject();
                times.add(time);
            } catch (Exception e) {
                break;
            }
        }

        read.close();
        in.close();
        return times;
    }

}
