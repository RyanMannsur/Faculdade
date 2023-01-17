#include <stdio.h>


typedef struct CONTA{
    int numero;
    char nome[100];
    float saldo;
} Conta;

int main(){
    Conta p;
    printf("Digite o numero da conta: ");
    scanf("%d",&p.numero);
    getchar();
    printf("Digite seu nome: ");
    fgets(p.nome,100,stdin);
    printf("Digite seu saldo: ");
    scanf("%f",&p.saldo);
    printf("\nConta: %d\nNome: %sSaldo: %.2f\n",p.numero,p.nome,p.saldo);
}