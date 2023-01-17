#include <stdio.h>
#include <string.h>

char n_esimo(char s[], int n){
    if(n<=strlen(s)-1 && n>0)
        return s[n-1];
    else
        return 0;
}

int main(){
    char str[100];
    int n;
    printf("Digite a frase: ");
    fgets(str,100,stdin);
    printf("Digite a posicao do caracter: ");
    scanf(" %d",&n);
    if(n_esimo(str,n))
        printf("O caracter e: '%c'\n", n_esimo(str,n));
    else
        printf("Nao existe esse caracter.\n");
}