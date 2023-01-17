#include <stdio.h>

// Atividade 10
#define L 5
#define C 5

void preencher(int m[][C]){
    int i,j;
    for(i=0;i<L;i++)
        for(j=0;j<C;j++){
            printf("Posicao [%d][%d]: ",i,j);
            scanf(" %d",&m[i][j]);
        }
}

int Procura(int x,int m[][C]){
    int i,j;
    int aux = 0;
        for(i=0;i<L;i++)
            for(j=0;j<C;j++)
                if((x == m[i][j]))
                    aux++;
    return aux;
}

int main(){
    int m[L][C];
    int num;
    printf("Digite os elementos da matriz:\n");
    preencher(m);
    printf("Digite um numero: ");
    scanf("%d",&num);
    printf("O numero %d se repete %d vezes\n", num, Procura(num,m));
}