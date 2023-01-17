#include <stdio.h>

//Atividade 01
void Preencher(int v[]){
    int i;
    for(i=0;i<6;i++)
        scanf(" %d",&v[i]);
}

void Pares(int v[]){
    int i;
    for(i=0;i<6;i++)
        if(v[i]%2==0)
            printf(" %d",v[i]);
}

void Impares(int v[]){
    int i;
    for(i=0;i<6;i++)
        if(v[i]%2!=0)
            printf(" %d",v[i]);
}

int ContPar(int v[]){
    int i, contador=0;
    for(i=0;i<6;i++)
        if(v[i]%2==0)
            contador++;
    return contador;
}

int ContImpar(int v[]){ 
    int i, contador=0;
    for(i=0;i<6;i++)
        if(v[i]%2!=0)
            contador++;
    return contador;
}       

int main(){
    int v[6];
    printf("Digite seis numeros:\n ");
    Preencher(v);
    printf("\nNumeros pares:");
    Pares(v);
    printf("\nNumeros impares:");
    Impares(v);
    printf("\nTem no total de %d numeros pares e %d impares\n ", ContPar(v), ContImpar(v));
}