#include <stdio.h>
#include <stdlib.h>
//Atividade 01
int main(){
    int n,divisor;
    printf("Digite um Numero: ");
    scanf("%d", &n);
    if(n==0){
        printf("Nao existe divisores pra esse numero\n");
        return 0;
    }
    if(n<0)
        n=n*-1;
    printf("Divisores desse numero sao: ");
    for(divisor=1;divisor<=n;divisor++){
        if(n%divisor==0)
            printf("%d ",divisor);
    }
    printf("\n");
}