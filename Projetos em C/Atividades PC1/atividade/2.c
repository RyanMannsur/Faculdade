#include <stdio.h>

void Respostas(char v[]){
    int i;
    for(i=0;i<10;i++){
        scanf(" %c",&v[i]);
    }
}

int CalculaNota(char v[],char paran[]){
    int i,contador=0;
    for(i=0;i<10;i++){
        if(v[i] == paran[i])
            contador++;
    }
    return contador;
}

void NotaAluno(int nota[],int j, char gabarito[]){
    char v[j];
    int i;
    for(i=0;i<j;i++){
        printf("Digite as respostas do aluno %d: ", i+1);
        Respostas(v);
        nota[i] = CalculaNota(v,gabarito);
    }
}

void linha(){
    int i;
    for(i=0;i<10;i++)
        printf("*");
}
void imprimir(int nota[],int j){  
    int i;
    for(i=0;i<j;i++)
        printf("Aluno %d: %d\n",i+1, nota[i]);
}
    
int main(){
    int alunos;
    char gabarito[10];
    printf("Digite o gabarito da prova: ");
    Respostas(gabarito);
    printf("Digite o numero de alunos: ");
    scanf("%d",&alunos);
    int nota[alunos];
    
    NotaAluno(nota,alunos,gabarito);
    linha();
    printf("\nResultado:\n");
    linha();
    printf("\n");
    imprimir(nota,alunos);
}