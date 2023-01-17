package Campeonato;

import janelas.JCriarJogadores;
import janelas.JCriarTimes;
import janelas.JMudarCampeonato;
import janelas.JTabela;
import janelas.NewJFrame;
import java.io.FileNotFoundException;
import java.io.IOException;
import textFilesApps.*;


public class Main {
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
//        CreateTextFile create = new CreateTextFile();
//        ReadTextFile read = new ReadTextFile();
//        Configuracoes config = new Configuracoes();
//        create.gravar(config.getTimes());      
        JTabela jTabela = new JTabela();  
        jTabela.setResizable(false);
        jTabela.setVisible(true); 
//        JCriarJogadores j = new JCriarJogadores();
//        j.setVisible(true);
//            JCriarTimes j = new JCriarTimes();
//            j.setVisible(true);
//            JMudarCampeonato j = new JMudarCampeonato();
//            j.setVisible(true);
        
        
        
    }

}
