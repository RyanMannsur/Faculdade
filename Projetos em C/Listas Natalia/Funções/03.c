#include <stdio.h>
#include <stdlib.h>
//Atividade 03

int maior(int a, int b, int c){
    if(a>=b && a>=c)
        return a;
    else
        if(b>=a && b>=c)
            return b;
        else
            return c;
}

int main()
{
    int a,b,c;
    printf("Digite 3 numeros inteiros: ");
    scanf("%d %d %d",&a,&b,&c);
    printf("O maior deles e: %d\n",maior(a,b,c));

}