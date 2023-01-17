#include <stdio.h>

void corredores(float v[]){
    int i,num;
   
    for(i=0,num=1;i<15;i++,num++){
        printf("Digite o tempo do atleta %d (em segundos): ", num);
        scanf(" %f", &v[i]);
    }
    printf("\n");
}

int NumVenc(float v[]){
    int i, venc;
    float menor;
    for(i=0;i<15;i++){
        if(menor>v[i] || i==0){
            menor = v[i];
            if(i==0)
                venc = i;
            else
                venc = i+1;
        }
    }
    return venc;
}


float CalMedia(float v[]){
    int i;
    float soma=0, res;
    for(i=0;i<15;i++)
        soma=soma+v[i];
    res=soma/15;
    return res;
}

int Contador(float v[],float paran){
    int i,cont=0;
    for(i=0;i<15;i++){
        if(v[i]<paran)
            cont++;
    }
    return cont;
}

void linha(){
    int i;
    for(i=0;i<10;i++)
        printf("-");
}
    
int main()
{
    int i,num,abaixo;
    float media,corredor[15];
    corredores(corredor);
    num = NumVenc(corredor);
    media = CalMedia(corredor);
    abaixo = Contador(corredor,media);
    linha();
    printf("\nResultado\n");
    linha();
    printf("\nAtleta que venceu a corrida: %d\n", num);
    printf("Media dos tempos dos atletas: %f\n", media);
    printf("Quantidade de atletas com tempo menor que a media: %d\n",abaixo);
}