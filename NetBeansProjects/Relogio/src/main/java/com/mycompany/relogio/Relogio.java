
package com.mycompany.relogio;


public class Relogio {
    private Contador horas;
    private Contador minutos;
    private boolean formato;
    private String momento;
    
    public Relogio(boolean formato){
        this.formato = formato;
        if(formato == true){
            this.horas = new Contador(13,12);
        }    
        else{
            this.horas = new Contador(24,0);
        }    
        this.minutos = new Contador(60,0);
        momento = "a.m";
    }
    
    public void setHoras(Contador horas){
        this.horas = horas;
    }
    
    public Contador getHoras(){
        return horas;
    }
    
    public void setMinutos(Contador minutos){
        this.minutos = minutos;
    }

    public Contador getMinutos(){
        return minutos;
    }

    public boolean getFormato(){
        return formato;
    }

    public void setFormato(boolean formato){
        this.formato = formato;
    }

    public String getMomento() {
        return momento;
    }

    public void setMomento(String momento) {
        this.momento = momento;
    }
    
    public void ticTac(){
        minutos.contar();
        if(minutos.getValor() == 0){
            horas.contar();
            if(horas.getValor()==0 && formato==true)
                horas.setValor(1);
        }
    }
    public void mostrarHorario(){
        if(formato == false){
            System.out.printf("%02d:", horas.getValor());
            System.out.printf("%02d", minutos.getValor());
            System.out.println();
        }
        else{
            System.out.printf("%02d:", horas.getValor());
            System.out.printf("%02d", minutos.getValor());
            if(horas.getValor()==12 && momento=="a.m" && minutos.getValor() == 0)
                momento = "p.m";
            else
                if(horas.getValor()==12 && momento== "p.m" && minutos.getValor()==0)
                    momento="a.m";
            System.out.println(" "+momento);            
        }
    }
}
