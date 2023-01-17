#include <stdio.h>

//Atividade 06
void Preencher(int v[]){
    int i;
    for(i=0;i<10;i++)
        scanf(" %d",&v[i]);
}

int Interseccao(int v[], int u[], int w[]){
    int i,j, contador = 0;
    for(i=0;i<10;i++)
        for(j=0;j<10;j++)
            if(v[i]==u[j]){
                w[contador] = v[i];
                contador++;
        }
    return contador;
}

void Imprimir(int v[], int contador){
    int i;
    for(i=0;i<contador;i++)
        printf("%d\n",v[i]);
}

int main(){
    int v[10];
    int u[10];
    int w[20], tam;
    printf("Preecher o primeiro vetor:\n");
    Preencher(v);
    printf("\nPreencha o segundo vetor:\n");
    Preencher(u);
    tam = Interseccao(v,u,w);
    printf("\nInterseccao dos vetores:\n");
    Imprimir(w, tam);
}