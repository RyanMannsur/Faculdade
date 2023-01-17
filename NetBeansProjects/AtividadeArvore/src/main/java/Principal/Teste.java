
package Principal;

import java.util.Scanner;


public class Teste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dgite o nome da Pessoa 1:");
        Pessoa p1 = new Pessoa(sc.next());
        System.out.println("Dgite o nome do pai da pessoa 1:");
        Pessoa pai_p1 = new Pessoa(sc.next());
        System.out.println("Dgite o nome da mae da pessoa 1:");
        Pessoa mae_p1 = new Pessoa(sc.next());
        System.out.println("Dgite o nome da avo da pessoa 1:");
        Pessoa avo_p1 = new Pessoa(sc.next());
        System.out.println("Dgite o nome do(a) irmao(a) da pessoa 1:");
        Pessoa irmao_p1 = new Pessoa(sc.next());
        System.out.println("Dgite o nome da Pessoa 2:");
        Pessoa p2 = new Pessoa(sc.next());
        System.out.println("Dgite o nome do pai da pessoa 2:");
        Pessoa pai_p2 = new Pessoa(sc.next());
        System.out.println("Dgite o nome da mae da pessoa 2:");
        Pessoa mae_p2 = new Pessoa(sc.next());
        System.out.println("Dgite o nome da Pessoa 3:");
        Pessoa p3 = new Pessoa(sc.next());
        System.out.println("Dgite o nome do pai da pessoa 3:");
        Pessoa pai_p3 = new Pessoa(sc.next());
        System.out.println("Dgite o nome da mae da pessoa 3:");
        Pessoa mae_p3 = new Pessoa(sc.next());
        System.out.println("");
        p1.setMae(mae_p1); p1.setPai(pai_p1); pai_p1.setMae(avo_p1);
        irmao_p1.setMae(mae_p1); irmao_p1.setPai(pai_p1);
        p2.setMae(mae_p2); p2.setPai(pai_p2);
        p3.setMae(mae_p3); p3.setPai(pai_p3);

        if(pai_p1.antecessora(p1))
            System.out.println(p1.getNome()+" e filho(a) de "+pai_p1.getNome());
        if(mae_p1.antecessora(p1))
            System.out.println(p1.getNome()+" e filho(a) de "+mae_p1.getNome());
        if(avo_p1.antecessora(p1))
            System.out.println(avo_p1.getNome()+" e atecessor de "+p1.getNome());
        if(p1.saoIrmas(irmao_p1))
            System.out.println(p1.getNome()+" e irmao(a) de "+irmao_p1.getNome()+"\n");   
        
        if(pai_p2.antecessora(p2))
            System.out.println(p2.getNome()+" e filho(a) de "+pai_p2.getNome());
        if(mae_p2.antecessora(p2))
            System.out.println(p2.getNome()+" e filho(a) de "+mae_p2.getNome()+"\n");
        
        if(p1.saoIrmas(p2))
            System.out.println(p1.getNome()+" e irmao(a) de "+p2.getNome());
        else
            System.out.println(p1.getNome()+" nao e irmao de "+p2.getNome()+"\n");
        
        if(pai_p3.antecessora(p3))
            System.out.println(p3.getNome()+" e filho(a) de "+pai_p3.getNome());
        if(mae_p3.antecessora(p3))
            System.out.println(p3.getNome()+" e filho(a) de "+mae_p3.getNome()+"\n");
        

        if(p2.saoIrmas(p3))
            System.out.println(p2.getNome()+" e irmao(a) de "+p3.getNome());
        else
            System.out.println(p2.getNome()+" nao e irmao de "+p3.getNome());
        if(p1.saoIrmas(p3))
            System.out.println(p1.getNome()+" e irmao(a) de "+p3.getNome());
        else
            System.out.println(p1.getNome()+" nao e irmao de "+p3.getNome());
    }
}
