
package principalRyan;

import java.util.HashMap;
import java.util.Iterator;


public class Semana {
    private HashMap<String,Dia> diasDaSemana;

    public Semana() {
        this.diasDaSemana = new HashMap<>();
        inicializar();   
    }

    public HashMap<String, Dia> getDiasDaSemana() {
        return diasDaSemana;
    }

    public void setDiasDaSemana(HashMap<String, Dia> diasDaSemana) {
        this.diasDaSemana = diasDaSemana;
    }
    
    public void inicializar(){
        diasDaSemana.put("Segunda-Feira",new Dia());
        diasDaSemana.put("Terca-Feira",new Dia());
        diasDaSemana.put("Quarta-Feira",new Dia());
        diasDaSemana.put("Quinta-Feira",new Dia());
        diasDaSemana.put("Sexta-Feira",new Dia());
    }
    
    public void adicionarCompromisso(String diaUtil,Compromisso compromisso, Integer horario){
        Iterator it = diasDaSemana.keySet().iterator();
        while(it.hasNext()){
            String chaveDia = (String)it.next();
            if(chaveDia.equals(diaUtil)){
                diasDaSemana.get(chaveDia).adicionarCompromissos(compromisso, horario);
            }
        }
    }
    
    public void exibirHorarios(){       
        System.out.println("Horario     Dia         Duracao     Descricao");
        Iterator it = diasDaSemana.keySet().iterator();
        while(it.hasNext()){
            String chaveDia = (String)it.next();
                diasDaSemana.get(chaveDia).mostrarCompromissos(chaveDia);
        }
    }
    
    public void exibirHorarios(String diaUtil){       
        Iterator it = diasDaSemana.keySet().iterator();
        while(it.hasNext()){
            String chaveDia = (String)it.next();
            if(chaveDia.equals(diaUtil)){
                diasDaSemana.get(chaveDia).mostrarCompromissos(chaveDia);
            }
        }
    }
}
