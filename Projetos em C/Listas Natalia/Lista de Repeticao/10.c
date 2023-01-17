#include <stdio.h>
#include <stdlib.h>
//Atividade 10
int main(){
    int i,n, impar,par, fit;
    printf("Digite o termo da sequecia: ");
    scanf("%d", &n);
    for(i=1;i<=n;i++){
        if(i==1 || i==2){
            fit = 1;
            impar=par=fit=1;
        }
        else{
            if(i%2==0){
                fit=impar+par;
                par=fit;
            }
            else{
                fit=impar+par;
                impar=fit;
            }
        }
    }
    printf("O termo %d, equivale ao numero: %d\n", n,fit);

}