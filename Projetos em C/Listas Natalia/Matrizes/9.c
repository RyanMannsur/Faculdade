#include <stdio.h>

// Atividade 09
#define L 2
#define C 2

void preencher(float m[][C]){
    int i,j;
    for(i=0;i<L;i++)
        for(j=0;j<C;j++){
            printf("Posicao [%d][%d]: ",i,j);
            scanf(" %f",&m[i][j]);
        }
}

float Determinante(float m[][C]){
    int res;
    res = (m[0][0]*m[1][1])+(-1*(m[0][1]*m[1][0]));
    return res;
}

int main(){
    float m[L][C];
    printf("Digite os elementos da matriz:\n");
    preencher(m);
    printf("Determinante e: %.2f\n", Determinante(m));
}