#include <stdio.h>
#include <stdlib.h>
//Atividade 02

int TestarLetra(int c){
    if((c>=65 && c<=90) || (c>=97 && c<=122))
        return 1;
    else
        return 0;
}

int main()
{
    char c;
    printf("Digite um caracter: ");
    scanf("%c",&c);
    if(TestarLetra(c))
        printf("Letra do alfabeto\n");
    else
        printf("Caracter fora do alfabeto");
}