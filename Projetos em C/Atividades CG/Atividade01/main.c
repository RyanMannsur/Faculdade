#include <stdio.h>

int mdc(int a, int b){
    int num;
    if(a%2==0 && b%2==0){
        if(a>=b){
            num = (a/2) - (b/2);
        }
        else{
            num = (b/2) - (a/2);
        }
    }
    else{
        num = mdc(a+1,b+1);
    }
    return num;
}

int main(){
    int a,b;
    printf("Digite dois numeros inteiros: ");
    scanf("%d %d", &a , &b);
    printf("Resultado: %d",mdc( a,  b));
}
