//Ryan Eduardo
package com.mycompany.relogio;


public class TestarRelogio {
    public static void main(String[] args){
        Relogio r = new Relogio(false);
        for(int i=0;i<24*60;i++){
           r.ticTac();
           r.mostrarHorario();
        }
    }
}
