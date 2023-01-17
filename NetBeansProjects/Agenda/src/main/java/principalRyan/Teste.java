
package principalRyan;

import java.util.Iterator;
import java.util.Scanner;


public class Teste {
    public static void main(String[] args) {
        int aux = 1;
        String aux2 = " ";
        Scanner sc = new Scanner(System.in);
        Semana semana = new Semana();
        String segunda = "Segunda-Feira";
        String terca = "Terca-Feira";
        String quarta = "Quarta-Feira";
        String quinta = "Quinta-Feira";
        String sexta = "Sexta-Feira";
        Compromisso compromisso1 = new Compromisso("Medico", 2); int horario1 = 9;
        Compromisso compromisso2 = new Compromisso("Dentista", 1); int horario2 = 14;
        semana.adicionarCompromisso(segunda, compromisso1, horario1);
        semana.adicionarCompromisso(segunda, compromisso2, horario2);
        
        while(aux!=0){
           semana.exibirHorarios();
            System.out.println("Deseja adicionar algo na agenda?");
            System.out.println("Digite:\n2: para "+segunda+"\n3: para "+terca+"\n4: para "+quinta+"\n6: para "+sexta+"\nDigite 0 para sair");
            aux = sc.nextInt();
            if(aux!=0){
                System.out.println("Digite a descricao do compromisso");
                aux2 = sc.next();
                System.out.println("Digite o horario do compromisso entre 9 as 18h");
                horario1 = sc.nextInt();
                System.out.println("Digite a quantidade de horas que o compromisso vai durar");
                horario2 = sc.nextInt();
                switch(aux){
                    case 2: compromisso1.setDescricao(aux2);
                            compromisso1.setDuracao(horario2);
                            semana.adicionarCompromisso(segunda, compromisso1, horario1); break;
                    case 3: compromisso1.setDescricao(aux2);
                            compromisso1.setDuracao(horario2);
                            semana.adicionarCompromisso(terca, compromisso1, horario1); break;
                    case 4: compromisso1.setDescricao(aux2);
                            compromisso1.setDuracao(horario2);
                            semana.adicionarCompromisso(quarta, compromisso1, horario1); break;
                    case 5: compromisso1.setDescricao(aux2);
                            compromisso1.setDuracao(horario2);
                            semana.adicionarCompromisso(quinta, compromisso1, horario1); break;
                    case 6: compromisso1.setDescricao(aux2);
                            compromisso1.setDuracao(horario2);
                            semana.adicionarCompromisso(sexta, compromisso1, horario1); break;
                      
                }
            }
            System.out.println("");
        }
    }
}