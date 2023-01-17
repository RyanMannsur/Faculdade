#include <stdio.h>

// Atividade 01
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

int main(){
    int m[L][C];
    int maior,menor,lmaior,cmaior,lmenor,cmenor;
    printf("Digite os elementos da matriz:\n");
    preencher(m);
    for(int i=0;i<L;i++)
        for(int j=0;j<C;j++){
            if((i==0 && j==0) || m[i][j]>maior){
                maior = m[i][j];
                lmaior = i;
                cmaior = j;
            }
            if((i==0 && j==0) || m[i][j]<menor){
                menor = m[i][j];
                lmenor = i;
                cmenor = j;
            }
        }
    printf("Maior elemento: [%d][%d] %d\n", lmaior,cmaior,maior);
    printf("Menor elemento: [%d][%d] %d\n", lmenor,cmenor,menor);
}