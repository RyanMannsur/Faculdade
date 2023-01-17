
package principalRyan;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String problema = "inicializa";
        SuporteTecnico st = new SuporteTecnico();
        System.out.println("Bem vindos ao suporte tecnico!\n");
        while(!problema.equalsIgnoreCase("S")){
            System.out.println("Digite seu problema: ");
            
            problema = sc.nextLine();
            
            if(!problema.equalsIgnoreCase("S")){
                Interpretadora interpretadora = new Interpretadora(problema);
                System.out.println(st.buscarSolucao(interpretadora.getTokens()));
                System.out.println("Digite S para sair.\nDigite <enter> para continuar");
                problema = sc.nextLine();
            }
        }
    }
    
}
