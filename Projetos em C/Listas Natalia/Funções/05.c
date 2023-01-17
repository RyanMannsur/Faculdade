#include <stdio.h>
#include <stdlib.h>
//Atividade 05

int CalculaSeg(int h, int m, int s){
    int seg = 0;
    seg = s+(m*60)+(h*60)*60;
    return seg;

}

int main()
{
    int hora,min,seg;
    printf("Digite as horas, minutos e segundos: ");
    scanf("%d %d %d",&hora, &min, &seg);
    printf("%dH%dMin%ds e o mesmo que %d segundos\n",hora,min,seg,CalculaSeg(hora,min,seg));
}