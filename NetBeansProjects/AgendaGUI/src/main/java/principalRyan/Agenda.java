
package principalRyan;

import java.util.ArrayList;
import java.util.Iterator;
import testeFileApps.CriarArquivo;
import testeFileApps.LerArquivo;


public class Agenda {
    ArrayList<Contato> contatos;

    public Agenda() {
        this.contatos = new ArrayList<>();
    }

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }
    
    public boolean inserirContato(Contato c){
        contatos.add(c);
        return true;
    }
    
    public void gravar(){
        CriarArquivo.addRecords(this);
    }
    
    public Contato pesquisar(String nome){
        LerArquivo.readRecords(this);
        gravar();
        LerArquivo.readRecords(this);
        Iterator it = contatos.iterator();
        while(it.hasNext()){
            Contato aux = (Contato)it.next();
            if(aux.getNome().equalsIgnoreCase(nome)){
                return aux;
            }
        }
        return null;
    }
}
