
package Principal;


public class Pessoa {
    private String nome;
    private Pessoa pai;
    private Pessoa mae;
    
    public Pessoa(){
        
    }
    
    public Pessoa(String nome){
        this.nome = nome;
        this.pai = null;
        this.mae = null;
    }
    
    public Pessoa(String nome, String pai, String mae){
        this.nome = nome;
        this.mae = new Pessoa(mae);
        this.pai = new Pessoa(pai);
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return nome;
    }

    public void setMae(Pessoa mae) {
        this.mae = mae;
    }
    
    public Pessoa getMae() {
        return mae;
    }    
    
    public void setPai(Pessoa pai){
        this.pai = pai;
    }
    
    public Pessoa getPai(){
        return pai;
    }
    
    public boolean igualdadeSemantica(Pessoa p){
        if(p.getMae() != null && p.getPai() != null && getMae() != null && getPai() != null)
            return p.getMae().getNome().equalsIgnoreCase(getMae().getNome()) &&
                   p.getPai().getNome().equalsIgnoreCase(getPai().getNome()) &&
                   p.getNome().equalsIgnoreCase(getNome());        
        else
            if(p.getMae() != null && getMae() != null)
                return p.getMae().getNome().equalsIgnoreCase(getMae().getNome()) &&
                       p.getNome().equalsIgnoreCase(getNome());
        else
            if(p.getPai() != null && getPai() != null)
                return p.getPai().getNome().equalsIgnoreCase(getPai().getNome()) &&
                       p.getNome().equalsIgnoreCase(getNome());
            else
                return p.getNome().equalsIgnoreCase(getNome());
    }
    
    public boolean saoIrmas(Pessoa p){
        return (getMae().igualdadeSemantica(p.getMae()) ||
                getPai().igualdadeSemantica(p.getPai())) &&
               (! p.getNome().equalsIgnoreCase(getNome()));
    }
    
    public boolean antecessora(Pessoa p){
        if(p.getMae() != null && igualdadeSemantica(p.getMae())) //se mae
            return true;
        else
            if(p.getPai() != null && igualdadeSemantica(p.getPai())) // se pai
                return true;
        else
            if(p.getMae().getMae() != null && igualdadeSemantica(p.getMae().getMae())) // se avó materno
                return true;
        else
            if(p.getMae().getPai() != null && igualdadeSemantica(p.getMae().getPai())) // se avô materno
                return true;
        else
            if(p.getPai().getMae() != null && igualdadeSemantica(p.getPai().getMae())) // se avó paterno
                return true;
            else
            if(p.getPai().getPai() != null && igualdadeSemantica(p.getPai().getPai())) // se avô paterno
                return true;
        else
            return false;
    }
}
