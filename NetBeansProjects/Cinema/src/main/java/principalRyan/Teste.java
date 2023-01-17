package principalRyan;

import java.util.Iterator;
import java.util.Scanner;

public class Teste {

    public static void main(String[] args) {
        Bilheteria cinema = new Bilheteria(); //vende os ingressos
        Sala s1 = new Sala(1,15);
        Sala s2 = new Sala(2,15);
        Sala s3 = new Sala(3,15);

        Filme f1 = new Filme("Homem-Aranha", "Ficcao", "Mark", 2000, s1);
        cinema.addFilme(f1);
        Bilhete b1 = new Bilhete(10.0, f1);
        Filme f2 = new Filme("O Estudante", "Terror", "Cefet", 2019, s2);
        cinema.addFilme(f2);
        Bilhete b2 = new Bilhete(20.0, f2);
        Filme f3 = new Filme("Celta azul", "Automobilismo", "Jose", 2000, s3);
        cinema.addFilme(f3);
        Bilhete b3 = new Bilhete(15.0, f3);
        System.out.println("Bem vindo ao cinema Pipoca!!");
        testarPrograma(cinema,b1,b2,b3);

        System.out.println("O valor final das compras e de: " + cinema.devolverValorFinal() + "R$");
    }
    public static void testarPrograma(Bilheteria cinema, Bilhete b1, Bilhete b2, Bilhete b3){
        int sala = 1; // sala escolhida 
        Filme aux = new Filme(); // usar no iterator
        String aux1 = "0"; // Lugar na sala
        String menu = "S"; // Caso queira mais de um igresso
        Scanner sc = new Scanner(System.in);
        while (sala != 0) {
            Iterator<Filme> it = cinema.getFilmes().iterator();
            if (menu.equalsIgnoreCase("S")) {
                while (it.hasNext()) {
                    aux = it.next();
                    System.out.println("Sala:" + aux.getSala().getNumero()
                            + " Titulo:" + aux.getTitulo()
                            + ". Genero:" + aux.getGenero() + ". Ano:"
                            + aux.getAno() + ". Dirigido por:" + aux.getDiretor());
                }
                System.out.println("\nDigite a sala para o filme que deseja comprar.\nDigite 0 para sair.");
                sala = sc.nextInt();
            }
            
            Iterator<Filme> it2 = cinema.getFilmes().iterator();
            while (it2.hasNext()) {
                aux = it2.next();
                if (sala == aux.getSala().getNumero()) {
                    System.out.println("Digite a fileira na sala de A a C.");
                    aux1 = sc.next();
                    System.out.println("Digite a posicao na fileira de 1 a 5");
                    aux1 = aux1 + sc.next();
                    if (!cinema.verificarAssento(aux1, aux)) {
                        if (!aux.getSala().vericarSeLotou()) {
                            while (!cinema.verificarAssento(aux1, aux)) {
                                System.out.println("Cadeira ja escolhida. Digite a cadeira novamente.");
                                System.out.println("Digite a fileira na sala de A a C.");
                                aux1 = sc.next();
                                System.out.println("Digite a posicao na fileira de 1 a 5");
                                aux1 = aux1 + sc.next();
                            }
                        }
                    } if (!aux.getSala().vericarSeLotou()) {
                        if(b1.imprimirBilhete(sala)){
                            System.out.println("Ingresso no valor de: " + b1.getValor() + "R$ comprado");
                                cinema.venderBilhete(aux1, b1);
                        }
                        else
                            if(b2.imprimirBilhete(sala)){
                                System.out.println("Ingresso no valor de: " + b2.getValor() + "R$ comprado");
                                cinema.venderBilhete(aux1, b2);
                            }
                        else
                            if(b3.imprimirBilhete(sala)){
                                System.out.println("Ingresso no valor de: " + b3.getValor() + "R$ comprado");
                                cinema.venderBilhete(aux1, b3);
                            }
                        System.out.println("Digite S para voltar.\nDigite <A> para comprar outro ingresso para mesmo filme");
                        menu = sc.next();
                    } else {
                        System.out.println("Sala lotada. Digite S para escolher outra sala");
                        menu = sc.next();
                    }
                }
            }
        }

    }
}


