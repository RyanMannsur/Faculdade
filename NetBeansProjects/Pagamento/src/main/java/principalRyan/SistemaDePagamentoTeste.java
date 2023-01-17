
package principalRyan;



public class SistemaDePagamentoTeste {
    public static void main(String[] args) {
        ControlePagamento pagamentos = new ControlePagamento();
        Pagavel p1 = new Titulo(false,20,3,100.0,"Internet"); 
        Pagavel p2 = new Concessionaria("Conta de luz",20,3,200.0); 
        Pagavel p3 = new Assalariado("Ryan","Eduardo","111111",40); 
        Pagavel p4 = new Terceirizado("Jose", "da Silva", "22222", 40); 
        Pagavel p5 = new Comissionado(10000.0, "Maria", "Souza","33333"); 
        Pagavel p6 = new AssalariadoComissionado(10000.0,"Lucas", "Rocha", "444444"); 
        pagamentos.despesaAdd(p1);
        pagamentos.despesaAdd(p2);
        pagamentos.despesaAdd(p3);
        pagamentos.despesaAdd(p4);
        pagamentos.despesaAdd(p5);
        pagamentos.despesaAdd(p6);
        System.out.println("Valor a ser Pago:"+pagamentos.folhaPagamento()+"0R$");
    }
}
