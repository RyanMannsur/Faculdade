//Ryan Eduardo
package com.mycompany.jiujitsu;

import java.util.Scanner;


public class Teste {
    public static void main(String[] args){
        
        Turma turma1 = new Turma("Manha","Feminino",9,12,20);
        Turma turma2 = new Turma("Tarde","Feminino",13,18,20);
        Turma turma3 = new Turma("Noite","Feminino",19,30,20);
        Turma turma4 = new Turma("Manha","Masculino",9,12,20);
        Turma turma5 = new Turma("Tarde","Masculino",13,18,20);
        Turma turma6 = new Turma("Noite","Masculino",19,30,20);
        
        for(int i=0;i<10;i++){
            String[] nomes = {"Ryan","Maria","Gabriel","Jose","Joana",
                               "Lucia","Daniela","Eduardo","Vitor","Joao"};
        
            int[] idade = {19,10,40,8,15,16,24,11,17,12};
            
            String[] sexo = {"Masculino","Feminino","Masculino","Masculino","Feminino","Feminino","Feminino",
                             "Masculino","Masculino","Masculino"};
            
            Aluno pessoa = new Aluno(nomes[i],sexo[i],idade[i]);
            
            turma1.matricularAluno(pessoa);
            turma2.matricularAluno(pessoa);
            turma3.matricularAluno(pessoa);
            turma4.matricularAluno(pessoa);
            turma5.matricularAluno(pessoa);
            turma6.matricularAluno(pessoa);
        }   //fim do for                
        
        turma1.listarAlunosMatriculados();
        turma2.listarAlunosMatriculados();
        turma3.listarAlunosMatriculados();
        turma4.listarAlunosMatriculados();
        turma5.listarAlunosMatriculados();
        turma6.listarAlunosMatriculados();
    }
}
