#include <stdio.h>
#include <stdlib.h>

struct Seguimento{
    int tipo;
    int posicao_inicial;
    long int num;
}typedef SEGUIMENTO;

long int* ler_arquivo(long int *v,char *nome_arq){ // função que ler o arquivo
    FILE *arquivo = fopen(nome_arq,"r");
    int tam;
    int i;
    if(arquivo == NULL){
        printf("Erro na leitura do arquivo\n");
        exit(1);
    }
    fscanf(arquivo,"%d ",&tam);
    v = (long int*)realloc(v,tam*(sizeof(long int)));
    for(i=0; i<tam ;i++){
        fscanf(arquivo,"%ld ",&v[i]);
        //printf("%d ",v[i]);
    }
    fclose(arquivo);
    return (long int*)v;
} 

int ler_tam_arquivo(char *nome_arq){ // função que ler o tamanho arquivo
    FILE *arquivo = fopen(nome_arq,"r");
    int tam;
    if(arquivo == NULL){
        printf("Erro na leitura do arquivo\n");
        exit(1);
    }
    fscanf(arquivo,"%d ",&tam);
    fclose(arquivo);
    return tam;
} 

void ordena(SEGUIMENTO *s, int tam){
    SEGUIMENTO aux;
    for(int i=0;i<=tam;i++)
        for(int j=0;j<=tam;j++)
            if(s[i].num<s[j].num){
                aux = s[i];
                s[i] = s[j];
                s[j]= aux;
             }
}

int confere_tipo(long int num,SEGUIMENTO *s,int tam){
    int contador = 1;
    for(int i=0;i<tam;i++){
        if(num == s[i].num)
            break;
        else
            if(i!=0){
                if(s[i].num != s[i-1].num)
                    contador++;
             }
              else
                contador++;
    }
    return contador;
}

void seguimentos(long int *v,int **matriz,int tam_vetor,int linha,int coluna){
    int contador = 1,j,aux = 1;
    SEGUIMENTO s[tam_vetor];
    for(int i=0;i<tam_vetor;i++){
        for(j=i+1; v[j]==v[i] && j<tam_vetor;j++){
            contador++;
        }
        if(i>0){
            s[aux].num = v[i];
            s[aux].posicao_inicial = i;
            ordena(s,aux);
            coluna++;
            for(int i=0;i<linha;i++)
                matriz[i] = realloc(matriz[i], coluna*sizeof(int));
            matriz[1][coluna-1] = contador;
            aux++;
        }
        else{
            s[0].num = v[i];
            s[0].posicao_inicial = 0;
            ordena(s,0);
            coluna++;
            for(int i=0;i<linha;i++)
                matriz[i] = realloc(matriz[i], coluna*sizeof(int));
            matriz[1][coluna-1] = contador;
            //printf("%d\n%d\n\n",matriz[0][coluna-1],matriz[1][coluna-1]);
        }
        if(j==tam_vetor)
            break;
        i = i+(contador - 1);
        contador = 1;
    }
    for(int i=0,j=0;i<coluna;i++){
        s[i].tipo = confere_tipo(v[j],s,aux);
        matriz[0][i] = s[i].tipo;
        j = j+matriz[1][i];
       // printf("%d ",matriz[0][i]);
    }
    printf("Matriz:\n");
    for(int i =0;i<linha;i++){
        for(j=0;j<coluna;j++)
            printf("%d ",matriz[i][j]);
        printf("\n");
    }
    for (int i=0; i<linha; i++)
        free(matriz[i]) ;
    free(matriz);
}

int main(){
    long int *v; //vetor presente no arquivo, e matriz final
    int **matriz;
    int tam_vetor;
    int linha = 2, coluna = 0; //linha e coluna da matriz;
    char arquivo[30];
    printf("Digite o nome do arquivo: ");
    scanf("%s",arquivo);
    v = (long int*)malloc(sizeof (long int));
    matriz = malloc(linha*sizeof(int*));
    for(int i=0;i<linha;i++)
        matriz[i] = malloc(coluna*sizeof(int));
    tam_vetor = ler_tam_arquivo(arquivo);
    v = ler_arquivo(v,arquivo);
    seguimentos(v,matriz,tam_vetor,linha,coluna);
    free(v);
}