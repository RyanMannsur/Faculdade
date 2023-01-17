#include <stdio.h>

// Atividade 03
#define L 5
#define C 5

void preencher(float m[][C]){
    int i,j;
    for(i=0;i<L;i++)
        for(j=0;j<C;j++){
            printf("Posicao [%d][%d]: ",i,j);
            scanf(" %f",&m[i][j]);
        }
}

void Diagonal(float m[][C]){
    int i,j;
    float soma = 0;
    int aux = 0;
    for(i=0;i<L;i++){
        for(j=0;j<C;j++){
            if((i==aux && j==aux)){
                soma = soma+m[i][j];
                aux++;
            } 
        }
    }
    printf("A soma da diagonal principal e: %.3f\n", soma);
}

int main(){
    float m[L][C];
    printf("Digite os elementos da matriz:\n");
    preencher(m);
    Diagonal(m);
}