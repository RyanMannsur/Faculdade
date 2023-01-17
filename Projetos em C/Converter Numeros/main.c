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
void Conversao(int num,char c){
    int i = 0,div,res;
    char str[300];
    if(c=='b')
        div=2;
    if(c=='o')
        div=8;
    if(c=='h')
        div=16;
    if(num<div){
        if(div==16)
            switch(num){
                case 10: str[i]='A'; break;
                case 11: str[i]='B'; break;
                case 12: str[i]='C'; break;
                case 13: str[i]='D'; break;
                case 14: str[i]='E'; break;
                case 15: str[i]='F'; break;
                default: str[i]=num+'0';
            }
        else
            str[i]=num+'0';
    }
    while(num>=div){
        res=num%div;
        num=num/div;
        if(div == 16 && (res>=10 && res<16))
            switch(res){
                case 10: str[i]='A'; break;
                case 11: str[i]='B'; break;
                case 12: str[i]='C'; break;
                case 13: str[i]='D'; break;
                case 14: str[i]='E'; break;
                case 15: str[i]='F'; break;
            }
        else
            str[i]=res+'0';
        i++;
        if(num<div)
            str[i]=num+'0';
    }

    i++;
    str[i] = '\0';
    Inverte(str);
    puts(str);
}

int main(){
    int num;
    char c;
    printf("Digite o numero e a letra de acordo com a conversao: ");
    scanf("%d %c",&num,&c);
    Conversao(num,c);
}
