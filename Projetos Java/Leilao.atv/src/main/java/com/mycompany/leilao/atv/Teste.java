
package com.mycompany.leilao.atv;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String descricao;
        String nome;
        double valor;  
        int qtdmax = 2;
        Lote bike = new Lote("Bicicleta");
        Lote car = new Lote("Carro 0km");
        Leilao vendas = new Leilao(qtdmax);
        
        vendas.adicionaLote(bike);
        vendas.adicionaLote(car);
        
        for(int i=0;i<3;i++){
            vendas.imprimiLotes();
            System.out.println("Diga seu Nome, valor do lance e a descricao");
            nome = input.nextLine();
            valor = input.nextDouble();
            input.nextLine();
            descricao = input.nextLine();
            Lance comprar = new Lance(nome,valor);
            if(vendas.recebeLance(comprar, descricao))
                System.out.println("Lance Valido");
            else
                System.out.println("Lance Invalido");
        }
        
        vendas.encerrarLeilao();
    }
}
