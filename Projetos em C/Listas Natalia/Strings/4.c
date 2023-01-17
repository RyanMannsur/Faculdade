#include <stdio.h>
#include <string.h>

int Verificar(char str[],char c){
    int i,contador = 0;
    for(i=0;str[i]!='\0';i++)
        if(str[i] == c)
            contador++;
    return contador;

}

int main(){
    char str[100],c;
    printf("Digite a frase: ");
    fgets(str,100,stdin);
    printf("Digite a letra a ser procurada: ");
    scanf(" %c",&c);
    if(Verificar(str,c))
        printf("A letra digitada se repete na frase: %d vezes\n", Verificar(str,c));
    else
        printf("A letra nao aparece na frase.\n");
}