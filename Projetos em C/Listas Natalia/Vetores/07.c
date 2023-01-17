#include <stdio.h>

#define TAM 10

//Atividade 07
void Preencher(float v[]){
    int i;
    for(i=0;i<TAM;i++)
        scanf(" %f",&v[i]);
}

float max(float v[],int n){
    int i;
    float maior;
    for(i=0;i<n;i++)
        if(i==0|| maior<v[i])
            maior=v[i];
    return maior;
}

int main(){
    float v[TAM];
    int n;
    float maior;
    printf("Digite os numeros:\n");
    Preencher(v);
    printf("\nDigite o n menor que %d: ", TAM);
    scanf("%d",&n);
    maior=max(v,n);
    printf("O maior entre os n elementos e: %.2f\n", maior);
}