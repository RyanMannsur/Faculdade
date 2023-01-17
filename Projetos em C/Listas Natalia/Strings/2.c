#include <stdio.h>
#include <string.h>


void Inverte(char str[]){
    char aux[100];
    int i,tam;
    strcpy(aux,str);
    tam = strlen(str);
    tam--;
    for(i=0;aux[i]!='\0';i++){
        str[tam]=aux[i];
        tam--;
    }
}

void TrocaCons(char str[], char c){
    int i;
    for(i=0;str[i]!='\n';i++){
        switch (str[i]){
            case 'a': break;
            case 'e': break;
            case 'i': break;
            case 'o': break;
            case 'u': break;
            case 'A': break;
            case 'E': break;
            case 'I': break;
            case 'O': break;
            case 'U': break;
            case ' ': break;
            default: str[i]=c;
        }
    }
}

int main(){
    char str[100];
    printf("Digite a frase: ");
    fgets(str,100,stdin);
    TrocaCons(str,'#');
    Inverte(str);
    puts(str);
}