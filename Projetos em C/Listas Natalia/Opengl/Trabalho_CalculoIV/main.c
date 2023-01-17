#include <stdio.h>
#include <stdlib.h>
#include <math.h>

double fatorial(int n){ //Função que calcula fatorial
    if((n == 1) || (n == 0))
        return 1;
    else
        return (double)(n*fatorial(n-1));
    return 0.0;
}

double harmonica_alt(int n){//calculo da serie harmonica alternada
    double resultado = 0.0, result_ant = 0.0, aux = 0.0;
    double sinal = -1.0;
    for(int i=1;i<=n;i++){
        aux = (double)1/i;
        result_ant = resultado;
        resultado = (resultado+aux)*sinal;
        if((resultado-result_ant < 0.000001 && resultado-result_ant > 0.0) || 
            (resultado-result_ant > -0.000001 && resultado-result_ant < 0.0)){ //analise da estabilidade
            printf("Com n = %d, Resultado estabilizou em: %.10lf\n",i,resultado);
            //break;
        }
     }
    return resultado;
}

double serie_p2(int n){//Calculo da serie p = 2
    double resultado = 0.0, result_ant = 0.0;
    for(int i=1;i<=n;i++){
        result_ant = resultado;
        resultado = resultado + (1/pow(i,2));
        if((resultado-result_ant < 0.000001 && resultado-result_ant > 0.0) || 
            (resultado-result_ant > -0.000001 && resultado-result_ant < 0.0)){ //analise da estabilidade
            printf("Com n = %d, Resultado estabilizou em: %.10lf\n",i,resultado);
            //break;
        }
    }
    return resultado;
}

double fatorial_inv(int n){ // Calculo da serie inversa da fatorial
    double resultado = 0.0, result_ant = 0.0;
    double aux = 0.0;
    for(int i=0;i<=n;i++){
        aux = 1.0/fatorial(i);
        result_ant = resultado;
        resultado = resultado + aux;
        if((resultado-result_ant < 0.000001 && resultado-result_ant > 0.0) || 
            (resultado-result_ant > -0.000001 && resultado-result_ant < 0.0)){//analise da estabilidade
            printf("Com n = %d, Resultado estabilizou em: %.10lf\n",i,resultado);
            //break;
        }
    }
    return resultado;
}

int main(){ //Impressão na tela na main, para ficar mais intuitivo
    int n, escolha;
    while(escolha != 0){
    printf("Digite:\n1. Para harmonica alternada\n2. Para Serie p\n3. Para serie fatorial inversa\nDigite 0 para sair\n");
    scanf("%d",&escolha);
    if(escolha == 0)
        break;
    printf("Digite n vezes que ira somar:\n");
    scanf("%d",&n);
        if(escolha == 1)
            printf("\nResultado: %.10lf\n\n",harmonica_alt(n));
        else
            if(escolha == 2)
                printf("\nResultado: %.10lf\n\n",serie_p2(n));
            else
                if(escolha == 3)
                    printf("\nResultado: %.10lf\n\n",fatorial_inv(n));
                else
                    printf("Invalido\n\n");
    }
}