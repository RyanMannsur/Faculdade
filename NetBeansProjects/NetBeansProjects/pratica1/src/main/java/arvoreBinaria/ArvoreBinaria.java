
package arvoreBinaria;


public class ArvoreBinaria {
    private No raiz;
    public static int comp=-1;
    
    public ArvoreBinaria() {
        this.raiz = new No();
    }
    
    public Item pesquisa(Item reg){ //recebo um nomero
        return this.pesquisa(reg,this.raiz); //passo o numero e a raiz da arvore
    }
    
    public void insere(Item reg){
       insere(reg,this.raiz);
    }
    
    private No insere(Item reg, No p){
        if(p.reg == null || p == null){ // se nao existe nada nessa posicao, adiciono
           p.reg = reg;
           p.dir = new No();
           p.esq = new No();
        }
        else
            if(reg.compara(p.reg)<0) // se for menor, olho pro lado esquerdo
                return insere(reg,p.esq);
            else
                if(reg.compara(p.reg)>0) // se for maior, pro direito
                    return insere(reg,p.dir);
        return null;
    }
    
    private Item pesquisa(Item reg, No p){
        this.comp++; //para ver quantas vezes pesquisa errado
        if(p.reg == null || p == null)
            return null;
        else
            if(reg.compara(p.reg)<0) //se for menor pesquiso do lado esquerdo
                return pesquisa(reg,p.esq);
            else
                if(reg.compara(p.reg)>0) //se for maior pesquiso do lado direito
                    return pesquisa(reg,p.dir);
                else // se não for nada, é o proprio numero
                    return p.reg;
                  
    }
}