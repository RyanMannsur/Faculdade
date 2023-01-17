#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define TAM 90

void preenche(int v[]){
    int i;
    for(i=0;i<6;i++)
        v[i] = 1+rand()%60;
}

void repeticao(int v[]){
    int i,j;
    for(i=0;i<6;i++)
        for(j=0;j<6;j++)
            if(v[i] == v[j] && i!=j){
                v[i] = 1+rand()%60;
                i=j=0;
            }
}

void ordena(int v[]){
    int i,j;
    int aux;
    for(i=0;i<6;i++)
        for(j=i+1;j<6;j++)
            if(v[i]>v[j]){
                aux = v[i];
                v[i] = v[j];
                v[j] = aux;
            }
}

void imprime(int v[]){
    int i;
    for(i=0;i<6;i++)
        printf("%d ",v[i]);
    printf("\n");
}

void guarda(int v[]){
    int i;
    FILE *arq;
    arq = fopen("Mega.txt","a");
    for(i=0;i<6;i++)
        fprintf(arq,"%d ",v[i]);
    fprintf(arq,"\n");
    fclose(arq);
}

int main(){
    int v[6];
    srand(time(0));
    printf("\nNumeros Sorteados:\n");
    for(int i=0;i<TAM;i++){
        preenche(v);
        repeticao(v);
        ordena(v);
        imprime(v);
        guarda(v);
    }
}