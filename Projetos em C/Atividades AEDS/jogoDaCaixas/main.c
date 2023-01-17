#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Caixa
{
    int fileira;
    int caixa;
    int posicao;
} CAIXA;

int tamanho_da_caixa(FILE *f, char *arquivo){ //função que define o tamanho do vetor caixa
    int tamanho;
    f = fopen(arquivo,"r");
    if(f == NULL){
        printf("Erro na leitura do arquivo\n");
        return 0;
    }
    fscanf(f,"%d\n",&tamanho);
    for(int j=tamanho-1;j!=0;j--){
        tamanho = tamanho+j;
    }
    fclose(f);
    return tamanho;
}

void ler_arquivo(CAIXA *c, int tamanho, FILE *f, char *arquivo){ // função que ler o arquivo e coloca no vetor caixa
    int i,fileira = 1, contador_de_fileiras = 1;
    f = fopen(arquivo,"r");
    if(f == NULL){
        printf("Erro na leitura do arquivo\n");
        exit(1);
    }
    fscanf(f,"%d\n",&i); //jogo fora o numero de fileiras

    for(i=0;i<tamanho;i++){
        if(contador_de_fileiras == fileira){ //se fileira for igual a posição, proxima fileira
            fscanf(f,"%d\n",&c[i].caixa);
            c[i].fileira = fileira;
            c[i].posicao = contador_de_fileiras;
            fileira++;
            contador_de_fileiras = 1;
        }
        else{
            fscanf(f,"%d\n",&c[i].caixa);
            c[i].fileira = fileira;
            c[i].posicao = contador_de_fileiras;
            contador_de_fileiras++;
        }
    }
    fclose(f);
}


CAIXA melhor_caixa(CAIXA *c, int tamanho){ //função que procura melhor caixa
    int maior;
    int soma =0;
    CAIXA maior_caixa = c[0];
    maior = c[0].caixa; //caixa[0] inicia como maior
    for(int i=1;i<tamanho;i++){
        soma = c[i].caixa;
        for(int j = i-1; j>=0;j--){ 
            if(c[j].fileira != c[i].fileira)
                 soma = soma+c[j].caixa;
        }
        if(soma>maior){
            maior = soma;
            maior_caixa = c[i];
        }
        soma = 0;
    }
    return maior_caixa;
}

int main(){
    FILE *f = NULL;
    char arquivo[80];
    printf("Digite o nome do arquivo de entrada: ");
    scanf("%s",arquivo);
    int tamanho = tamanho_da_caixa(f,arquivo); // define o tanto de caixa que tem
    tamanho = tamanho; //tratando o warning
    CAIXA c[tamanho]; // define um vetor de caixas
    CAIXA maior; 
    ler_arquivo(c,tamanho,f,arquivo); //ler o arquivo e salva em c
    maior = melhor_caixa(c,tamanho); // salva a caixa vencedora
    printf("Resposta: fileira %d, caixa %d.\n", maior.fileira,maior.posicao);
}
