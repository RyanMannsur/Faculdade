#include <stdio.h>
#include <stdlib.h>
//Atividade 07

int x_isdigit(int x){
    if((x>=48 && x<=57))
        return 1;
    else
        return 0;
}

int main()
{
    char x;
    printf("Digite um caracter: ");
    scanf("%c",&x);
    if(x_isdigit(x))
        printf("Esse caracter e um digito\n");
    else
        printf("Esse caracter nao e um digito\n");
}