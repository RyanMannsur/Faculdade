#include <stdio.h>
#include <string.h>

typedef struct TESTE{
    char nome[50];
    int num1;
    int num2;
}teste;

int main(){
    teste a;
    char str[50];
    char *c;
    printf("Digite uma palavra: ");
    fgets(a.nome,20,stdin);
    a.nome[strlen(a.nome)-1] = '\0';
    printf("Digite um numero: ");
    scanf("%d",&a.num1);
    printf("Digite um numero: ");
    scanf("%d",&a.num2);
    c = &a.nome[0];
    while(*c!='\0'){
        printf("%c",*c);
        c++;
    }
}