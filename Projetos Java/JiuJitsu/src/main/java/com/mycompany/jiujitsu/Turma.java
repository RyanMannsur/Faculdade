
package com.mycompany.jiujitsu;


public class Turma {
    private String turno;
    private String sexo;
    private int idademin;
    private int idademax;
    private Aluno[] alunos;
    private int alunosMax;
    private int quantidadeAlunos;
    public Turma(String turno, String sexo, int idademin, int idademax,int alunosMax){
        this.turno = turno;
        this.sexo = sexo;
        this.idademin = idademin;
        this.idademax = idademax;
        this.alunos = new Aluno[alunosMax];
        this.alunosMax = alunosMax;
        this.quantidadeAlunos = 0;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdademin() {
        return idademin;
    }

    public void setIdademin(int idademin) {
        this.idademin = idademin;
    }

    public int getIdademax() {
        return idademax;
    }

    public void setIdademax(int idademax) {
        this.idademax = idademax;
    }

    public Aluno[] getAlunos() {
        return alunos;
    }

    public void setAlunos(Aluno aluno) {
        this.alunos[quantidadeAlunos] = aluno;
        quantidadeAlunos++;
    }
    
    public void matricularAluno(Aluno aluno){
        if(aluno.getSexo().equals(getSexo())&&
            aluno.getIdade()<= getIdademax()&&
            aluno.getIdade()>= getIdademin()){
            setAlunos(aluno);
        }
    }
    
    public void listarAlunosMatriculados(){
        System.out.println("Turma "+getTurno()+" "+getSexo()+":");
        for(int i=0;i<quantidadeAlunos;i++){
            System.out.println(""+alunos[i].getNome());
        }
        System.out.println();
    }
}
