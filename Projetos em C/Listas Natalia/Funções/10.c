#include <stdio.h>
#include <stdlib.h>
//Atividade 10

float altura(float g, float v, float tempo){
 float h; //altura que a bola atingirá
 h = v * tempo - g*tempo*tempo*0.5;
 return h;
}

float velocidade(float g, float v, float tempo){
 float vf; //velocidade final da bola
 vf = v - g*tempo;
 return vf;
}

void imprime(float altura, float velocidade, float t){
  printf("A   velocidade   da   bola   no   instante   %f   e   %f   e   a   altura   e   %f\n",   t,
velocidade, altura);
}

int main(){
    float gravidade, vel_inicial, inst;
    float vel,h;
    
    printf("Digite a gravidade: ");             scanf("%f", &gravidade);
    printf("Digite a velocidade inicial: ");    scanf("%f", &vel_inicial);
    printf("Digite o instante: ");             scanf("%f", &inst);
    
    h = altura(gravidade,vel_inicial,inst);
    vel = velocidade(gravidade,vel_inicial,inst);
    
    imprime(h,vel,inst);
}