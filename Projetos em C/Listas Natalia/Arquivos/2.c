#include <stdio.h>
#include <stdlib.h>

int main(){
    FILE *f;
    char str[100];
    int i;
    f = fopen("Atv2.txt","w");
    if(f == NULL){
        printf("Erro ao abrir o arquivo\n");
        return 0;
    }
    printf("Digite uma frase: ");
    fgets(str,100,stdin);
    for(i=0;str[i]!='\0';i++)
        fputc(str[i],f);
    fclose(f);
}