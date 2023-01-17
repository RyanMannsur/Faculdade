#include <stdio.h>
#include <stdlib.h>
#include <math.h>

void onze(){
    int n,i;
    float x, s=1.0;
    printf("\n\n11\n\nSomatoria\n\n");
    printf("Digite um numero inteiro e um real: ");
    scanf("%d %f",&n,&x);
        for(i=2;i<=n;i++)
            s=s+(i/pow(x,i));
    printf("O resultado e: %.3f\n", s);

}


void dez(){
    int i,n, impar,par, fit;
    printf("\n\n10\n\nSequencia fibonacci\n\n");
    printf("Digite o termo da sequecia: ");
    scanf("%d", &n);
    for(i=1;i<=n;i++){
        if(i==1 || i==2){
            fit = 1;
            impar=par=fit=1;
        }
        else{
            if(i%2==0){
                fit=impar+par;
                par=fit;
            }
            else{
                fit=impar+par;
                impar=fit;
            }
        }
    }
    printf("O termo %d, equivale ao numero: %d\n", n,fit);

}


void oito(){
    printf("\n\n08\n\nResposta da 08\n\n");
    printf("\nA) 20 Vezes\nB) 10 Vezes\nC) 40 Vezes\nD) 10 Vezes\nE) 6 Vezes\n");
}


void tres(){
    int n, contador,i, primos=0, contador_primo=0;
    printf("\n\n03\n\nNumeros primos\n\n");
    printf("Digite 25 numeros:\n");
    for(i=0;i<10;i++){
        scanf("%d", &n);
        for(contador=1;contador<=n;contador++){
            if(n%contador==0)
                contador_primo++;
        
            if(contador==n){
                if(contador_primo<=2)
                    primos++;
            contador_primo=0;
            }

        }
    }
    printf("Quantidade de numeros primos e: %d\n", primos);
}

void dois(){
    int idade,i, cont_idade = 0, cont_media = 0, cont_peso = 0;
    float altura, peso, soma = 0, media,percent;
    printf("\n\n02\n\nMedia de peso e idade\n\n");
    for(i=0;i<25;i++){
        printf("Digite a idade, a altura e o peso: ");
        scanf("%d %f %f", &idade, &altura, &peso);
        if(idade==0 && peso==0 && altura == 0)
            break;
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

//Atividade 01
int main(){
    int n,divisor;
    printf("\n\n01\nDivisores\n\n");
    printf("Digite um Numero: ");
    scanf("%d", &n);
    if(n==0){
        printf("Nao existe divisores pra esse numero\n");
        return 0;
    }
    if(n<0)
        n=n*-1;
    printf("Divisores desse numero sao: ");
    for(divisor=1;divisor<=n;divisor++){
        if(n%divisor==0)
            printf("%d ",divisor);
    }
    printf("\n");
    dois();
    tres();
    oito();
    dez();
    onze();
}
