#include <stdio.h>

//Atividade 02
void Preencher(int v[]){
    int i;
    for(i=0;i<10;i++)
        scanf(" %d",&v[i]);
}

void Multiplica(int v[],int u[],int w[]){
    int i;
    for(i=0;i<10;i++)
        w[i] = v[i]*u[i];
}

void Imprimir(int v[], int u[], int w[]){
    int i;
    for(i=0;i<10;i++)
        printf(" %d * %d = %d\n",v[i], u[i], w[i]);
}

int main(){
    int v[10];
    int u[10];
    int w[10];
    printf("Preecher o primeiro vetor:\n");
    Preencher(v);
    printf("\nPreencha o segundo vetor:\n");
    Preencher(u);
    Multiplica(v,u,w);
    Imprimir(v,u,w);
}