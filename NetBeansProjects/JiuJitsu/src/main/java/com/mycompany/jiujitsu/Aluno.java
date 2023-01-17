
package com.mycompany.jiujitsu;


public class Aluno {
    private String nome;
    private String sexo;
    private String telefone;
    private int idade;
    private double peso;
    private double altura;
    public Aluno(String nome, String sexo, String telefone, int idade, double peso, double altura){
        this.nome = nome;
        this.sexo = sexo;
        this.telefone = telefone;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
    }
    public Aluno(String nome,String sexo,int idade){
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    public void setSexo(String sexo){
        this.sexo = sexo;
    }
    public String getSexo(){
        return sexo;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    public String getTelefone(){
        return telefone;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
    public int getIdade(){
        return idade;
    }
    public void setPeso(double peso){
        this.peso = peso;
    }
    public double getPeso(){
        return peso;
    }
    public void setAltura(double altura){
        this.altura = altura;
    }
    public double getAltura(){
        return altura;
    }
}
