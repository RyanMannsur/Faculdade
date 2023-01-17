#include <stdio.h>

void preencher(int m[][3]){
    int i,j;
    for(i=0;i<3;i++)
        for(j=0;j<3;j++)
            scanf(" %d",&m[i][j]);

}

void repeticoes(int m[][3],int num){
    int i,j;
    int aux=0;
    for(i=0;i<3;i++)
        for(j=0;j<3;j++)
            if(m[i][j]==num)
                aux++;
    printf("Repeticoes: %d\n",aux);
}

void posicoes(int m[][3],int num){
    int i,j;
    printf("Posicoes:\n");
    for(i=0;i<3;i++)
        for(j=0;j<3;j++)
            if(m[i][j]==num)
                printf("(%d, %d)\n",i,j);
}

int main(){
    int m[3][3];
    int num;
    printf("Digite os numeros da matriz:\n");
    preencher(m);
    printf("Digite o numero a ser procurado:\n");
    scanf("%d",&num);
    repeticoes(m,num);
    posicoes(m,num);
}