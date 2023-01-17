#include <stdio.h>
#include <stdlib.h>

int main(){
  
int a;
    printf("Digite um numero da tabela valido de 32 a 127: ");
    scanf("%d",&a);
   if(a>=32 && a<=127) 
    printf("%d , %c\n",a,a);
       else
        printf("Numero invalido\n");
}