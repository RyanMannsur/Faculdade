#include <stdio.h>
#include <math.h>
//Atividade 11
int main(){
    int n,i;
    float x, s=1.0;
    printf("Digite um numero inteiro e um real: ");
    scanf("%d %f",&n,&x);
        for(i=2;i<=n;i++)
            s=s+(i/pow(x,i));
    printf("O resultado e: %.3f\n", s);

}