#include <stdio.h>

void strlwr(char s[]){
    int i;
    for(i=0;s[i]!='\0';i++)
        if(s[i]>=65 && s[i]<=90)
            s[i] = s[i] + 32;
   
}

int main(){
    char str[100];
    printf("Digite a frase: ");
    fgets(str,100,stdin);
    strlwr(str);
    printf("\nString minuscula: ");
    puts(str);
}