#include <stdio.h>
#include <stdlib.h>

/****************

LAED1 - Problema da Mochila

Alunos(as): Anélio Gonçalves Caldas e Ryan Eduardo Mansur

Data: 24/02/2021

****************/

typedef struct itenDisponiveis
{
    int peso;
    int valor;
    float valorPorPeso;
} ItensDisponiveis;

int verificaMelhorSolucao(ItensDisponiveis itens[], int numItens, int pesoMaximo);
void reordenarVetor(ItensDisponiveis itens[], int numItens);
void tirarElemento(ItensDisponiveis itens[], int numItens, int indice);

int main(){
    FILE *f;
    char arquivo[20];
    int capacidadeMochila, numItensDisponiveis, pesoEscolha=0, valorEscolha=0, escolhido;
    printf("Digite o nome do arquivo: ");
    scanf("%s", arquivo);
    f = fopen(arquivo,"r");
    if(f == NULL){
        printf("Erro na leitura do arquivo\n");
        exit(1);
    }
    fscanf(f,"%d\n", &capacidadeMochila);
    fscanf(f,"%d\n",&numItensDisponiveis);

    ItensDisponiveis itens[numItensDisponiveis];

    for(int i=0; i<numItensDisponiveis; i++){
       fscanf(f,"%d ",&itens[i].peso);
       fscanf(f,"%d ",&itens[i].valor);
    }

    for(int i=0; i<numItensDisponiveis; i++){
        itens[i].valorPorPeso = (float) itens[i].valor/itens[i].peso;
    }

    for(int i=0;i<numItensDisponiveis;i++){
       fscanf(f,"%d ",&escolhido);
        if(escolhido){
            pesoEscolha += itens[i].peso;
            valorEscolha += itens[i].valor;
        }
    }
    fclose(f);
    //printf("peso da escolha = %d\nvalor da escolha = %d\n\n",pesoEscolha, valorEscolha);
    if(pesoEscolha > capacidadeMochila){
        printf("Solucao inviavel.\n");
    }
    else{
        if(valorEscolha < verificaMelhorSolucao(itens, numItensDisponiveis, pesoEscolha)){
            printf("Solucao viavel mas nao otima.\n");
        }
        else{
            printf("Solucao otima.");
        }
    }
}

int verificaMelhorSolucao(ItensDisponiveis itens[], int numItens, int pesoMaximo){
    int melhor;
    if(numItens == 1){
        return itens[0].valor;
    }
    reordenarVetor(itens, numItens);
    int maiorValor = itens[0].valor, indice=0, pesoTotal =0;
    maiorValor = itens[0].valor;
    pesoTotal = itens[0].peso;

    for(int i=0; i<numItens; i++){
        if(i != indice){
            if((pesoTotal + itens[i].peso) <= pesoMaximo){
                maiorValor += itens[i].valor;
                pesoTotal += itens[i].peso;
            }
        }
    }
    tirarElemento(itens, numItens, indice);
    melhor = verificaMelhorSolucao(itens, numItens-1, pesoMaximo);
    //printf("melhor = %d\n",melhor);
    if(maiorValor > melhor){
        return maiorValor;
    }
    return melhor;
}

void reordenarVetor(ItensDisponiveis itens[], int numItens){
    ItensDisponiveis aux;
    for(int i=0; i<numItens; i++){
        for (int j=i+1; j<numItens; j++){
            if(itens[i].valor < itens[j].valor){
                aux = itens[j];
                itens[j] = itens[i];
                itens[i] = aux;
            }
        }
    }
}

void tirarElemento(ItensDisponiveis itens[], int numItens, int indice){
    for(int i=indice; i<numItens-1; i++){
        itens[i] = itens[i+1];
    }
}