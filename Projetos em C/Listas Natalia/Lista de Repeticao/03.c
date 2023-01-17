#include <stdio.h>
#include <stdlib.h>
//Atividade 03
int main(){
    int n, contador,i, primos=0, contador_primo=0;
    printf("Digite 25 numeros:\n");
    for(i=0;i<10;i++){
        scanf("%d", &n);
        for(contador=1;contador<=n;contador++){
            if(n%contador==0)
                contador_primo++;
        
            if(contador==n){
                if(contador_primo<=2)
                    primos++;
            contador_primo=0;
            }

        }
    }
    printf("Quantidade de numeros primos e: %d\n", primos);
}