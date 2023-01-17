package arvoreSBB;

public class ArvoreSBB {

    private No raiz;
    private boolean condicao;
    public static int comp = -1;

    public ArvoreSBB() {
        this.raiz = null;
        this.condicao = true;
    }

    public void insere(Item reg) {
        this.raiz = insere(reg, null, this.raiz, true);
    }

    public Item pesquisa(Item reg) {
        return pesquisa(reg, this.raiz);
    }
    
    private Item pesquisa(Item reg, No p){
        comp++; //para ver quantas vezes pesquisa errado
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

    private No insere(Item reg, No pai, No filho, boolean filhoEsq) {
        if (filho == null || filho.reg == null) { // se raiz nao existe, cria
            filho = new No();
            filho.reg = reg;
            filho.dir = new No();
            filho.esq = new No();
            if (pai != null) { // se pai existe crie no horizontal
                if (filhoEsq) { 
                    pai.incE = No.Horizontal;
                } else {
                    pai.incD = No.Horizontal;
                }
            }
            this.condicao = false;
        } else if (reg.compara(filho.reg) < 0) { //se for menor
            filho.esq = insere(reg, filho, filho.esq, true); //chamo o elemento a esquerda
            if (!condicao) { //propriedade desfeita
                if (filho.incE == No.Horizontal) { //se for horizontal
                    if (filho.esq.incE == No.Horizontal) { // horizontal
                        filho = filho.eec(filho); //faço a mudança ee
                        if (pai != null) { // se existe um No apontando, ele vira horizontal
                            if (filhoEsq) {
                                pai.incE = No.Horizontal;
                            } else {
                                pai.incD = No.Horizontal;
                            }
                        }
                    } else if (filho.esq.incD == No.Horizontal) { // se o filho for horiontal
                        filho = filho.edc(filho); //faço mudança ed
                        if (pai != null) { // se o No pai não for nulo, vira horizontal
                            if (filhoEsq) {
                                pai.incE = No.Horizontal;
                            } else {
                                pai.incD = No.Horizontal;
                            }
                        }
                    }
                } else {
                    this.condicao = true;
                }
            }
        } else if (reg.compara(filho.reg) > 0) { // Se for maior, o mesmo pra se for menor
            filho.dir = insere(reg, filho, filho.dir, true);
            if (!condicao) {
                if (filho.incD == No.Horizontal) {
                    if (filho.dir.incD == No.Horizontal) {
                        filho = filho.ddc(filho);
                        if (pai != null) {
                            if (filhoEsq) {
                                pai.incE = No.Horizontal;
                            } else {
                                pai.incD = No.Horizontal;
                            }
                        }
                    } else if (filho.dir.incE == No.Horizontal) {
                        filho = filho.dec(filho);
                        if (pai != null) {
                            if (filhoEsq) {
                                pai.incE = No.Horizontal;
                            } else {
                                pai.incD = No.Horizontal;
                            }
                        }
                    }
                } else {
                    this.condicao = true;
                }
            }
        } else {
            System.out.println("Erro: Registro ja Existente");
            this.condicao = true;
        }
        return filho;
    }
    
    
}
