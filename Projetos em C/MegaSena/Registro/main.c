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
    Conta c[MAX_CONTAS];
    int menu = 1,i = 0, aux = 0, j;
    float maior,menor;
    long int v[MAX_CONTAS], ex;
    while(menu==1 || menu == 5){
        Asteristicos();
        printf("0.Sair\n1.Cadastrar nova conta\n2.Visualizartodas as contas\n");
        printf("3.Mostar informacoes da conta com maior saldo\n4.Mostrar conta com menor saldo\n");
        printf("5.Excluir conta\n");
        Asteristicos();
        scanf("%d", &menu);
        getchar();
        if(menu==1){
            printf("\nDigite o numero da conta: ");
            scanf("%ld",&c[i].numero);
            for(j=0;j<aux;j++)
                if(v[j] == c[i].numero){
                    getchar();
                    printf("Numero de conta invalido,Digite novamente: ");
                    scanf("%ld",&c[i].numero);
                    j = -1;
                }
            getchar();
            printf("Digite o nome do cliente: ");
            fgets(c[i].nome,100,stdin);
            printf("Digite o saldo: ");
            scanf("%f",&c[i].saldo);
            getchar();
            printf("\n");
            aux++;
            if(i==0||maior<c[i].saldo)
                maior = c[i].saldo;
            if(i==0||menor>c[i].saldo)
                menor = c[i].saldo;
            v[i] = c[i].numero;
            i++;
        }
    printf("\n");
        if(menu == 5){
            if(i==0)
                printf("\nNao ha conta para excluir\n\n");
            else{
                printf("Digite o numero conta que deseja excluir: ");
                scanf("%ld",&ex);
                getchar();
            }
        }
    }
    if(menu==2){
        Asteristicos();
        printf("Contas Digitadas\n");
        Asteristicos();
        for(i=0;i<aux;i++)
            if(c[i].numero != ex)
                printf("\nConta: %ld\nNome: %sSaldo: %.2f\n",c[i].numero,c[i].nome,c[i].saldo);
    }
    else
        if(menu==3){
            Asteristicos();
            printf("Maior saldo\n");
            Asteristicos();
            for(i=0;i<aux;i++)
                if(maior == c[i].saldo)
                    printf("\nConta: %ld\nNome: %sSaldo: %.2f\n",c[i].numero,c[i].nome,c[i].saldo);
        }
        else
            if(menu==4){
                Asteristicos();
                printf("Menor saldo\n");
                Asteristicos();
                for(i=0;i<aux;i++)
                    if(menor == c[i].saldo)
                        printf("\nConta: %ld\nNome: %sSaldo: %.2f\n",c[i].numero,c[i].nome,c[i].saldo);
            }
}