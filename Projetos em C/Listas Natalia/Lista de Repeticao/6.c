#include <stdio.h>
#include <stdlib.h>
//Atividade 06
int main(){
    int n, maior=0,menor=0,i=1;
    while(n!=0){
        printf("\nDigite um numero: ");
        scanf("%d",&n);
        if(n<=0)
            printf("Numero Invalido\n");
        else{
            if(i==1)
                maior=menor=n;
            if(n>=maior)
                maior=n;
            if(n<=menor)
                menor=n;
        }
        i++;
    }
    printf("O maior numero foi: %d\nO menor numero foi: %d\n",maior,menor);
}