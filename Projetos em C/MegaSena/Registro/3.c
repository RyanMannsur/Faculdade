#include <stdio.h>
#define MAX_CONTAS 100

typedef struct CONTA{
    long int numero;
    char nome[100];
    float saldo;
} Conta;

void Asteristicos(){
    int i;
    for(i=0;i<20;i++)
        printf("*");
    printf("\n");
}

int main(){
    int i,j;
    Conta p[MAX_CONTAS];
    long int v[MAX_CONTAS];
    for(i=0;i<MAX_CONTAS;i++){
        printf("Digite o numero da conta: ");
        scanf("%ld",&p[i].numero);
        for(j=0;j<aux;j++)
            if(v[j] == p[i].numero){
                getchar();
                printf("Numero de conta invalido,Digite novamente: ");
                    scanf("%ld",&p[i].numero);
                    j = -1;
            }
        getchar();
        printf("Digite o nome do cliente: ");
        fgets(p[i].nome,100,stdin);
        printf("Digite o saldo: ");
        scanf("%f",&p[i].saldo);
        getchar();
        v[i] = p[i].numero;
        printf("\n");
    }
    Asteristicos();
    printf("Contas Digitadas\n");
    Asteristicos();
    for(i=0;i<MAX_CONTAS;i++)
        printf("\nConta: %ld\nNome: %sSaldo: %.2f\n",p[i].numero,p[i].nome,p[i].saldo);
}