#include <stdio.h>
#include <stdlib.h>
//Atividade 02
int main(){
    int idade,i, cont_idade = 0, cont_media = 0, cont_peso = 0;
    float altura, peso, soma = 0, media,percent;
    for(i=0;i<25;i++){
        printf("Digite a idade, a altura e o peso: ");
        scanf("%d %f %f", &idade, &altura, &peso);  
        if(idade>50)
            cont_idade++;
        if(idade<=20 && idade>=10){
            soma = soma + altura;
            cont_media++;
        }
        if(peso<40)
            cont_peso++;
    }
    media = soma/cont_media;
    percent = (cont_peso*100)/25;
    printf("Pessoas com mais de 50 anos: %d\n", cont_idade);
    printf("Media de altura das pessoas entre 10 e 20 anos: %f\n", media);
    printf("Porcentagem de pessoas com menos de 40kg: %f\n", percent);
}