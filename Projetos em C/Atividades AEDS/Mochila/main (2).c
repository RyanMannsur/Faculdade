#include <stdio.h>
#include <stdlib.h>

typedef struct item
{
    int peso;
    int valor;
} ITEM;

typedef struct Mochila
{
    ITEM itens[20];
    int capacidade;
    int itens_mochila;
} MOCHILA;


MOCHILA ler_arquivo(ITEM *itens_totais ,FILE *f, char *arquivo){ // função que ler o arquivo
    int num_itens;
    MOCHILA m;
    m.itens_mochila = 0;
    int i;
    int situacao = 0;
    f = fopen(arquivo,"r");
    if(f == NULL){
        printf("Erro na leitura do arquivo\n");
        exit(1);
    }
    fscanf(f,"%d\n", &m.capacidade); //jogo fora o numero de fileiras
    fscanf(f,"%d\n",&num_itens); //quantidade de itens no arquivo

    for(i=0;i<num_itens;i++){
       fscanf(f,"%d ",&itens_totais[i].peso);
       fscanf(f,"%d ",&itens_totais[i].valor);
    }
    for(i=0;i<num_itens;i++){
       fscanf(f,"%d ",&situacao);
        if(situacao){
            m.itens[m.itens_mochila] = itens_totais[i];
            m.itens_mochila++;
        }
    }
    fclose(f);
    return m;
}

int main(){
    FILE *f = NULL;
    MOCHILA m;
    ITEM itens_totais[20];
    char arquivo[20];
    printf("Digite o nome do arquivo de entrada: ");
    scanf("%s",arquivo);
    m = ler_arquivo(itens_totais,f,arquivo);
}