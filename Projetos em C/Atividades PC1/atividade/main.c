#include <stdio.h>
#define TAM 25

typedef struct ALUNO{
    int matricula;
    int serie;
    int rec;
} Aluno;

void Ordena(Aluno p[]){
    Aluno aux;
    int i,j;
    for(i=0;i<TAM;i++)
        for(j=i+1;j<TAM;j++)
            if(p[i].matricula>p[j].matricula){
                aux = p[i];
                p[i] = p[j];
                p[j] = aux;
    }
}

int main(){
    Aluno p[TAM];
    int i;
    float valor,perc;
    for(i=0;i<TAM;i++){
        printf("Digite o numero de matricula: ");
        scanf(" %d",&p[i].matricula);
        printf("Digite o codigo da serie: ");
        scanf(" %d",&p[i].serie);
        printf("Digite o numero de recuperacoes: ");
        scanf(" %d",&p[i].rec);
        printf("\n");
    }
    Ordena(p);
    printf("\nMatricula    Novo valor\n");
    for(i=0;i<TAM;i++){
        if(p[i].serie == 1)
            valor = 707.37;
        else
            if(p[i].serie<=3)
                valor = 750.0;
            else
                if(p[i].serie<=8)
                    valor = 688.43;
                else
                    if(p[i].serie<=12)
                        valor = 694.10;
                    else
                        if(p[i].serie<=14)
                            valor = 808.95;
                        else
                            valor = 860.29;
        if(p[i].serie<=12 && p[i].serie>3)
            perc = valor * (0.10 * p[i].rec);
        else
            if(p[i].serie<=15)
                perc = valor * (0.15 * p[i].rec);
        if(p[i].rec!=0){
            printf("%9d    ", p[i].matricula);
            printf("R$ %.2f\n", perc+valor);
        }
    }
}