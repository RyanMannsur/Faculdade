#include <stdio.h>

// Atividade 08
#define L 10
#define C 10

void preencher(int m[][C]){
    int i,j;
    for(i=0;i<L;i++)
        for(j=0;j<C;j++){
            printf("Posicao [%d][%d]: ",i,j);
            scanf(" %d",&m[i][j]);
        }
}

int MaiorElemento(int m[][C]){
    int i,j;
    int maior;
    for(i=0;i<L;i++)
        for(j=0;j<C;j++)
            if((i==0 && j==0) || m[i][j]>maior)
                maior = m[i][j];
    return maior;
}

int main(){
    int m[L][C];
    printf("Digite os elementos da matriz:\n");
    preencher(m);
    printf("Maior elemento: %d\n", MaiorElemento(m));
}