#include <stdio.h>
#include <string.h>

int main(){
    FILE *f;
    char str[100];
    char nome[100];
    int i=0,contador=0;
    printf("Digite o nome do arquivo: ");
    fgets(nome,100,stdin);
    nome[strlen(nome)-1] = '\0';
    f = fopen(nome,"r");
    if(f == NULL){
        printf("Erro ao abrir o arquivo\n");
        return 0;
    }
    while(!feof(f)){
        str[i] = fgetc(f);
        i++;
    }
    str[i] = '\0';
    printf("Frase escrita no arquivo:\n");
    puts(str);
    for(i=0;str[i]!='\0';i++)
        if(str[i] == 'a' || str[i] == 'A')
            contador++;
    printf("Letra A presente no arquivo: %d\n",contador);
}