#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define TAM 60

typedef struct numero{
    int num;
    int qnt;
}Numero;

void Ler(int v[TAM]){
    int i;
    FILE *arq;
    arq = fopen("Mega.txt","r");
        for(i=0;i<TAM;i++){
            fscanf(arq,"%d",&v[i]);
            fgetc(arq);
        }
}

void Preenche(Numero n[TAM],int v[TAM]){
    int i;
    for(i=0;i<TAM;i++)
        n[i].num = v[i];
}

void Contador(Numero v[TAM]){
    int i;
    int contador=0;
    for(i=0;i<TAM;i++)
        if(v[i].num<=60){
            for(int j=0;j<TAM;j++){
                if(v[i].num==v[j].num){
                    contador++;
                }
            }
                v[i].qnt=contador;
                contador=0;
        }
        else{
            v[i].qnt=0;
        }
}

void Repeticao(Numero n[TAM]){
    int i,j;
    for(i=0;i<TAM;i++)
        for(j=0;j<TAM;j++)
            if(j!=i&& n[j].num==n[i].num){
                n[j].qnt=0;
                n[j].num=100;
            }
}

void Ordena(Numero v[TAM]){
    Numero aux;
    for(int i=0;i<TAM;i++)
        for(int j=i+1;j<TAM;j++)
            if(v[i].qnt<v[j].qnt){
                aux = v[i];
                v[i] = v[j];
                v[j] = aux;
            }
}

void Imprime(Numero v[TAM]){
    int i;
    for(i=0;i<6;i++)
        printf("%d ",v[i].num);
    printf("\n");
}

int main(){
    int v[TAM];
    Numero n[TAM];
    Ler(v);
    Preenche(n,v);
    Contador(n);
    Repeticao(n);
    Ordena(n);
    Imprime(n);
}