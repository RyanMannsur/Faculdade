
package principalRyan;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;


public class Dia {
    private TreeMap<Integer,Compromisso> compromissos;

    public Dia() {
        compromissos = new TreeMap<>();
        inicializar();
    }

    public TreeMap<Integer, Compromisso> getCompromissos() {
        return compromissos;
    }

    public void setCompromissos(TreeMap<Integer, Compromisso> compromissos) {
        this.compromissos = compromissos;
    }
    
    public void adicionarCompromissos(Compromisso compromisso, Integer horario) {
        if (verificarCompromisso(horario)) {
            Iterator it = compromissos.keySet().iterator();
            while (it.hasNext()) {
                Integer chave = (Integer) it.next();
                if (chave == horario) {
                    compromissos.get(chave).setDescricao(compromisso.getDescricao());
                    compromissos.get(chave).setDuracao(compromisso.getDuracao());
                    if (compromisso.getDuracao() > 1) {
                        for (int i = 1; i < compromisso.getDuracao(); i++) {
                            Integer chave2 = (Integer) it.next();
                            compromissos.get(chave2).setDescricao(compromisso.getDescricao());
                            compromissos.get(chave2).setDuracao(compromisso.getDuracao() - i);
                        }
                        break;
                    }
                }
            }
        } else {
            System.out.println("Ja existe um copromisso para este horario");
        }
    }
    
    public void mostrarCompromissos(String dia) {
        Iterator it = compromissos.keySet().iterator();
        while(it.hasNext()){
            Integer chave = (Integer)it.next();
            if (compromissos.get(chave).getDescricao() != null) {
                System.out.println(chave + ":00    " + dia + "      " + compromissos.get(chave).getDuracao()
                        + "         " + compromissos.get(chave).getDescricao());
            }
            if(compromissos.get(chave).getDuracao()>1){
                for(int i = 1;i<compromissos.get(chave).getDuracao();i++){
                    it.next();
                }
            }
        }
    }
    
    public boolean verificarCompromisso(Integer horario){
        for (Map.Entry<Integer, Compromisso> entry : compromissos.entrySet()) {
            if (entry.getValue().getDescricao() != null && horario == entry.getKey()) {
                return false;
            }
        }
        return true;
    }
    
    public void inicializar(){
        for(Integer i=9;i<=18;i++){
            compromissos.put(i, new Compromisso());
        }
        
    }
}
