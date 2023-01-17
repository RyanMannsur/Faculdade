
package Principal;

import java.util.Scanner;


public class Teste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aux = 1;
        Fatura fatura = new Fatura(10);
        Produto cooler = new Produto("Cooler para processador", 40.0, 1);
        Produto mouse = new Produto("Mouse gamer sem fio", 70.0, 2);
        Produto monitor = new Produto("Monitor LED 24’’", 692.0, 3);
        Produto teclado = new Produto("Teclado / mouse sem fio", 125.0, 4);
        
        System.out.println("LOJA DE SUPRIMENTOS ATIVIDADE!\nConfira nossos produtos.");
        System.out.println("Codigo: "+cooler.getCodigo()+" - "+cooler.getDescricao()+": "+cooler.getValor()+"R$\n"+
                           "Codigo: "+mouse.getCodigo()+" - "+mouse.getDescricao()+": "+mouse.getValor()+"R$\n"+
                           "Codigo: "+monitor.getCodigo()+" - "+monitor.getDescricao()+": "+monitor.getValor()+"R$\n"+
                           "Codigo: "+teclado.getCodigo()+" - "+teclado.getDescricao()+": "+teclado.getValor()+"R$");
        while(aux!=0){
            System.out.println("");
            Item compra= new Item(); 
            System.out.println("Digite 0 para sair.\nDigite o codigo do produto que deseja comprar: ");
            aux = sc.nextInt();
            if(aux == cooler.getCodigo()){
                compra.setProduto(cooler);
                System.out.println("Digite quantos produtos voce deseja comprar: ");
                compra.setQuantidade(sc.nextInt());
                fatura.adicionarItem(compra);
                System.out.println("Produto adicionado no carrinho.");       
            }
            else
                if(aux == mouse.getCodigo()){
                    compra.setProduto(mouse);
                    System.out.println("Digite quantos produtos voce deseja comprar: ");
                    compra.setQuantidade(sc.nextInt());
                    fatura.adicionarItem(compra);
                    System.out.println("Produto adicionado no carrinho.");       
                }
            else
                if(aux == monitor.getCodigo()){
                    compra.setProduto(monitor);
                    System.out.println("Digite quantos produtos voce deseja comprar: ");
                    compra.setQuantidade(sc.nextInt());
                    fatura.adicionarItem(compra);
                    System.out.println("Produto adicionado no carrinho.");       
                }
            else
                if(aux == teclado.getCodigo()){
                    compra.setProduto(teclado);
                    System.out.println("Digite quantos produtos voce deseja comprar: ");
                    compra.setQuantidade(sc.nextInt());
                    fatura.adicionarItem(compra);
                    System.out.println("Produto adicionado no carrinho.");       
                }
            else
                if(aux != 0)
                    System.out.println("Erro! Produto nao comprado");
            System.out.println("");
        }
        System.out.println("FATURA!");
        for(int i=0;i<fatura.tamanho(); i++){
            System.out.println(+fatura.getItens()[i].getQuantidade()+" "
                               +fatura.getItens()[i].getProduto().getDescricao()+" no valor de "
                               +fatura.getItens()[i].getQuantidade()*fatura.getItens()[i].getProduto().getValor()+"R$");
        }
        System.out.println("Valor total: "+fatura.valorFatura()+"R$");

    }
                
}