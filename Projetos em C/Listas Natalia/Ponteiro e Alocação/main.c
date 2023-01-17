#include <stdio.h>
#include <string.h>

int main(){
    FILE *f;
    int i;
    char str1[300],str2[100],str3[100];
    f = fopen("Questao123.txt","w");
    if(f == NULL){
        printf("Arquivo nao pode ser aberto\n");
        return 0;
    }
    printf("Responda a 1: ");
    fgets(str1,300,stdin);
    printf("Responda a 2: ");
    fgets(str2,100,stdin);
    printf("Responda a 3: ");
    fgets(str3,100,stdin);
    strcat(str1,str2);
    strcat(str1,str3);
    for(i=0;str1[i]!='\0';i++)
        putc(str1[i],f);
    fclose(f);
}