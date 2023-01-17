#include <stdio.h>
#include <string.h>

void DataExtenso(char str[]){
    char dia[30],ano[15],mes[50];
    int i,j;
    if(str[3]== '0')
        switch(str[4]){
            case '1': strcpy(mes,"/Janeito/"); break;
            case '2': strcpy(mes,"/Fevereiro/"); break;
            case '3': strcpy(mes,"/Marco/"); break;
            case '4': strcpy(mes,"/Abril/"); break;
            case '5': strcpy(mes,"/Maio/"); break;
            case '6': strcpy(mes,"/Junho/"); break;
            case '7': strcpy(mes,"/Julho/"); break;
            case '8': strcpy(mes,"/Agosto/"); break;
            case '9': strcpy(mes,"/Setembro/"); break;
        }
    else
        switch(str[4]){
            case '0': strcpy(mes,"/Outubro/"); break;
            case '1': strcpy(mes,"/Novembro/"); break;
            case '2': strcpy(mes,"/Dezembro/"); break;
        }
    for(i=0;i<2;i++)
        dia[i]=str[i];
    dia[i] = '\0';
    strcat(dia,mes);
    for(i=6,j=0;str[i]!='\0';i++,j++)
        ano[j]=str[i];
    ano[j] = '\0';
    strcat(dia,ano);
    strcpy(str,dia);
}

int main(){
    char data[100];
    printf("Digite a data: ");
    fgets(data,100,stdin);
    DataExtenso(data);
    puts(data);
}